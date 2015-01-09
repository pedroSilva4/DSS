package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Material.Material;
import com.habitat.BusinessLayer.Material.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class MaterialDAO {

    private Connection conn;

    public MaterialDAO(Connection conn) {
        this.conn = conn;
    }

    public void remove(String aCod) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        String sql = "delete from Habitat.Material where id = ?;";

        st = conn.prepareStatement(sql);
        st.setString(1, aCod);
        st.executeUpdate();
    }

    public Material get(String aCod) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        String sql = "select * from Habitat.Material where id = ?;";

        st = conn.prepareStatement(sql);
        st.setString(1, aCod);
        rs = st.executeQuery();
        rs.next();
        return new Material(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)), rs.getString(4));
    }

    public void add(String aDescricao, String aUnidade, int aQuantidade) throws SQLException {
        /*PreparedStatement st;
        String sql = "insert into Habitat.Material (`descricao`, `quantidade`, `unidade`) values(?,?,?);";

        st = conn.prepareStatement(sql);
        st.setString(1, aDescricao);
        st.setInt(2, aQuantidade);
        st.setString(3, aUnidade);
        st.executeUpdate();*/
        PreparedStatement st;
        String sql = "call sp_actualizaMaterial(?,?,?)";
        st = conn.prepareStatement(sql);
        st.setString(1, aDescricao);
        st.setInt(2, aQuantidade);
        st.setString(3, aUnidade);
        st.executeUpdate();
    }
   

    public void set(String aCod, String aDescricao, String aUnidade, int aQuantidade) throws SQLException {
        PreparedStatement st;
        String sql = "UPDATE Habitat.Material SET descricao = ?, quantidade = ?, unidade = ? WHERE id = ?;";
        st = conn.prepareStatement(sql);
        st.setString(1, aDescricao);
        st.setInt(2, aQuantidade);
        st.setString(3, aUnidade);
        st.setString(4, aCod);
        st.executeUpdate();
    }
    
    public void set(Material m) throws SQLException {
        PreparedStatement st;
        String sql = "UPDATE Habitat.Material SET descricao = ?, quantidade = ?, unidade = ? WHERE id = ?;";
        st = conn.prepareStatement(sql);
        st.setString(1, m.getDescricao());
        st.setInt(2, m.getQuantidade());
        st.setString(3, m.getUnidade());
        st.setString(4, m.getCod());
        st.executeUpdate();
    }

    public boolean contains(String aDesc) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        String sql = "select * from Habitat.Material where descricao = ?;";

        st = conn.prepareStatement(sql);
        st.setString(1, aDesc);
        rs = st.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }
    public HashMap<String,Material> getMap() throws SQLException{
        Statement st;
        ResultSet res;
        String sql;
        HashMap<String,Material> ms = new HashMap<String,Material>();
        sql = "select * from Habitat.Material;";
        st = conn.createStatement();
        res = st.executeQuery(sql);
        while(res.next()){
            Integer i = new Integer(res.getString("quantidade"));
            Material m = new Material(res.getString("id"),res.getString("descricao"),
                            i,res.getString("unidade"));
            ms.put(res.getString("id"), m);
        }
        return ms;
    }
    public ArrayList<Material> getLista() throws SQLException{
        Statement st;
        ResultSet res;
        String sql;
        ArrayList<Material> ms = new ArrayList<Material>();
        sql = "select * from Habitat.Material;";
        st = conn.createStatement();
        res = st.executeQuery(sql);
        while(res.next()){
            Integer i = new Integer(res.getString("quantidade"));
            Material m = new Material(res.getString("id"),res.getString("descricao"),
                            i,res.getString("unidade"));
            ms.add(m);
        }
        return ms;
    }
}
