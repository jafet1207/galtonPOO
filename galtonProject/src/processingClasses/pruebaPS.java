/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processingClasses;

import java.util.ArrayList;
import processing.core.*;
import java.util.Iterator ;


public class pruebaPS extends PApplet {

    float[] color = {random(255), random(255), random(255), random(255)};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PApplet.main(new String[]{processingClasses.pruebaPS.class.getName()});
    }
    
    float posicionX = 50;
    float posicionY = 50;
    float velocidadX = 2;
    float velocidadY = 2;
    
    /*public void settings() {
        size(500, 500);
    }
    
    @Override 
    public void draw() { //FUNCIONA
        if(posicionX == 500 || posicionY == 500 || posicionX == 0 || posicionY == 0){
            velocidadX *= -1;
            velocidadY *= -1;
        }
        posicionX += velocidadX;
        posicionY += velocidadY;
        
        background(40);
        noStroke();
        fill(color[0], color[1], color[2]);
        if(mousePressed){
            ellipse(posicionX, posicionY, 40, 40);
        }

    }*/
    
    
    
    

    
    ArrayList<bola> balls;

    public void settings() {
        size(500, 500);
    }
    
    @Override
    public void setup() {
        size(500, 500);
        background(255, 255, 255);
        balls = new ArrayList();
        blendMode(ADD);
    } 

    @Override
    public void draw() {
        background(0);
        Iterator<bola> it = balls.iterator();
        while (it.hasNext()) {
            bola b = it.next();
            b.display();
            b.update();
            if (b.isDead()) {
                it.remove();
            }
        }
        if (mousePressed) { //Al darle click
            for (int i = 0; i < 10; i++) { //Durante N veces
                float[] c = {random(255), random(255), random(255), 128}; //Crea un nuevo color
                bola b = new bola(mouseX, mouseY, 5,5, c, random(10, 20),5); //Crea una nueva bola
                balls.add(b); //Agrega la bola a la lista
            }
        }
    }

    
}
