package com.habitat.DataLayer;

// import Class_Diagram_Evento.Doadores.Doador;

import com.habitat.BusinessLayer.Doadores.Doador;
import com.habitat.BusinessLayer.Doadores.Empresa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

// import com.habitat.BusinessLayer.Doadores.Doador;

public class DoadoresDAO {
    
    private Connection conn;

    public DoadoresDAO(Connection conn) {
        this.conn = conn;
    }

	public boolean contains(String aCod) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql; 
            sql = "select * from Habitat.Doadores where id = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, aCod);
            res = st.executeQuery();
            return res.next();
	}

	public void add(Doador aDoador) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql;
            if(aDoador.getClass() == Empresa.class){
                sql = "insert into Habitat.Doadores "
                    + "(nome,NIF,rua,localidade,codPostal,contacto,dataAssociacao,"
                    + "actividade, email, site,pessoaDeContacto)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?);";
                st = conn.prepareStatement(sql);
                st.setString(1, aDoador.getNome());
                st.setString(2, aDoador.getNIF());
                st.setString(3, aDoador.getRua());
                st.setString(4, aDoador.getLocalidade());
                st.setString(5, aDoador.getCodPostal());
                st.setString(6, aDoador.getContacto());
                st.setString(7, aDoador.getDataAssoc().toString());
                st.setString(8, ((Empresa)aDoador).getSetor());
                st.setString(9, aDoador.getEmail());
                st.setString(10, ((Empresa)aDoador).getSite());
                st.setString(11, ((Empresa)aDoador).getPContacto());
                //campo voluntario fica a null po enquanto
            }
            else{
                sql = "insert into Habitat.Doadores "
                    + "(nome,NIF,rua,localidade,codPostal,contacto,dataAssociacao,email)"
                    + "values(?,?,?,?,?,?,?,?);";
                st = conn.prepareStatement(sql);
                st.setString(1, aDoador.getNome());
                st.setString(2, aDoador.getNIF());
                st.setString(3, aDoador.getRua());
                st.setString(4, aDoador.getLocalidade());
                st.setString(5, aDoador.getCodPostal());
                st.setString(6, aDoador.getContacto());
                st.setString(7, aDoador.getDataAssoc().toString());
                st.setString(8, aDoador.getEmail());
                //campo voluntario fica a null po enquanto
            }
            st.executeUpdate();
	}

	public Doador get(String aCod) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql;
            sql = "select * from Habitat.Doadores where id = ?;";
            st = conn.prepareStatement(sql);
            st.setString(1, aCod);
            res = st.executeQuery();
            if(res.next() == false) return null;
            if(res.getString(9)!= null){
                Empresa e;
                String[] parts = res.getString(8).split("-");
                Date d1 = new Date(Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
//(String cod,String nome,String nif,String rua,String localidade,
   //String codP,String contacto,String email,Date dataAssoc,
   //String sector, String site,String pContacto)
                e = new Empresa(res.getString(1),res.getString(2),res.getString(3),res.getString(4),
                                res.getString(5),res.getString(6),res.getString(7),res.getString(10),
                                d1,res.getString(9),res.getString(11),res.getString(12));
                return e;
            }
            Doador d;
            String[] parts = res.getString(8).split("-");
            Date d1 = new Date(Integer.parseInt(parts[1]),
                                Integer.parseInt(parts[2]),
                                Integer.parseInt(parts[3]));
//(String cod,String nome,String nif,String rua,String localidade,
//String codP,String contacto,String email,Date dataAssoc)
            d = new Doador(res.getString(1),res.getString(2),res.getString(3),res.getString(4),
                           res.getString(5),res.getString(6),res.getString(7),res.getString(10),d1);
            return d;
	}

	public boolean update(Doador aDoador) throws SQLException {
            PreparedStatement st;
            ResultSet res;
            String sql;
            if(aDoador.getClass() == Empresa.class){
               Empresa e = (Empresa) aDoador;
               sql = "update Habitat.Doadores set "
                       + "nome = ?,"
                       + "rua = ?,"
                       + "localidade = ?,"
                       + "codPostal = ?,"
                       + "contacto = ?,"
                       + "dataAssociacao = ?,"
                       + "actividade = ?,"
                       + "email = ?,"
                       + "site = ?,"
                       + "pessoaDeContacto = ?"
                       + "where id = ?;";
               //funcionario fica a null
               st = conn.prepareStatement(sql);
               st.setString(1, aDoador.getNome());
               st.setString(2, aDoador.getRua());
               st.setString(3, aDoador.getLocalidade());
               st.setString(4, aDoador.getCodPostal());
               st.setString(5, aDoador.getContacto());
               st.setString(6, aDoador.getDataAssoc().toString());
               st.setString(7, e.getSetor());
               st.setString(8, aDoador.getEmail());
               st.setString(9, e.getSite());
               st.setString(10, e.getPContacto());
               st.setString(11, aDoador.getCod());
               st.executeUpdate();
               return true;
            }
            sql = "update Habitat.Doadores set "
                       + "nome = ?,"
                       + "rua = ?,"
                       + "localidade = ?,"
                       + "codPostal = ?,"
                       + "contacto = ?,"
                       + "dataAssociacao = ?,"
                       + "email = ? "
                       + "where id = ?;";
               //funcionario fica a null
               st = conn.prepareStatement(sql);
               st.setString(1, aDoador.getNome());
               st.setString(2, aDoador.getRua());
               st.setString(3, aDoador.getLocalidade());
               st.setString(4, aDoador.getCodPostal());
               st.setString(5, aDoador.getContacto());
               st.setString(6, aDoador.getDataAssoc().toString());
               st.setString(7, aDoador.getEmail());
               st.setString(8, aDoador.getCod());
               st.executeUpdate();
               return true;
	}
        
        public HashMap<String,String> getListaIdDoadores() throws SQLException{
            HashMap<String,String> l = new HashMap<String,String>();
            Statement st;
            ResultSet res;
            String sql = "select id,nome from Habitat.Doadores;";
            st = conn.createStatement();
            res = st.executeQuery(sql);
            while(res.next()){
                l.put(res.getString("id"), res.getString("nome"));
            }
            return l;
        }
        public ArrayList<Doador> getListaDoadores() throws SQLException{
            ArrayList<Doador> ds = new ArrayList<Doador>();
            Statement st;
            ResultSet res;
            String sql = "select * from Habitat.Doadores;";
            st = conn.createStatement();
            res = st.executeQuery(sql);
            while(res.next()){
                if(res.getString("actividade") == null){
                    String[] parts = res.getString("dataAssociacao").split("-");
                    Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
                    Doador d = new Doador(res.getString("id"),res.getString("nome"),res.getString("NIF"),
                            res.getString("rua"),res.getString("localidade"),res.getString("codPostal"),
                            res.getString("contacto"),res.getString("email"),d1);
                    ds.add(d);
                }
                else{
                    String[] parts = res.getString("dataAssociacao").split("-");
                    Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
                    Empresa e = new Empresa(res.getString("id"),res.getString("nome"),res.getString("NIF"),
                            res.getString("rua"),res.getString("localidade"),res.getString("codPostal"),
                            res.getString("contacto"),res.getString("email"),d1,res.getString("actividade"),
                            res.getString("site"),res.getString("pessoaDeContacto"));
                    ds.add(e);
                }
                
            }
            return ds;
        }
}