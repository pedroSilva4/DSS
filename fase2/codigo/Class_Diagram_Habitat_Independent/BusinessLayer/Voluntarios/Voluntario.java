package Class_Diagram_Habitat_Independent.BusinessLayer.Voluntarios;

public class Voluntario {
	private String _nomeEquipa;
	private Object _dataNasc;
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

	public void setDataNasc(String aDataNasc) {
		throw new UnsupportedOperationException();
	}

	public String getDataNasc() {
		throw new UnsupportedOperationException();
	}

	public void setMorada(Object aMorada_m) {
		throw new UnsupportedOperationException();
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