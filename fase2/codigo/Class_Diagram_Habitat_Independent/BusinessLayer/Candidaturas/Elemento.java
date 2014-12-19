package Class_Diagram_Habitat_Independent.BusinessLayer.Candidaturas;

public class Elemento {
	private String _nome;
	private String _escolaridade;
	private Callendar _dataNasc;
	private String _estCivil;
	private String _parentesco;
	private String _ocupacao;
	private String _cod;

	public Elemento() {
		throw new UnsupportedOperationException();
	}

	public String getNome() {
		return this._nome;
	}

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public String getEscolaridade() {
		return this._escolaridade;
	}

	public void setEscolaridade(String aEscolaridade) {
		this._escolaridade = aEscolaridade;
	}

	public Callendar getDataNasc() {
		return this._dataNasc;
	}

	public void setDataNasc(Callendar aDataNasc) {
		this._dataNasc = aDataNasc;
	}

	public String getEstCivil() {
		return this._estCivil;
	}

	public void setEstCivil(String aEstCivil) {
		this._estCivil = aEstCivil;
	}

	public String getParentesco() {
		return this._parentesco;
	}

	public void setParentesco(String aParentesco) {
		this._parentesco = aParentesco;
	}

	public String getOcupacao() {
		return this._ocupacao;
	}

	public void setOcupacao(String aOcupacao) {
		this._ocupacao = aOcupacao;
	}

	public String getCod() {
		return this._cod;
	}

	public void setCod(String aCod) {
		this._cod = aCod;
	}
}