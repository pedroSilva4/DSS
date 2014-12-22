package Class_Diagram_Habitat_Independent.BusinessLayer.Material;

public class Material {
	private String _cod;
	private String _descricao;
	private String _unidade;
	private int _quantidade;

	public String getCod() {
		return this._cod;
	}

	public void setCod(String aCod) {
		this._cod = aCod;
	}

	public String getDescricao() {
		return this._descricao;
	}

	public void setDescricao(String aDescricao) {
		this._descricao = aDescricao;
	}

	public String getUnidade() {
		return this._unidade;
	}

	public void setUnidade(String aUnidade) {
		this._unidade = aUnidade;
	}

	public int getQuantidade() {
		return this._quantidade;
	}

	public void setQuantidade(int aQuantidade) {
		this._quantidade = aQuantidade;
	}
}