/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesPS;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 *
 * @author
 */
public class trianguloPascal {

    static int size = 0;
    static int valor = 0;
    static int diagonal = 0;

    public trianguloPascal(int val, int tamano) {
        valor = val;
        size = tamano;
        PApplet pa = new processingWindow();
        PApplet.main(classesPS.trianguloPascal.processingWindow.class.getName());
    }
    
    public trianguloPascal(int val, int tamano, int diag) {
        valor = val;
        size = tamano;
        diagonal = diag;
        PApplet pa = new processingWindow();
        PApplet.main(classesPS.trianguloPascal.processingWindow.class.getName());
    }

    /*public void correr(int valor) {
        if (valor == 1) {
            PApplet pa = new processingWindow();
            PApplet.main(classesPS.trianguloPascal.processingWindow.class.getName());
        }

    }*/
    public static class processingWindow extends PApplet {

        public void settings() {
            //generated size: replace this settings with yours
            size(800, 800);
        }

        public void setup() {
            background(255);

        }

        public void exit() {

            super.stop();
        }

        public void draw() {
            pascal p = new pascal(this);
            p.crearTriangulo(size);

            if (valor == 1) {
                p.graficarTriangulo();
            } else if(valor == 2) {
                p.diagonal(diagonal);
            } else if(valor == 3) {
                p.sierpinski();
            } else if(valor == 4) {
                p.sumasHorizontales();
            } else if(valor == 5) {
                p.simetria();
            }
            //p.sierpinski();
        }
    }

    public static class pascal {

        PApplet sketch;
        private ArrayList<int[]> filas; //Arraylist de arrays de enteros
        int posX = 325;
        int posY = 200;
        int size = 50;

        public pascal(PApplet sketch) {
            filas = new ArrayList<int[]>();
            this.sketch = sketch;
        }

