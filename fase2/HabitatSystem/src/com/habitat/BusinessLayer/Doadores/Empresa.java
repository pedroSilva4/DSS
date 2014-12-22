package com.habitat.BusinessLayer.Doadores;

public class Empresa extends Doador {
	private String _setor;
	private String _site;
	private String _pContacto;

	public String getSetor() {
		return this._setor;
	}

	public void setSetor(String aSetor) {
		this._setor = aSetor;
	}

	public String getSite() {
		return this._site;
	}

	public void setSite(String aSite) {
		this._site = aSite;
	}

	public String getPContacto() {
		return this._pContacto;
	}

	public void setPContacto(String aPContacto) {
		this._pContacto = aPContacto;
	}
}