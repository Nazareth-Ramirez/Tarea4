/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author yaris
 */
public class PaginaInformativa extends Pagina {

    public PaginaInformativa(String titulo,
            int numeroPagina, String contenido, String mensajePositivo) {

        super(titulo, numeroPagina, contenido, mensajePositivo);
    }

    
    public String mostrarContenido() {
        return getTitulo() + "\n\n" + getContenido();
    }
}