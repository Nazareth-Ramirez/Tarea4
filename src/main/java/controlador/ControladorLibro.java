/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.PreguntaMultiple;
import vista.GUI_Actividad;
import vista.GUI_Historia;
import vista.GUI_Menu;
import vista.GUI_Portada;

/**
 *
 * @author Usuario
 */
public class ControladorLibro implements ActionListener{

    private Libro modelo;
    private GUI_Historia vista;
    private GUI_Portada vistaPortada;
    private GUI_Menu vistaMenu;
    private GUI_Actividad vistaActividad = new GUI_Actividad();
    
    
    private int paginaActual = 0;
    private int indicePregunta = 0;
    
    private boolean enActividad = false;
    
    
    // CONTROL DE PREGUNTAS
    private int numeroPregunta = 0;
    private boolean preguntaRespondida = false;
    private boolean capituloFinalizado = false;

    public ControladorLibro(GUI_Portada vistaPortada, GUI_Menu vistaMenu) {
        this.vistaPortada = vistaPortada;
        this.vistaMenu = vistaMenu;
        this.modelo = new Libro();
        this.vista = new GUI_Historia();

        // Registra este mismo controlador en el menú y en la vista de historia
        if (this.vistaMenu != null) {
            this.vistaMenu.addMenuListener(this);
        }
        this.vista.addButtonListener(this);
        this.vistaActividad.addButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();

        switch (opcion) {
            // Comandos del menú
            case "INICIARHISTORIA":
                abrirHistoria();
                break;
            case "INICIARPREGUNTA":
                abrirActividad();
                break;
            case "VOLVER":
                volverPortada();
                break;

            // Comandos de la historia
            case "Anterior":
                anterior();
                break;
            case "Siguiente":
                siguiente();
                break;
            case "Iniciar":
                abrirActividad();
                break;
            case "Volver":
                volverPortada();
                break;

            // Comandos de la actividad
            case "VolverMenu":
                volverPortada();
                break;
            case "OP1":
                
                break;
            case "OP2":

                break;
            case "OP3":

                break;
            case "SIGUIENTE":
                siguiente();
                break;

        }
    }

    private void abrirHistoria() {
        if (vistaMenu != null) {
            vistaMenu.dispose();
        }
        mostrarPagina();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    private void abrirActividad() {
        
        if (vistaMenu != null) {
            vistaMenu.dispose();
        }

        if (vista != null) {
            vista.dispose();
        }
        vistaActividad.setLocationRelativeTo(null);
        vistaActividad.setVisible(true);
        
//        responder();
        mostrarPregunta();
        
        enActividad = true;
    }

    private void volverPortada() {
        if (vistaMenu != null ) {
            vistaMenu.dispose();
            vista.dispose();
            vistaActividad.dispose();
        }
        if (vistaPortada != null ) {
            vistaPortada.setLocationRelativeTo(null);
            vistaPortada.setVisible(true);
        }
    }

    private void mostrarPagina() {
        vista.mostrarTexto(modelo.obtenerPagina(paginaActual).mostrarContenido());
        vista.habilitarBotones(
                paginaActual > 0,
                paginaActual < modelo.cantidadPaginas() - 1,
                paginaActual == modelo.cantidadPaginas() - 1);
    }

    private void anterior() {
        if (paginaActual > 0) {
            paginaActual--;
            mostrarPagina();
        }
    }

    private void siguiente() {
        if (enActividad) {
            siguientePregunta();
            return;
        }
        
        if (paginaActual < modelo.cantidadPaginas() - 1) {
            paginaActual++;
            mostrarPagina();
        }
    }

    private void responder() {
        if (modelo.getIntentos() >= 3) {
            JOptionPane.showMessageDialog(vista, "Ya utilizo los tres intentos.");
            return;
        }

        int[] respuestas = new int[3];
        for (int i = 0; i < 3; i++) {
            PreguntaMultiple pregunta = modelo.obtenerPregunta(i);
            int respuesta = JOptionPane.showOptionDialog(vista, pregunta.getEnunciado(),
                    "Pregunta " + (i + 1), JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, pregunta.getOpciones(),
                    pregunta.getOpciones()[0]);
            if (respuesta == -1) {
                JOptionPane.showMessageDialog(vista, "Actividad cancelada. No se guardo el intento.");
                return;
            }
            respuestas[i] = respuesta;
        }

        try {
            int puntos = modelo.registrarRespuestas(respuestas);
            JOptionPane.showMessageDialog(vista,
                    "Respuestas correctas: " + puntos + " de 3\n\n" + modelo.mostrarHistorial());
        } catch (IllegalArgumentException | IllegalStateException ex) {
            JOptionPane.showMessageDialog(vista, ex.getMessage());
        }
    }
    
    private void mostrarPregunta() {
        int totalPreguntas = 3; // O el método que tengas para el total de preguntas
        if (indicePregunta < 0) {
            indicePregunta = 0;
        } else if (indicePregunta >= totalPreguntas) {
            indicePregunta = totalPreguntas - 1;
        }

        PreguntaMultiple pregunta = modelo.obtenerPregunta(indicePregunta);
        if (pregunta == null) {
            return;
        }

        // Muestra el enunciado y las opciones en la vista de actividad
        vistaActividad.mostrarPregunta(
                pregunta.getEnunciado(),
                pregunta.getOpciones(),
                indicePregunta + 1,
                totalPreguntas
        );
    }
    
    private void siguientePregunta() {
        if (indicePregunta < 3 - 1) { // va de 0 a 1 (pasa a la 1 y luego a la 2, que es la 3.ª pregunta)
            indicePregunta++;
            mostrarPregunta();
        } else {
            // Ya estás en la 3.ª pregunta (índice 2) y volvieron a dar siguiente
            // Aquí llamas a tu método para guardar/evaluar respuestas o cerrar
        }
    }
    
//    // RESPUESTA DE OPCIÓN MÚLTIPLE
//    private void validarRespuestaMultiple(int opcion) {
//
//        // Consultamos la selección desde la vista.
//        String respuesta = vistaActividad.obtenerRespuestaMultiple(opcion);
//
//        procesarRespuesta(respuesta);
//    }
//    
//     // PROCESAMIENTO COMÚN DE RESPUESTAS
//    private void procesarRespuesta(String respuesta) {
//
//        // Evitamos contabilizar varias respuestas.
//        if (preguntaRespondida || capituloFinalizado) {
//            return;
//        }
//
//        if (respuesta == null || respuesta.isEmpty()) {
//            return;
//        }
//
//        // El modelo determina si es correcta.
//        boolean correcta = modelo.registrarRespuestas(respuestas);
//        
//
//
//        preguntaRespondida = true;
//
//
//        // Bloqueamos todas las respuestas.
//        vistaActividad.habilitarRespuestas(false);
//
//        
//        
//    }
}
