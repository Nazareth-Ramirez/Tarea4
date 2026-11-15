/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author kaysc
 */
public class Libro {
    
    //Almacena el patron de respuestas correctas
    private int[] respuestasCorrectas = {2,1,3};
    
    //Guardara las respuestas que dara el lector a las actividades 
    private int[] respuestasLector = new int[3];
    
    //Almacena los intentos
    //Las filas son los intentos y las columnas las respuestas a las preguntas
    private int[][] historial = new int[3][3];
    
    //Contador de intentos
    private int cantidadIntentos = 0;
    
    
    public int calcularResultado(){
        
        int correctas = 0;
        
        for (int i = 0; i < respuestasLector.length; i++){
            if (respuestasLector[i] == respuestasCorrectas[i]){
                correctas++;
                
            }
        }
        
        return correctas;
    }
    
    public void guardarIntentos(){
        
        for(int i = 0; i < respuestasLector.length; i++){
            historial[cantidadIntentos][i] = respuestasLector[i];
        }
        cantidadIntentos++;
        
    }
}
