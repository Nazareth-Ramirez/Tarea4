/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Libro;
import vista.GUI_Menu;
import vista.GUI_Portada;

/**
 *
 * @author Usuario
 */
public class ControladorPortada implements ActionListener{
    
    private GUI_Portada vista = new GUI_Portada();

    public ControladorPortada() {
        vista.addMenuListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        String op = e.getActionCommand();
        switch (op){
            case "INICIO":
                abrirMenu();
                break;
            case "SALIR":
                vista.dispose();
                //System.exit(0);
                break;
                
        }
        
    }
    
     public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public void abrirMenu() {
//        Coordenada modelo = new Coordenada();
//        Libro modelo = new Libro();
        GUI_Menu vistaMenu = new GUI_Menu();
//        ControladorLibro control = new ControladorLibro(modelo, vistaLibro, vista);
        ControladorLibro controlUno = new ControladorLibro(vista, vistaMenu);

        vista.setVisible(false);
        vistaMenu.setLocationRelativeTo(null);
        vistaMenu.setVisible(true);
    }
    
}
