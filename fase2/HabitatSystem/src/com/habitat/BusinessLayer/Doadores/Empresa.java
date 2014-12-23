package com.habitat.BusinessLayer.Doadores;

import java.sql.Date;

public class Empresa extends Doador {
	private String _setor;
	private String _site;
	private String _pContacto;
        
        public Empresa(String cod,String nome,String nif,String rua,String localidade,
                String codP,String contacto,String email,Date dataAssoc,
                String sector, String site,String pContacto){
            super(cod,nome,nif,rua,localidade,
                codP,contacto,email,dataAssoc);
            this._setor = sector;
            this._site = site;
            this._pContacto = pContacto;
        }

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