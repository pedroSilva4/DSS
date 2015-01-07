package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Doadores.DMaterial;
import com.habitat.BusinessLayer.Doadores.Doacao;
import com.habitat.BusinessLayer.Doadores.Monetario;
import com.habitat.BusinessLayer.Doadores.Servicos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

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
        if (res.next() == false) {
            return null;
        }
        if (res.getString(4).equals("material")) {
            DMaterial m;
            Integer i = new Integer(res.getString(6));
            m = new DMaterial(res.getString(1), res.getDate(3), res.getString(2), res.getString(7), i.intValue());
            return m;
        }
        if (res.getString(4).equals("serviço")) {
            Servicos s;
            s = new Servicos(res.getString(1), res.getDate(3), res.getString(2));
            return s;
        }
        if (res.getString(4).equals("monetário")) {
            Monetario m;
            Float f = new Float(res.getString(5));
            m = new Monetario(res.getString(1), res.getDate(3), res.getString(2), f.floatValue());
            return m;
        }
        return null;
    }

    public String add(String aDoador, Doacao aDoacao) throws SQLException {
        PreparedStatement st;
        ResultSet res;
        String sql;
        if (aDoacao.getClass() == DMaterial.class) {
            sql = "insert into Habitat.Doacoes"
                    + "(descricao,data,tipo,quantidade,unidade,doador)"
                    + "values("
                    + "?,?,?,?,?,?);";
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, aDoacao.getDescricao());
            st.setDate(2, aDoacao.getData());
            st.setString(3, "material");
            Integer i = new Integer(((DMaterial) aDoacao).getQuantidade());
            st.setString(4, i.toString());
            st.setString(5, ((DMaterial) aDoacao).getUnidade());
            st.setString(6, aDoador);
            st.executeUpdate();
            res = st.getGeneratedKeys();
            String key = null;
            if (res.next()) {
                key = res.getString(1);
            }
            return key;
        }
        if (aDoacao.getClass() == Monetario.class) {
            sql = "insert into Habitat.Doacoes"
                    + "(descricao,data,tipo,valor,doador)"
                    + "values(?,?,?,?,?);";
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, aDoacao.getDescricao());
            st.setDate(2, aDoacao.getData());
            st.setString(3, "monetário");
            //Float f = ((Monetario)aDoacao).getValor();
            st.setFloat(4, ((Monetario) aDoacao).getValor());
            st.setString(5, aDoador);
            st.executeUpdate();
            res = st.getGeneratedKeys();
            String key = null;
            if (res.next()) {
                key = res.getString(1);
            }
            return key;
        }
        if (aDoacao.getClass() == Servicos.class) {
            sql = "insert into Habitat.Doacoes"
                    + "(descricao,data,tipo,doador)"
                    + "values(?,?,?,?);";
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, aDoacao.getDescricao());
            st.setDate(2, aDoacao.getData());
            st.setString(3, "serviço");
            st.setString(4, aDoador);
            st.executeUpdate();
            res = st.getGeneratedKeys();
            String key = null;
            if (res.next()) {
                key = res.getString(1);
            }
            return key;
        }

        return null;
    }

    public boolean associarDoacao(String codD, String codE) throws SQLException {
        PreparedStatement st;
        String sql;
        sql = "update Habitat.Doacoes set evento = ?;";
        st = conn.prepareStatement(sql);
        st.setString(1, codE);
        st.executeUpdate();
        return true;
    }

    public boolean associaProjecto(String codP, String codD) throws SQLException {
        PreparedStatement st;
        String sql = "update Habitat.Doacoes set "
                + "projecto = ?"
                + "where id = ?;";
        st = conn.prepareStatement(sql);
        st.setString(1, codP);
        st.setString(2, codD);
        st.executeUpdate();
        return true;
    }

    public ArrayList<Doacao> getLista(String projeto, String evento, String doador) throws SQLException {

        ArrayList<Doacao> ds = new ArrayList<>();
        PreparedStatement st;
        ResultSet res;
        String sql = "select * from Habitat.Doacoes";
        int contador = 0;
        if (projeto != null) {
            sql += " where projecto = ?";
            contador++;
        }
        if (evento != null) {
            if (contador > 0) {
                sql += " and evento = ?";
            } else {
                sql += " where evento = ?";
            }
            contador++;
        }

        if (doador != null) {
            if (contador > 0) {
                sql += " and doador = ?";
            } else {
                sql += " where doador = ?";
            }
            contador++;
        }
        sql += ";";
        st = conn.prepareStatement(sql);

        if (doador != null) {
            st.setString(contador, doador);
            contador--;
        }
        if (evento != null) {
            st.setString(contador, evento);
            contador--;
        }
        if (projeto != null) {
            st.setString(contador, projeto);
            contador--;
        }
        res = st.executeQuery();

        while (res.next()) {
            if (res.getString(4).equals("material")) {
                DMaterial m;
                Integer i = new Integer(res.getString(6));
                m = new DMaterial(res.getString(1), res.getDate(3), res.getString(2), res.getString(7), i.intValue());
                ds.add(m);
            }
            if (res.getString(4).equals("serviço")) {
                Servicos s;
                s = new Servicos(res.getString(1), res.getDate(3), res.getString(2));
                ds.add(s);
            }
            if (res.getString(4).equals("monetário")) {
                Monetario m;
                Float f = new Float(res.getString(5));
                m = new Monetario(res.getString(1), res.getDate(3), res.getString(2), f.floatValue());
                ds.add(m);
            }
        }
        return ds;
    }

    public ArrayList<Doacao> getLista() throws SQLException {
        ArrayList<Doacao> ds = new ArrayList<Doacao>();
        Statement st;
        ResultSet res;
        String sql = "select * from Habitat.Doacoes";
        st = conn.createStatement();
        res = st.executeQuery(sql);
        //(String cod, Date data, String descricao, String tipo,
// String valor,String quant, String unidade)
        while (res.next()) {
            if (res.getString(4).equals("material")) {
                DMaterial m;
                Integer i = new Integer(res.getString(6));
                m = new DMaterial(res.getString(1), res.getDate(3), res.getString(2), res.getString(7), i.intValue());
                ds.add(m);
            }
            if (res.getString(4).equals("serviço")) {
                Servicos s;

                s = new Servicos(res.getString(1), res.getDate(3), res.getString(2));
                ds.add(s);
            }
            if (res.getString(4).equals("monetário")) {
                Monetario m;
                Float f = new Float(res.getString(5));
                m = new Monetario(res.getString(1), res.getDate(3), res.getString(2), f.floatValue());
                ds.add(m);
            }
        }
        return ds;
    }

    
    //apagar daqui ate ao fim?
    public HashMap<String, Doacao> getPorProjecto(String aCod) throws SQLException {
        PreparedStatement st;
        ResultSet res;
        String sql;
        sql = "select * from Habitat.Doacoes where projecto = ?;";
        HashMap<String, Doacao> ds = new HashMap<String, Doacao>();
        st = conn.prepareStatement(sql);
        st.setString(1, aCod);
        res = st.executeQuery();
        while (res.next()) {
            if (res.getString(4).equals("material")) {
                DMaterial m;
                //(String cod, Date data, String descricao,String unidade,int quantidade)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                Integer i = new Integer(res.getString(6));
                m = new DMaterial(res.getString(1), d1, res.getString(2), res.getString(7), i.intValue());
                ds.put(res.getString("id"), m);
            }
            if (res.getString(4).equals("serviço")) {
                Servicos s;
                //(String cod, Date data, String descricao)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                s = new Servicos(res.getString(1), d1, res.getString(2));
                ds.put(res.getString("id"), s);
            }
            if (res.getString(4).equals("monetário")) {
                Monetario m;
                //(String cod, Date data, String descricao,float valor)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                Float f = new Float(res.getString(5));
                m = new Monetario(res.getString(1), d1, res.getString(2), f.floatValue());
                ds.put(res.getString("id"), m);
            }
        }
        return ds;
    }

    public HashMap<String, Doacao> getPorDoador(String aCod) throws SQLException {
        PreparedStatement st;
        ResultSet res;
        String sql;
        HashMap<String, Doacao> ds = new HashMap<String, Doacao>();
        sql = "select * from Habitat.Doacoes where doador = ?;";
        st = conn.prepareStatement(sql);
        st.setString(1, aCod);
        res = st.executeQuery();
        while (res.next()) {
            if (res.getString(4).equals("material")) {
                DMaterial m;
                //(String cod, Date data, String descricao,String unidade,int quantidade)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                Integer i = new Integer(res.getString(6));
                m = new DMaterial(res.getString(1), d1, res.getString(2), res.getString(7), i.intValue());
                ds.put(res.getString("id"), m);
            }
            if (res.getString(4).equals("serviço")) {
                Servicos s;
                //(String cod, Date data, String descricao)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                s = new Servicos(res.getString(1), d1, res.getString(2));
                ds.put(res.getString("id"), s);
            }
            if (res.getString(4).equals("monetário")) {
                Monetario m;
                //(String cod, Date data, String descricao,float valor)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                float f = Float.parseFloat(res.getString(5));
                m = new Monetario(res.getString(1), d1, res.getString(2), f);
                ds.put(res.getString("id"), m);
            }
        }
        return ds;
    }

    public HashMap<String, Doacao> getPorEvento(String aCod) throws SQLException {
        PreparedStatement st;
        ResultSet res;
        String sql;
        sql = "select * from Habitat.Doacoes where evento = ?;";
        HashMap<String, Doacao> ds = new HashMap<String, Doacao>();
        st = conn.prepareStatement(sql);
        st.setString(1, aCod);
        res = st.executeQuery();
        while (res.next()) {
            if (res.getString(4).equals("material")) {
                DMaterial m;
                //(String cod, Date data, String descricao,String unidade,int quantidade)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                Integer i = new Integer(res.getString(6));
                m = new DMaterial(res.getString(1), d1, res.getString(2), res.getString(7), i.intValue());
                ds.put(res.getString("id"), m);
            }
            if (res.getString(4).equals("serviço")) {
                Servicos s;
                //(String cod, Date data, String descricao)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                s = new Servicos(res.getString(1), d1, res.getString(2));
                ds.put(res.getString("id"), s);
            }
            if (res.getString(4).equals("monetário")) {
                Monetario m;
                //(String cod, Date data, String descricao,float valor)
                String[] parts = res.getString(3).split("-");
                Date d1 = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                Float f = new Float(res.getString(5));
                m = new Monetario(res.getString(1), d1, res.getString(2), f.floatValue());
                ds.put(res.getString("id"), m);
            }
        }
        return ds;
    }

}
