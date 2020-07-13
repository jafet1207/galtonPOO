/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesPS;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import shiffman.box2d.Box2DProcessing;
import static processing.core.PConstants.CENTER;
import processing.core.*;
/**
 *
 * @author 
 */
public class Contenedor {
    
    PApplet sketch;
    Box2DProcessing box2d;
    // A boundary is a simple rectangle with x,y,width,and height
    float x;
    float y;
    float w;
    float h;
    // But we also have to make a body for box2d to know about it
    Body b;

    Contenedor(float x_, float y_, float w_, float h_, float a, PApplet sketch, Box2DProcessing box2d) {
        this.sketch = sketch;
        this.box2d = box2d;
        x = x_;
        y = y_;
        w = w_;
        h = h_;

        // Define the polygon
        PolygonShape sd = new PolygonShape();
        // Figure out the box2d coordinates
        float box2dW = box2d.scalarPixelsToWorld(w / 2);
        float box2dH = box2d.scalarPixelsToWorld(h / 2);
        // We're just a box
        sd.setAsBox(box2dW, box2dH);

        // Create the body
        BodyDef bd = new BodyDef();
        bd.type = BodyType.STATIC;
        bd.angle = a;
        bd.position.set(box2d.coordPixelsToWorld(x, y));
        b = box2d.createBody(bd);

        // Attached the shape to the body using a Fixture
        b.createFixture(sd, 1);
    }

    // Draw the boundary, if it were at an angle we'd have to do something fancier
    void display() {
        sketch.noFill();
        sketch.stroke(0);
        sketch.strokeWeight(1);
        sketch.rectMode(CENTER);

        float a = b.getAngle();

        sketch.pushMatrix();
        sketch.fill(238, 208, 157);
        sketch.translate(x, y);
        sketch.rotate(-a);
        sketch.rect(0, 0, w, h);
        sketch.popMatrix();
    }

}
