/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class PaginaActividad extends Pagina {
    
    private String mensajePositivo;

    public PaginaActividad(String mensajePositivo, String titulo, int numeroPagina, String contenido) {
        super(titulo, numeroPagina, contenido);
        this.mensajePositivo = mensajePositivo;
    }
    

    @Override
    public void mostrarContenido(Pagina p) {
        JOptionPane.showMessageDialog(null, "Informacion de la actividad"
                + "\nTitulo: " + p.getTitulo()
                + "\nNumero de pagona: " + p.getNumeroPagina()
                + "\nPregunta: " + p.getContenido());

    }
    
    
    
}
