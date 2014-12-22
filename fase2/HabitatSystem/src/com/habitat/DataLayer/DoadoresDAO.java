package com.habitat.DataLayer;

// import Class_Diagram_Evento.Doadores.Doador;

import com.habitat.BusinessLayer.Doadores.Doador;
import java.sql.Connection;
import java.sql.Date;

// import com.habitat.BusinessLayer.Doadores.Doador;

public class DoadoresDAO {

    public DoadoresDAO(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public boolean contains(String aCod) {
		throw new UnsupportedOperationException();
	}

	public void add(String aNome, String aNif, String aMorada, Date aData, String aSetor, String aSite, String aPescontac) {
		throw new UnsupportedOperationException();
	}

	public Doador get(String aCod) {
		throw new UnsupportedOperationException();
	}

	public boolean update(com.habitat.BusinessLayer.Doadores.Doador aDoador) {
		throw new UnsupportedOperationException();
	}
}