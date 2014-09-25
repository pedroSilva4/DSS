package business_layer;


/**
 * Write a description of class Empregado here.
 * 
 * @author anr
 * @version 2013.05.06
 */
public class Empregado {

   // de classe
   private static double salDia = 50.00;
   public static double getSalDia() { return salDia; }
   public static void setSalDia(double nvSalDia) { 
     salDia = nvSalDia; 
   }
   
   // de inst‚ncia
   private String codigo;
   private String nome;
   private int dias;
   
   // Construtores
   public Empregado(String cod, String nom, int dias) {
       this.codigo = cod; this.nome = nom; this.dias = dias;
   }   
   public Empregado(Empregado emp) {
       this.codigo = emp.getCodigo(); this.nome = emp.getNome(); 
       this.dias = emp.getDias();
   }
   
   
   public String getNome() { return this.nome; }
   public String getCodigo() { return this.codigo; }
   public int getDias() { return this.dias; }
   
   public boolean equals(Object obj) {
      if(this == obj) return true; 
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Empregado e = (Empregado) obj;
      return this.nome.equals(e.getNome()) && this.codigo.equals(e.getCodigo()) && this.dias == e.getDias();
   } 
  
   public double salario() { 
       return this.getDias()*getSalDia(); 
   }
   
   public String toString() {
      return "Empregado Normal: " + this.getNome() + " - " + this.getCodigo() + " - " +
              this.salario() + " euros";
   }
   
   public Empregado clone() { return new Empregado(this); }
   
}
  