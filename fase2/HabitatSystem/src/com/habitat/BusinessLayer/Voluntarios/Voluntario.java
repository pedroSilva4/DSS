package com.habitat.BusinessLayer.Voluntarios;

import java.sql.Date;

public class Voluntario {
	private String _nomeEquipa;
	private Date _dataNasc;
	private String _contacto;
	private String _nome;
	private String _profissao;
	private Morada _morada;

	public void setNomeEquipa(String aNomeEquipa) {
		this._nomeEquipa = aNomeEquipa;
	}

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public void setDataNasc(Date aDataNasc) {
		throw new UnsupportedOperationException();
	}

	public Date getDataNasc() {
		throw new UnsupportedOperationException();
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