package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Projetos.Projeto;
import com.habitat.BusinessLayer.Projetos.ProjetoTarefas;
import com.habitat.BusinessLayer.Tarefas.Tarefa;
import com.mysql.fabric.xmlrpc.base.Data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetosDAO {

    private Connection conn;
    
    public ProjetosDAO(Connection conn) {
       this.conn = conn;
    }

    public boolean existeProjeto(String aCod) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        String sql = "select * from Habitat.Projectos where id = ?;";

        st = conn.prepareStatement(sql);
        st.setString(1, aCod);
        rs = st.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public void add(Projeto aProjeto) throws SQLException {
        PreparedStatement st;
        String sql = "INSERT INTO `Habitat`.`Projectos` (`candidatura`, `dataInicio`, `dataFim`, `estado`, `descricao`, `orcamento`, `funcionario`) VALUES (?, ?, ?, ?, ?, ?, ?);";

        st = conn.prepareStatement(sql);
        st.setInt(1, Integer.parseInt(aProjeto.getCandidatura()));
        st.setString(2, aProjeto.getDateI());
        st.setString(3, aProjeto.getDateF());
        st.setString(4, aProjeto.getEstado());
        st.setString(5, aProjeto.getDescricao());
        st.setDouble(6, aProjeto.getOrcamento());
        st.setString(7, aProjeto.getFuncionario());        
        st.executeUpdate();
    }
    

    public void addTarefa(String aTarefa, String aProjeto, Date aDataI, Date aDataF) throws SQLException {
        PreparedStatement st;
        String sql = "insert into Habitat.ProjectoTarefas (dataInicio,dataFim,projecto,tarefas) values(?,?,?,?);";
        st = conn.prepareStatement(sql);
        st.setString(1, aDataI.getYear()+"-"+aDataI.getMonth()+"-"+aDataI.getDate());
        st.setString(2, aDataF.getYear()+"-"+aDataF.getMonth()+"-"+aDataF.getDate());
        st.setString(3, aProjeto);
        st.setString(4, aTarefa);
        st.executeUpdate();
    }

    public Projeto get(String aProjeto) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        String sqlP = "select * from Habitat.Projectos where id = ?;";
        String sqlPT = "select * from Habitat.ProjectoTarefas where projecto = ?;";
        
        st = conn.prepareStatement(sqlPT); 
        st.setString(1, aProjeto);
        rs = st.executeQuery();

        ArrayList<ProjetoTarefas> tarefas = new ArrayList<ProjetoTarefas>();
        while(rs.next())
            tarefas.add(new ProjetoTarefas(rs.getDate(1),rs.getDate(2),rs.getString(4)));        
        
        st = conn.prepareStatement(sqlP);        
        st.setString(1, aProjeto);
        rs = st.executeQuery();
        if(rs.next()){
            String[] auxData = rs.getString(3).split("-");
            Date dA = new Date(Integer.parseInt(auxData[0]),
                    Integer.parseInt(auxData[1]), Integer.parseInt(auxData[2]));

            auxData = rs.getString(4).split("-");
            Date dC = new Date(Integer.parseInt(auxData[0]),
                    Integer.parseInt(auxData[1]), Integer.parseInt(auxData[2]));

        
            return new Projeto(rs.getString(1),rs.getString(2), dA, dC,rs.getString(5),rs.getString(6),Double.parseDouble(rs.getString(7)),rs.getString(8),tarefas);
        }
        return null;
    }

    public void update(Projeto aProjeto) throws SQLException {
        PreparedStatement st;
        String sql = "UPDATE Habitat.Projectos SET `dataInicio`=?, `dataFim`=?, `estado`=?, `descricao`=?, `orcamento`=?, funcionario=? WHERE `id`=?;";
        st = conn.prepareStatement(sql);
        st.setString(1, aProjeto.getDataI().toString());
        st.setString(2, aProjeto.getDataF().toString());
        st.setString(3, aProjeto.getEstado());
        st.setString(4, aProjeto.getDescricao());
        st.setDouble(5, aProjeto.getOrcamento());
        st.setString(6, aProjeto.getFuncionario());
        st.setString(7,aProjeto.getCod());
        st.executeUpdate();
        
        /*atualizar tarefas?????? */    
    }

    public void addExeTarefa(String aTarefa, String aProjeto, String aVoluntario, Date aData, double aDuracao) throws SQLException {
        PreparedStatement st;
        String sql = "insert into Habitat.ProjectoTarefaVoluntario (duracaoHoras, dataRealizacao, voluntarios, tarefas, projecto) VALUES (?,?,?,?,?);";
        st = conn.prepareStatement(sql);
        st.setDouble(1, aDuracao);
        st.setDate(2, aData);
        st.setString(3, aVoluntario);
        st.setString(4, aTarefa);
        st.setString(5, aProjeto);
        st.executeUpdate();
    }
}
