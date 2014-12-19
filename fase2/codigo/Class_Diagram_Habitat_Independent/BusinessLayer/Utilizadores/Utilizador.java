package Class_Diagram_Habitat_Independent.BusinessLayer.Utilizadores;

import Class_Diagram_Habitat_Independent.BusinessLayer.Voluntarios.Morada;

public class Utilizador {
	private String _nome;
	private String _password;
	private String _username;
	private String _nif;
	private String _tipo;
	private Morada _morada;

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

	public void setMorada(Object aMorada_m) {
		throw new UnsupportedOperationException();
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