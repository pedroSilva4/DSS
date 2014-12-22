package com.habitat.BusinessLayer.Utilizadores;

import com.habitat.BusinessLayer.Voluntarios.Morada;

public class Utilizador {
	private String _nome;
	private String _password;
	private String _username;
	private String _nif;
        private String _email;
	private String _tipo;
	private Morada _morada;
        
        public Utilizador(String nome, String password, String username, String nif, String tipo, String rua, String localidade,String codPostal){
            this._nome = nome;
            this._nif = nif;
            this._password = password;
            this._tipo= tipo;
            this._username = username;
            this._morada = new Morada(rua,localidade,codPostal);
        }

	public String getNome() {
		return this._nome;
	}

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public String getPassword() {
		return this._password;
	}

	public void setPassword(String aPassword) {
		this._password = aPassword;
	}

	public String getUsername() {
		return this._username;
	}

	public void setUsername(String aUsernam) {
		this._username = aUsernam;
	}

	public String getNif() {
		return this._nif;
	}

	public void setNif(String aNif) {
		this._nif = aNif;
	}

	public Morada getMorada() {
		return this._morada;
	}

	public void setMorada(Morada aM) {
		this._morada = aM;
	}

	public String getTipo() {
		return this._tipo;
	}

	public void setTipo(String aTipo) {
		this._tipo = aTipo;
	}

	public boolean login(String aUser, String aPasswd) {
		throw new UnsupportedOperationException();
	}
}