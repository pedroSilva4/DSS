package com.habitat.BusinessLayer.Doadores;

import java.sql.Date;

public class Monetario extends Doacao {
	private float _valor;
        
        public Monetario(String cod, Date data, String descricao,float valor){
            super(cod,data,descricao);
            this._valor = valor;
        }
        
	public float getValor() {
		return this._valor;
	}

	public void setValor(float aValor) {
		this._valor = aValor;
	}
}