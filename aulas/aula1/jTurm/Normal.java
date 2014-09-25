
/**
 * Write a description of class Normal here.
 * 
 * @author anr
 * @version 2014.05.07
 */
import java.util.*;
import java.io.*;

public class Normal extends Empregado implements Serializable, Seguravel {
    
  
  public double custoSegSaude(){
       return salario()*0.05;
    }   
    
    
    
    
    public Normal() {
    super();
  }
  
  public Normal(String cod, String nome, int dias) {
    super(cod,nome,dias);
  }
  
  public Normal(Normal n) {
    super(n);
  }
  
  
  
  public boolean equals(Object obj) {
      if(this == obj) return true; 
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Normal e = (Normal) obj;
      return super.equals(e);
  } 
  
   public double salario() {
     return this.getDias()*getSalDia();  
   }
   
   public String toString() {
      return "Empregado Normal: " + this.getNome() + " - " + this.getCodigo() + " - " +
              this.salario() + " euros";
   }
  
   public Normal clone() {return new Normal(this);}
    
    
}
