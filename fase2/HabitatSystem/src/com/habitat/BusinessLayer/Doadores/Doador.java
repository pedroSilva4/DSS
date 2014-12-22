package com.habitat.BusinessLayer.Doadores;

import java.sql.Date;

public class Doador {
	private String _cod;
	private String _nome;
	private float _nIF;
	private String _rua;
	private String _localidade;
	private String _codPostal;
	private int _contacto;
	private Date _dataAssociacao;

	public void Doador() {
		throw new UnsupportedOperationException();
	}

	public void setCod(String aCod) {
		this._cod = aCod;
	}

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public void setNIF(float aNif) {
		this._nIF = aNif;
	}

	public void setRua(String aRua) {
		this._rua = aRua;
	}

	public void setLocalidade(String aLocalidade) {
		this._localidade = aLocalidade;
	}

	public void setCodPostal(String aCP) {
		this._codPostal = aCP;
	}

	public void setContacto(int aContacto) {
		this._contacto = aContacto;
	}

	public void setDataAssoc(Date aData) {
		throw new UnsupportedOperationException();
	}

	public String getCod() {
		return this._cod;
	}

	public String getNome() {
		return this._nome;
	}

	public float getNIF() {
		return this._nIF;
	}

	public String getRua() {
		return this._rua;
	}

	public String getLocalidade() {
		return this._localidade;
	}

	public String getCodPostal() {
		return this._codPostal;
	}

	public int getContacto() {
		return this._contacto;
	}

	public Date getDataAssoc() {
		throw new UnsupportedOperationException();
	}
}