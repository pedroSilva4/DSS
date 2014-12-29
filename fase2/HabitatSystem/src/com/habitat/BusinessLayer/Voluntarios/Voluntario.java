package com.habitat.BusinessLayer.Voluntarios;

import java.sql.Date;

public class Voluntario {
        private String _cod;
        private String _nome;
	private String _nomeEquipa;
	private Date _dataNasc;
        private Date _dataAssociacao;
	private String _contacto;
	private String _profissao;
	private Morada _morada;

        public Voluntario(String cod, String nome, Date dataNasc,Date dataAssoc, String contacto, String equipa,String profissao,Morada m){
            this._cod = cod;
            this._nome = nome;
            this._dataNasc = dataNasc;
            this._dataAssociacao = dataAssoc;
            this._contacto = contacto;
            this._nomeEquipa = equipa;
            this._profissao = profissao;
            this._morada = m;
        }
        public String getDateNasc(){
            return ((this._dataNasc.getYear())+"-"+(this._dataNasc.getMonth()+1)+"-"+this._dataNasc.getDate());
        }
        public String getDateAssociacao(){
            return ((this._dataAssociacao.getYear()+1900)+"-"+(this._dataAssociacao.getMonth()+1)+"-"+this._dataAssociacao.getDate());
        }
	public void setNomeEquipa(String aNomeEquipa) {
		this._nomeEquipa = aNomeEquipa;
	}
        public String getCod(){
            return this._cod;
        }
	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public void setDataNasc(Date aDataNasc) {
		this._dataNasc = aDataNasc;
	}

	public Date getDataNasc() {
		return this._dataNasc;
	}
        public void setDataAssociacao(Date aDataAss) {
		this._dataAssociacao = aDataAss;
	}
        public Date getDataAssociacao() {
		return this._dataAssociacao;
	}

	public void setMorada(Morada aM) {
		this._morada = aM;
	}

	public String getNome() {
		return this._nome;
	}

	public void setContacto(String aContacto) {
		this._contacto = aContacto;
	}

	public String getNomeEquipa() {
		return this._nomeEquipa;
	}

	public String getContacto() {
		return this._contacto;
	}

	public Morada getMorada() {
		return this._morada;
	}

	public void setProfissao(String aProfissao) {
		this._profissao = aProfissao;
	}

	public String getProfissao() {
		return this._profissao;
	}
}