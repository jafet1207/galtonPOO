/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesPS;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import static processing.core.PConstants.CENTER;
import shiffman.box2d.Box2DProcessing;
import processing.core.*;

/**
 *
 * @author
 */
public class bola extends figura{
    
    boolean m_contacting;
    float[] c = {255, 0, 0};
    //Body body;

    public bola(float x, float y, float radio, float[] color, PApplet sketch, Box2DProcessing box2d) {
        super(radio, color, sketch, box2d);
        makeBody(x, y);
        body.setUserData(this); //Puede fallar, talvez sea sketch en lugar de this o viceversa
        c[0] = (float) (Math.random()*255)+100;
        c[1] = (float) (Math.random()*255)+100;
        c[2] = (float) (Math.random()*255)+100;
        color=c;
    }
    
    @Override
    public void makeBody(float x, float y) {

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position.set(box2d.coordPixelsToWorld(x, y)); //Falla
        body = box2d.createBody(bd);
        // Define a polygon (this is what we use for a rectangle)
        CircleShape sd = new CircleShape();
        sd.m_radius = box2d.scalarPixelsToWorld(radio);
        
        FixtureDef fd = new FixtureDef();
        fd.shape = sd;
        // Parameters that affect physics
        fd.density = 1;
        fd.friction = 0;
        fd.restitution = (float) 0.09;

        // Attach Fixture to Body               
        body.createFixture(fd);

    }

    @Override
    public void display() {
        // We need the Body’s location and angle
        Vec2 pos = box2d.getBodyPixelCoord(body);
        float a = body.getAngle();

        sketch.pushMatrix();
        sketch.translate(pos.x, pos.y);    // Using the Vec2 position and float angle to
        sketch.rotate(-a);              // translate and rotate the rectangle
        sketch.fill(c[0], c[1], c[2]);
        sketch.stroke(0);
        sketch.rectMode(CENTER);
        sketch.ellipse(0, 0, radio * 2, radio * 2);
        sketch.popMatrix();
    }

    void cambioColor() {
        
        c[0] = (float) (Math.random()*255)+100;
        c[1] = (float) (Math.random()*255)+100;
        c[2] = (float) (Math.random()*255)+100;
        
        
    }

}
