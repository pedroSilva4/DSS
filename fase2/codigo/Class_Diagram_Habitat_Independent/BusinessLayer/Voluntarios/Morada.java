package Class_Diagram_Habitat_Independent.BusinessLayer.Voluntarios;

public class Morada {
	private String _rua;
	private String _localidade;
	private String _codigo_postal;

	public String getRua() {
		return this._rua;
	}

	public void setRua(String aRua) {
		this._rua = aRua;
	}

	public String getLocalidade() {
		return this._localidade;
	}

	public void setLocalidade(String aLocalidade) {
		this._localidade = aLocalidade;
	}

	public String getCodigo_postal() {
		return this._codigo_postal;
	}

	public void setCodigo_postal(String aCodigo_postal) {
		this._codigo_postal = aCodigo_postal;
	}
}