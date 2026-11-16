/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kaysc
 */
public class LibroPreguntas {

    //creamos un metodo tipo objeto para control de barras:
    public Pagina getPersonaje(int indice) {
        return pag.get(indice);
    }

    ArrayList<Pagina> pag = new ArrayList<>();

    private int[] respuestasCorrectas = {2, 1, 3};

    //Guardara las respuestas que dara el lector a las actividades 
    private int[] respuestasLector = new int[3];

    //Almacena los intentos
    //Las filas son los intentos y las columnas las respuestas a las preguntas
    private int[][] historial = new int[3][3];

    //Contador de intentos
    private int cantidadIntentos = 0;

    public void inicializarPreguntas() {

        pag.add(new PaginaActividad(new String[]{"Amarillo y Verde", "Rojo y Naranja", "Azul y Morado"}, "¡Correcto! Toronja tiene los colores de un precioso atardecer", "Capítulo 1: El rastro cálido de Toronja", 1, "¿De qué colores es el pelaje de Toronja, el primer gatito encontrado?"));

        pag.add(new PaginaActividad(new String[]{"En un prado entre girasoles y árboles", "En un lago de lavandas", "En un huerto de fresas"}, "¡Correcto! Limón se encontraba bajo un limonero", "Capítulo 2: La travesura de Limón", 2, "¿Dónde encontró Mamá Arcoíris a Limón?"));

        pag.add(new PaginaActividad(new String[]{"Rojo y Amarillo", "Naranja y Verde", "Azul y Morado"}, "¡Correcto! Uva tiene los colores de una noche fría", "Capítulo 3: El sueño nocturno de Uva", 3, "¿Qué colores tiene el pelaje de Uva, el gatito más pequeño?"));

    }

    public void mostrarPregunta() {

        int respuesta;

        for (int i = 0; i < respuestasLector.length; i++) {
            Pagina p = pag.get(i);
            respuesta = Integer.parseInt(JOptionPane.showInputDialog(p.mostrarContenido(p)));

            respuestasLector[i] = respuesta;
        }
        
        JOptionPane.showMessageDialog(null,"Respuestas: " + respuestasLector);
    }

    public int calcularResultado() {

        int correctas = 0;

        for (int i = 0; i < respuestasLector.length; i++) {
            if (respuestasLector[i] == respuestasCorrectas[i]) {
                correctas++;
            }
        }

        return correctas;
    }

    public void guardarIntentos() {

        for (int i = 0; i < respuestasLector.length; i++) {
            historial[cantidadIntentos][i] = respuestasLector[i];
        }
        cantidadIntentos++;

    }
}
