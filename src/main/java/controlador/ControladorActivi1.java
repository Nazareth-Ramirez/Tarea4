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
import vista.GUI_Portada;

/**
 *
 * @author Usuario
 */
public class ControladorActivi1 implements ActionListener{
    
    private ArraAdministrar modelo;
    private GUI_Educativa1 vista1;
    private GUI_Portada vistaMenu1;

    public ControladorActivi1(ArraAdministrar modelo, GUI_Educativa1 vista1, GUI_Portada vistaMenu1) {
        this.modelo = modelo;
        this.vista1 = vista1;
        this.vistaMenu1 = vistaMenu1;
        
        vista1.addButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String op = e.getActionCommand();
        switch (op){
            case "SIGUIENTE":
                abrirCapitulo2();
                break;
            case "REGRESAR":
                volverMenu();
                break;
        }
    }
    
    public void abrirCapitulo2() {
//        Coordenada modelo = new Coordenada();
        GUI_Educativa2 vistaEdu2 = new GUI_Educativa2();
//        ControladorLibro control = new ControladorLibro(modelo, vistaLibro, vista);
        ControladorActivi2 controldos = new ControladorActivi2(modelo, vistaEdu2, vistaMenu1, vista1);

//        vista1.setVisible(false);
        vista1.dispose();
        vistaEdu2.setLocationRelativeTo(null);
        vistaEdu2.setVisible(true);
    }

    public void volverMenu() {
        vista1.dispose();//para apagar la vista
        vistaMenu1.setVisible(true);
    }

}
