package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Eventos.Evento;
import com.habitat.BusinessLayer.Eventos.*;
import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EventosDAO {
    private Connection conn;

    public EventosDAO(Connection conn) {
        this.conn = conn;
    }

	public boolean contains(String aCod) throws SQLException {
		PreparedStatement st;
                ResultSet res;
                String sql;
                sql = "select * from Habitat.Eventos where id = ?;";
                st = conn.prepareStatement(sql);
                st.setString(1, aCod);
                res = st.executeQuery();
                return res.next();
	}

	public Evento get(String aCod) throws SQLException {
		PreparedStatement st;
                ResultSet res;
                String sql;
                sql = "select * from Habitat.Eventos where id = ?";
                st = conn.prepareStatement(sql);
                st.setString(1, aCod);
                res = st.executeQuery();
                if(res.next()==false) return null;
                String[] parts = res.getString(2).split("-");
                Date d1 = new Date(Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
                Float f = new Float(res.getString(7));
                Integer i = new Integer(res.getString(3));
                return new Evento(res.getString(1),d1,f.floatValue(),i.intValue(),
                                  res.getString(5),res.getString(4));
	}

	public void update(Evento aEvento) throws SQLException {
		PreparedStatement st;
                String sql;
                sql = "update Habitat.Eventos set"
                        + "data = ?,"
                        + "nrParticipantes = ?,"
                        + "observacoes = ?,"
                        + "funcionario = ?,"
                        + "valorAngariado = ?"
                        + "where id = ?;";
                st = conn.prepareStatement(sql);
                st.setString(1, aEvento.getData().toString());
                Integer i = aEvento.getNPessoas();
                st.setString(2, i.toString());
                st.setString(3, aEvento.getNota());
                st.setString(4, aEvento.getorganisador());
                Float f = aEvento.getAngariacao();
                st.setString(5, f.toString());
                st.setString(6, aEvento.getCod());
	}

	public void add(Date aData, float aMont, int aNpessoas, String aOrg, String aNota) throws SQLException {
		PreparedStatement st;
                String sql;
                sql = "insert into Habitat.Eventos"
                        + "(data,nrParticipantes,observacoes,funcionario,valorAngariado)"
                        + "values(?,?,?,?,?);";
                st = conn.prepareStatement(sql);
                st.setString(1, aData.toString());
                Integer i = aNpessoas;
                st.setString(2, i.toString());
                st.setString(3, aNota);
                st.setString(4, aOrg);
                Float f = aMont;
                st.setString(5, f.toString());
                st.executeUpdate();
	}
        
        
        

	public boolean associarDoador(String codD, String codE) throws SQLException {
		PreparedStatement st;
                String sql;
                sql = "update Habitat.EventosDoadores set"
                        + "doador = ?,"
                        + "evento = ?;";
                st = conn.prepareStatement(sql);
                st.setString(1, codD);
                st.setString(2, codE);
                st.executeUpdate();
                return true;
                
	}

	public boolean associaProjeto(String aCodP, String aCodD) throws SQLException {
		PreparedStatement st;
                String sql;
                sql = "update Habitat.Eventos set"
                        + "projecto = ?"
                        + "where id = ?;";
                st = conn.prepareStatement(sql);
                st.setString(1, aCodP);
                st.setString(2, aCodD);
                st.executeUpdate();
                return true;
	}                        
        
        public ArrayList<String> getListaIds() throws SQLException{
            ArrayList<String> ids  =new ArrayList<>();
            PreparedStatement st;
                String sql;
                sql = "Select id  from Habitat.Eventos;";
                st = conn.prepareStatement(sql);
                
                ResultSet rs = st.executeQuery();
                while(rs.next())
                {
                    ids.add(rs.getString(1));
                }
            return ids;
        }
        
        public ArrayList<Evento> getListaEventos() throws SQLException{
            Statement st;
            ResultSet res;
            ArrayList<Evento> evs = new ArrayList<Evento>();
            String sql = "select * from Habitat.Eventos;";
            st = conn.createStatement();
            res = st.executeQuery(sql);
            while(res.next()){   
                String[] parts = res.getString("data").split("-");
                Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
                Float f = new Float(res.getString("valorAngariado"));
                Integer i = new Integer(res.getString("nrParticipantes"));
                Evento ev = new Evento(res.getString("id"),d1,f.floatValue(),i.intValue(),
                                res.getString("funcionario"),res.getString("observacoes"));
                evs.add(ev);  
            }
            return evs;
        }
}