package Class_Diagram_Habitat_Independent.BusinessLayer.Projetos;

public class Projeto {
	private double _orcamento;
	private String _estado;
	private String _descricao;
	private Date _dataI;
	private Date _dataF;

	public double getOrcamento() {
		return this._orcamento;
	}

	public void setOrcamento(double aOrcamento) {
		this._orcamento = aOrcamento;
	}

	public String getEstado() {
		return this._estado;
	}

	public void setEstado(String aEstado) {
		this._estado = aEstado;
	}

	public String getDescricao() {
		return this._descricao;
	}

	public void setDescricao(String aDescricao) {
		this._descricao = aDescricao;
	}

	public Projeto() {
		throw new UnsupportedOperationException();
	}

	public Projeto(String aDescricao) {
		throw new UnsupportedOperationException();
	}

	public Callendar getDataI() {
		throw new UnsupportedOperationException();
	}

	public Callendar getDataF() {
		throw new UnsupportedOperationException();
	}

	public void setDataF(Callendar aDataF) {
		throw new UnsupportedOperationException();
	}
}