/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 * Esta clase sirve para tirar excepciones personalizadas
 * @author Priscilla Chacón
 * @author Álvaro Moreira
 * @author Jafet Valverde
 */
public class miExcepcion extends Exception{
    
    private int codigo;
    
    public miExcepcion(int codigo){
        this.codigo = codigo;
    }
    
    @Override
    public String getMessage(){
        String mensaje = "";
        switch(codigo){
            case 1:
                mensaje = "La altura debe ser mayor a la diagonal seleccionada";
                break;
        }
        return mensaje;
    }
}
