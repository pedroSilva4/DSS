package com.habitat.BusinessLayer.Projetos;

import com.habitat.BusinessLayer.Tarefas.Tarefa;
import java.sql.Date;
import java.util.ArrayList;

public class Projeto {
    private String cod;   
    //nao faz sentido ter aqui o id da candidatura, deve de estar o id do Projeto na Candidatura
    private String _candidatura;
    private Date _dataI;
    private Date _dataF;
    private String _estado;
    private String _descricao;
    private double _orcamento;
    private String Funcionario;
    private ArrayList<ProjetoTarefas> tarefas;

    public Projeto(String cod,String cand, Date _dataI, Date _dataF, String _estado, String _descricao, double _orcamento, String Funcionario, ArrayList<ProjetoTarefas> tarefas) {
        this._candidatura = cand;
        this.cod = cod;
        this._dataI = _dataI;
        this._dataF = _dataF;
        this._estado = _estado;
        this._descricao = _descricao;
        this._orcamento = _orcamento;
        this.Funcionario = Funcionario;
        this.tarefas = tarefas;
    }

    public String getCandidatura() {
        return _candidatura;
    }   
    
    public String getCod() {
        return cod;
    }

    public Date getDataI() {
        return _dataI;
    }

    public Date getDataF() {
        return _dataF;
    }
    
    public String getDateI(){
        return (this._dataI.getYear()+"-"+this._dataI.getMonth()+"-"+this._dataI.getDate());
    }
    
    public String getDateF(){
        return (this._dataF.getYear()+"-"+this._dataF.getMonth()+"-"+this._dataF.getDate());
    }

    public String getEstado() {
        return _estado;
    }

    public String getDescricao() {
        return _descricao;
    }

    public double getOrcamento() {
        return _orcamento;
    }

    public String getFuncionario() {
        return Funcionario;
    }

    public ArrayList<ProjetoTarefas> getTarefas() {
        return tarefas;
    }

    public void setDataI(Date _dataI) {
        this._dataI = _dataI;
    }

    public void setDataF(Date _dataF) {
        this._dataF = _dataF;
    }

    public void setEstado(String _estado) {
        this._estado = _estado;
    }

    public void setDescricao(String _descricao) {
        this._descricao = _descricao;
    }

    public void setOrcamento(double _orcamento) {
        this._orcamento = _orcamento;
    }

    public void addTarefa(ProjetoTarefas t){
        this.tarefas.add(t);
    }
    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Projeto{"+"cod=" + cod +", candidatura="+_candidatura +  ", _dataI=" + this.getDateI() + ", _dataF=" + this.getDateF() + ", _estado=" + _estado + ", _descricao=" + _descricao + ", _orcamento=" + _orcamento + ", Funcionario=" + Funcionario + '}');
        for(ProjetoTarefas t : tarefas)
            res.append(t.toString());
        return res.toString();
    }

}
