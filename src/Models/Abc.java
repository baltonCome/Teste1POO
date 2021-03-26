/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Mr. Savagery
 */
public class Abc extends CartaoSIM implements Serializable {
    
    private Double megas;

    public Abc(String proprietario, String numero, Double saldo, Double megas) {
        super(proprietario, numero, saldo);
        this.megas = megas;
    }

    public Double getMegas() {
        return megas;
    }

    public void setMegas(Double megas) {
        this.megas = megas;
    }

    @Override
    public String toString() {
        return super.toString()+ ", megas=" + megas +"\n";
    }
    
    
}
