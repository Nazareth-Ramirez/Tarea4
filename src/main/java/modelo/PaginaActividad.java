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

    public PaginaActividad(String titulo, int numeroPagina, String contenido) {
        super(titulo, numeroPagina, contenido);
    }

    @Override
    public String mostrarContenido() {
        return "Actividad " + getNumeroPagina() + ": " + getTitulo()
                + "\n\n" + getContenido()
                + "\n\nSeleccione una respuesta según el enunciado:";
    }

    
    
}
