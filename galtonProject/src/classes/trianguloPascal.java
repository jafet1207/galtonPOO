/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

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
    
    public boolean agregarFila(ArrayList<int[]> filas, int[] fila) {
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
            }
            arreglo = aux;
            agregarFila(filas, arreglo);
        }
    }
    
    public void imprimirTriangulo(ArrayList<int[]> filas){
        for (int[] fila : filas) {
            for (int i : fila) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    public ArrayList diagonal(int diag){
        ArrayList<Integer> aux = new ArrayList<>();
        for (int i = diag; i < filas.size(); i++) {
            aux.add(filas.get(i)[diag]);
        }
        return aux;
    }
    
     public ArrayList<int[]> diagonales(int diag){
        ArrayList<int []> diags = new ArrayList();
        int[] arreglo = new int[1];
        for (int i = 1; i <= filas.size(); i++) { //Recorre todas las filas
            int[] actual = filas.get(i-1);
            
            int[] aux = new int[i];
            
            if(actual.length < diag){ //Filas que tengan menos elementos que diag
                for(int j = 0; j < actual.length; j++){ //Recorre el arreglo actual
                    aux[j] = 0;
                }
            } else { //Filas que tengan más elementos que diag
                for(int j = 0; j < actual.length; j++){ //Recorre el arreglo actual
                    if(j == diag-1){
                        aux[j] = 1;
                    } else{
                        aux[j] = 0;
                    }
                }
            }
            arreglo = aux;
            agregarFila(diags, arreglo);
        }
        return diags ;
    }
    
    public ArrayList<int[]> paresImpares (){
        ArrayList<int []> pares = new ArrayList();
        int[] arreglo = new int[1];
        for (int i = 1; i <= filas.size(); i++) {
            int[] aux = new int[i];
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {
                    aux[j] = 0;
                } else {
                    if ((arreglo[j] + arreglo[j - 1])%2==0){
                        aux[j] = 1;
                    }else{
                        aux[j] = 0;
                    }
                }
            }
            arreglo = aux;
            agregarFila(pares, arreglo);
        }
        return pares;
    }
    
    public ArrayList<Integer> sumasHorizontales(){
        ArrayList<Integer> arreglo = new ArrayList<>();
        
        for (int i = 1; i <= filas.size(); i++) {
            int[] actual = filas.get(i-1);
            int cant = 0;
            for (int j = 0; j < i; j++){
                cant+=actual[j];
            }
            arreglo.add(cant);
        }
        return arreglo;
    }
    
    @Override
    public String toString() {
        return "trianguloPascal{" + "filas=" + filas + '}';
    }
    
}
