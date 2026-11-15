/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;


/**
 *
 * @author yaris
 */
public class Pagina {
    
    private String titulo;
    private int numeroPag;
    private String contenido;
    private String mensajePositivo;
    
    
    //CONSTRUCTOR
    
    
    public Pagina() {
    }

    public Pagina(String titulio, int numeroPag, String contenido, String mensajePositivo) {
        this.titulo = titulio;
        this.numeroPag = numeroPag;
        this.contenido = contenido;
        this.mensajePositivo = mensajePositivo;
    }
    
    //GET Y SET

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulio) {
        this.titulo = titulio;
    }

    public int getNumeroPag() {
        return numeroPag;
    }

    public void setNumeroPag(int numeroPag) {
        this.numeroPag = numeroPag;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getMensajePositivo() {
        return mensajePositivo;
    }

    public void setMensajePositivo(String mensajePositivo) {
        this.mensajePositivo = mensajePositivo;
    }
    
    

    
    
    //public abstract void mostrarContenido(Pagina){
        
    //}

    @Override
    public String toString() {
        return "Pagina{" + "titulo=" + titulo + ", numeroPag=" + numeroPag + ", contenido=" + contenido + ", mensajePositivo=" + mensajePositivo + '}';
    }
    
    
    
}//FIN DE LA CLASE
