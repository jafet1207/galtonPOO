class Bola{
  float r;//radio
  color c;//color
  boolean m_contacting;
  
  
  
 
  
  Body body;
  
  
  Bola(float x, float y) {
    // This function puts the particle in the Box2d world
    makeBody(x, y);
    body.setUserData(this);
    c = color(254,0,0);
    
  }
  
  void makeBody(float x,float y){
    r = 6.4;
   
   
    
    BodyDef bd = new BodyDef();      
    bd.type = BodyType.DYNAMIC;
    bd.position.set(box2d.coordPixelsToWorld(x,y));
    body = box2d.createBody(bd);
    // Define a polygon (this is what we use for a rectangle)
    CircleShape sd = new CircleShape();
    sd.m_radius = box2d.scalarPixelsToWorld(r);
     
    FixtureDef fd = new FixtureDef();
    fd.shape = sd;
    // Parameters that affect physics
    fd.density = 1;
    fd.friction = 0;
    fd.restitution = .09;

    // Attach Fixture to Body               
    body.createFixture(fd);
    
  }
    void display() {
    // We need the Body’s location and angle
    Vec2 pos = box2d.getBodyPixelCoord(body);    
    float a = body.getAngle();

    pushMatrix();
    translate(pos.x,pos.y);    // Using the Vec2 position and float angle to
    rotate(-a);              // translate and rotate the rectangle
    fill(c);
    stroke(0);
    rectMode(CENTER);
    ellipse(0,0,r*2,r*2);
    popMatrix();
  }
   void startContact() { 
   m_contacting = true;
 }
   
   void endContact(){
   m_contacting = false;
   
   }
     
   void applyForce(){//Vec2 force){
  // Vec2 pos = body.getWorldCenter();
 //  body.applyForce(force,pos);
   c = color(random(255), random(255), random(255), 128);
   
   //System.out.println("ENTRO");
     }

     
   }
