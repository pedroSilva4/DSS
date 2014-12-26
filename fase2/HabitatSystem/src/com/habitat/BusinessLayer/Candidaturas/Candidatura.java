package com.habitat.BusinessLayer.Candidaturas;

import java.util.ArrayList;
import com.habitat.BusinessLayer.Candidaturas.Questao;
import com.habitat.BusinessLayer.Candidaturas.Elemento;
import java.sql.Date;
import java.util.Calendar;

public class Candidatura {
	private String _cod;
        private Date _dataAbertura;
	private Date _dataDecisao;
	private String _obs;
	private String _estado;
	private String _funcionario;
        private ArrayList<Questao> _questionario = new ArrayList<Questao>();
        private ArrayList<Elemento> _elementos = new ArrayList<Elemento>();
	private float _rendimentoBruto;
	private String _rua;
	private String _localidade;
	private String _codPostal;		
	private Elemento _candidato;	

    public Candidatura(String _cod, String _obs, String _estado, Date _dataAbertura, 
            Date _dataDecisao, float _rendimentoBruto, String _rua, String _localidade, 
            String _codPostal, String _funcionario, Elemento _candidato, 
            ArrayList<Questao> questionario, ArrayList<Elemento> elementos) {
        this._cod = _cod;
        this._obs = _obs;
        this._estado = _estado;
        this._dataAbertura = _dataAbertura;
        this._dataDecisao = _dataDecisao;
        this._rendimentoBruto = _rendimentoBruto;
        this._rua = _rua;
        this._localidade = _localidade;
        this._codPostal = _codPostal;
        this._funcionario = _funcionario;
        this._candidato = _candidato;
        this._questionario = questionario;
        this._elementos = elementos;
    }

    public Candidatura(String _cod, Date _dataAbertura, Date _dataDecisao, String _obs, 
            String _estado, String _funcionario, ArrayList<Questao> questionario, 
            ArrayList<Elemento> elementos) {
        this._cod = _cod;
        this._dataAbertura = _dataAbertura;
        this._dataDecisao = _dataDecisao;
        this._obs = _obs;
        this._estado = _estado;
        this._funcionario = _funcionario;
        this._questionario = questionario;
        this._elementos = elementos;
    }

    public String getCod() {
        return _cod;
    }

    public Date getDataAbertura() {
        return _dataAbertura;
    }
    
    
    public Date getDataDecisao() {
        return _dataDecisao;
    }

    public String getObs() {
        return _obs;
    }

    public String getEstado() {
        return _estado;
    }

    public float getRendimentoBruto() {
        return _rendimentoBruto;
    }

    public String getRua() {
        return _rua;
    }

    public String getLocalidade() {
        return _localidade;
    }

    public String getCodPostal() {
        return _codPostal;
    }

    public Elemento getCandidato() {
        return _candidato;
    }

    public String getFuncionario() {
        return this._funcionario;
    }
    
    
    public void setFuncionario(String aFuncionario) {
	this._funcionario = aFuncionario;
    }
    
    public String getDateAbertura(){
        return (this._dataAbertura.getYear()+"-"+this._dataAbertura.getMonth()+"-"+this._dataAbertura.getDate());
    }
    
    public String getDateDecisao(){
        return (this._dataDecisao.getYear()+"-"+this._dataDecisao.getMonth()+"-"+this._dataDecisao.getDate());
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("*** Candidatura ***\n");
        res.append("cod: "+this._cod+"\ndataAbertura: "+this.getDateAbertura()+"\ndataDecisao"+
                this.getDateDecisao()+"\nobs: "+this._obs+"\nestado: "+this._estado+
                "\nFuncionario: "+this._funcionario);
        
        res.append("\n->Elementos");
        for(Elemento aux : this._elementos)
            res.append(aux.toString());
        res.append("\n->Qustionario");
        for(Questao aux : this._questionario)
            res.append(aux.toString());
        
        return res.toString();
    }
        
        
}