package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Voluntarios.Morada;
import com.habitat.BusinessLayer.Voluntarios.Voluntario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                    + "(nome,dataAssociacao,tipo,contacto,dataNascimento,"
                    + "profissao,rua,localidade,codPostal,nomeEquipa)"
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, aVol.getNome());
            st.setString(2, aVol.getDataAssociacao().toString());
            st.setString(3, aVol.getTipo());
            st.setString(4, aVol.getContacto());
            st.setString(5, aVol.getDataNasc().toString());
            st.setString(6, aVol.getProfissao());
            st.setString(7, aVol.getMorada().getRua());
            st.setString(8, aVol.getMorada().getLocalidade());
            st.setString(9, aVol.getMorada().getCodigo_postal());
            st.setString(8, aVol.getNomeEquipa());
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
                Morada m = new Morada(res.getString(8),res.getString(9),res.getString(10));
 //(String cod, String nome, Date dataNasc,Date dataAssoc,
 //        String tipo, String contacto, String equipa,String profissao,Morada m)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
                String[] parts2 = res.getString(6).split("-");
                Date d2 = new Date(Integer.parseInt(parts2[1]),
                        Integer.parseInt(parts2[2]),Integer.parseInt(parts2[3]));
                return new Voluntario(res.getString(1),res.getString(2),d1,d2,
                            res.getString(4),res.getString(5),
                            res.getString(11),res.getString(7),m);
                
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
                    + "tipo = ?,"
                    + "contacto = ?,"
                    + "dataNascimento = ?,"
                    + "profissao = ?,"
                    + "rua = ?,"
                    + "localidade = ?,"
                    + "codPostal = ?,"
                    + "nomeEquipa = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, aVol.getNome());
            st.setString(2, aVol.getDataAssociacao().toString());
            st.setString(3, aVol.getTipo());
            st.setString(4, aVol.getContacto());
            st.setString(5, aVol.getDataNasc().toString());
            st.setString(6, aVol.getProfissao());
            st.setString(7, aVol.getMorada().getRua());
            st.setString(8, aVol.getMorada().getLocalidade());
            st.setString(9, aVol.getMorada().getCodigo_postal());
            st.setString(10, aVol.getNomeEquipa());
            st.executeUpdate();
	}
}