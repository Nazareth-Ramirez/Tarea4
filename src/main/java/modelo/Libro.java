/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kaysc
 */
public class Libro {

    ArrayList<Pagina> pag = new ArrayList<>();

    public void inicializarContenido() {
        // Página 1: Capítulo 1 - Toronja (Rojo y Naranja)
        pag.add(new PaginaInformativa(
                "Capítulo 1: El rastro cálido de Toronja\n\n",
                1,
                "INTRODUCCIÓN: Mamá Arcoíris bajó muy preocupada de las nubes porque un viento "
                + "\ntravieso dispersó a sus tres hijitos por la Tierra.\n\n"
                + "\nEn un huerto soleado lleno de fresas y mandarinas encontró a TORONJA. "
                + "\nSu pelaje ROJO (color primario lleno de energía) y NARANJA (color secundario "
                + "\nque nace al mezclar rojo + amarillo) brillaba como el atardecer. "
                + "\n¡Toronja subió al lomo de su mamá para buscar a sus hermanos!"));

        // Página 2: Capítulo 2 - Limón (Amarillo y Verde)
        pag.add(new PaginaInformativa(
                "Capítulo 2: La travesura de Limón\n\n",
                2,
                "Junto a Toronja, Mamá Arcoíris llegó a un prado lleno de girasoles y árboles frondosos. "
                + "\nEscondido entre las hojas de un limonero escuchó un dulce maullido: ¡era LIMÓN!\n\n"
                + "\nSu pelaje AMARILLO (color primario radiante como el sol) y VERDE (color secundario "
                + "\nque se forma al unir amarillo + azul) se confundía con el pasto fresco. "
                + "\nMamá Arcoíris lo abrazó feliz y continuaron la búsqueda."));

        // Página 3: Capítulo 3 - Uva (Azul y Morado)
        pag.add(new PaginaInformativa(
                "Capítulo 3: El sueño nocturno de Uva\n\n",
                3,
                "Al caer la tarde, junto a un lago tranquilo y un jardín de lavandas, "
                + "\nMamá Arcoíris encontró al más pequeño acurrucado mirando las estrellas: ¡era UVA!\n\n"
                + "\nSu pelaje AZUL (color primario profundo como el mar) y MORADO (color secundario "
                + "\nmágico que nace al mezclar azul + rojo) brillaba bajo la luna. "
                + "\nCon sus tres hijos reunidos, los seis colores volvieron a formar el gran Miau-rcoiris."));
    }

    public void consultar() {

        int opPag = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de una pagina"));

        boolean existe = false;

        for (int i = 0; i < pag.size(); i++) {

            Pagina p = pag.get(i);
            
            if (opPag == pag.get(i).getNumeroPagina()) {
                JOptionPane.showMessageDialog(null, p.mostrarContenido(p));

                existe = true;

            } else if (!existe) {
                JOptionPane.showMessageDialog(null, "LA PAGINA QUE DIGITO NO EXISTE");
            }
        }//FIN DEL CONSULTAR
    }

    public void disponibles() {

        JOptionPane.showMessageDialog(null, "La cantidad de pagina que tenemos es de: " + pag.size());
    }

}
