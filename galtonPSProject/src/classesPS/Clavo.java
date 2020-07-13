/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesPS;


import static javafx.scene.transform.Transform.translate;
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
public class Clavo {

    float r;
    PApplet sketch;
    Box2DProcessing box2d;
    float[] c = {0, 0, 0};

    Body body;

    Clavo(float x, float y, PApplet sketch, Box2DProcessing box2d) {
        // This function puts the particle in the Box2d world
        this.sketch = sketch;
        this.box2d = box2d;
        makeBody(x, y);
        body.setUserData(this);
        c[0] = 175;
    }

    void makeBody(float x, float y) {
        r = 3;

        BodyDef bd = new BodyDef();
        bd.type = BodyType.STATIC;
        bd.position.set(box2d.coordPixelsToWorld(x, y));
        body = box2d.createBody(bd);
        body.setUserData(this);

        // Define a polygon (this is what we use for a circle)
        CircleShape sd = new CircleShape();
        sd.m_radius = box2d.scalarPixelsToWorld(r);

        FixtureDef fd = new FixtureDef();
        fd.shape = sd;
        // Parameters that affect physics
        fd.density = 1;
        fd.friction = 0;
        fd.restitution = 0;

        // Attach Fixture to Body               
        body.createFixture(fd);

    }

    void display() {
        // We need the Body’s location and angle
        Vec2 pos = box2d.getBodyPixelCoord(body);
        float a = body.getAngle();

        sketch.pushMatrix();
        sketch.translate(pos.x, pos.y);    // Using the Vec2 position and float angle to
        sketch.rotate(a);              // translate and rotate the rectangle
        sketch.fill(175);
        sketch.stroke(0);

        sketch.ellipse(0, 0, r * 2, r * 2);
        sketch.popMatrix();
    }

//  void display(){
//  noStroke();
//  fill(0);
    //ellipse(x,y,10,10);
    // }
}
