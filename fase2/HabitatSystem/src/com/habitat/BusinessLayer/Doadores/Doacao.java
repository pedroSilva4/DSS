package com.habitat.BusinessLayer.Doadores;

import java.sql.Date;

public class Doacao {
	private String _cod;
	private Date _data;
	private String _nota;

	public void Docao() {
		throw new UnsupportedOperationException();
	}

	public void setCod(String aCod) {
		this._cod = aCod;
	}

	public String getCod() {
		return this._cod;
	}

	public Date getData() {
		return this._data;
	}

	public void setData(Date aData) {
		this._data = aData;
	}

	public String getNota() {
		return this._nota;
	}

	public void setNota(String aNota) {
		this._nota = aNota;
	}
}