package com.mycompany.proyecto;

import com.google.common.io.Files;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import ucar.nc2.dt.grid.GridDataset;
import ucar.nc2.dt.image.ImageDatasetFactory;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import ucar.nc2.VariableSimpleIF;
import ucar.nc2.time.CalendarDate;

public class Generador {    
    public void recibir(String ds, int lol){
        if(ds!=null){ //Verificador de ruta, en caso de que la ruta no se haya capturado correctamente
                try {
                    GridDataset gd= GridDataset.open(ds); //Se almacena la ruta, para utilizar el metodo de GridDataset
                    ImageDatasetFactory imageFactory = new ImageDatasetFactory();
                    CalendarDate finicial = gd.getCalendarDateStart();
                    CalendarDate ffinal = gd.getCalendarDateEnd();
                    List<VariableSimpleIF> a = gd.getDataVariables();//Obtener parametros, tiempo, latitud y longitud, 
                    imageFactory.openDataset(gd.getGrids().get(0));
                    System.out.print(a);
                    BufferedImage image = imageFactory.getNextImage(true); //Lectura de imagen
            
                    switch(lol){ //Verificador de botones, creara una imagen con diferentes nombres dependiendo el boton 
                    case 1: ImageIO.write(image, "png", new File("mapa1.png"));
                            JOptionPane.showMessageDialog(null, "Fecha Inicial:"+finicial+"\n"+"Fecha Final:"+ffinal, "Fechas Capturas", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    case 2: ImageIO.write(image, "png", new File("mapa2.png"));
                            JOptionPane.showMessageDialog(null, "Fecha Inicial:"+finicial+"\n"+"Fecha Final:"+ffinal, "Fechas Capturas", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    case 3: ImageIO.write(image, "png", new File("mapa3.png"));
                            JOptionPane.showMessageDialog(null, "Fecha Inicial:"+finicial+"\n"+"Fecha Final:"+ffinal, "Fechas Capturas", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }
                } catch (IOException ex) { //Los metodos GridDataset solitican utilizar try- catch por si da error
                    JOptionPane.showMessageDialog(null, "Error en generar imagen");    
                }  
        }else{
            switch(lol){
                case 1: JOptionPane.showMessageDialog(null, "No se encontro la ruta - Boton 1", "Error", JOptionPane.WARNING_MESSAGE);
                        break;
                case 2: JOptionPane.showMessageDialog(null, "No se encontro la ruta - Boton 2", "Error", JOptionPane.WARNING_MESSAGE);
                        break;
                case 3: JOptionPane.showMessageDialog(null, "No se encontro la ruta - Boton 3", "Error", JOptionPane.WARNING_MESSAGE);
                        break;
            }
        }

    }
    public void Guardarimagen(String archivo){
        int a=0; //Validador temporal
        JFileChooser agarrar = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("[Insertar nombre]+(.png)(.jpg)(.bmp)","png"); //Indicaciones paara el usuario
        agarrar.setFileFilter(filtro);
        agarrar.setMultiSelectionEnabled(false);
        int option = agarrar.showSaveDialog(null);
        File rutainicial = new File(archivo); //Ruta de la imagen original
        File rutafinal = agarrar.getSelectedFile(); //Ruta seleccionada por el usuario por medio de la interfaz
    
        if(option != JFileChooser.APPROVE_OPTION || rutafinal == null) { //Validacion vacia, su unica finalidad es para que se ejecute el menu de ruta
        return;
        }
        try{
            Files.copy(rutainicial, rutafinal); //Se realiza una copia de la imagen original, para que la copia sea dirigida a la ruta echa por el usuario
            a=1; //Notificacion que se ejecuto correctamente la copia
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(a==1){
            JOptionPane.showMessageDialog(null, "Imagen Guardada", "Guardado", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo completar tu solicitud", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}