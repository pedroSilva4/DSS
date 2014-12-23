/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habitat.BusinessLayer.Doadores;

import java.sql.Date;

/**
 *
 * @author xavier
 */
public class DMaterial extends Doacao {
	private String _unidade;
	private int _quantidade;

        public DMaterial(String cod, Date data, String descricao,String unidade,int quantidade) {
            super(cod, data, descricao);
            this._quantidade = quantidade;
            this._unidade = unidade;
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
