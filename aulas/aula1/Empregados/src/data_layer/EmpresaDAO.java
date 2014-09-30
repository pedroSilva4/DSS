/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data_layer;

import business_layer.EmpresaZeca;
import com.sun.org.apache.xml.internal.utils.SerializableLocatorImpl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class EmpresaDAO implements Serializable{
    
    
    public static void save(EmpresaZeca emp,String file) throws IOException
    {
        EmpresaZeca em  =new EmpresaZeca(emp.getNome());
        
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
      
         oos.writeObject(em);
         oos.flush(); //limpa o buff
         oos.close(); //fecha o ficheiro
         
         EmpregadosDAO.save(emp.getEmpregados(),"Empregados"+file);
         
    }
    public static EmpresaZeca load(String file) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        EmpresaZeca em;
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
        
        em = (EmpresaZeca) is.readObject();
        
       EmpresaZeca emp = new EmpresaZeca(em.getNome(), EmpregadosDAO.load("Empregados"+file));
        
        return emp;
    }
}
