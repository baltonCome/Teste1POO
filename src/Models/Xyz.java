/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Mr. Savagery
 */
public class Xyz extends CartaoSIM {
    
    public Double txuna;
    
    public Xyz(String proprietario, String numero, Double saldo, Double txuna) {
        super(proprietario, numero, saldo);
        this.txuna = txuna;
    }

    public Double getTxuna() {
        return txuna;
    }

    public void setTxuna(Double txuna) {
        this.txuna = txuna;
    }    

    @Override
    public String toString() {
        return super.toString()+ " Xyz{" + "txuna=" + txuna + '}'+"\n";
    }
   
}
