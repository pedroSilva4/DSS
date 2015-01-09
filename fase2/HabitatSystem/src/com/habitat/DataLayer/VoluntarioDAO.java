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
                        res.getString("codPostal"));

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
        public ArrayList<Voluntario> getListaVolProjTar(String cProj, String cTar) throws SQLException{
            PreparedStatement st;
            ResultSet res;
            ArrayList<Voluntario> vs = new ArrayList<Voluntario>();
            String sql = "select * from voluntarios " +
                            "where id in(select voluntarios from ProjectoTarefaVoluntario\n" +
                                            "where tarefas = ? and projecto = ?);";
            st = conn.prepareStatement(sql);
            st.setString(1, cTar);
            st.setString(2, cProj);
            res = st.executeQuery();
            while(res.next()){
         //(String rua, String localidade, String codPostal)
//(String cod, String nome, Date dataNasc,Date dataAssoc, String contacto, String equipa,String profissao,Morada m)
                Morada m = new Morada(res.getString("rua"),res.getString("localidade"),res.getString("codPostal"));
                Voluntario v = new Voluntario(res.getString("id"),res.getString("nome"),
                                res.getDate("dataNascimento"),res.getDate("dataAssociacao"),
                                res.getString("contacto"),res.getString("nomeEquipa"),res.getString("profissao"),m);
                vs.add(v);
            }
            return vs;
        }
        
        public Date getDataParticipacao(String cTar, String cProj, String cVol) throws SQLException{
            PreparedStatement st;
            ResultSet res;
            String sql = "select dataRealizacao from Habitat.ProjectoTarefaVoluntario "
                             + "where voluntarios = ? and tarefas = ? and projecto = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, cVol);
            st.setString(2, cTar);
            st.setString(3, cProj);
            res = st.executeQuery();
            if(res.next())
                return res.getDate("dataRealizacao");
            return null;
        }
        public String getDuracaoParticipacao(String cTar, String cProj, String cVol) throws SQLException{
            PreparedStatement st;
            ResultSet res;
            String sql = "select duracaoHoras from Habitat.ProjectoTarefaVoluntario "
                             + "where voluntarios = ? and tarefas = ? and projecto = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, cVol);
            st.setString(2, cTar);
            st.setString(3, cProj);
            res = st.executeQuery();
            if(res.next())
                return res.getString("duracaoHoras");
            return null;
        }
        public void addParticipacao(String cVol, String cTar, String cProj, Date dataR, int dHoras) throws SQLException{
            PreparedStatement st;
            ResultSet res;
            String sql = "select * from Habitat.ProjectoTarefaVoluntario "
                            + "where voluntarios = ? and tarefas = ? and projecto = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, cVol);
            st.setString(2, cTar);
            st.setString(3, cProj);
            res = st.executeQuery();
            if(res.next()){
                Integer h = new Integer(res.getString("duracaoHoras"));
                h+=dHoras;
                sql = "update Habitat.ProjectoTarefaVoluntario "
                        + "set duracaoHoras = ? "
                        + "where voluntarios = ? and tarefas = ? and projecto = ?;";
                st = conn.prepareStatement(sql);
                st.setString(1, h.toString());
                st.setString(2, cVol);
                st.setString(3, cTar);
                st.setString(4, cProj);
                st.executeUpdate();
            }
            else{
                sql = "insert into Habitat.ProjectoTarefaVoluntario (duracaoHoras, dataRealizacao, voluntarios, tarefas, projecto) "
                        + "values(?,?,?,?,?);";
                st = conn.prepareStatement(sql);
                Integer h = new Integer(dHoras);
                st.setString(1, h.toString());
                st.setDate(2, dataR);
                st.setString(3, cVol);
                st.setString(4, cTar);
                st.setString(5, cProj);
                st.executeUpdate();
            }
        }
}