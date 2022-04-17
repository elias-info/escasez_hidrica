/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.io.IOException;
import javax.swing.JOptionPane;
import ucar.ma2.InvalidRangeException;

/**
 *
 * @author jooli
 */
public class Funciones {
    
    String[] indiceHidrico;
    String fecha;
    

    //Creamos una clase para recopilar la información de las 3 variables
    //Llamamos creamos los objetos para analizar y calcular el índice de Riesgo Hídrico
    
    public Funciones(String ruta1, String ruta2, String ruta3, String fechaDoc) throws InvalidRangeException, IOException{
    
                    this.fecha = fechaDoc;
        
                    Procesador_Archivos_NC procesador1 =new Procesador_Archivos_NC(ruta1, fecha);
                    String[] datos1 = procesador1.acceder_variables_nuble();
                                        
                    Procesador_Archivos_NC procesador2 =new Procesador_Archivos_NC(ruta2, fecha);
                    String[] datos2 = procesador2.acceder_variables_nuble();
                    
                    Procesador_Archivos_NC procesador3 =new Procesador_Archivos_NC(ruta3, fecha);
                    String[] datos3 = procesador3.acceder_variables_nuble();
                    
                    Analizador_NC analizador1 = new Analizador_NC(datos1, datos2); 
                    String[] resultado = analizador1.unirDatosNC();  //Concatenamos los datos de Variable
                  
                    Analizador_NC analizador2 = new Analizador_NC(resultado,datos3); 
                    String[] resultadoFinal = analizador2.unirDatosNC(); //Concatenamos los datos de Variable
                    
                    indiceHidrico = analizador2.indiceHidrico(resultadoFinal); //calculamos el índice de Riesgo Hídrico
    }
    
    //Método para retornar arreglo con índice de Riesgo Hídrico
    public String[] retornarIndice(){
        
        return(indiceHidrico);
    }
    
    //Llamamos al Analizador para crear y exportar el archivo CSV del Índice de Riesgo Hídrico
    public void exportarCSV(){
        
        Analizador_NC analizadorCSV = new Analizador_NC(fecha);
        analizadorCSV.crearCSVIndice(indiceHidrico);
        
        JOptionPane.showMessageDialog(null, "ARCHIVO CREADO", "EXITO", JOptionPane.INFORMATION_MESSAGE);        
           
    }
}
