/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galtonproject;

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
        System.out.println("Imprimir");
        pascal.imprimirTriangulo();
    }
}
