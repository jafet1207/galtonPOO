void setup(){
    size(800,800);
    background(0);
    
    trianguloPascal pascal = new trianguloPascal();
    pascal.crearTriangulo(10);
    System.out.println("Imprimir");
    
    //pascal.imprimirTriangulo(pascal.getFilas()); //Imprime el triángulo normal
 
    //pascal.graficarTriangulo(pascal.filas, posX, posY, size);
    
    
    //pascal.graficarSierpinski(posX, posY, size); //Grafica el triangulo marcando el triángulo de sierpinski
    
    //pascal.imprimirTriangulo(pascal.diagonal(4)); //Imprime la diagonal en consola y la grafica
}

void draw(){
     fill(128);
     stroke(0);
     rect(50, 50, 200, 100);
     fill(0);
     text("borrar", x+6, y+h-10);
     // verificar si se dio click en el boton
     if(mouseX > x && mouseX < x+w && mouseY > y && mouseY < y+h && mousePressed==true) {
         pascal.imprimirTriangulo(pascal.diagonal(4)); //Imprime la diagonal en consola y la grafica 
     } 
     // seleccionar color de relleno gris
     fill(200);
     // desconectar el borde
     noStroke();
     if(mousePressed == true) {
     // si el mouse está presionado en el área de la ventana
     // dibujar el trazo con elipses de 5 pixeles de radio
     ellipse(mouseX, mouseY, 5, 5);
     }
    
  
}
