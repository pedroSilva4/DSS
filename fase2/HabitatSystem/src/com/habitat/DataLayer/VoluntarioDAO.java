package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Voluntarios.Morada;
import com.habitat.BusinessLayer.Voluntarios.Voluntario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VoluntarioDAO {
    private Connection conn;

    public VoluntarioDAO(Connection conn) {
        this.conn = conn;
    }

	public boolean add(Voluntario aVol) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql;
            sql = "select * from Habitat.Voluntarios where id = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, aVol.getCod());
            res = st.executeQuery();
            if(res.next()) return false;
            sql = "insert into Habitat.Voluntarios"
                    + "(nome,dataAssociacao,contacto,dataNascimento,"
                    + "profissao,rua,localidade,codPostal,nomeEquipa)"
                    + "values(?,?,?,?,?,?,?,?,?);";
            st = conn.prepareStatement(sql);
            st.setString(1, aVol.getNome());
            st.setDate(2, aVol.getDataAssociacao());
            st.setString(3, aVol.getContacto());
            st.setDate(4, aVol.getDataNasc());
            st.setString(5, aVol.getProfissao());
            st.setString(6, aVol.getMorada().getRua());
            st.setString(7, aVol.getMorada().getLocalidade());
            st.setString(8, aVol.getMorada().getCodigo_postal());
            st.setString(9, aVol.getNomeEquipa());
            st.executeUpdate();
            return true;
	}

	public boolean contains(String aId) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql; 
            sql = "select * from Habitat.Voluntarios where id = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, aId);
            res = st.executeQuery();
            return res.next();
	}

	public Voluntario get(String aId) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql; 
            sql = "select * from Habitat.Voluntarios where id = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, aId);
            res = st.executeQuery();
            if(res.next()){
                Morada m = new Morada(res.getString("rua"),res.getString("localidade"),
                        res.getString("dataNascimento"));

                return new Voluntario(res.getString("id"),res.getString("nome"),res.getDate("dataNascimento"),res.getDate("dataAssociacao"),
                            res.getString("contacto"),res.getString("nomeEquipa"),
                            res.getString("profissao"),m);
                
            }
            return null;
	}

	public void update(Voluntario aVol) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql;
            sql = "UPDATE Habitat.Voluntarios SET "
                    + "nome = ?, "
                    + "dataAssociacao = ?, "
                    + "contacto = ?, "
                    + "dataNascimento = ?, "
                    + "profissao = ?, "
                    + "rua = ?, "
                    + "localidade = ?, " 
                    + "codPostal = ?, "
                    + "nomeEquipa = ? "
                    + "where id = ? ;";
            st = conn.prepareStatement(sql);
            st.setString(1, aVol.getNome());
            st.setDate(2, aVol.getDataAssociacao());
            st.setString(3, aVol.getContacto());
            st.setDate(4, aVol.getDataNasc());
            st.setString(5, aVol.getProfissao());
            st.setString(6, aVol.getMorada().getRua());
            st.setString(7, aVol.getMorada().getLocalidade());
            st.setString(8, aVol.getMorada().getCodigo_postal());
            st.setString(9, aVol.getNomeEquipa());
            st.setString(10, aVol.getCod());
            st.executeUpdate();
	}
        public ArrayList<Voluntario> getLista() throws SQLException{
            ArrayList<Voluntario> vs = new ArrayList<Voluntario>();
            Statement st;
            ResultSet res;
            String sql = "select * from Habitat.Voluntarios;";
            st = conn.createStatement();
            res = st.executeQuery(sql);
            while(res.next()){
                Morada m = new Morada(res.getString("rua"),
                        res.getString("localidade"),res.getString("codPostal"));
                Voluntario v;
                v = new Voluntario(res.getString("id"),res.getString("nome"),res.getDate("dataNascimento"),res.getDate("dataAssociacao"),
                            res.getString("contacto"),res.getString("nomeEquipa"),
                            res.getString("profissao"),m);
                vs.add(v);
            }
            return vs;

        }
}