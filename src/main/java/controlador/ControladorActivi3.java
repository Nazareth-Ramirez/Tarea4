/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ArraAdministrar;
import vista.GUI_Actividad;
import vista.GUI_Educativa2;
import vista.GUI_Educativa3;
import vista.GUI_Portada;

/**
 *
 * @author Usuario
 */
public class ControladorActivi3 implements ActionListener{
    
    private ArraAdministrar modelo;
    private GUI_Educativa2 vista2;
    private GUI_Portada vistaMenu1;
    private GUI_Educativa3 vista3;

    public ControladorActivi3(ArraAdministrar modelo, GUI_Educativa2 vista2, GUI_Portada vistaMenu1, GUI_Educativa3 vista3) {
        this.modelo = modelo;
        this.vista2 = vista2;
        this.vistaMenu1 = vistaMenu1;
        this.vista3 = vista3;
        
        vista3.addButtonListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
          String op = e.getActionCommand();
        switch (op){
            case "ACTIVIDAD":
                abrirActividad();
                break;
            case "REGRESAR":
               volverPaginaAnterior();
                break;
            case "PORTADA":
                volverMenu();
                break;
        }
    }
    
    public void abrirActividad() {
//        Coordenada modelo = new Coordenada();
        GUI_Actividad actividad = new GUI_Actividad();
//        ControladorLibro control = new ControladorLibro(modelo, vistaLibro, vista);

//        vista1.setVisible(false);
        vista3.dispose();
        actividad.setLocationRelativeTo(null);
        actividad.setVisible(true);
    }
    
    public void volverPaginaAnterior() {
        vista3.dispose();//para apagar la vista
        vista2.setVisible(true);
    }
    
    public void volverMenu() {
        vista3.dispose();//para apagar la vista
        vistaMenu1.setVisible(true);
    }
    
}
