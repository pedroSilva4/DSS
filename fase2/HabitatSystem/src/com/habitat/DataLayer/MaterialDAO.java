package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Material.Material;
import com.habitat.BusinessLayer.Material.*;
import java.sql.Connection;

public class MaterialDAO {

    public MaterialDAO(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public void remove(String aCod) {
		throw new UnsupportedOperationException();
	}

	public Material get(String aCod) {
		throw new UnsupportedOperationException();
	}

	public void add(String aDescricao, String aUnidade, int aQuantidade) {
		throw new UnsupportedOperationException();
	}

	public void set(String aCod, String aDescricao, String aUnidade, int aQuantidade) {
		throw new UnsupportedOperationException();
	}

	public boolean contains(String aCod) {
		throw new UnsupportedOperationException();
	}
}