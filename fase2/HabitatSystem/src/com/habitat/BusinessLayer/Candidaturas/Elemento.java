package com.habitat.BusinessLayer.Candidaturas;

import java.sql.Date;
import java.util.Calendar;

public class Elemento {
        private String _cod;
	private String _nome;
        private Date _dataNasc;
	private String _escolaridade;	
	private String _estCivil;
	private String _parentesco;
	private String _ocupacao;	

        public Elemento(String _cod, String _nome, Date _dataNasc, String _escolaridade, String _estCivil, String _parentesco, String _ocupacao) {
            this._cod = _cod;
            this._nome = _nome;
            this._dataNasc = _dataNasc;
            this._escolaridade = _escolaridade;
            this._estCivil = _estCivil;
            this._parentesco = _parentesco;
            this._ocupacao = _ocupacao;            
        }                
        
	public String getNome() {
		return this._nome;
	}

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public String getEscolaridade() {
		return this._escolaridade;
	}

	public void setEscolaridade(String aEscolaridade) {
		this._escolaridade = aEscolaridade;
	}

	public Date getDataNasc() {
		return this._dataNasc;
	}

	public void setDataNasc(Date aDataNasc) {
		this._dataNasc = aDataNasc;
	}

	public String getEstCivil() {
		return this._estCivil;
	}

	public void setEstCivil(String aEstCivil) {
		this._estCivil = aEstCivil;
	}

	public String getParentesco() {
		return this._parentesco;
	}

	public void setParentesco(String aParentesco) {
		this._parentesco = aParentesco;
	}

	public String getOcupacao() {
		return this._ocupacao;
	}

	public void setOcupacao(String aOcupacao) {
		this._ocupacao = aOcupacao;
	}

	public String getCod() {
		return this._cod;
	}

	public void setCod(String aCod) {
		this._cod = aCod;
	}

    @Override
    public String toString() {
        return "Elemento{" + "_cod=" + _cod + ", _nome=" + _nome + ", _dataNasc=" + _dataNasc + ", _escolaridade=" + _escolaridade + ", _estCivil=" + _estCivil + ", _parentesco=" + _parentesco + ", _ocupacao=" + _ocupacao + '}';
    }
        
        
}