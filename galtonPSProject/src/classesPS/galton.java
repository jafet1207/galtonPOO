package classesPS;

import UI.menuWindow;
import processing.core.*;
import java.util.ArrayList;
import shiffman.box2d.*;
import org.jbox2d.dynamics.*;
import static processing.core.PApplet.radians;
import org.jbox2d.dynamics.contacts.*;

/**
 * Clase que se encarga de crear y grafica el aparato de Galton y sus funcionalidades
 * @author Priscilla Chacón
 * @author Álvaro Moreira
 * @author Jafet Valverde
 */
public class galton extends PApplet {

    static int size = 0;

    public galton(int tamano) {
        size = tamano;
        PApplet pa = new processingWindow();
        PApplet.main(classesPS.galton.processingWindow.class.getName());
    }

    /**
     * Clase interna que genera la ventana de processing
     */
    public static class processingWindow extends PApplet {

        ArrayList<clavo> clavos;
        ArrayList<contenedor> plataformas; 
        figura[] bolas = new bola[150]; //Aquí se cambia la cantidad de bolas
        int contador = 1, i, j;
        float clavoX, clavoY, primerclavo;
        Box2DProcessing box2d;
        float[] color = {0, 0, 0};

        /**
         * Acá se configura el tamaño de la ventana
         */
        public void settings() {
            size(800, 800);
        }

        /**
         * Acá van las configuraciones predeterminadas de programa antes de iniciar el bucle
         */
        public void setup() {

            box2d = new Box2DProcessing(this);
            box2d.createWorld();
            box2d.listenForCollisions();
            plataformas = new ArrayList<contenedor>();
            //bolas = new ArrayList<Bola>();
            for (int i = 0; i < bolas.length; i++) { //bolas.length
                bolas[i] = new bola(random(120, 500), random(-50, 10), 6.4f, color, this, box2d);
            }
            clavos = new ArrayList<clavo>();
            //mecanismo de idb
            plataformas.add(new contenedor(175, 110, 800, 5, radians(-5), this, box2d));//barra superio iz
            plataformas.add(new contenedor(625, 180, 810, 5, radians(5), this, box2d));//superio derecha
            plataformas.add(new contenedor(175, 255, 435, 5, radians(-5), this, box2d));//barra superio iz 2
            plataformas.add(new contenedor(559, 260, 300, 5, radians(5), this, box2d));//superio derecha 2
            plataformas.add(new contenedor(800, 115, 100, 5, radians(90), this, box2d));//barrera de choque drecha
            plataformas.add(new contenedor(0, 137, 200, 5, radians(90), this, box2d));//barrera de choque iz
            plataformas.add(new contenedor(760, 205, 130, 5, radians(40), this, box2d));//barrera de choque iz

            //bumper
            plataformas.add(new contenedor(537.5f, 430, 400, 5, radians(-49.8f), this, box2d));
            plataformas.add(new contenedor(262.5f, 430, 400, 5, radians(49.8f), this, box2d));

            clavoX = 400;
            clavoY = 310;
            // genera un triangulo de pascal para saber donde ponder los clavos   
            for (i = 0; i < size; i++) {
                for (j = 0; j <= i; j++) {
                    if (j == 0 || i == 0) {
                        contador = 1;
                        primerclavo = clavoX;
                    } else {
                        contador = contador * (i - j + 1) / j;
                        clavoX = clavoX + 50;

                    }
                    System.out.print(contador);
                    //clavos.add(new clavo(clavoX, clavoY, this, box2d));
                    clavos.add(new clavo(clavoX, clavoY, 3, color, this, box2d));

                }
                System.out.print("\n");
                clavoY = clavoY + 30;
                clavoX = primerclavo - 25;

            }
            // genera la base para que se depositen las bolitas 
            clavoY = clavoY - 30;
            primerclavo = primerclavo - 50;
            plataformas.add(new contenedor(400, clavoY + 220, 600, 5, radians(180), this, box2d));
            for (i = 0; i < size + 2; i++) {
                plataformas.add(new contenedor(primerclavo, clavoY + 110, 210, 5, radians(90), this, box2d));
                primerclavo = primerclavo + 50;
            }

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
        @Override
        public void draw() {
            background(230);

            box2d.step();

            for (contenedor wall : plataformas) {
                wall.display();
            }

            for (clavo c : clavos) {
                c.display();
            }

            for (figura b : bolas) {
                b.display();
            }
        }

        /**
         * 
         * @param cp 
         */
        public void beginContact(Contact cp) {
            // Get both fixtures

            Fixture f1 = cp.getFixtureA();
            Fixture f2 = cp.getFixtureB();
            // Get both bodies
            Body b1 = f1.getBody();
            Body b2 = f2.getBody();

            // Get our objects that reference these bodies
            Object o1 = b1.getUserData();
            Object o2 = b2.getUserData();
            if (o1 == null || o2 == null) {
                return;
            }

            if (o1.getClass() == bola.class && o2.getClass() == clavo.class) {
                //System.out.println("Entro");
                bola p1 = (bola) o1;
                p1.cambioColor();
            }

        }

        public void endContact(Contact cp) {

        }
    }
}
