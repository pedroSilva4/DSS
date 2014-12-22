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

	public boolean add(Utilizador aUt) throws SQLException{
            PreparedStatement st;
            ResultSet res;
            String sql; 
            sql = "select id from Habitat.Funcionarios where username = '?';";
            st = conn.prepareStatement(sql);
            st.setString(1, aUt.getNome());
            res = st.executeQuery();
            if(res.next()) return false;
            sql = "insert into Habitat.Funcionarios values('?','?','?','?','?','?','?','?');";
            st = conn.prepareStatement(sql);
            st.setString(1, aUt.getUsername());
            st.setString(2, aUt.getPassword());
            st.setString(3, aUt.getNome());
            st.setString(4, aUt.getNif());
            st.setString(5, aUt.getMorada().getRua());
            st.setString(6, aUt.getMorada().getLocalidade());
            st.setString(7, aUt.getMorada().getCodigo_postal());
            st.setString(8, aUt.getTipo());
            st.executeUpdate();
            return true;
	}

	public void update(Utilizador aUt) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql; 
            sql = "UPDATE Habitat.Funcionarios SET"
                    + "password = '?',"
                    + "nome = '?',"
                    + "NIF = '?',"
                    + "rua = '?',"
                    + "localidade = '?',"
                    + "codPostal = '?',"
                    + "tipo = '?';";
            st = conn.prepareStatement(sql);
            st.setString(2, aUt.getPassword());
            st.setString(3,aUt.getNome());
            st.setString(4, aUt.getNif());
            st.setString(5, aUt.getMorada().getRua());
            st.setString(6, aUt.getMorada().getLocalidade());
            st.setString(7, aUt.getMorada().getCodigo_postal());
            st.setString(8, aUt.getTipo());
            st.executeUpdate();
	}

	public boolean contains(String aUsr) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql; 
            sql = "select * from Habitat.Funcionarios where username = '?';";
            st = conn.prepareStatement(sql);
            st.setString(1, aUsr);
            res = st.executeQuery();
            return res.next();
	}

	public Utilizador get(String aUsr) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql; 
            sql = "select * from Habitat.Funcionarios where username = '?';";
            st = conn.prepareStatement(sql);
            st.setString(1, aUsr);
            res = st.executeQuery();
            if(res.next()){
            // (String nome, String password, String username, String nif, 
            // String tipo, String rua, String localidade,String codPostal)
                    return new Utilizador(res.getString(3),res.getString(2),
                            res.getString(1),res.getString(4),res.getString(8),res.getString(5),
                            res.getString(6),res.getString(7));
            }
            return null;
	}

	public boolean remove(String aUsername) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql;
            
            sql = "select * from Habitat.Funcionarios where username = '?';";
            st = conn.prepareStatement(sql);
            st.setString(1, aUsername);
            res = st.executeQuery();
            if(res.next() == false) return false;
            
            sql = "DELETE FROM Habitat.Funcionarios where username = '?';";
            st = conn.prepareStatement(sql);
            st.setString(1, aUsername);
            st.executeUpdate();
            return true;
	}

	public Utilizador login(String aUser, String aPasswd) throws SQLException {
            //Statement st;
            PreparedStatement st;
            ResultSet res;
            String sql; 
            sql = "select * from Habitat.Funcionarios where username = '?';";
            st = conn.prepareStatement(sql);
            st.setString(1, aUser);
            res = st.executeQuery();
            
            if(res.next()){
                if(res.getString(2).equals(aPasswd)){
                    return new Utilizador(res.getString(3),res.getString(2),
                            res.getString(1),res.getString(4),res.getString(8),res.getString(5),
                            res.getString(6),res.getString(7));
                }
            }
            return null;
	}

	public void logout() throws SQLException {
		conn.close();
	}
}