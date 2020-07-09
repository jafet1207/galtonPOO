import shiffman.box2d.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.joints.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.contacts.*;

//ArrayList<Bola> bolas;
ArrayList<Clavo> clavos;
ArrayList<Contenedor> plataformas;
Bola[] bolas = new Bola[100]; //Aquí se cambia la cantidad de bolas
int altura,contador=1,i,j;
float clavoX,clavoY,primerclavo;
Box2DProcessing box2d;

void setup(){
    size(800,800);
  
  box2d = new Box2DProcessing(this);  
  box2d.createWorld();
  box2d.listenForCollisions();
  

  plataformas = new ArrayList<Contenedor>();
  //bolas = new ArrayList<Bola>();
  for(int i = 0; i< bolas.length; i++){
    bolas[i] = new Bola(int(random(120,500)),int(random(-50,10)));  
  }
  clavos = new ArrayList<Clavo>();
  //mecanismo de idb
  plataformas.add(new Contenedor(175,110,800,5,radians(-5)));//barra superio iz
  plataformas.add(new Contenedor(625,180,810,5,radians(5)));//superio derecha
  plataformas.add(new Contenedor(175,255,435,5,radians(-5)));//barra superio iz 2
  plataformas.add(new Contenedor(559,260,300,5,radians(5)));//superio derecha 2
  plataformas.add(new Contenedor(800,115,100,5,radians(90)));//barrera de choque drecha
  plataformas.add(new Contenedor(0,185,100,5,radians(90)));//barrera de choque iz
  plataformas.add(new Contenedor(760,205,130,5,radians(40)));//barrera de choque iz
  
  
 
  //bumper
  plataformas.add(new Contenedor(537.5,430,400,5,radians(-49.8)));
  plataformas.add(new Contenedor(262.5,430,400,5,radians(49.8)));
  
  clavoX = 400;
  clavoY= 310;
  altura = 10;  
  // genera un triangulo de pascal para saber donde ponder los clavos   
    for(i=0;i<altura;i++)
    
    {
        for(j=0;j<=i;j++){
            if(j==0||i==0){
                contador=1;
                primerclavo = clavoX;
              }
                else{
               contador=contador*(i-j+1)/j;
               clavoX = clavoX +50;
               
           }
              System.out.print("A "+contador);
              clavos.add(new Clavo(clavoX,clavoY));
              
        }
        System.out.print("\n");
        clavoY =clavoY + 30;
        clavoX = primerclavo -25;
        
    }
    // genera la base para que se depositen las bolitas 
    clavoY =clavoY - 30;
    primerclavo = primerclavo - 50;
    plataformas.add(new Contenedor(400,clavoY+220,600,5,radians(180)));
    for(i=0;i<altura+2;i++){
      plataformas.add(new Contenedor(primerclavo,clavoY+110,210,5,radians(90)));
      primerclavo = primerclavo + 50;
    }
    

  
  
  
}

void draw(){
  background(255);
  
  box2d.step();
  
   for (Contenedor wall: plataformas) {
    wall.display();
  }
  
  //Clavo co = new Clavo(width/2,290);
  //clavos.add(co);
 
   for (Clavo c: clavos) {
    c.display();
    
  }
  
//for(int i =0; i< 1; i++){
//  Bola p = new Bola(random(width),0);
//  bolas.add(p);
//  }
  
  for (Bola b: bolas) {
    b.display();
}

}

void beginContact(Contact cp) {
  // Get both fixtures
  
  Fixture f1 = cp.getFixtureA();
  Fixture f2 = cp.getFixtureB();
  // Get both bodies
  Body b1 = f1.getBody();
  Body b2 = f2.getBody();

  // Get our objects that reference these bodies
  Object o1 = b1.getUserData();
  Object o2 = b2.getUserData();
  if (o1==null || o2==null)
     return;

  if (o1.getClass() == Bola.class && o2.getClass() == Clavo.class) {
    Bola p1 = (Bola) o1;
    int a;
    a= int(random(1,3));
      //for(Bola b: bolas){
         if (a==1 ){
           // Vec2 wind = new Vec2(-1,0);
            p1.applyForce();}
          if (a==2 ){
            //Vec2 wind = new Vec2(+1,0);
            p1.applyForce();
    }
    
  }

}

// Objects stop touching each other
void endContact(Contact cp) {
  

  } 
