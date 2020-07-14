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
import shiffman.box2d.Box2DProcessing;
import processing.core.*;

/**
 *
 * @author 
 */
public class clavo extends figura{

    Body body;
    
     public clavo(float x, float y, float radio, float[] color, PApplet sketch, Box2DProcessing box2d) {
        super(radio, color, sketch, box2d);
        makeBody(x, y);
        body.setUserData(this); //Puede fallar, talvez sea sketch en lugar de this o viceversa
        color[0] = 255;
    }

    @Override
    public void makeBody(float x, float y) {
        //r = 3;

        BodyDef bd = new BodyDef();
        bd.type = BodyType.STATIC;
        bd.position.set(box2d.coordPixelsToWorld(x, y));
        body = box2d.createBody(bd);
        body.setUserData(this);

        // Define a polygon (this is what we use for a circle)
        CircleShape sd = new CircleShape();
        sd.m_radius = box2d.scalarPixelsToWorld(radio);

        FixtureDef fd = new FixtureDef();
        fd.shape = sd;
        // Parameters that affect physics
        fd.density = 1;
        fd.friction = 0;
        fd.restitution = 0;

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
        sketch.rotate(a);              // translate and rotate the rectangle
        sketch.fill(175);
        sketch.stroke(0);

        sketch.ellipse(0, 0, radio * 2, radio * 2);
        sketch.popMatrix();
    }

}
