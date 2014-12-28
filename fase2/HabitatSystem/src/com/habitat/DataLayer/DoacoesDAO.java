package com.habitat.DataLayer;

// import Class_Diagram_Evento.Doadores.Doacao;

import com.habitat.BusinessLayer.Doadores.DMaterial;
import com.habitat.BusinessLayer.Doadores.Doacao;
import com.habitat.BusinessLayer.Doadores.Monetario;
import com.habitat.BusinessLayer.Doadores.Servicos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// import com.habitat.BusinessLayer.Doadores.Doacao;

public class DoacoesDAO {
    
    private Connection conn;

    public DoacoesDAO(Connection conn) {
        this.conn = conn;
    }

	public boolean contains(String aCod) throws SQLException {
		PreparedStatement st;
                ResultSet res;
                String sql;
                sql = "select * from Habitat.Doacoes where id = ?;";
                st = conn.prepareStatement(sql);
                st.setString(1, aCod);
                res = st.executeQuery();
                return res.next();
	}

	public Doacao get(String aCod) throws SQLException {
		PreparedStatement st;
                ResultSet res;
                String sql;
                sql = "select * from Habitat.Doacoes where id = ?;";
                st = conn.prepareStatement(sql);
                st.setString(1, aCod);
                res = st.executeQuery();
                if(res.next() == false) return null;
                if(res.getString(4).equals("material")){
                    DMaterial m;
 //(String cod, Date data, String descricao,String unidade,int quantidade)
                    String[] parts = res.getString(3).split("-");
                    Date d1 = new Date(Integer.parseInt(parts[1]),
                                Integer.parseInt(parts[2]),
                                Integer.parseInt(parts[3]));
                    Integer i = new Integer(res.getString(6));
                    m = new DMaterial(res.getString(1),d1,res.getString(2),res.getString(7),i.intValue());
                    return m;
                }
                if(res.getString(4).equals("serviço")){
                    Servicos s;
 //(String cod, Date data, String descricao)
                    String[] parts = res.getString(3).split("-");
                    Date d1 = new Date(Integer.parseInt(parts[1]),
                                Integer.parseInt(parts[2]),
                                Integer.parseInt(parts[3]));
                    s = new Servicos(res.getString(1),d1,res.getString(2));
                    return s;
                }
                
                Monetario m;
 //(String cod, Date data, String descricao,float valor)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[1]),
                                Integer.parseInt(parts[2]),
                                Integer.parseInt(parts[3]));
                Float f = new Float(res.getString(5));
                m = new Monetario(res.getString(1),d1,res.getString(2),f.floatValue());
                return m;
	}

	public void add(String aDoador, Doacao aDoacao) throws SQLException {
		PreparedStatement st;
                ResultSet res;
                String sql;
                if(aDoacao.getClass().toString().equals("DMaterial")){
                    sql = "insert into Habitat.Doacoes"
                            + "(descricao,data,tipo,quantidade,unidade,doador)"
                            + "values("
                            + "?,?,?,?,?,?);";
                    st = conn.prepareStatement(sql);
                    st.setString(1, aDoacao.getDescricao());
                    st.setString(2, aDoacao.getData().toString());
                    st.setString(3, "material");
                    Integer i = new Integer(((DMaterial)aDoacao).getQuantidade());
                    st.setString(4, i.toString());
                    st.setString(5, ((DMaterial)aDoacao).getUnidade());
                    st.setString(6, aDoador);
                    st.executeUpdate();
                }
                if(aDoacao.getClass().toString().equals("Monetario")){
                    sql = "insert into Habitat.Doacoes"
                            + "(descricao,data,tipo,valor,doador)"
                            + "values(?,?,?,?,?);";
                    st = conn.prepareStatement(sql);
                    st.setString(1, aDoacao.getDescricao());
                    st.setString(2, aDoacao.getData().toString());
                    st.setString(3, "monetário");
                    Float f = new Float(((Monetario)aDoacao).getValor());
                    st.setString(4, f.toString());
                    st.setString(5, aDoador);
                    st.executeUpdate();
                }
                if(aDoacao.getClass().toString().equals("Servicos")){
                    sql = "insert into Habitat.Doacoes"
                            + "(descricao,data,tipo,doador)"
                            + "values(?,?,?,?);";
                    st = conn.prepareStatement(sql);
                    st.setString(1, aDoacao.getDescricao());
                    st.setString(2, aDoacao.getData().toString());
                    st.setString(3, "serviço");
                    st.setString(4, aDoador);
                    st.executeUpdate();
                }     
	}
        public boolean associarDoacao(String codD, String codE) throws SQLException{
            PreparedStatement st;
            String sql;
            sql = "update Habitat.Doacoes set evento = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, codE);
            st.executeUpdate();
            return true;
        }
}