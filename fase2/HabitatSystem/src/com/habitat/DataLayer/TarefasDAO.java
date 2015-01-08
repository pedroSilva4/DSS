package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Material.Material;
import com.habitat.BusinessLayer.Projetos.ProjetoTarefas;
import com.habitat.BusinessLayer.Tarefas.Tarefa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class TarefasDAO {
    
    private Connection conn;

    public TarefasDAO(Connection conn) {
        this.conn = conn;
    }

    public void add(Tarefa aTarefa) throws SQLException {
        PreparedStatement st;
        String sql = "insert into Habitat.Tarefas (`descricao`) values(?);";
        st = conn.prepareStatement(sql);
        st.setString(1, aTarefa.getDescricao());
        st.executeUpdate();
    }
    
    public void add(String desc) throws SQLException{
        PreparedStatement st;
        String sql = "insert into Habitat.Tarefas (`descricao`) values(?);";

        st = conn.prepareStatement(sql);
        st.setString(1, desc);
        st.executeUpdate();
    }

    public boolean existe(String aDescricao) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        String sql = "select * from Habitat.Tarefas where descricao = ?;";

        st = conn.prepareStatement(sql);
        st.setString(1, aDescricao);
        rs = st.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public Tarefa get(String aCod) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        String sql = "select * from Habitat.Tarefas where id = ?;";

        st = conn.prepareStatement(sql);
        st.setString(1, aCod);
        rs = st.executeQuery();
        rs.next();
        return new Tarefa(rs.getString(1), rs.getString(2));
    }

    public void setTarefa(Tarefa aTarefa) throws SQLException {
        PreparedStatement st;
        String sql = "UPDATE Habitat.Tarefas SET descricao = ? WHERE id = ?;";
        st = conn.prepareStatement(sql);
        st.setString(1, aTarefa.getDescricao());
        st.setString(2, aTarefa.getCod());
        st.executeUpdate();
    }
    public ArrayList<Tarefa> getTarefas() throws SQLException{
        Statement st;
        ResultSet res;
        ArrayList<Tarefa> ts = new ArrayList<Tarefa>();
        String sql = "Select * from Habitat.Tarefas;";
        st = conn.createStatement();
        res = st.executeQuery(sql);
        while(res.next()){
            Tarefa t = new Tarefa(res.getString("id"),res.getString("descricao"));
            ts.add(t);
        }
        return ts;
    }
    
    public ArrayList<Tarefa> getTarefasAssociadas(String codProj) throws SQLException{
        PreparedStatement st;
        ResultSet res;
        ArrayList<Tarefa> ts = new ArrayList<Tarefa>();
        String sql = "select * from Tarefas " +
                        "where id in (Select tarefas from ProjectoTarefas where projecto = ?);";
        st = conn.prepareStatement(sql);
        st.setString(1, codProj);
        res = st.executeQuery();
        while(res.next()){
            Tarefa t = new Tarefa(res.getString("id"),res.getString("descricao"));
            ts.add(t);
        }
        return ts;
    }
    public HashMap<String,ProjetoTarefas> getProjetoTarefa(String codProj) throws SQLException{
        PreparedStatement st;
        ResultSet res;
        HashMap<String,ProjetoTarefas> pts = new HashMap<String,ProjetoTarefas>();
        String sql = "select * from ProjectoTarefas where projecto = ?;";
        st = conn.prepareStatement(sql);
        st.setString(1, codProj);
        res = st.executeQuery();
        while(res.next()){
            //Date aDataI, Date aDataF, String aTarefa
            ProjetoTarefas pt = new ProjetoTarefas(res.getDate("dataInicio"),
                    res.getDate("dataFim"),res.getString("tarefas"));
            pts.put(pt.getaTarefa(), pt);
        }
        return pts;
    }
}
