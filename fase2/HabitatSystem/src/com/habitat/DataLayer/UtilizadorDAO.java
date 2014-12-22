package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Utilizadores.Utilizador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilizadorDAO {
    
    private Connection conn;

    public UtilizadorDAO(Connection conn) {
        this.conn = conn;
    }

	public boolean add(Utilizador aUt) {
		throw new UnsupportedOperationException();
	}

	public void update(Utilizador aUt) {
		throw new UnsupportedOperationException();
	}

	public boolean contains(String aUsr) {
		throw new UnsupportedOperationException();
	}

	public Utilizador get(String aUsr) {
		throw new UnsupportedOperationException();
	}

	public boolean remove(String aUsername) {
		throw new UnsupportedOperationException();
	}

	public boolean login(String aUser, String aPasswd) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql;
            sql = "select password from Funcionarios where username = '?';";
            st = conn.prepareStatement(sql);
            st.setString(1, aUser);
            res = st.executeQuery();
            if(res==null) return false;
            if(res.getString(1).equals(aPasswd)) return true;
            return false;
            
	}

	public void logout() {
		throw new UnsupportedOperationException();
	}
}