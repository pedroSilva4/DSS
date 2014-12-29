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
            if(res.next() == false) return false;
            sql = "insert into Habitat.Voluntarios"
                    + "(nome,dataAssociacao,contacto,dataNascimento,"
                    + "profissao,rua,localidade,codPostal,nomeEquipa)"
                    + "values(?,?,?,?,?,?,?,?,?);";
            st = conn.prepareStatement(sql);
            st.setString(1, aVol.getNome());
            st.setString(2, aVol.getDateAssociacao());
            st.setString(3, aVol.getContacto());
            st.setString(4, aVol.getDateNasc());
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
                String[] parts = res.getString("dataNascimento").split("-");
                Date d1 = new Date(Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
                String[] parts2 = res.getString("dataAssociacao").split("-");
                Date d2 = new Date(Integer.parseInt(parts2[1]),
                        Integer.parseInt(parts2[2]),Integer.parseInt(parts2[3]));
                return new Voluntario(res.getString("id"),res.getString("nome"),d1,d2,
                            res.getString("contacto"),res.getString("nomeEquipa"),
                            res.getString("profissao"),m);
                
            }
            return null;
	}

	public void update(Voluntario aVol) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql;
            sql = "update Habitat.Voluntarios set"
                    + "nome = ?,"
                    + "dataAssociacao = ?,"
                    + "contacto = ?,"
                    + "dataNascimento = ?,"
                    + "profissao = ?,"
                    + "rua = ?,"
                    + "localidade = ?,"
                    + "codPostal = ?,"
                    + "nomeEquipa = ?;"
                    + "where id = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, aVol.getNome());
            st.setString(2, aVol.getDateAssociacao());
            st.setString(3, aVol.getContacto());
            st.setString(4, aVol.getDateNasc());
            st.setString(5, aVol.getProfissao());
            st.setString(6, aVol.getMorada().getRua());
            st.setString(7, aVol.getMorada().getLocalidade());
            st.setString(8, aVol.getMorada().getCodigo_postal());
            st.setString(9, aVol.getNomeEquipa());
            st.setString(9, aVol.getCod());
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
                        res.getString("localidade"),res.getString("dataNascimento"));
                String[] parts = res.getString("dataNascimento").split("-");
                Date d1 = new Date(Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
                String[] parts2 = res.getString("dataAssociacao").split("-");
                Date d2 = new Date(Integer.parseInt(parts2[1]),
                        Integer.parseInt(parts2[2]),Integer.parseInt(parts2[3]));
                Voluntario v;
                v = new Voluntario(res.getString("id"),res.getString("nome"),d1,d2,
                            res.getString("contacto"),res.getString("nomeEquipa"),
                            res.getString("profissao"),m);
                vs.add(v);
            }
            return vs;

        }
}