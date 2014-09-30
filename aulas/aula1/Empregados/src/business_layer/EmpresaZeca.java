package business_layer;


/**
 * Write a description of class EmpresaZeca here.
 * 
 * @author anr
 * @version 2014.05.12
 */

import business_layer.ComparatorNome;
import data_layer.EmpresaDAO;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaZeca implements Serializable {
  
  private String nome;
  private TreeMap<String,Empregado> empregados;
  private static HashMap<String,Comparator<Empregado>> algoritmos = 
                new HashMap<String,Comparator<Empregado>>();;

  public static void addAlgoritmo(String n,Comparator<Empregado> alg){
    algoritmos.put(n,alg);
    }
  
  public static Comparator<Empregado> getAlgoritmo(String nome) throws Ordenacao_Enexistente_Exception{
      return algoritmos.get(nome);
    }
    
    
  
  public EmpresaZeca() {
   this.nome = "";
   this.empregados = new TreeMap<String,Empregado>();
  }
  
  public EmpresaZeca(String nome) {
   this.nome = nome;
   this.empregados = new TreeMap<String,Empregado>();
  }
  
  public EmpresaZeca(String nome, Map<String,Empregado> emps) {
    this.nome = nome;
    // this.empregados = emps; Não!!Encapsulamento
    this.empregados = new TreeMap<String,Empregado>();
    for (Empregado e: emps.values())
      this.empregados.put(e.getCodigo(), e.clone());
      
  }    
  
  public EmpresaZeca(EmpresaZeca ez) {
    this.nome = ez.getNome();
    this.empregados = ez.getEmpregados();
  }
  
  public String getNome() {return this.nome;}
  
  public TreeMap<String,Empregado> getEmpregados() {
    TreeMap<String,Empregado> aux = new TreeMap<String,Empregado>();
    
    for(Empregado e: this.empregados.values())
      aux.put(e.getCodigo(), e.clone());
      
    return aux;
  }
  
  public boolean existeEmpregado(String cod){
    return this.empregados.containsKey(cod);          
  }    
    
  public Empregado getEmpregado(String cod) {
    return this.empregados.get(cod);          
  }    
  
  public void addEmpregado(Empregado e) throws Empregado_Exist_Exception {
       if(this.empregados.containsKey(e.getCodigo())){
           throw new Empregado_Exist_Exception(e.getCodigo());
        }
        this.empregados.put(e.getCodigo(), e.clone());
  }
  
  
  public void addEmpregados(Set<Empregado> emps) throws Empregado_Exist_Exception{
    for(Empregado e: emps)
        addEmpregado(e); 
    
        
    //este metudo pode receber exceções do addEmpregado, como não a consegue tratar passa a babata quente para cima.
  }    
  
  public void remEmpregado(String cod) throws Empregado_Enexistente_Exception{
    if(!this.empregados.containsKey(cod)){
        throw new Empregado_Enexistente_Exception(cod);
    }
    this.empregados.remove(cod);  
   
  }    
     
  //------------------------------------------
  
  /*public Iterator<Empregado> ordenaPor(String mAlgoritmo) throws Ordenacao_Enexistente_Exception{
    Comparator<Empregado> cmp = EmpresaZeca.getAlgoritmo(mAlgoritmo);
    List emp = new ArrayList();
    
    Collections.sort(emp, cmp);
    
    return emp.iterator();
    }
  */
  
  
 
 
 
 
 public double totalSegSaude(){
    double total = 0;
    
    for(Empregado e: empregados.values()){
        if(e instanceof Seguravel) {
            Seguravel n = (Seguravel) e;
            total += n.custoSegSaude();
        }
    }
    return total;
    }
  
 public Iterator<Seguravel> empSeguraveis(){
    HashMap<String,Empregado> aux = new HashMap<String,Empregado>();
    
    for(Empregado e: empregados.values()){
        if(e instanceof Seguravel) {
            aux.put(e.getCodigo(),e.clone());
        }
    }
    
    Iterator it = aux.values().iterator();
    return it;
    }
  
  
  
  //------------------------------------------
  public double totalSalarios() {
    double total = 0.0;
    for(Empregado e: this.empregados.values())
      total += e.salario();  //polimorfismo!!
      
    return total;
  }
  
  public int totalGestores() {
    int total = 0;
    for(Empregado e: this.empregados.values())
      if (e instanceof Gestor)
        total++;
    
    return total;    
      
  }    
  
  //  if ((e.getClass().getSimpleName()).equals("Gestor"))
    
  public int qtsDeTipo(String nomeClasse) {
    int total = 0;
    for(Empregado e: this.empregados.values())
      if ((e.getClass().getSimpleName()).equals(nomeClasse))
        total++;
        
    return total;
  }  
  
  public double qtsKmsTotal() {
    double total = 0.0;
    for(Empregado e: this.empregados.values())
      if (e instanceof Motorista)
        total += ((Motorista)e).getNKms();
    return total;
  }    
    
  
  public Set<Empregado> ordenaSalario() {
    TreeSet<Empregado> res = new TreeSet<Empregado>(new ComparatorSalario());  
    
    for(Empregado e: this.empregados.values())
      res.add(e);
    return res;
  }  
      
  public Set<Empregado> ordenaPorNome() {
    TreeSet<Empregado> res = new TreeSet<Empregado>(new ComparatorNome());  
    
    for(Empregado e: this.empregados.values())
      res.add(e);
    return res; 
  }
  
  public Set<String> top3Salarios() {
    
    //treeset que vai conter os empregados ordenados por ordem decrescente de salário
    TreeSet<Empregado> aux = new TreeSet<Empregado>(new ComparatorSalario());
    
    for(Empregado e: this.empregados.values())
      aux.add(e);
    
    /* 
     É necessário criar um conjunto de códigos para os três empregados com maior salário.
     Como o treeset é de String, se utilizarmos a ordem natural de comparação de strings
     teremos os códigos ordenados alfabeticamente, o que não é o objectivo.
     Para mantermos a ordem, vamos parametrizar o treeset por um comparator que não altere a 
     ordem dos elementos.
    */
    
    TreeSet<String> res = new TreeSet<String>(new ComparatorOrdemVisita());
    Iterator<Empregado> it = aux.iterator();
    int i=0;
    while(it.hasNext() && i<3)
      res.add(it.next().getCodigo());
      
    return res;  
  }    
  
  
  public String toString() {
      StringBuilder sb = new StringBuilder("--- Empregados ---\n");
      for(Empregado emp : this.empregados.values())
        sb.append(emp.toString() + "\n");
      return sb.toString();
  }
  
  public boolean equals(Object obj) {
    if(this == obj) return true; 
    if((obj == null) || (this.getClass() != obj.getClass())) 
      return false;
    EmpresaZeca umaEmp = (EmpresaZeca) obj;
    return this.nome.equals(umaEmp.getNome()) && this.empregados.equals(umaEmp.getEmpregados());
  }  
      
  
  public EmpresaZeca clone() {
    return new EmpresaZeca(this);
  }
  
  public void save() throws IOException 
  {
     
          EmpresaDAO.save(this, "empresa.dat");   
  }
  
  public static EmpresaZeca load() throws IOException, FileNotFoundException, ClassNotFoundException
  {
     EmpresaZeca emp = new EmpresaZeca(EmpresaDAO.load("empresa.dat"));
      return emp;
  }
  
  
  
  
  
  
    
}
