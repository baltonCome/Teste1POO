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
public abstract class CartaoSIM implements Serializable {
    
    private String proprietario;
    private String numero;
    private Double saldo;

    public CartaoSIM(String proprietario, String numero, Double saldo) {
        this.proprietario = proprietario;
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "proprietario =" + proprietario + ", numero =" + numero + ", saldo =" + saldo ;
    }
}
