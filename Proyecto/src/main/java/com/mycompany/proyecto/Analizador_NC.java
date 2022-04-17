/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jooli
 */
public class Analizador_NC {
    
    String[] datosNC1;
    String[] datosNC2;
    String fecha;
    
    public Analizador_NC(String FechaDoc){
        fecha = FechaDoc;
    }
    
    public Analizador_NC(String[] datos1, String[] datos2){
        
      datosNC1 = datos1;
      datosNC2 = datos2;
      
    }
    
    //Concatenamos la información de las Variables
    public String[] unirDatosNC(){
        
        String[] datosNC = new String[datosNC1.length];
        String[] fila;
        String nuevaFila;
        
        for(int i = 0; i < datosNC1.length;i++){
            
            fila = datosNC2[i].split(";");
            nuevaFila = fila[3]; 
            
            datosNC[i] = datosNC1[i] + ";" + nuevaFila;
        }
        
        return(datosNC);
        
    }
    
    
    //Método para calcular índice de Riesgo Hídrico
    public String[] indiceHidrico(String[] archivo){
        
        String[] datosNC = new String[archivo.length];
        String[] fila;
        String[] nuevaFila;
        String titulos = archivo[0];
        int indexPr = posicionVariable(titulos,"pr");
        int indexTmin = posicionVariable(titulos,"tmin");        
        int indexTmax = posicionVariable(titulos,"tmax");
        double tpromedio;
        int indiceHidrico;
        double tmin;
        double tmax;
        double pr;
        String[] min,max,pre;
        String mes = extraerMes(archivo[1]);
        
        datosNC[0] = archivo[0] + ";" + "ih";
        
        //Tomamos la información de las Variables y la convertimos al tipo de variable primitivo original.
        for(int i = 1; i < archivo.length; i++){
            
            fila = archivo[i].split(";");
            
            if("-9999,0".equals(fila[indexTmin])){
                tmin = -9999.0;
            }else{
                min = fila[indexTmin].split(",");
                tmin = Double.parseDouble(min[0] + "." + min[1]);
            }
            
            if("-9999,0".equals(fila[indexTmax])){
                tmax = -9999.0;
            }else{
                max = fila[indexTmax].split(",");
                tmax = Double.parseDouble(max[0] + "." + max[1]);
            }
            
            if("-9999,0".equals(fila[indexPr])){
                pr = -9999.0;
            }else{
                pre = fila[indexPr].split(",");
                pr = Double.parseDouble(pre[0] + "." + pre[1]);
            }
            
            
            tpromedio = (tmin+tmax)/2; //Obtenemos la temperatura promedio mensual
            
            Comparador comparador = new Comparador();
            
            
        //Seleccionamos el mes para calcular el IRH.    
        switch(mes){
            
            case "01":  indiceHidrico = comparador.enero(tpromedio, pr); //Se calcular el IRH
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;
                        break;
                    
            case "02":  indiceHidrico = comparador.febrero(tpromedio, pr); 
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;                    
                        break;
                    
            case "03":  indiceHidrico = comparador.marzo(tpromedio, pr);
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;
                        break;
                    
            case "04":  indiceHidrico = comparador.abril(tpromedio, pr);
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;                    
                        break;
                    
            case "05":  indiceHidrico = comparador.mayo(tpromedio, pr);
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;
                        break;
                    
            case "06":  indiceHidrico = comparador.junio(tpromedio, pr);
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;                    
                        break;
                    
            case "07":  indiceHidrico = comparador.julio(tpromedio, pr);
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;
                        break;
                    
            case "08":  indiceHidrico = comparador.agosto(tpromedio, pr);
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;                    
                        break;
                    
            case "09":  indiceHidrico = comparador.septiembre(tpromedio, pr);
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;
                        break;
                    
            case "10":  indiceHidrico = comparador.octubre(tpromedio, pr);
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;                    
                        break;
                     
            case "11":  indiceHidrico = comparador.noviembre(tpromedio, pr);
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;
                        break;
                     
            case "12":  indiceHidrico = comparador.diciembre(tpromedio, pr);
                        datosNC[i] = archivo[i] + ";" + indiceHidrico;
                        break;
            
            default:    System.out.println("[ ERROR ] : El indice no se pudo calcular de forma correcta");            
                        break;
            }
            
        }
        
        return(datosNC);
    }
    
    //Verificamos en que posición se encuentra cada Variable (tmin, tmax y pr)
    public int posicionVariable(String cadena, String nombreVariable){
        int indice = 0;
        String[] fila;
        
        fila = cadena.split(";");
        
        for(int i = 0;i<fila.length;i++){
            if(fila[i].equals(nombreVariable)){
                indice = i;
            }
        }
                
        return(indice);
    }
    
    //Obtenemos el mes que se está consultando para calcular el IRH
    public String extraerMes(String fila){
        
        String[] cadena = fila.split(";");
        String[] fecha = cadena[0].split("-");
        String mes = fecha[0];
        
        return(mes);
    }
    
    //Se crea y exporta archivo CSV de IRH
    public void crearCSVIndice(String[] registros){
        
        FileWriter archivo;
        try {
            archivo = new FileWriter("INDICE_HIDRICO_REGION_NUBLE" + fecha + ".csv");
            BufferedWriter escritor = new BufferedWriter(archivo);
            
            for(int i = 0; i< registros.length; i++) {
                    escritor.write(registros[i]);
                    escritor.newLine();
            }
            
            escritor.close();
            System.out.println("ARCHIVO CREADO EXITOSAMENTE");
        
        
        } catch (IOException ex) {
            Logger.getLogger(Analizador_NC.class.getName()).log(Level.SEVERE, null, ex);
        }
	
        
    }
    
    public void toString(String[] cadena){
        for(int i = 0; i< cadena.length; i++){
            System.out.println(cadena[i]);
        }
    }

    
    
}
