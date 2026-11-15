/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author yaris
 */
public class ArraAdministrar {

    Pagina p = new Pagina();
    ArrayList<Pagina> pag = new ArrayList<>();

    public void agregar() {

//        String nombre = JOptionPane.showInputDialog("Digite el nombre del capitulo aqui:");
//        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de la pagina:"));
//        String cont = JOptionPane.showInputDialog("Digite el contenido del capitulo aqui:");
        pag.add(new Pagina("Colores Primarios", 1, "Los colores primarios son rojo, azul y amarillo","¡Muy bien! Vas a dar el primer paso, aprender sobre los colores primarios es divertido"));
        pag.add(new Pagina("Colores cálidos y fríos", 2, "Los colores cálidos son los que se parecen al sol o al fuego y son: El rojo, el naranja y el amarillo."
                + "                    \nLos colores fríos son los que se parecen al agua o a la noche y sus colores son; El azul, el verde y el morado.",
                                      "\n¡Ahora vas a conocer sobre los cálidos y fríos! Vas a conocer sobre los secretos de la paleta de colores"));
        pag.add(new Pagina("Colores Primarios", 3, "Los colores primarios son rojo, azul y amarillo", "¡Vas por buen camino! Cada mezcla te acerca más a dominar el arte de los colores."));
        pag.add(new Pagina("Actividad colores", 4, "Ahora vamos a jugar para saber que aprendimos","¡Es hora de jugar! Todo va a estar bien, las actividades son divertidas" ));
    }

    
    
    public void consultar(){

        int opPag = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de una pagina"));
        
        boolean existe = false;
        
        for (int i = 0; i < pag.size(); i++) {
            
            
            if (opPag == pag.get(i).getNumeroPag()) {
                JOptionPane.showMessageDialog(null, "El dato de la pagina es: "
                        + "\nTitulo " + pag.get(i).getTitulo()
                        + "Pagina " + pag.get(i).getNumeroPag()
                        + "\nContenido " + pag.get(i).getContenido());
                
            existe = true;
            
            }else if(!existe){
                JOptionPane.showMessageDialog(null, "LA PAGINA QUE DIGITO NO EXISTE");
            }
        }//FIN DEL CONSULTAR
    }   
        
   public void recorrido(){
       
       for(int i=0; i<pag.size(); i++){
           
            JOptionPane.showMessageDialog(null, "El dato de la pagina es: "
                        + "\n Indice: " +i
                        + "\nTitulo " + pag.get(i).getTitulo()
                        + "\nPagina " + pag.get(i).getNumeroPag()
                        + "\nContenido " + pag.get(i).getContenido());
            
            
       }
   }

  public void disponibles(){
      
      JOptionPane.showMessageDialog(null, "La cantidad de pagina que tenemos es de: " +pag.size());
  }
        
        
    

}
