void setup(){
    size(800,800);
    background(0);
    
    //pascal.imprimirTriangulo(pascal.getFilas()); //Imprime el triángulo normal
 
    //pascal.graficarTriangulo(pascal.filas, posX, posY, size);
    
    
    //pascal.graficarSierpinski(posX, posY, size); //Grafica el triangulo marcando el triángulo de sierpinski
    
    //pascal.imprimirTriangulo(pascal.diagonal(4)); //Imprime la diagonal en consola y la grafica
}

void draw(){
    int posX = 15; int posY = -35; int size = 40; //Para los botones
    int X = 26; int Y = -10; //Para los textos
    trianguloPascal pascal = new trianguloPascal();
    pascal.crearTriangulo(10);
    
    for(int i = 0; i < pascal.getFilas().size(); i++){ //Botones de diagonales
      fill(225);
      stroke(255);
      rect(posX, posY+=size+10, size*2, size);
      fill(0);
      text("Diagonal"+(i+1), X, Y+=size+10);
      if(mouseX > posX && mouseX < posX+(size*2) && mouseY > posY && mouseY < posY+size && mousePressed==true) {
          background(0);
          //pascal.imprimirTriangulo(pascal.diagonal(i+1)); //Imprime la diagonal en consola y la grafica 
          pascal.diagonal(i+1); //Grafica el triangulo con la diagonal
      }
    }
    
    posX = 15; posY = 15; //Para los botones
    X = 26; Y = 40; //Para los textos
    String[] titulos = {" Sierpinski"," Sumas H","  Simetría"," Fibonacci","   Pascal"};
    for(int i = 0; i < 5; i++){ //Botones de otros
      fill(225);
      stroke(255);
      rect(posX+=size*2+10, posY, size*2, size);
      fill(0);
      text(titulos[i], X+=(size*2)+10, Y);
      if(mouseX > posX && mouseX < posX+(size*2) && mouseY > posY && mouseY < posY+size && mousePressed==true) {
           if(i == 0){
             background(0);
             pascal.sierpinski();
           } else if(i == 1){
             background(0);
             pascal.sumasHorizontales();
           } else if(i == 2){
             //Simetría
           } else if(i == 3){
             //Fibonacci
           } else if(i == 4){
             background(0);
             pascal.graficarTriangulo();
           }
      }
    }
     
}
