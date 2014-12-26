package com.habitat.DataLayer;

import com.habitat.BusinessLayer.Candidaturas.Candidatura;
import com.habitat.BusinessLayer.Candidaturas.Elemento;
import com.habitat.BusinessLayer.Candidaturas.Questao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CandidaturaDAO {

    private Connection conn;

    public CandidaturaDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean contains(String aCod) throws SQLException {
        PreparedStatement st;
        ResultSet res;
        String sql;
        sql = "select id from Habitat.Candidaturas where id = ?;";
        st = conn.prepareStatement(sql);
        st.setString(1, aCod);
        res = st.executeQuery();

        if (res.next()) 
            return true;       
        else 
            return false;
    }

    public Candidatura get(String aCod) throws SQLException {
        PreparedStatement stC, stE, stQ;
        ResultSet aux;
        String sqlCand, sqlElem, sqlQuest;

        sqlCand = "select * from Habitat.Candidaturas where id = ?;";
        sqlQuest = "select * from Habitat.CandidaturaPerguntas inner join Habitat.Perguntas on Perguntas_id = id where Candidaturas_id = ? order by id;";
        sqlElem = "select * from Elementos where familia in (select familia from Candidaturas where id = ?);";

        //Elementos
        stE = conn.prepareStatement(sqlElem);
        stE.setString(1, aCod);
        aux = stE.executeQuery();
        ArrayList<Elemento> elems = new ArrayList<Elemento>();
        while (aux.next())
            elems.add(new Elemento(aux.getString(1), aux.getString(2), aux.getDate(3), aux.getString(4), aux.getString(5), aux.getString(6), aux.getString(7)));        
        
        //Questionario
        stQ = conn.prepareStatement(sqlQuest);
        stQ.setString(1, aCod);
        aux = stQ.executeQuery();
        ArrayList<Questao> quest = new ArrayList<Questao>();
        
        while (aux.next())
            quest.add(new Questao(aux.getString(4), aux.getString(5), aux.getString(1)));        

        stC = conn.prepareStatement(sqlCand);
        stC.setString(1, aCod);
        aux = stC.executeQuery();

        if (aux.next()) {
            String[] auxData = aux.getString(2).split("-");
            Date dA = new Date(Integer.parseInt(auxData[0]),
                    Integer.parseInt(auxData[1]), Integer.parseInt(auxData[2]));

            auxData = aux.getString(3).split("-");
            Date dC = new Date(Integer.parseInt(auxData[0]),
                    Integer.parseInt(auxData[1]), Integer.parseInt(auxData[2]));

            return new Candidatura(aux.getString(1), dA, dC, aux.getString(4),
                    aux.getString(5), aux.getString(6), quest, elems);
        }
        return null;

    }

    public void set(Candidatura aC) {
        throw new UnsupportedOperationException();
    }

    public void add(Candidatura aC) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        String sqlC;
        sqlC = "INSERT INTO `Habitat`.`Candidaturas` (`dataAbertura`, `dataDecisao`, `observacoes`, `estado`, `funcionario`,`familia`) VALUES (?, ?, ?, ?, ?,?);";
        st = conn.prepareStatement(sqlC);
        st.setString(1, aC.getDateAbertura());
        st.setString(2, aC.getDateDecisao());
        st.setString(3, aC.getObs());
        st.setString(4, aC.getEstado().toString());
        st.setString(5, aC.getFuncionario());
        st.setString(6, "1");       
        st.executeUpdate();       
        
    }
}
