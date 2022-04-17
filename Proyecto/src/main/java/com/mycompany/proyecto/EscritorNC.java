/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ucar.ma2.ArrayDouble;
import ucar.ma2.ArrayInt;
import ucar.ma2.ArrayString;
import ucar.ma2.DataType;
import ucar.ma2.Index;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.Attribute;
import ucar.nc2.Dimension;
import ucar.nc2.Variable;
import ucar.nc2.write.NetcdfFormatWriter;

/**
 *
 * @author jooli
 */
public class EscritorNC {
    
    String[] data;
    
    
    public EscritorNC(String[] datos) throws InvalidRangeException{
        
       data = datos;
              
       String[] lats = valoresDimension(data,"lat");
       String[] lons = valoresDimension(data,"lon");
       String[] hidros = valoresDimension(data,"ih");
       String[] fila;
       String fecha = obtenerFecha(data[1]);
       int nLat = lats.length;
       int nLon = lons.length;
       int nIH = hidros.length;
       int[] indicesH = new int[data.length];
       Integer indice;
       Double[] latitudes = datosDimensiones(lats);
       Double[] longitudes = datosDimensiones(lons);
       Integer[] indices = datosVariable(hidros);
       
       //Se crea el construtor del archivo 
       NetcdfFormatWriter.Builder builder = NetcdfFormatWriter.createNewNetcdf3("INDICE_HIDRICO_REGION_NUBLE" + fecha + ".nc");
       builder.setFill(true);
       
       //Se crean las Dimensiones de las Coordenadas 
       Dimension latDim = builder.addDimension("lat",nLat);
       Dimension lonDim = builder.addDimension("lon",nLon);
       
       //Se crea lista de tipo dimensión y se añaden los datos de latitud
       List<Dimension> dimsLat = new ArrayList<Dimension>();
       dimsLat.add(latDim);

       //Se crea lista de tipo dimensión y se añaden los datos de longitud
       List<Dimension> dimsLon = new ArrayList<Dimension>();
       dimsLon.add(lonDim);
       
       
       List<Dimension> dims = new ArrayList<Dimension>();
       dims.add(latDim);
       dims.add(lonDim);
       
 
       //Se crea el constructor para la variable´latitud
       Variable.Builder latitude = builder.addVariable("lat", DataType.DOUBLE,dimsLat);
       latitude.addAttribute(new Attribute("long_name", "latitude"));
       latitude.addAttribute(new Attribute("units", "degrees north"));
       
       //Se crea el constructor para la variable´longitud
       Variable.Builder longitude = builder.addVariable("lon", DataType.DOUBLE,dimsLon);
       longitude.addAttribute(new Attribute("long_name", "longitude"));
       longitude.addAttribute(new Attribute("units", "degrees east"));
              
       //Se crea el constructor para la variable de Índice de Riesgo Hídrico
       Variable.Builder ih = builder.addVariable("ih", DataType.INT, dims);
       ih.addAttribute(new Attribute("long_name", "INDICE HIDRICO"));
       ih.addAttribute(new Attribute("units", "RIESGO"));
       
            for(int i = 1; i < data.length; i++){
                fila = data[i].split(";");
                indice = Integer.parseInt(fila[6]);
                indicesH[i] = indice;
            }
       
            
       try (NetcdfFormatWriter writer = builder.build()) {
           
            //Se crea la dimensión tiempo
            ArrayString time = new ArrayString.D1(1);

            //Se crea la dimensión latitud
            ArrayDouble latitud = new ArrayDouble.D1(nLat);
            for(int i = 0; i < latitudes.length; i++){
                latitud.setDouble(i, latitudes[i]);
            }
            
            //Se añade la dimensión al archivo
            writer.write("lat", latitud);
            
            //Se crea la dimensión longitud
            ArrayDouble longitud = new ArrayDouble.D1(nLon);
            for(int i = 0; i < longitudes.length; i++){
                longitud.setDouble(i, longitudes[i]);
            }
            //Se añade la dimensión al archivo
            writer.write("lon",longitud);
            
            //Se crea la variable de Índice de Riesgo Hídrico (ih)
            Variable v = writer.findVariable("ih");
            int[] shape = v.getShape();
            int nLatitud = shape[0];
            int nLongitud = shape[1];
            
            //Se crea la dimensión para la variable "ih"
            ArrayInt hidrico = new ArrayInt.D2(nLatitud,nLongitud, true);
            
            //Se crea el índex que se utilizará para almacenar los valores para la Variable multidimensional
            Index ima = hidrico.getIndex();  
            
            for(int i = 0; i < nLatitud; i++){
                for(int j = 0; j < nLongitud; j++){
                    
                    //Se añade el valor de la Variable del índice de Riesgo Hídrico para cada par de Coordenadas
                    hidrico.set(ima.set(i,j),indicesH[i]);
                            
                }
            }
            
            //Se escribe la variable en el archivo 
            writer.write("ih",hidrico);
            
            
            JOptionPane.showMessageDialog(null, "ARCHIVO CREADO", "EXITO", JOptionPane.INFORMATION_MESSAGE);   
            
            
            
            

            
            
            
            System.out.println("ARCHIVO CREADO EXITOSAMENTE");
        
        } catch (IOException e) {
           System.out.println("No se pudo crear el archivo");
        }
       
       
    }
    
    
    
    //metodo para obtener los valores de lat y lon
    public String[] valoresDimension(String[] datos, String var){
        
        String[] d = datos;
        String[] titulos = d[0].split(";");
        int indexVar = 0;
        int flag = 0;
        String[] fila;
        List<String> coords = new ArrayList();
        String[] info;
        
        for(int i = 0; i < titulos.length; i++){
            
            if(var.equals(titulos[i])){
                indexVar = i;
            }
        }

        fila = d[1].split(";");
        coords.add(fila[indexVar]);

        for(int j = 1; j < d.length;j++){
            flag = 0;
            fila = d[j].split(";");
            
            for(int i = 0; i < coords.size();i++){
                
                if(i != j){
                    if(fila[indexVar].equals(coords.get(i))){                    
                        flag = 1;
                        break;
                    }
                }

            }
            
            if (flag != 1) {
                coords.add(fila[indexVar]);
                flag = 0;
            }
            
        }
        
        info = new String[coords.size()];
        
        for(int k = 0; k < info.length; k++){
            info[k] = coords.get(k);
        }
        
        return (info);
        
    }
    
    //Obtenemos la fecha
    public String obtenerFecha(String cadena){
        
        String[] fila = cadena.split(";");
        
        return(fila[0]);
    }
    
    //Se convierten las Variables a variable primitiva original
    public Double[] datosDimensiones(String[] datos){
        
        String[] fila;
        Double[] variable = new Double[datos.length];
        
        for(int i = 0; i < datos.length; i++){
            
            fila = datos[i].split(",");
            variable[i] = Double.parseDouble(fila[0] + "." + fila[1]);
        }
        
        return(variable);
    }
    
    //Se convierte IRH en variable primitiva Integer
    public Integer[] datosVariable(String[] datos){
        
        Integer[] variable = new Integer[datos.length];
        
         for(int i = 0; i < datos.length; i++){
            
            variable[i] = Integer.parseInt(datos[i]);
        }
        
        return(variable);
    }
    
}
