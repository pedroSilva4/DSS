package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Projetos.Projeto;
import java.sql.Connection;
import java.sql.Date;

public class ProjetosDAO {

    public ProjetosDAO(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public boolean existeProjeto(String aCandidato) {
		throw new UnsupportedOperationException();
	}

	public void add(Projeto aProjeto) {
		throw new UnsupportedOperationException();
	}

	public void addTarefa(String aTarefa, String aProjeto, Date aDataI, Date aDataF, double aTempo) {
		throw new UnsupportedOperationException();
	}

	public Projeto get(String aProjeto) {
		throw new UnsupportedOperationException();
	}

	public void update(Projeto aProjeto) {
		throw new UnsupportedOperationException();
	}

	public void addExeTarefa(String aTarefa, String aProjeto, Date aData, double aDuracao) {
		throw new UnsupportedOperationException();
	}
}