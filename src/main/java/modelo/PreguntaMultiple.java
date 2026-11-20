/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author kaysc
 */
public class PreguntaMultiple {
    
    private String enunciado;
    private String[] opciones;

    public PreguntaMultiple(String enunciado, String[] opciones) {
        this.enunciado = enunciado;
        this.opciones = opciones;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getOpciones() {
        return opciones;
    }
  
}
