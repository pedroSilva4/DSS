package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Eventos.Evento;
import com.habitat.BusinessLayer.Eventos.*;
import java.sql.Connection;
import java.sql.Date;

public class EventosDAO {

    public EventosDAO(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public boolean contains(String aCod) {
		throw new UnsupportedOperationException();
	}

	public Evento get(String aCod) {
		throw new UnsupportedOperationException();
	}

	public boolean update(Evento aEvento) {
		throw new UnsupportedOperationException();
	}

	public void add(Date aData, float aMont, int aNpessoas, String aOrg, String aNota) {
		throw new UnsupportedOperationException();
	}

	public boolean associarDoador(String aCod) {
		throw new UnsupportedOperationException();
	}

	public boolean associaProjeto(String aCodP, String aCodD) {
		throw new UnsupportedOperationException();
	}
}