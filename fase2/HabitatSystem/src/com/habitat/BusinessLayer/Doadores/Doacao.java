package com.habitat.BusinessLayer.Doadores;

import java.sql.Date;

public class Doacao {
	private String _cod;
	private Date _data;
        private String _descricao;

	public Doacao(String cod, Date data, String descricao) {
		this._cod = cod;
                this._data = data;
                this._descricao = descricao;
	}

	public void setCod(String aCod) {
		this._cod = aCod;
	}



	public String getCod() {
		return this._cod;
	}

	public Date getData() {
		return this._data;
	}
        
        /*
        public String getDate(){
        return ((this._data.getYear()+1900)+"-"+(this._data.getMonth()+1)+"-"+this._data.getDate());
    }
        */

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