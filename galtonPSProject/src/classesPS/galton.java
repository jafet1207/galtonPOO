package classesPS;

import UI.MenuWindow;
import processing.core.*;
import java.util.ArrayList;
import shiffman.box2d.*;
import org.jbox2d.dynamics.*;
import static processing.core.PApplet.radians;
import org.jbox2d.dynamics.contacts.*;

/**
 *
 * @author
 */
public class galton extends PApplet {

    ArrayList<Clavo> clavos;
    ArrayList<Contenedor> plataformas;
    Bola[] bolas = new Bola[100]; //Aquí se cambia la cantidad de bolas
    int altura, contador = 1, i, j;
    float clavoX, clavoY, primerclavo;
    Box2DProcessing box2d;

    public void settings() {
        size(800, 800);
    }

    public void setup() {

        box2d = new Box2DProcessing(this);
        box2d.createWorld();
        box2d.listenForCollisions();

        plataformas = new ArrayList<Contenedor>();
        //bolas = new ArrayList<Bola>();
        for (int i = 0; i < bolas.length; i++) { //bolas.length
            bolas[i] = new Bola(random(120, 500), random(-50, 10), this, box2d);
        }
        clavos = new ArrayList<Clavo>();
        //mecanismo de idb
        plataformas.add(new Contenedor(175f, 110f, 800f, 5f, radians(-5), this, box2d));//barra superio iz
        plataformas.add(new Contenedor(625, 180, 810, 5, radians(5), this, box2d));//superio derecha
        plataformas.add(new Contenedor(175, 255, 435, 5, radians(-5), this, box2d));//barra superio iz 2
        plataformas.add(new Contenedor(559, 260, 300, 5, radians(5), this, box2d));//superio derecha 2
        plataformas.add(new Contenedor(800, 115, 100, 5, radians(90), this, box2d));//barrera de choque drecha
        plataformas.add(new Contenedor(0, 137, 200, 5, radians(90), this, box2d));//barrera de choque iz
        plataformas.add(new Contenedor(760, 205, 130, 5, radians(40), this, box2d));//barrera de choque iz

        //bumper
        plataformas.add(new Contenedor(537.5f, 430, 400, 5, radians(-49.8f), this, box2d));
        plataformas.add(new Contenedor(262.5f, 430, 400, 5, radians(49.8f), this, box2d));

        clavoX = 400;
        clavoY = 310;
        altura = 10;
        // genera un triangulo de pascal para saber donde ponder los clavos   
        for (i = 0; i < altura; i++) {
            for (j = 0; j <= i; j++) {
                if (j == 0 || i == 0) {
                    contador = 1;
                    primerclavo = clavoX;
                } else {
                    contador = contador * (i - j + 1) / j;
                    clavoX = clavoX + 50;

                }
                System.out.print("A " + contador);
                clavos.add(new Clavo(clavoX, clavoY, this, box2d));

            }
            System.out.print("\n");
            clavoY = clavoY + 30;
            clavoX = primerclavo - 25;

        }
        // genera la base para que se depositen las bolitas 
        clavoY = clavoY - 30;
        primerclavo = primerclavo - 50;
        plataformas.add(new Contenedor(400, clavoY + 220, 600, 5, radians(180), this, box2d));
        for (i = 0; i < altura + 2; i++) {
            plataformas.add(new Contenedor(primerclavo, clavoY + 110, 210, 5, radians(90), this, box2d));
            primerclavo = primerclavo + 50;
        }

    }

    @Override
    public void draw() {
        background(255);

        box2d.step();

        for (Contenedor wall : plataformas) {
            wall.display();
        }

        //Clavo co = new Clavo(width/2,290);
        //clavos.add(co);
        for (Clavo c : clavos) {
            c.display();

        }

        for (Bola b : bolas) {
            b.display();
        }

        fill(225);
        stroke(255);
        rect(750, 30, 80, 30);
        fill(0);
        text("Regresar", 725, 35);
        if (mouseX > 710 && mouseX < 790 && mouseY > 15 && mouseY < 45 && mousePressed == true) { //Al presionar el botón
           
        }

    }

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

        if (o1.getClass() == Bola.class && o2.getClass() == Clavo.class) {
            Bola p1 = (Bola) o1;
            p1.cambioColor();
        }

    }

    public void endContact(Contact cp) {

    }
}

//cambiocolor random 255 + 100
