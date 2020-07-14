/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesPS;

import org.jbox2d.dynamics.Body;
import processing.core.PApplet;
import shiffman.box2d.Box2DProcessing;

/**
 *
 * @author 
 */
public abstract class figura {
    
    PApplet sketch;
    Box2DProcessing box2d;
    float radio;//radio
    float[] color = {0,0,0};
    Body body;

    public figura(PApplet sketch) {
        this.sketch = sketch;
    }
    
    public figura(float radio, float[] color, PApplet sketch, Box2DProcessing box2d) {
        this.sketch = sketch;
        this.box2d = box2d;
        this.radio = radio;
        this.color = color;
    }

    public PApplet getSketch() {
        return sketch;
    }

    public void setSketch(PApplet sketch) {
        this.sketch = sketch;
    }

    public Box2DProcessing getBox2d() {
        return box2d;
    }

    public void setBox2d(Box2DProcessing box2d) {
        this.box2d = box2d;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public float[] getColor() {
        return color;
    }

    public void setColor(float[] color) {
        this.color = color;
    }
    
    public abstract void makeBody(float x, float y);
    public abstract void display();

    @Override
    public String toString() {
        return "radio=" + radio + ", color=" + color;
    }
    
    
}
