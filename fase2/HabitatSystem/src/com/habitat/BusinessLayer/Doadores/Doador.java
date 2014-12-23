package com.habitat.BusinessLayer.Doadores;

import java.sql.Date;

public class Doador {
	private String _cod;
	private String _nome;
	private String _nIF;
	private String _rua;
	private String _localidade;
	private String _codPostal;
	private String _contacto;
        private String _email;
	private Date _dataAssociacao;

	public Doador(String cod,String nome,String nif,String rua,String localidade,
                String codP,String contacto,String email,Date dataAssoc) {
		this._cod = cod;
                this._nome = nome;
                this._nIF = nif;
                this._rua = rua;
                this._localidade = localidade;
                this._codPostal = codP;
                this._contacto = contacto;
                this._email = email;
                this._dataAssociacao = dataAssoc;
	}

	public void setCod(String aCod) {
		this._cod = aCod;
	}
        public void setEmail(String email){
            this._email = email;
        }
        public String getEmail(){
            return this._email;
        }

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public void setNIF(String aNif) {
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

	public void setContacto(String aContacto) {
		this._contacto = aContacto;
	}

	public void setDataAssoc(Date aData) {
		this._dataAssociacao = aData;
	}

	public String getCod() {
		return this._cod;
	}

	public String getNome() {
		return this._nome;
	}

	public String getNIF() {
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

	public String getContacto() {
		return this._contacto;
	}

	public Date getDataAssoc() {
		return this._dataAssociacao;
	}
}