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
public class Binario {
    
    
    public static String binario(int inteiro){
        
        String binario = "";
        
        if (inteiro != 0 ){
            binario += inteiro % 2;
            if(inteiro % 2 == 0)
                return binario += binario(inteiro/2);
            else
                return binario += binario((inteiro-1)/2);             
        }else
            return binario;
    }
    
    public static void main (String [] args){
        
        System.out.println(Numero3InverteInt.inverte(binario(13).split(""),binario(13).split("").length-1));
    }
}
