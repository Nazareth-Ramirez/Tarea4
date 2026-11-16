/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author kaysc
 */
public class PaginaActividad extends Pagina {

    private String[] opciones = new String[3]; // Arreglo unidimensional de 3 opciones
    private String mensajePositivo;

    public PaginaActividad(String[] opciones, String mensajePositivo, String titulo, int numeroPagina, String contenido) {
        super(titulo, numeroPagina, contenido);
        this.opciones = opciones;
        this.mensajePositivo = mensajePositivo;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public String getMensajePositivo() {
        return mensajePositivo;
    }

    public void setMensajePositivo(String mensajePositivo) {
        this.mensajePositivo = mensajePositivo;
    }

    @Override
    public String mostrarContenido(Pagina p) {
        return "Informacion de la pagina"
                + "\nTitulo: " + p.getTitulo()
                + "\nNumero de pagina: " + p.getNumeroPagina()
                + "\nContenido: " + p.getContenido()
                + "\nOpciones: " + getOpciones();
    }
}
