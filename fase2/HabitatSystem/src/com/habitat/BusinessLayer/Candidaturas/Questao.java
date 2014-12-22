package com.habitat.BusinessLayer.Candidaturas;

public class Questao {
	private String _pergunta;
	private String _resposta;
	private String _cod;

	public Questao() {
		throw new UnsupportedOperationException();
	}

	public void setPergunta() {
		throw new UnsupportedOperationException();
	}

	public void SetResposta() {
		throw new UnsupportedOperationException();
	}

	public String getPergunta() {
		return this._pergunta;
	}

	public String getResposta() {
		return this._resposta;
	}

	public String getCod() {
		return this._cod;
	}

	public void setCod(String aCod) {
		this._cod = aCod;
	}
}