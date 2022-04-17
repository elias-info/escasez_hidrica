/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author jooli
 */
public class Comparador {

    //Esta clase se crea para contener los cálculos para el índice de Riesgo Hídrico
    //Se crea un método para cada mes del año con su respectivos valores considerados para el cálculo
    
    public Comparador(){
        
    }
    
    public int enero(double tprom, double pr){
        
        int indice;
        
        if(tprom > 21.15 && pr < 11.15){
            indice = 4;
        }else{
            if(tprom > 21.15 && pr > 11.15){
                indice = 3;
            }else{
                if(tprom <= 21.15 && tprom > 18.15 && pr < 11.15){
                    indice = 3;
                }else{
                    if (tprom <= 21.15 && tprom > 18.15 && pr > 11.15){
                        indice = 2;
                    }else{
                        if(tprom <= 18.15 && tprom > 15.15 && pr <11.15){
                            indice = 2;
                        }else{
                            if (tprom <= 18.15 && tprom > 15.15 && pr > 11.15) {
                                indice = 1;
                            }else{
                                if (tprom < 15.15 && tprom > 0 && pr < 11.15) {
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    }
    
    public int febrero(double tprom, double pr){
        
        int indice;
        
        if(tprom > 20.4 && pr < 16.59){
            indice = 4;
        }else{
            if(tprom > 20.4 && pr > 16.59){
                indice = 3;
            }else{
                if(tprom <= 20.4 && tprom > 17.4 && pr < 16.59){
                    indice = 3;
                }else{
                    if (tprom <= 20.4 && tprom > 17.4 && pr > 16.59){
                        indice = 2;
                    }else{
                        if(tprom <= 17.4 && tprom > 14.4 && pr <16.59){
                            indice = 2;
                        }else{
                            if (tprom <= 17.4 && tprom > 14.4 && pr > 16.59) {
                                indice = 1;
                            }else{
                                if (tprom < 14.4 && tprom > 0 && pr < 16.59) {
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    }
    
    public int marzo(double tprom, double pr){
        
        int indice;
        
        if(tprom > 18.5 && pr < 24.28){
            indice = 4;
        }else{
            if(tprom > 18.5 && pr > 24.28){
                indice = 3;
            }else{
                if(tprom <= 18.5 && tprom > 15.5 && pr < 24.28){
                    indice = 3;
                }else{
                    if (tprom <= 18.5 && tprom > 15.5 && pr > 24.28){
                        indice = 2;
                    }else{
                        if(tprom <= 15.5 && tprom > 12.5 && pr < 24.28){
                            indice = 2;
                        }else{
                            if (tprom <= 15.5 && tprom > 12.5 && pr > 24.28) {
                                indice = 1;
                            }else{
                                if (tprom < 12.5 && tprom > 0 && pr < 24.28) {
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    }
    
    public int abril(double tprom, double pr){
        
        int indice;
        
        if(tprom > 15.3 && pr < 96.2){
            indice = 4;
        }else{
            if(tprom > 15.3 && pr > 96.2){
                indice = 3;
            }else{
                if(tprom <= 15.3 && tprom > 12.3 && pr < 96.2){
                    indice = 3;
                }else{
                    if (tprom <= 15.3 && tprom > 12.3 && pr > 96.2){
                        indice = 2;
                    }else{
                        if(tprom <= 12.3 && tprom > 9.3 && pr < 96.2){
                            indice = 2;
                        }else{
                            if (tprom <= 12.3 && tprom > 9.3 && pr > 96.2) {
                                indice = 1;
                            }else{
                                if (tprom < 9.3 && tprom > 0 && pr < 96.2) {
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    }

    public int mayo(double tprom, double pr){
        
        int indice;
        
        if(tprom > 11.8 && pr < 271.8){
            indice = 4;
        }else{
            if(tprom > 11.8 && pr > 271.8){
                indice = 3;
            }else{
                if(tprom <= 11.8 && tprom > 8.8 && pr < 271.8){
                    indice = 3;
                }else{
                    if (tprom <= 11.8 && tprom > 8.8 && pr > 271.8){
                        indice = 2;
                    }else{
                        if(tprom <= 8.8 && tprom > 5.8 && pr < 271.8){
                            indice = 2;
                        }else{
                            if (tprom <= 8.8 && tprom > 5.8 && pr > 271.8){
                                indice = 1;
                            }else{
                                if (tprom < 5.8 && tprom > 0 && pr < 271.8){
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    }

    public int junio(double tprom, double pr){
        
        int indice;
        
        if(tprom > 8.75 && pr < 335.11){
            indice = 4;
        }else{
            if(tprom > 8.75 && pr > 335.11){
                indice = 3;
            }else{
                if(tprom <= 8.75 && tprom > 5.75 && pr < 335.11){
                    indice = 3;
                }else{
                    if (tprom <= 8.75 && tprom > 5.75 && pr > 335.11){
                        indice = 2;
                    }else{
                        if(tprom <= 5.75 && tprom > 2.75 && pr < 335.11){
                            indice = 2;
                        }else{
                            if (tprom <= 5.75 && tprom > 2.75 && pr > 335.11){
                                indice = 1;
                            }else{
                                if (tprom < 2.75 && tprom > 0 && pr < 335.11){
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    }
    
    public int julio(double tprom, double pr){
        
        int indice;
        
        if(tprom > 7.55 && pr < 317.89){
            indice = 4;
        }else{
            if(tprom > 7.55 && pr > 317.89){
                indice = 3;
            }else{
                if(tprom <= 7.55 && tprom > 4.55 && pr < 317.89){
                    indice = 3;
                }else{
                    if (tprom <= 7.55 && tprom > 4.55 && pr > 317.89){
                        indice = 2;
                    }else{
                        if(tprom <= 4.55 && tprom > 1.55 && pr < 317.89){
                            indice = 2;
                        }else{
                            if (tprom <= 4.55 && tprom > 1.55 && pr > 317.89){
                                indice = 1;
                            }else{
                                if (tprom < 1.55 && tprom > 0 && pr < 317.89){
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    }    

    public int agosto(double tprom, double pr){
        
        int indice;
        
        if(tprom > 8.75 && pr < 201){
            indice = 4;
        }else{
            if(tprom > 8.75 && pr > 201){
                indice = 3;
            }else{
                if(tprom <= 8.75 && tprom > 5.75 && pr < 201){
                    indice = 3;
                }else{
                    if (tprom <= 8.75 && tprom > 5.75 && pr > 201){
                        indice = 2;
                    }else{
                        if(tprom <= 5.75 && tprom > 2.75 && pr < 201){
                            indice = 2;
                        }else{
                            if (tprom <= 5.75 && tprom > 2.75 && pr > 201){
                                indice = 1;
                            }else{
                                if (tprom < 2.75 && tprom > 0 && pr < 201){
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    } 
    
    public int septiembre(double tprom, double pr){
        
        int indice;
        
        if(tprom > 10.4 && pr < 122.86){
            indice = 4;
        }else{
            if(tprom > 10.4 && pr > 122.86){
                indice = 3;
            }else{
                if(tprom <= 10.4 && tprom > 7.4 && pr < 122.86){
                    indice = 3;
                }else{
                    if (tprom <= 10.4 && tprom > 7.4 && pr > 122.86){
                        indice = 2;
                    }else{
                        if(tprom <= 7.4 && tprom > 4.4 && pr < 122.86){
                            indice = 2;
                        }else{
                            if (tprom <= 7.4 && tprom > 4.4 && pr > 122.86){
                                indice = 1;
                            }else{
                                if (tprom < 4.4 && tprom > 0 && pr < 122.86){
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    } 
    
    public int octubre(double tprom, double pr){
        
        int indice;
        
        if(tprom > 12.6 && pr < 92.46){
            indice = 4;
        }else{
            if(tprom > 12.6 && pr > 92.46){
                indice = 3;
            }else{
                if(tprom <= 12.6 && tprom > 9.6 && pr < 92.46){
                    indice = 3;
                }else{
                    if (tprom <= 12.6 && tprom > 9.6 && pr > 92.46){
                        indice = 2;
                    }else{
                        if(tprom <= 9.6 && tprom > 6.6 && pr < 92.46){
                            indice = 2;
                        }else{
                            if (tprom <= 9.6 && tprom > 6.6 && pr > 92.46){
                                indice = 1;
                            }else{
                                if (tprom < 6.6 && tprom > 0 && pr < 92.46){
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    }
    
    public int noviembre(double tprom, double pr){
        
        int indice;
        
        if(tprom > 12.6 && pr < 46.28){
            indice = 4;
        }else{
            if(tprom > 12.6 && pr > 46.28){
                indice = 3;
            }else{
                if(tprom <= 12.6 && tprom > 9.6 && pr < 46.28){
                    indice = 3;
                }else{
                    if (tprom <= 12.6 && tprom > 9.6 && pr > 46.28){
                        indice = 2;
                    }else{
                        if(tprom <= 9.6 && tprom > 6.6 && pr < 46.28){
                            indice = 2;
                        }else{
                            if (tprom <= 9.6 && tprom > 6.6 && pr > 46.28){
                                indice = 1;
                            }else{
                                if (tprom < 6.6 && tprom > 0 && pr < 46.28){
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    }    
    
    public int diciembre(double tprom, double pr){
        
        int indice;
        
        if(tprom > 15.4 && pr < 28.87){
            indice = 4;
        }else{
            if(tprom > 15.4 && pr > 28.87){
                indice = 3;
            }else{
                if(tprom <= 15.4 && tprom > 12.4 && pr < 28.87){
                    indice = 3;
                }else{
                    if (tprom <= 15.4 && tprom > 12.4 && pr > 28.87){
                        indice = 2;
                    }else{
                        if(tprom <= 12.4 && tprom > 9.4 && pr < 28.87){
                            indice = 2;
                        }else{
                            if (tprom <= 12.4 && tprom > 9.4 && pr > 28.87){
                                indice = 1;
                            }else{
                                if (tprom < 9.4 && tprom > 0 && pr < 28.87){
                                    indice = 1;
                                }else{
                                    indice = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
            
    return(indice);
    }
        
}
