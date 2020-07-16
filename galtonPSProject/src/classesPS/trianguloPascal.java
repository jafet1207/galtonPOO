/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesPS;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Clase que se encarga de crear una instancia de la clase pascal con la funcionalidad indicada en el constructor de esta clase
 * @author Priscilla Chacón
 * @author Álvaro Moreira
 * @author Jafet Valverde
 */
public class trianguloPascal {

    static int size = 0;
    static int valor = 0;
    static int diagonal = 0;

    public trianguloPascal(int val, int tamano) {
        valor = val;
        size = tamano;
        PApplet pa = new processingWindow();
        PApplet.main(classesPS.trianguloPascal.processingWindow.class.getName());
    }

    public trianguloPascal(int val, int tamano, int diag) {
        valor = val;
        size = tamano;
        diagonal = diag;
        PApplet pa = new processingWindow();
        PApplet.main(classesPS.trianguloPascal.processingWindow.class.getName());
    }
    
    /**
     * Clase interna que genera la ventana de processing
     */
    public static class processingWindow extends PApplet {

        /**
         * Acá se configura el tamaño de la ventana
         */
        public void settings() {
            //generated size: replace this settings with yours
            size(650, 600);
        }

        /**
         * Acá van las configuraciones predeterminadas de programa antes de iniciar el bucle
         */
        public void setup() {
            background(230);
        }

        /**
         * Cierra la ventana sin cerrar todo el proyecto
         */
        public void exit() {
            super.stop();
        }

        /**
         * Bucle infinito donde se ejecuta el aparato de Galton
         */
        public void draw() {
            pascal p = new pascal(this);
            p.crearTriangulo(size);

            if (valor == 1) {
                p.graficarTriangulo();
            } else if (valor == 2) {
                p.diagonal(diagonal);
            } else if (valor == 3) {
                p.sierpinski();
            } else if (valor == 4) {
                p.sumasHorizontales();
            } else if (valor == 5) {
                p.simetria();
            } else if (valor == 6) {
                p.fibonacci();
            }
        }
    }
}
