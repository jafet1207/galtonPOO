/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galtonproject;

import java.util.ArrayList;

/**
 *
 * @author Jafet Valverde
 */
public class trianguloPascal {
    private ArrayList<int[]> filas; //Arraylist de arrays de enteros

    public trianguloPascal() {
        filas = new ArrayList<>();
    }
    
    public trianguloPascal(ArrayList<int[]> filas) {
        this.filas = filas;
    }

    public ArrayList<int[]> getFilas() {
        return filas;
    }

    public void setFilas(ArrayList<int[]> filas) {
        this.filas = filas;
    }
    
    public boolean agregarArreglo(int[] fila) {
        filas.add(fila);
        return true;
    }
    
    public void crearTriangulo(int nfilas) {
        int[] arreglo = new int[1];
        for (int i = 1; i <= nfilas; i++) {
            int[] aux = new int[i];
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {
                    aux[j] = 1;
                } else {
                    aux[j] = arreglo[j] + arreglo[j - 1];
                }
                //System.out.print(aux[j] + " ");
            }
            arreglo = aux;
            //System.out.println();
            
            //System.out.println(arreglo instanceof int[]);
            
            //System.out.println(arreglo[0]);
            agregarArreglo(arreglo);
        }
    }
    
    public void imprimirTriangulo(){
        for (int[] fila : filas) {
            for (int i : fila) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    @Override
    public String toString() {
        return "trianguloPascal{" + "filas=" + filas + '}';
    }
    
}
