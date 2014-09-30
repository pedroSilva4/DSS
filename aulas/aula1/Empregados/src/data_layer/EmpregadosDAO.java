/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data_layer;

import business_layer.Empregado;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Pedro
 */
public class EmpregadosDAO implements Serializable{
    
    public static void save(Map<String,Empregado> emps,String str) throws IOException 
    {
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(str));
      
         oos.writeObject(emps);
         oos.flush(); //limpa o buff
         oos.close(); //fecha o ficheiro
    }
    
    public static Map<String,Empregado> load(String file) throws IOException, ClassNotFoundException
    {
        
      Map<String,Empregado> map;
      ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
      
      map = (Map<String,Empregado>) is.readObject();
      is.close();
    
    
        return map;
    }
}
