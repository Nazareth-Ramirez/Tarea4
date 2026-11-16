/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ArraAdministrar;
import vista.GUI_Educativa1;
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
                abrirLibro();
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
    
    public void abrirLibro() {
//        Coordenada modelo = new Coordenada();
        ArraAdministrar modelo = new ArraAdministrar();
        GUI_Educativa1 vista1 = new GUI_Educativa1();
//        ControladorLibro control = new ControladorLibro(modelo, vistaLibro, vista);
        ControladorActivi1 controlUno = new ControladorActivi1(modelo, vista1, vista);

        vista.setVisible(false);
        vista1.setLocationRelativeTo(null);
        vista1.setVisible(true);
    }
}