        public pascal(ArrayList<int[]> filas, PApplet sketch) {
            this.filas = filas;
            this.sketch = sketch;
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

        public void restaurarPosiciones() {
            posX = 325;
            posY = 100;
            size = 50;
        }

        public void crearTriangulo(int nfilas) {
            int[] arreglo = new int[1];

            for (int i = 1; i <= nfilas; i++) {
                int[] aux = new int[i]; //Crea nuevo array de enteros

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

        public void imprimirTriangulo(ArrayList<int[]> filas) {
            for (int[] fila : filas) {
                for (int i : fila) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }

        public ArrayList<int[]> diagonal(int diag) { //Lógica y grafico juntos
            int x = posX;
            int y = posY;
            ArrayList<int[]> diags = new ArrayList();
            int[] arreglo = new int[1];
            int cont = 1;
            for (int[] fila : filas) {
                int[] aux = new int[cont];
                int contAux = 0;
                for (int i : fila) {
                    if (contAux == diag - 1) {
                        sketch.fill(50);
                        aux[contAux] = i * -1;
                    } else {
                        sketch.fill(150); //Los cuadros salen grises
                        aux[contAux] = i;
                    }
                    sketch.rect(x += size, y, size, size);//PosX, PosY, Ancho, Alto
                    sketch.fill(0); //El texto sale negro
                    sketch.text(i, x + (size / 2) - 3, y + (size / 2) + 5);
                    contAux++;
                }
                arreglo = aux;
                agregarFila(diags, arreglo);
                y += size;
                x = posX -= size / 2;
                cont++;
            }
            restaurarPosiciones();
            return diags;
        }

        public ArrayList<int[]> sierpinski() { //Lógica y grafico juntos
            int x = posX;
            int y = posY;
            ArrayList<int[]> sierp = new ArrayList();
            int[] arreglo = new int[1];
            int cont = 1;
            for (int[] fila : filas) {
                int[] aux = new int[cont];
                int contAux = 0;
                for (int i : fila) {
                    if (i % 2 == 0) { //Pares
                        sketch.fill(50);
                        aux[contAux] = i;
                    } else { //Impares
                        sketch.fill(150); //Los cuadros salen grises
                        aux[contAux] = i * -1;
                    }
                    sketch.rect(x += size, y, size, size);//PosX, PosY, Ancho, Alto
                    sketch.fill(0); //El texto sale negro
                    sketch.text(i, x + (size / 2) - 3, y + (size / 2) + 5);
                    contAux++;
                }
                arreglo = aux;
                agregarFila(sierp, arreglo);
                y += size;
                x = posX -= size / 2;
                cont++;
            }
            restaurarPosiciones();
            return sierp;
        }

        public ArrayList<Integer> sumasHorizontales() { //Lógica y grafico juntos
            int auxX = posX + (size * 3);
            int auxY = posY - size;
            graficarTriangulo();

            ArrayList<Integer> arreglo = new ArrayList<Integer>();

            for (int i = 1; i <= filas.size(); i++) {
                sketch.fill(50);
                sketch.line(auxX - 45, auxY + size + (size / 2), auxX + 20, auxY + size + (size / 2));
                sketch.rect(auxX += size / 2, auxY += size, size, size);

                int[] actual = filas.get(i - 1);
                int cant = 0;
                for (int j = 0; j < i; j++) {
                    cant += actual[j];
                }
                arreglo.add(cant);
                sketch.fill(0); //El texto sale negro
                if (cant < 9) {
                    sketch.text(cant, auxX + (size / 2) - 3, auxY + (size / 2) + 5);
                } else if (cant < 99) {
                    sketch.text(cant, auxX + (size / 2) - 6, auxY + (size / 2) + 5);
                } else {
                    sketch.text(cant, auxX + (size / 2) - 9, auxY + (size / 2) + 5);
                }
            }
            restaurarPosiciones();
            return arreglo;
        }

        public void graficarTriangulo() {
            int x = posX;
            int y = posY;
            for (int[] fila : filas) {
                for (int i : fila) {
                    sketch.fill(150); //Los cuadros salen grises
                    sketch.rect(x += size, y, size, size);//PosX, PosY, Ancho, Alto
                    sketch.fill(0); //El texto sale negro
                    sketch.text(i, x + (size / 2) - 3, y + (size / 2) + 5);
                }
                y += size;
                x = posX -= size / 2;
            }
        }

        public ArrayList<ArrayList<Integer>> simetria() {
            int x = posX;
            int y = posY;
            ArrayList<ArrayList<Integer>> lista = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> izquierda = new ArrayList<Integer>();
            ArrayList<Integer> derecha = new ArrayList<Integer>();
            for (int[] fila : filas) {
                if (fila.length == 1) {
                    izquierda.add(1);
                    derecha.add(1);
                    sketch.fill(150);
                    sketch.rect(x += size, y, size / 2, size);//PosX, PosY, Ancho, Alto
                    sketch.fill(50);
                    sketch.rect(x + size / 2, y, size / 2, size);//PosX, PosY, Ancho, Alto
                    sketch.fill(0); //El texto sale negro
                    sketch.text(1, x + (size / 2) - 3, y + (size / 2) + 5);
                } else if (fila.length % 2 == 0) { //Pares
                    for (int i = 0; i < fila.length / 2; i++) { //Primera mitad
                        int actual = fila[i];
                        izquierda.add(actual);
                        sketch.fill(150);
                        sketch.rect(x += size, y, size, size);//PosX, PosY, Ancho, Alto
                        sketch.fill(0); //El texto sale negro
                        sketch.text(actual, x + (size / 2) - 3, y + (size / 2) + 5);
                    }
                    for (int i = fila.length / 2; i < fila.length; i++) { //Segunda mitad
                        int actual = fila[i];
                        derecha.add(actual);
                        sketch.fill(50);
                        sketch.rect(x += size, y, size, size);//PosX, PosY, Ancho, Alto
                        sketch.fill(0); //El texto sale negro
                        sketch.text(actual, x + (size / 2) - 3, y + (size / 2) + 5);
                    }
                } else { //Impares
                    for (int i = 0; i < fila.length / 2; i++) { //Primera mitad
                        int actual = fila[i];
                        izquierda.add(actual);
                        sketch.fill(150);
                        sketch.rect(x += size, y, size, size);//PosX, PosY, Ancho, Alto
                        sketch.fill(0); //El texto sale negro
                        sketch.text(actual, x + (size / 2) - 3, y + (size / 2) + 5);
                    }
                    for (int i = fila.length / 2; i < fila.length; i++) { //Segunda mitad
                        int actual = fila[i];
                        derecha.add(actual);
                        if (i == fila.length / 2) {
                            sketch.fill(150);
                            sketch.rect(x += size, y, size / 2, size);//PosX, PosY, Ancho, Alto
                            sketch.fill(50);
                            sketch.rect(x + size / 2, y, size / 2, size);//PosX, PosY, Ancho, Alto
                            sketch.fill(0); //El texto sale negro
                            sketch.text(actual, x + (size / 2) - 3, y + (size / 2) + 5);
                        } else {
                            sketch.fill(50);
                            sketch.rect(x += size, y, size, size);//PosX, PosY, Ancho, Alto
                            sketch.fill(0); //El texto sale negro
                            sketch.text(actual, x + (size / 2) - 3, y + (size / 2) + 5);
                        }
                    }
                }
                y += size;
                x = posX -= size / 2;
            }
            lista.add(izquierda);
            lista.add(derecha);
            restaurarPosiciones();
            return lista;
        }

        public void imprimirSimetria(ArrayList<ArrayList<Integer>> lista) {
            System.out.print("Izq ");
            for (int i : lista.get(0)) {
                System.out.print(i + " ");
            }
            System.out.print("\nDer ");
            for (int i : lista.get(1)) {
                System.out.print(i + " ");
            }
        }

        public void fibonacci() {
            int x = posX;
            int y = posY;
            for (int[] fila : filas) {
                for (int i : fila) {
                    sketch.fill(150); //Los cuadros salen grises
                    sketch.rect(x += size, y, size, size);//PosX, PosY, Ancho, Alto
                    sketch.fill(0); //El texto sale negro
                    sketch.text(i, x + (size / 2) - 3, y + (size / 2) + 5);
                }
                y += size;
                x = posX -= size / 2;
            }
        }

        @Override
        public String toString() {
            return "trianguloPascal{" + "filas=" + filas + '}';
        }

    }

}
