/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Abc;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mr. Savagery
 */
public class AbcControl implements Serializable {
    
    public static void guardar (ArrayList <Abc> abc ) throws IOException{
        
        if (!abc.isEmpty()){
            try(FileOutputStream fos = new FileOutputStream("src/Files/Abc.dat")){
                try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    oos.writeObject(abc);
                    oos.flush();
                    oos.close();
                    fos.flush();
                    fos.close();
                }
            }
        }
    }
    
    public static ArrayList<Abc> mostrar () throws IOException, ClassNotFoundException{
        
        try (FileInputStream fis = new FileInputStream("src/Files/Abc.dat")){
            try(ObjectInputStream ois = new ObjectInputStream(fis)){
                return (ArrayList<Abc>) ois.readObject();
            }
        }
    }
    
    public static void apagar(ArrayList<Abc> abc, String numero){

        boolean found = false;
        if (Files.exists(Paths.get("src/Files/Abc.dat"))) {
            if (!abc.isEmpty()) {
                try {
                    Abc procurado;
                    for (int i = 0; i < abc.size(); i++) {
                        if (numero.equalsIgnoreCase(abc.get(i).getNumero())) {
                            found = true;
                            procurado = abc.get(i);
                            abc.remove(procurado);
                            JOptionPane.showMessageDialog(null, "Numero Removido","INFO",JOptionPane.PLAIN_MESSAGE);
                            break;
                        }
                    }
                    if (!found){
                        JOptionPane.showMessageDialog(null, "Numero Nao encontrado","INFO",JOptionPane.PLAIN_MESSAGE);
                    }
                    guardar(abc);
                } catch (HeadlessException | IOException e) {
                }
            }
        }
    }
    
    public static int quantidade(ArrayList<Abc> abc){
        
        int quant = 0;
        if (Files.exists(Paths.get("src/Files/Abc.dat"))) {
            if (!abc.isEmpty()) {
                try {
                    for (int i = 0; i < abc.size(); i++) {
                       quant++;
                    }
                } catch (HeadlessException e) {
                }
            }
        }
        return quant;
    }
    
    public static void recarregar(ArrayList<Abc> abc, String numero, Double valor){

        boolean found = false;
        if (Files.exists(Paths.get("src/Files/Abc.dat"))) {
            if (!abc.isEmpty()) {
                try {
                    for (int i = 0; i < abc.size(); i++) {
                        if (numero.equalsIgnoreCase(abc.get(i).getNumero())) {
                            found = true;
                            Double saldo = abc.get(i).getSaldo();
                            Double megas = abc.get(i).getMegas();
                            abc.get(i).setSaldo(saldo+valor);
                            abc.get(i).setMegas(megas+(valor/4));
                            JOptionPane.showMessageDialog(null, "Conta Recarregada","INFO",JOptionPane.PLAIN_MESSAGE);
                            break;
                        }
                    }
                    if (!found){
                        JOptionPane.showMessageDialog(null, "Numero Nao encontrado","INFO",JOptionPane.PLAIN_MESSAGE);
                    }
                    guardar(abc);
                } catch (HeadlessException | IOException e) {
                }
            }
        }
    }
    
    public static void transferir(ArrayList<Abc> abc, String origem, Double valor,String destino){

        boolean found = false;
        boolean found2 = false;
        if (Files.exists(Paths.get("src/Files/Abc.dat"))) {
            if (!abc.isEmpty()) {
                try {
                    int pos = -1;
                    int pos2 = -1;
                    for (int i = 0; i < abc.size(); i++) {
                        if (origem.equalsIgnoreCase(abc.get(i).getNumero())) {
                            found = true;
                            pos = i;
                            break;
                        }
                    }
                    for (int i = 0; i < abc.size(); i++) {
                        if (destino.equalsIgnoreCase(abc.get(i).getNumero())) {
                            found2 = true;
                            pos2 = i;
                            break;
                        }
                    }
                    if (found && found2){
                        Double saldo = abc.get(pos).getSaldo() - valor;
                        abc.get(pos).setSaldo(saldo);
                        Double saldo2 = abc.get(pos2).getSaldo() + valor;
                        abc.get(pos2).setSaldo(saldo2);
                    }
                    guardar(abc);
                } catch (HeadlessException | IOException e) {
                }
            }
        }
    }
    
    public static int procurar(ArrayList<Abc> abc, String numero){

        if (Files.exists(Paths.get("src/Files/Abc.dat"))) {
            if (!abc.isEmpty()) {
                for (int i = 0; i < abc.size(); i++) {
                    if (numero.equalsIgnoreCase(abc.get(i).getNumero())) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}