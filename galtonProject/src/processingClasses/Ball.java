/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processingClasses;

import java.awt.Color;
import java.util.Random;
import processing.core.*;

class Ball extends PApplet{

    PVector pos;
    PVector vel;
    float[] c;
    float size;
    float dec;

    Ball(float x, float y, float[] c, float size) {
        pos = new PVector(x, y);
        vel = PVector.random2D();
        vel.mult(random(0.5f, 1.5f));
        this.c = c;
        this.size = size;
        dec = 0;
    }

    void display() {
        noStroke();
        fill(c[0], c[1], c[2], c[3]);
        ellipse(pos.x, pos.y, size, size);
    }

    void update() {
        pos.add(vel);
        if (pos.x < size / 2 || pos.x > width - size / 2) {
            vel.x *= -1;
        }
        if (pos.y < size / 2 || pos.y > height - size / 2) {
            vel.y *= -1;
        }
        size -= dec;
    }

    boolean isDead() {
        return size <= 0;
    }
}
