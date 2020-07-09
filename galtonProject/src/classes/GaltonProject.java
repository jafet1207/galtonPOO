/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author XPC
 */
public class GaltonProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        trianguloPascal pascal = new trianguloPascal();
        pascal.crearTriangulo(10);
        System.out.println(pascal.diagonal(3));
        System.out.println("Imprimir");
        //pascal.imprimirTriangulo(pascal.getFilas()); //Imprime el triángulo normal
        //pascal.imprimirTriangulo(pascal.diagonales(5)); //Imprime el triángulo de la diagonal indicada
        pascal.imprimirTriangulo(pascal.paresImpares()); //Imprime el triángulo de pares e impares
        //System.out.println(pascal.sumasHorizontales()); //Imprime un ArrayList con los valores de las sumas horizontalmente
        
        
    }
}
