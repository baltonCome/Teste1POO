/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Numero3;

/**
 *
 * @author Mr. Savagery
 */
public class Numero3InverteInt {
    
    public static String inverte(String []numero, int ultimo){
        String invertido = ""; 
        if(ultimo != -1){
            invertido +=numero[ultimo];
            ultimo--;
            return invertido += inverte(numero, ultimo);
        }else
            return invertido;
    }
}
