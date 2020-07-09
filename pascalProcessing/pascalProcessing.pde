void setup(){
    size(800,800);
    background(0);
    
    int posX = 325; int posY = 100; int size = 50;
    
    trianguloPascal pascal = new trianguloPascal();
    pascal.crearTriangulo(10);
    System.out.println("Imprimir");
    
    pascal.imprimirTriangulo(pascal.getFilas()); //Imprime el triángulo normal
 
    //pascal.graficarTriangulo(pascal.filas, posX, posY, size);
    
    //pascal.graficarDiagonal(10, posX, posY, size); //Grafica el triangulo marcando una  diagonal
    
    pascal.graficarSierpinski(posX, posY, size); //Grafica el triangulo marcando el triángulo de sierpinski
}

void draw(){
    //
    
    
  
}
