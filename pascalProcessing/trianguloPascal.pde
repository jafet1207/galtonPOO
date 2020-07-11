import java.util.ArrayList;

public class trianguloPascal {
    private ArrayList<int[]> filas; //Arraylist de arrays de enteros
    int posX = 325; int posY = 200; int size = 50;

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
    
    public void restaurarPosiciones(){
        posX = 325; posY = 100; size = 50;
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
    
    public ArrayList<int []> diagonal(int diag){ //Lógica y grafico juntos
        int x = posX; int y = posY;
        ArrayList<int []> diags = new ArrayList();
        int[] arreglo = new int[1]; int cont = 1;
        for (int[] fila : filas) {
            int[] aux = new int[cont];
            int contAux=0;
            for (int i : fila) {
                if(contAux == diag-1){
                  fill(50);
                  aux[contAux] = i*-1;
                }else{
                  fill(150); //Los cuadros salen grises
                  aux[contAux] = i;
                }
                rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                fill(0); //El texto sale negro
                text(i, x+(size/2)-3, y+(size/2)+5);
                contAux++;
            }
            arreglo = aux;
            agregarFila(diags, arreglo);
            y+=size;
            x = posX-=size/2;
            cont++;
        }
        restaurarPosiciones();
        return diags;
    }
    
    public ArrayList<int []> sierpinski(){ //Lógica y grafico juntos
        int x = posX; int y = posY;
        ArrayList<int []> sierp = new ArrayList();
        int[] arreglo = new int[1]; int cont = 1;
        for (int[] fila : filas) {
            int[] aux = new int[cont];
            int contAux=0;
            for (int i : fila) {
                if(i%2 == 0){ //Pares
                  fill(50);
                  aux[contAux] = i;
                }else{ //Impares
                  fill(150); //Los cuadros salen grises
                  aux[contAux] = i*-1;
                }
                rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                fill(0); //El texto sale negro
                text(i, x+(size/2)-3, y+(size/2)+5);
                contAux++;
            }
            arreglo = aux;
            agregarFila(sierp, arreglo);
            y+=size;
            x = posX-=size/2;
            cont++;
        }
        restaurarPosiciones();
        return sierp;
    }
    
    public ArrayList<Integer> sumasHorizontales(){ //Lógica y grafico juntos
        int auxX = posX+(size*3); int auxY = posY-size;
        graficarTriangulo();
      
        ArrayList<Integer> arreglo = new ArrayList<Integer>();
        
        for (int i = 1; i <= filas.size(); i++) {
            fill(50);
            line(auxX-45, auxY+size+(size/2), auxX+20, auxY+size+(size/2));
            rect(auxX+=size/2, auxY+=size, size, size);
            
          
            int[] actual = filas.get(i-1);
            int cant = 0;
            for (int j = 0; j < i; j++){
                cant+=actual[j];
            }
            arreglo.add(cant);
            fill(0); //El texto sale negro
            if(cant < 9){
              text(cant, auxX+(size/2)-3, auxY+(size/2)+5);
            } else if (cant < 99){
              text(cant, auxX+(size/2)-6, auxY+(size/2)+5);
            } else {
              text(cant, auxX+(size/2)-9, auxY+(size/2)+5);
            }
        }
        restaurarPosiciones();
        return arreglo;
    }
    
        
    public void graficarTriangulo(){
        int x = posX; int y = posY;
        for (int[] fila : filas) {
            for (int i : fila) {
                fill(150); //Los cuadros salen grises
                rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                fill(0); //El texto sale negro
                text(i, x+(size/2)-3, y+(size/2)+5);
            }
            y+=size;
            x = posX-=size/2;
        }
    }
    
    public ArrayList<ArrayList<Integer>> simetria(){
        int x = posX; int y = posY;
        ArrayList<ArrayList<Integer>> lista = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> izquierda = new ArrayList<Integer>();
        ArrayList<Integer> derecha = new ArrayList<Integer>();
        for (int[] fila : filas) {
            if(fila.length == 1){
                izquierda.add(1); derecha.add(1);
                fill(150);
                rect (x+=size,y,size/2,size);//PosX, PosY, Ancho, Alto
                fill(50);
                rect (x+size/2,y,size/2,size);//PosX, PosY, Ancho, Alto
                fill(0); //El texto sale negro
                text(1, x+(size/2)-3, y+(size/2)+5);
            } else if(fila.length%2 == 0){ //Pares
                for(int i = 0; i < fila.length/2; i++){ //Primera mitad
                    int actual = fila[i];
                    izquierda.add(actual);
                    fill(150);
                    rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                    fill(0); //El texto sale negro
                    text(actual, x+(size/2)-3, y+(size/2)+5);
                }
                for(int i = fila.length/2; i < fila.length; i++){ //Segunda mitad
                    int actual = fila[i];
                    derecha.add(actual);
                    fill(50);
                    rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                    fill(0); //El texto sale negro
                    text(actual, x+(size/2)-3, y+(size/2)+5);
                }
            } else { //Impares
                for(int i = 0; i < fila.length/2; i++){ //Primera mitad
                    int actual = fila[i];
                    izquierda.add(actual);
                    fill(150);
                    rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                    fill(0); //El texto sale negro
                    text(actual, x+(size/2)-3, y+(size/2)+5);
                }
                for(int i = fila.length/2; i < fila.length; i++){ //Segunda mitad
                    int actual = fila[i];
                    derecha.add(actual);
                    if(i == fila.length/2){
                        fill(150);
                        rect (x+=size,y,size/2,size);//PosX, PosY, Ancho, Alto
                        fill(50);
                        rect (x+size/2,y,size/2,size);//PosX, PosY, Ancho, Alto
                        fill(0); //El texto sale negro
                        text(actual, x+(size/2)-3, y+(size/2)+5);
                    } else {
                        fill(50);
                        rect (x+=size,y,size,size);//PosX, PosY, Ancho, Alto
                        fill(0); //El texto sale negro
                        text(actual, x+(size/2)-3, y+(size/2)+5);
                    }
                }
            }
            y+=size;
            x = posX-=size/2;
        }
        lista.add(izquierda); lista.add(derecha);
        restaurarPosiciones();
        return lista;
    }
    
    public void imprimirSimetria(ArrayList<ArrayList<Integer>> lista){
        System.out.print("Izq ");
        for(int i : lista.get(0)){
             System.out.print(i + " ");
        }
        System.out.print("\nDer ");
        for(int i : lista.get(1)){
             System.out.print(i + " ");
        }
    }
    
    @Override
    public String toString() {
        return "trianguloPascal{" + "filas=" + filas + '}';
    }
    
}
