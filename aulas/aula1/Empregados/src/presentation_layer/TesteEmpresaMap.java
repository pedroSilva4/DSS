package presentation_layer;


/**
 * Write a description of class TesteEmpresaMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import business_layer.EmpresaZeca;
import business_layer.Empregado_Exist_Exception;
import business_layer.Normal;
import business_layer.Gestor;
import business_layer.Motorista;
import business_layer.Empregado_Enexistente_Exception;
import java.util.*;
import java.io.*;
import java.lang.*;

public class TesteEmpresaMap implements Serializable{
    
  public static void main(String[] args) {
   
       Motorista mt1 = new Motorista("M10", "Rui", 20, 1000);
       Motorista mt2 = new Motorista("M12", "Luis", 22, 1200);
       Gestor g1 = new Gestor("G1", "Manuel", 22, 1.5);
       Gestor g2 = new Gestor("G2", "Joel", 22, 1.5);
       Normal n1 = new Normal("N1", "Vasco", 25);
       Normal n2 = new Normal("N22", "Maria", 20);
       Normal n3 = new Normal("N25", "Laura", 21);
   
    EmpresaZeca empresa = new EmpresaZeca("Formação em POO");
  
  
        /**
           * Teste de addEmpregado e remEmpregado
         */
  
        try{
            empresa.addEmpregado(mt1);
            empresa.addEmpregado(mt2);
            empresa.addEmpregado(g1);
            empresa.addEmpregado(g2);
            empresa.addEmpregado(n1);
            empresa.addEmpregado(n2);
            empresa.addEmpregado(n3);
        }
        catch(Empregado_Exist_Exception e1){System.out.println("Empregado já existe:" + e1.getMessage());};
   
    System.out.println(empresa.toString());
    
    try{
        empresa.remEmpregado("N24");}
    
    catch(Empregado_Enexistente_Exception e2){System.out.println("Empregado " + e2.getMessage() + " não existe");};
  
  
    /*Iterator<Empregado> it = empresa.ordenaPor("Nome");
    while (it.hasNext())
      System.out.println(it.next().toString());
    */
    
    
    
    
    
    /*Iterator<Empregado> it = empresa.ordenaSalario().iterator();
    System.out.println("\n Imprimir ordenado por sal�rio");
    while (it.hasNext())
      System.out.println(it.next().toString());
  
  
    Iterator<Empregado> it_aux = empresa.ordenaPorNome().iterator();
    System.out.println("\n Imprimir ordenado por nome");
    while (it_aux.hasNext())
      System.out.println(it_aux.next().toString());
      */
    /* try{
        empresa.gravaObj("Empresa");}
    catch(IOException e){System.out.println("Erro ao gravar");}
    
    try{
        empresa.readObj();}
    catch(IOException e){System.out.println("Erro ao ler");}
    //catch(ClassNotFoundException e){System.out.println("Erro ao ler. Classe não encontrada");}
    
  }
*/
}}
