/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processingClasses;

import java.util.Random;
import processing.core.*;

class bola extends PApplet {

    int posX;
    int posY;
    int velX;
    int velY;
    float[] color;
    float size;
    float dec;

    public bola() {
    }

    public bola(int posX, int posY, int velX, int velY, float[] color, float size, float dec) {
        this.posX = posX;
        this.posX = posX;
        this.velX = velX;
        this.velY = velY;
        this.color = color;
        this.size = size;
        this.dec = dec;
    }

    public void display() {
        noStroke();
        fill(color[0], color[1], color[2], color[3]);
        ellipse(posX, posY, size, size);
    }
    public void update() {
        posX+=velX;
        posY+=velY;
        if (posX < size / 2 || posY > width - size / 2) {
            velX *= -1;
        }
        if (posX < size / 2 || posY > height - size / 2) {
            velY *= -1;
        }
        size -= dec;
    }

    public boolean isDead() {
        return size <= 0;
    }
    
}
