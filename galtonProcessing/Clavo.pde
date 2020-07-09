class Clavo{
  float r;
  
  
  Body body;
  
  Clavo(float x, float y) {
    // This function puts the particle in the Box2d world
    makeBody(x, y);
    body.setUserData(this);
  }
  
  void makeBody(float x,float y){
    r = 3;
   
    
    BodyDef bd = new BodyDef();      
    bd.type = BodyType.STATIC;
    bd.position.set(box2d.coordPixelsToWorld(x,y));
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

    pushMatrix();
    translate(pos.x,pos.y);    // Using the Vec2 position and float angle to
    rotate(a);              // translate and rotate the rectangle
    fill(175);
    stroke(0);
 
    ellipse(0,0,r*2,r*2);
    popMatrix();
  }
  
//  void display(){
//  noStroke();
//  fill(0);
  //ellipse(x,y,10,10);
 // }
}
