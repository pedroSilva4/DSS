package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Utilizadores.Utilizador;
import java.sql.Connection;
import java.sql.DriverManager;
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

	public Utilizador login(String aUser, String aPasswd) throws SQLException {
            //Statement st;
            PreparedStatement st;
            ResultSet res;
            String sql; 
            sql = "select * from Habitat.Funcionarios where username = ?;";
            /*st = conn.createStatement();
           // st.setString(1, aUser);
            res = st.executeQuery(sql);*/
            st = conn.prepareStatement(sql);
            st.setString(1, aUser);
            res = st.executeQuery();
            
            if(res.next()){
                if(res.getString(2).equals(aPasswd)){
            // (String nome, String password, String username, String nif, 
            // String tipo, String rua, String localidade,String codPostal)
                    return new Utilizador(res.getString(3),res.getString(2),
                            res.getString(1),res.getString(4),res.getString(8),res.getString(5),
                            res.getString(6),res.getString(7));
                }
            }
            return null;
	}

	public void logout() {
		throw new UnsupportedOperationException();
	}
}