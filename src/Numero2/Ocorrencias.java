/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Numero2;

import javax.swing.JOptionPane;

/**
 *
 * @author Mr. Savagery
 */
public class Ocorrencias {
    
    
    public static int ocorrencias(String [] numero, String procurado, int pos){
        
        int ocorre = 0;
        
        if ((pos != numero.length) && (procurado.equalsIgnoreCase(numero[pos]))){
            pos++;
            ocorre++; 
            return ocorre + ocorrencias(numero, procurado, pos);
        }else if((pos != numero.length) && (!procurado.equalsIgnoreCase(numero[pos]))){
            pos++;
            return ocorre + ocorrencias(numero, procurado, pos);
        }else
            return ocorre;
    }
    
    public static void main(String [] args){
        
        String numero = JOptionPane.showInputDialog("Insira o numero");
        String procurado = JOptionPane.showInputDialog("Insira o procurado");
        System.out.println(ocorrencias(numero.split(""), procurado, 0));
    }
}
