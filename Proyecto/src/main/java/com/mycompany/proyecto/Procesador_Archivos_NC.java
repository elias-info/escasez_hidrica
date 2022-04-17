package com.mycompany.proyecto;

import java.io.IOException;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.NetcdfFile;


public class Procesador_Archivos_NC {
    
    public String nombreNC;
    public String nombreCSV;
    public NetcdfFile ncfile;
    public Objeto_NC objetoNC;
    public String[] datos;
    String textFecha;
    
    
    public Procesador_Archivos_NC(){
        
    }
    
    public Procesador_Archivos_NC(String ruta, String fecha)  {
       
       textFecha = fecha; 
       nombreNC = ruta;
       
       //Se abre el archivo NetCDF
       try {
           ncfile = NetcdfFile.open(ruta);
           System.out.println(" [ MENSAJE ] Archivo NC se ha abierto correctamente");
       } catch (IOException ex) {
           System.out.println(" [ ERROR ] Problema al abrir el archivo NC");
       }
            
    }
    
   
    //Obtenemos los datos de la Variable
    public String[] acceder_variables() throws InvalidRangeException, IOException {
        
       objetoNC=new Objeto_NC(ncfile.getGlobalAttributes(),
                              ncfile.getVariables());
       
       System.out.println(objetoNC.toString());

       datos = objetoNC.retornar_variable(objetoNC.variables.get(3),textFecha);
       
       return(datos);
    }
    
    //Acceder a los datos de la variable para Coordenadas de la Región de Ñuble
    public String[] acceder_variables_nuble() throws InvalidRangeException, IOException {
        
       objetoNC=new Objeto_NC(ncfile.getGlobalAttributes(),
                              ncfile.getVariables());
       
       System.out.println(objetoNC.toString());

       datos = objetoNC.obtenerInfoNuble(objetoNC.variables.get(3),textFecha);
       
       return(datos);
    }
    
    //Se llama la función para crear y exportar archivo CSV
    public void exportarCSV(String nombreCSV) throws InvalidRangeException{
        
        objetoNC=new Objeto_NC(ncfile.getGlobalAttributes(),
                              ncfile.getVariables());
       
       System.out.println(objetoNC.toString());
       
       objetoNC.crearCSV(objetoNC.variables.get(3),nombreCSV,textFecha);
       
    }
    
    //Se llama la función para leer archivo CSV
    public void leerCSV(String nombreCSV){
        
        objetoNC = new Objeto_NC();
        objetoNC.leerCSV(nombreCSV);
    }
    
    
}
