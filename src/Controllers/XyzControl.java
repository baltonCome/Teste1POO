/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.Serializable;
import Models.Xyz;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mr. Savagery
 */
public class XyzControl implements Serializable {
    
    public static void guardar (ArrayList <Xyz> xyz ) throws IOException{
        
        if (!xyz.isEmpty()){
            try(FileOutputStream fos = new FileOutputStream("src/Files/Xyz.dat")){
                try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    oos.writeObject(xyz);
                    oos.flush();
                    oos.close();
                    fos.flush();
                    fos.close();
                }
            }
        }
    }
    
    public static ArrayList<Xyz> mostrar () throws IOException, ClassNotFoundException{
        
        try (FileInputStream fis = new FileInputStream("src/Files/Xyz.dat")){
            try(ObjectInputStream ois = new ObjectInputStream(fis)){
                return (ArrayList<Xyz>) ois.readObject();
            }
        }
    }
    
    public static void apagar(ArrayList<Xyz> xyz, String numero) throws IOException{

        boolean found = false;
        if (Files.exists(Paths.get("src/Files/Xyz.dat"))) {
            if (!xyz.isEmpty()) {
               
                Xyz procurado;
                for (int i = 0; i < xyz.size(); i++) {
                    if (numero.equalsIgnoreCase(xyz.get(i).getNumero())) {
                        found = true;
                        procurado = xyz.get(i);
                        xyz.remove(procurado);
                        JOptionPane.showMessageDialog(null, "Numero Removido","INFO",JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }
                if (!found){
                    JOptionPane.showMessageDialog(null, "Numero Nao encontrado","INFO",JOptionPane.PLAIN_MESSAGE);
                }
                guardar(xyz);

            }
        }
    }
    
    public static int quantidade(ArrayList<Xyz> xyz){
        
        int quant = 0;
        if (Files.exists(Paths.get("src/Files/Xyz.dat"))) {
            if (!xyz.isEmpty()) {
                try {
                    for (int i = 0; i < xyz.size(); i++) {
                       quant++;
                    }
                } catch (HeadlessException e) {
                }
            }
        }
        return quant;
    }
    
    public static void recarregar(ArrayList<Xyz> xyz, String numero, Double valor) throws IOException{

        boolean found = false;
        if (Files.exists(Paths.get("src/Files/Xyz.dat"))) {
            if (!xyz.isEmpty()) {
                try {
                    for (int i = 0; i < xyz.size(); i++) {
                        if (numero.equalsIgnoreCase(xyz.get(i).getNumero())) {
                            found = true;
                            Double saldo = xyz.get(i).getSaldo();
                            xyz.get(i).setSaldo(saldo+valor);
                            JOptionPane.showMessageDialog(null, "Conta Recarregada","INFO",JOptionPane.PLAIN_MESSAGE);
                            break;
                        }
                    }
                    if (!found){
                        JOptionPane.showMessageDialog(null, "Numero Nao encontrado","INFO",JOptionPane.PLAIN_MESSAGE);
                    }
                    guardar(xyz);
                } catch (HeadlessException e) {
                }
            }
        }
    }
    
    public static void transferir(ArrayList<Xyz> xyz, String origem, Double valor,String destino) throws IOException{

        boolean found = false;
        boolean found2 = false;
        if (Files.exists(Paths.get("src/Files/Xyz.dat"))) {
            if (!xyz.isEmpty()) {
                try {
                    int pos = -1;
                    int pos2 = -1;
                    for (int i = 0; i < xyz.size(); i++) {
                        if (origem.equalsIgnoreCase(xyz.get(i).getNumero())) {
                            found = true;
                            pos = i;
                            break;
                        }
                    }
                    for (int i = 0; i < xyz.size(); i++) {
                        if (destino.equalsIgnoreCase(xyz.get(i).getNumero())) {
                            found2 = true;
                            pos2 = i;
                            break;
                        }
                    }
                    if (found && found2){
                        Double saldo = xyz.get(pos).getSaldo()-valor;
                        xyz.get(pos).setSaldo(saldo);
                        Double saldo2 = xyz.get(pos2).getSaldo()+valor;
                        xyz.get(pos2).setSaldo(saldo2);
                    }
                    guardar(xyz);
                } catch (HeadlessException e) {
                }
            }
        }
    }
    
    public static void txunar(ArrayList<Xyz> xyz, String numero) throws IOException{
        if (Files.exists(Paths.get("src/Files/Xyz.dat"))) {
            if (!xyz.isEmpty()) {
                try {
                    for (int i = 0; i < xyz.size(); i++) {
                        if (numero.equalsIgnoreCase(xyz.get(i).getNumero())) {
                            if(xyz.get(i).getSaldo()<15){
                                xyz.get(i).setTxuna(15.0);
                                JOptionPane.showMessageDialog(null, "Txuna feito","INFO",JOptionPane.PLAIN_MESSAGE);
                            }else
                                JOptionPane.showMessageDialog(null, "Saldo Superior a 15 mts, Txuna nao disponivel","INFO",JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                    guardar(xyz);
                } catch (HeadlessException e) {
                }
            }
        }
    }
    
    public static int procurar(ArrayList<Xyz> xyz, String numero){

        if (Files.exists(Paths.get("src/Files/Xyz.dat"))) {
            if (!xyz.isEmpty()) {
                for (int i = 0; i < xyz.size(); i++) {
                    if (numero.equalsIgnoreCase(xyz.get(i).getNumero())) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
