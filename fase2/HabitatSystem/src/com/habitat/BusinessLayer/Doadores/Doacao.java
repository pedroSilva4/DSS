package com.habitat.BusinessLayer.Doadores;

import java.sql.Date;

public class Doacao {
	private String _cod;
	private Date _data;
        private String _descricao;
        private String _tipo;
        private float _valor;
        private int _quantidade;
        private String _unidade;

	public Doacao(String cod, Date data, String descricao, String tipo,
                float valor,int quant, String unidade) {
		this._cod = cod;
                this._data = data;
                this._descricao = descricao;
                this._tipo = tipo;
                this._valor = valor;
                this._unidade = unidade;
                this._quantidade = quant;
	}

	public void setCod(String aCod) {
		this._cod = aCod;
	}

    public String getTipo() {
        return _tipo;
    }

    public void setTipo(String _tipo) {
        this._tipo = _tipo;
    }

    public float getValor() {
        return _valor;
    }

    public void setValor(float _valor) {
        this._valor = _valor;
    }

    public int getQuantidade() {
        return _quantidade;
    }

    public void setQuantidade(int _quantidade) {
        this._quantidade = _quantidade;
    }

    public String getUnidade() {
        return _unidade;
    }

    public void setUnidade(String _unidade) {
        this._unidade = _unidade;
    }

	public String getCod() {
		return this._cod;
	}

	public Date getData() {
		return this._data;
	}

	public void setData(Date aData) {
		this._data = aData;
	}

	public String getDescricao() {
		return this._descricao;
	}

	public void Descricao(String aDescricao) {
		this._descricao = aDescricao;
	}
}