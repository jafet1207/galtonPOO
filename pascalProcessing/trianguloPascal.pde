import java.util.ArrayList;

public class trianguloPascal {
    private ArrayList<int[]> filas; //Arraylist de arrays de enteros
    int posX = 325; int posY = 100; int size = 50;

    public trianguloPascal() {
        filas = new ArrayList<int[]>();
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
    
    public void imprimirTriangulo(ArrayList<int[]> filas){
        for (int[] fila : filas) {
            for (int i : fila) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    public ArrayList<int []> diagonal(int diag){
        int x = posX; int y = posY;
        ArrayList<int []> diags = new ArrayList();
        int[] arreglo = new int[1]; int cont = 1;
        for (int[] fila : filas) {
            int[] aux = new int[cont];
            int contAux=0;
            for (int i : fila) {
                if(contAux == diag-1){
                  fill(250,100,100); //Los cuadros salen rojos
                }else{
                  fill(225); //Los cuadros salen grises
                }
                rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                fill(0); //El texto sale negro
                text(i, x+(size/2)-3, y+(size/2)+5);
                aux[contAux] = i;
                contAux++;
            }
            arreglo = aux;
            agregarFila(diags, arreglo);
            y+=size;
            x = posX-=size/2;
            cont++;
        }
        return diags;
    }
    
    public void graficarDiagonal(int diag){
        int x = posX; int y = posY; diag--;
        for (int[] fila : filas) { //Recorre todo el triángulo
            if(fila.length < diag){ //Si la fila tiene menos elementos que el número de la diagonal
                for (int i : fila) {
                    fill(225); //Los cuadros salen grises
                    rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                    fill(0); //El texto sale negro
                    text(i, x+(size/2)-3, y+(size/2)+5);
                }
            } else {
                for(int i = 0; i < fila.length; i++){ //Recorre toda la fila
                    if(i == diag){
                        fill(250,100,100); //Los cuadros salen rojos
                    } else {
                        fill(225); //Los cuadros salen grises
                    }
                    rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                    fill(0); //El texto sale negro
                    text(i, x+(size/2)-3, y+(size/2)+5);
                }
            }
            y+=size;
            x = posX-=size/2;
        }
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
                        //int a = arreglo[j];
                        System.out.print(arreglo[j]+arreglo[j-1]);
                        aux[j] = 101;
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
        ArrayList<Integer> arreglo = new ArrayList<Integer>();
        
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
    
        
    public void graficarTriangulo(int posX, int posY, int size){
        int x = posX; int y = posY;
        for (int[] fila : filas) {
            for (int i : fila) {
                rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                fill(0); //El texto sale negro
                text(i, x+(size/2)-3, y+(size/2)+5);
                fill(255); //Los cuadros salen blancos
            }
            y+=size;
            x = posX-=size/2;
        }
    }
    
    public void graficarSierpinski(int posX, int posY, int size){
        int x = posX; int y = posY;
        for (int[] fila : filas) {
            for (int i : fila) {
                if(i%2 == 0){ //Si son pares
                    fill(225); //Los cuadros salen grises
                } else { //Si son impares
                    fill(250,100,100); //Los cuadros salen rojos
                }
                rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                fill(0); //El texto sale negro
                text(i, x+(size/2)-3, y+(size/2)+5);
                
            }
            y+=size;
            x = posX-=size/2;
        }
    }
    
    @Override
    public String toString() {
        return "trianguloPascal{" + "filas=" + filas + '}';
    }
    
}
