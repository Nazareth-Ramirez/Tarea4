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
public class PaginaInformativa extends Pagina {
    
    private String mensajePositivo;

    public PaginaInformativa(String mensajePositivo, String titulo, int numeroPagina, String contenido) {
        super(titulo, numeroPagina, contenido);
        this.mensajePositivo = mensajePositivo;
    }

    
    public String getMensajePositivo() {
        return mensajePositivo;
    }

    public void setMensajePositivo(String mensajePositivo) {
        this.mensajePositivo = mensajePositivo;
    }

   

    @Override
    public void mostrarContenido(Pagina p) {
        JOptionPane.showMessageDialog(null, "Informacion de la pagina"
                + "\nTitulo: " + p.getTitulo()
                + "\nNumero de pagina: " + p.getNumeroPagina()
                + "\nContenido: " + p.getContenido()
                + "\n"+ mensajePositivo);

    }
    
    
}
