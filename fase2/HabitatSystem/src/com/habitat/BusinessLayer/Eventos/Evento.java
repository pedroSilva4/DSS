package com.habitat.BusinessLayer.Eventos;

import com.habitat.DataLayer.DoacoesDAO;
import com.habitat.DataLayer.DoadoresDAO;
import java.sql.Date;

public class Evento {
	private String _cod;
	private Date _data;
	private float _angariacao;
	private int _npessoas;
	private String _organizador;
	private String _nota;
        public DoacoesDAO doacoes_;
        public DoadoresDAO doadores_;
        
	public Evento(String cod, Date data, float val, 
                        int nPessoas, String organizador, String nota) {
            this._cod = cod;
            this._data = data;
            this._angariacao = val;
            this._npessoas = nPessoas;
            this._organizador = organizador;
            this._nota = nota;
	}


	public void setAngariacao(float aAnga) {
		this._angariacao = aAnga;
	}

	public void setData(Date aDate) {
		this._data = aDate;
	}

	public void setNPessoas(int aN) {
		this._npessoas = aN;
	}

	public void setOrganisador(String aOrg) {
		this._organizador = aOrg;
	}

	public void setNota(String aNota) {
		this._nota = aNota;
	}

	public String getCod() {
		return this._cod;
	}

	public float getAngariacao() {
		return this._angariacao;
	}

	public Date getData() {
		return this._data;
	}

	public int getNPessoas() {
		return this._npessoas;
	}

	public String getorganisador() {
		return this._organizador;
	}

	public String getNota() {
		return this._nota;
	}
        
        /*
        public String toString(){
            
            Date d = this.getData();
            return this.getCod()+": "+d.getYear()+"/"+(d.getMonth()-1)+"/"+d.getDate();
        }
        */

}
