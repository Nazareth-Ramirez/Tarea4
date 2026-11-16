/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ArraAdministrar;
import vista.GUI_Educativa1;
import vista.GUI_Educativa2;
import vista.GUI_Educativa3;
import vista.GUI_Portada;

/**
 *
 * @author Usuario
 */
public class ControladorActivi2 implements ActionListener {
    private ArraAdministrar modelo;
    private GUI_Educativa2 vista2;
    private GUI_Portada vistaMenu1;
    private GUI_Educativa1 vista1;

    public ControladorActivi2(ArraAdministrar modelo, GUI_Educativa2 vista2, GUI_Portada vistaMenu1, GUI_Educativa1 vista1) {
        this.modelo = modelo;
        this.vista2 = vista2;
        this.vistaMenu1 = vistaMenu1;
        this.vista1 = vista1;
        
        vista2.addButtonListener(this);
    }
    
    

  
    @Override
    public void actionPerformed(ActionEvent e) {
        String op = e.getActionCommand();
        switch (op){
            case "SIGUIENTE":
                abrirCapitulo3();
                break;
            case "REGRESAR":
               volverPaginaAnterior();
                break;
            case "PORTADA":
                volverMenu();
                break;
        }
    }
    
    public void abrirCapitulo3() {
//        Coordenada modelo = new Coordenada();
        GUI_Educativa3 vistaEdu3 = new GUI_Educativa3();
        ControladorActivi3 controltres = new ControladorActivi3(modelo, vista2, vistaMenu1, vistaEdu3);
//        ControladorLibro control = new ControladorLibro(modelo, vistaLibro, vista);

//        vista1.setVisible(false);
        vista2.dispose();
        vistaEdu3.setLocationRelativeTo(null);
        vistaEdu3.setVisible(true);
    }
    
    public void volverPaginaAnterior() {
        vista2.dispose();//para apagar la vista
        vista1.setVisible(true);
    }
    
    public void volverMenu() {
        vista2.dispose();//para apagar la vista
        vistaMenu1.setVisible(true);
    }

    
}
