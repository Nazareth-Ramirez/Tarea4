/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author kaysc
 */
public class Libro {

    private ArrayList<Pagina> paginas = new ArrayList<>();
    private int[] respuestasCorrectas = {1, 0, 2};
    private int[][] historial = new int[3][3]; // 3 intentos y 3 respuestas
    private PreguntaMultiple[][] preguntas = new PreguntaMultiple[1][3]; // matriz de objetos
    private int intentos = 0;

    public Libro() {
        paginas.add(new PaginaInformativa("Introducción", 1,
                "Mamá Arcoíris bajó muy preocupada de las nubes porque un viento "
                + "\ntravieso dispersó a sus tres hijitos por la Tierra.\n\n"));

        paginas.add(new PaginaInformativa("Capítulo 1: El rastro cálido de Toronja", 2,
                "En un huerto soleado lleno de fresas y mandarinas encontró a Toronja"
                + "\n\nSu pelaje ROJO (color primario lleno de energía) y NARANJA (color secundario "
                + "\nque nace al mezclar rojo + amarillo) brillaba como el atardecer. "
                + "\n¡Toronja subió al lomo de su mamá para buscar a sus hermanos!"));

        paginas.add(new PaginaInformativa("Capítulo 2: La travesura de Limón", 3,
                "Junto a Toronja, Mamá Arcoíris llegó a un prado lleno de girasoles y árboles frondosos."
                + "Escondido entre las hojas de un limonero escuchó un dulce maullido: ¡era LIMÓN!"
                + "\n\nSu pelaje AMARILLO (color primario radiante como el sol) y VERDE (color secundario "
                + "\nque se forma al unir amarillo + azul) se confundía con el pasto fresco. "
                + "\nMamá Arcoíris lo abrazó feliz y continuaron la búsqueda."));
        
        paginas.add(new PaginaInformativa("Capítulo 3: El sueño nocturno de Uva", 4,
                "Al caer la tarde, junto a un lago tranquilo y un jardín de lavandas, "
                + "\nMamá Arcoíris encontró al más pequeño acurrucado mirando las estrellas: ¡era UVA!"
                + "\n\nSu pelaje AZUL (color primario profundo como el mar) y MORADO (color secundario "
                + "\nmágico que nace al mezclar azul + rojo) brillaba bajo la luna. "
                + "\nCon sus tres hijos reunidos, los seis colores volvieron a formar el gran Miau-rcoiris."));

        paginas.add(new PaginaActividad("Preguntas de selección única", 5,
                "Responda según la historia de mamá Arcoíris y sus pequeños"));
        
        preguntas[0][0] = new PreguntaMultiple("¿De qué colores es el pelaje de Toronja, el primer gatito encontrado?",
                new String[]{"Amarillo y Verde", "Rojo y Naranja", "Azul y Morado"});
        
        preguntas[0][1] = new PreguntaMultiple("¿Dónde encontró Mamá Arcoíris a Limón?",
                new String[]{"En un prado entre girasoles y árboles", "En un lago de lavandas", "En un huerto de fresas"});
        
        preguntas[0][2] = new PreguntaMultiple("¿Qué colores tiene el pelaje de Uva, el gatito más pequeño?",
                new String[]{"Rojo y Amarillo", "Naranja y Verde", "Azul y Morado"});
    }

    public int cantidadPaginas() {
        return paginas.size();
    }

    public Pagina obtenerPagina(int numero) {
        return paginas.get(numero); // ArrayList y polimorfismo
    }

    public PreguntaMultiple obtenerPregunta(int numero) {
        return preguntas[0][numero]; // matriz de objetos
    }

    public int getIntentos() {
        return intentos;
    }

    public int registrarRespuestas(int[] respuestas) {
        if (intentos >= 3) {
            throw new IllegalStateException("Ya se realizaron los tres intentos disponibles");
        }
        if (respuestas.length != 3) {
            throw new IllegalArgumentException("Debe responder las tres preguntas.");
        }
        int puntos = 0;
        for (int i = 0; i < respuestas.length; i++) {
            historial[intentos][i] = respuestas[i]; // matriz primitiva
            if (respuestas[i] == respuestasCorrectas[i]) {
                puntos++;
            }
        }
        intentos++;
        return puntos;
    }

    public String mostrarHistorial() {
        String texto = "Historial de intentos:\n";
        for (int i = 0; i < intentos; i++) {
            texto += "Intento " + (i + 1) + ": ";
            for (int j = 0; j < 3; j++) {
                texto += (historial[i][j] + 1) + " ";
            }
            texto += "\n";
        }
        return texto;
    }
    
}
