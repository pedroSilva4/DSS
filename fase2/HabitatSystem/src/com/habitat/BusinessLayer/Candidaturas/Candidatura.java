package com.habitat.BusinessLayer.Candidaturas;

import java.util.ArrayList;
import java.sql.Date;

public class Candidatura {

    private String _cod;
    private Date _dataAbertura;

    public void setCod(String _cod) {
        this._cod = _cod;
    }

    public void setDataAbertura(Date _dataAbertura) {
        this._dataAbertura = _dataAbertura;
    }

    public void setDataDecisao(Date _dataDecisao) {
        this._dataDecisao = _dataDecisao;
    }

    public void setObs(String _obs) {
        this._obs = _obs;
    }

    public void setEstado(String _estado) {
        this._estado = _estado;
    }

    public void setRendimentoBruto(float _rendimentoBruto) {
        this._rendimentoBruto = _rendimentoBruto;
    }

    public void setRua(String _rua) {
        this._rua = _rua;
    }

    public void setLocalidade(String _localidade) {
        this._localidade = _localidade;
    }

    public void setCodPostal(String _codPostal) {
        this._codPostal = _codPostal;
    }
    private Date _dataDecisao;
    private String _obs;
    private String _estado;
    private String _funcionario;
    private ArrayList<Questao> _questionario = new ArrayList<>();
    private ArrayList<Elemento> _elementos = new ArrayList<>();
    private float _rendimentoBruto;
    private String _rua;
    private String _localidade;
    private String _codPostal;
    private Elemento _candidato;
    private String _contacto;

    public Candidatura(String cod, Date dataAbertura, Date dataDecisao,
            String obs, String estado, String funcionario,
            ArrayList<Questao> quest, ArrayList<Elemento> elems,
            float rendimentoBruto, String rua, String localidade,
            String codPostal, Elemento candidato, String contacto) {
        this._cod = cod;
        this._dataAbertura = dataAbertura;
        this._dataDecisao = dataDecisao;
        this._obs = obs;
        this._estado = estado;
        this._funcionario = funcionario;
        this._questionario = quest;
        this._elementos = elems;
        this._rendimentoBruto = rendimentoBruto;
        this._rua = rua;
        this._localidade = localidade;
        this._codPostal = codPostal;
        this._candidato = candidato;
        this._contacto = contacto;
    }

    public ArrayList<Questao> getQuestionario() {
        return this._questionario;
    }

    public void stQuestionario(ArrayList<Questao> questionario) {
        this._questionario = questionario;
    }

    public ArrayList<Elemento> getElementos() {
        return this._elementos;
    }

    public void setElementos(ArrayList<Elemento> elems) {
        this._elementos = elems;
    }

    public void setQuestionario(ArrayList<Questao> _questionario) {
        this._questionario = _questionario;
    }
        

    public String getContacto() {
        return this._contacto;
    }

    public void setContacto(String contacto) {
        this._contacto = contacto;
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

    public void setCandidato(Elemento c) {
        this._candidato = c;
    }

    public String getFuncionario() {
        return this._funcionario;
    }

    public void setFuncionario(String aFuncionario) {
        this._funcionario = aFuncionario;
    }

    /*
    public String getDateAbertura() {
        return (this._dataAbertura.getYear() + "-" + this._dataAbertura.getMonth() + "-" + this._dataAbertura.getDate());
    }

    public String getDateDecisao() {
        return (this._dataDecisao.getYear() + "-" + this._dataDecisao.getMonth() + "-" + this._dataDecisao.getDate());
    }
    */

    public String toString() {
       return this._cod+ ": "+this._candidato.getNome();
    }

}
