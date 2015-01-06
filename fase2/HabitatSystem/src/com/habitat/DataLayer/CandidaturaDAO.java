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
    
    public ArrayList<Questao> getQuestoesActivas() throws SQLException{
        Statement st;
        ResultSet res;
        String sql = "select * from Habitat.Perguntas where estado = activo;";
        st = conn.createStatement();
        res = st.executeQuery(sql);
        ArrayList<Questao> questionario = new ArrayList<Questao>();
        while(res.next()){
        //(String _cod, String _pergunta, String _resposta)
            Questao q = new Questao(res.getString("id"),res.getString("pergunta"),"");
            questionario.add(q);
        }
        return questionario;
    }

    public boolean contains(String aCod) throws SQLException {
        PreparedStatement st;
        ResultSet res;
        String sql;
        sql = "select id from Habitat.Candidatura where id = ?;";
        st = conn.prepareStatement(sql);
        st.setString(1, aCod);
        res = st.executeQuery();
        return res.next();
    }

    public Candidatura get(String aCod) throws SQLException {
        PreparedStatement stCand;
        PreparedStatement stFam;
        ResultSet resCand;
        ResultSet resFam;
        String sqlCand;
        String sqlFam;
        sqlCand = "select * from Habitat.Candidaturas where id = ?;";
        stCand = conn.prepareStatement(sqlCand);
        stCand.setString(1, aCod);
        resCand = stCand.executeQuery();
        if(resCand.next() == false) return null;
        sqlFam = "select * from Habitat.Familias where id = ?;";
        stFam = conn.prepareStatement(sqlFam);
        stFam.setString(1, resCand.getString("familia"));
        resFam = stFam.executeQuery();
        String[] parts = resCand.getString("dataAbertura").split("-");
        Date d1 = new Date(Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
        String[] parts2 = resCand.getString("dataDecisao").split("-");
        Date d2 = new Date(Integer.parseInt(parts2[1]),
                        Integer.parseInt(parts2[2]),Integer.parseInt(parts2[3]));
        Float f = new Float(resFam.getString("rendimentoBruto"));
        Candidatura c = new Candidatura(resCand.getString("id"),d1,d2,resCand.getString("observacoes"),
                        resCand.getString("estado"),resCand.getString("funcionario"),
                        null,null,f.floatValue(),resFam.getString("rua"),
                        resFam.getString("localidade"),resFam.getString("codPostal"),null,resFam.getString("contacto"));
        /*ir buscar as questoes*/
        ArrayList<Questao> qs = new ArrayList<Questao>();
        PreparedStatement stQ, stCQ;
        ResultSet resQ,resCQ;
        String sqlCQ = "select * from Habitat.CandidaturaPerguntas where id = ?;";
        String sqlQ = "select * from Habitat.Perguntas where id = ?;";
        stCQ = conn.prepareStatement(sqlCQ);
        resCQ = stCQ.executeQuery();
        while(resCQ.next()){
            //(String _cod, String _pergunta, String _resposta)
            Questao q = new Questao(resCQ.getString("pergunta"),"",resCQ.getString("resposta"));
            stQ = conn.prepareStatement(sqlQ);
            resQ = stQ.executeQuery();
            if(resQ.next()){
                q.setPergunta(resQ.getString("descricao"));
            }
            qs.add(q);
        }
        /*buscar candidato*/
        String sqlElems = "select * from elementos where id = ?";
        PreparedStatement stElems = conn.prepareStatement(sqlQ);
        stElems.setString(1, resFam.getString("responsavel"));
        ResultSet resC = stElems.executeQuery();
        if(resC.next()){
        String[] parts3 = resC.getString("dataNasc").split("-");
        Date d3 = new Date(Integer.parseInt(parts3[1]),
                        Integer.parseInt(parts3[2]),Integer.parseInt(parts3[3]));
            Elemento cand = new Elemento(resC.getString("id"),resC.getString("nome"),
                            d3,resC.getString("escolaridade"),resC.getString("estadoCivil"),
                            resC.getString("parentesco"),resC.getString("ocupacao"),
                            resC.getString("naturalidade"),resC.getString("nacionalidade"));
            c.setCandidato(cand);
        }
        /*buscar elementos*/
        sqlElems = "select * from elementos where familia = ?";
        stElems = conn.prepareStatement(sqlQ);
        stElems.setString(1, resFam.getString("id"));
        ArrayList<Elemento> el = new ArrayList<Elemento>();
        ResultSet resElems = stElems.executeQuery();
        while(resElems.next()){
            String[] parts4 = resElems.getString("dataNasc").split("-");
            Date d4 = new Date(Integer.parseInt(parts4[1]),
                        Integer.parseInt(parts4[2]),Integer.parseInt(parts4[3]));
            Elemento e = new Elemento(resElems.getString("id"),resElems.getString("nome"),
                            d4,resElems.getString("escolaridade"),resElems.getString("estadoCivil"),
                            resElems.getString("parentesco"),resElems.getString("ocupacao"),
                            resElems.getString("naturalidade"),resElems.getString("nacionalidade"));
            el.add(e);
        }
        c.setElementos(el);
        return c;
    }

    public void set(Candidatura aC) throws SQLException {
        PreparedStatement st;
        String sql;
        /*actualizar Familia*/
        sql = "update Habitat.Familias set"
                + "rendimento = ?,"
                + "rua = ?,"
                + "localidade = ?,"
                + "codPostal = ?,"
                + "contacto = ?,"
                + "responsavel = ?,"
                + "funcionario = ?"
                + "where id = ?";
        Float f = new Float(aC.getRendimentoBruto());
        st = conn.prepareStatement(sql);
        st.setString(1, f.toString());
        st.setString(2, aC.getRua());
        st.setString(3, aC.getLocalidade());
        st.setString(4, aC.getCodPostal());
        st.setString(5, aC.getContacto());
        st.setString(6, aC.getCandidato().getCod());
        st.setString(7, aC.getFuncionario());
        st.setString(8, aC.getCod());
        st.executeUpdate();
        /*actualizar candidatura*/
        sql = "update Habitat.Candidaturas set"
                + "dataAbertura = ?,"
                + "dataDecisao = ?,"
                + "observacoes = ?,"
                + "estado = ?,"
                + "funcionario = ?"
                + "where id = ?";
        st = conn.prepareStatement(sql);
        st.setString(1, aC.getDataAbertura().toString());
        st.setString(2, aC.getDataDecisao().toString());
        st.setString(3, aC.getObs());
        st.setString(4, aC.getEstado());
        st.setString(5, aC.getFuncionario());
        st.setString(6, aC.getCod());
        st.executeUpdate();
        /*actualizar perguntas*/
        sql = "update Habitat.CandidaturaPerguntas set"
                + "resposta = ?"
                + "where candidatura = ? and pergunta = ?;";
        st = conn.prepareStatement(sql);
        for(Questao q : aC.getQuestionario()){
            st.setString(1, q.getResposta());
            st.setString(2, aC.getCod());
            st.setString(3, q.getCod());
            st.executeUpdate();
        }
        /*actualizar candidato*/
        sql = "update Habitat.Elementos set"
                + "nome = ?,"
                + "dataNasc = ?,"
                + "escolaridade = ?,"
                + "estadoCivil = ?,"
                + "parentesco = ?,"
                + "ocupacao = ?,"
                + "naturalidade = ?,"
                + "nacionalidade = ?,"
                + "where familia = ?;";
        st = conn.prepareStatement(sql);
        st.setString(1, aC.getCandidato().getNome());
        st.setString(2, aC.getCandidato().getDataNasc().toString());
        st.setString(3, aC.getCandidato().getEscolaridade());
        st.setString(4, aC.getCandidato().getEstCivil());
        st.setString(5, aC.getCandidato().getParentesco());
        st.setString(6, aC.getCandidato().getOcupacao());
        st.setString(7, aC.getCandidato().getNaturalidade());
        st.setString(8, aC.getCandidato().getNacionalidade());
        st.setString(9, aC.getCod());
        st.executeUpdate();
        /*actualizar elementos*/
        for(Elemento e : aC.getElementos()){
            st.setString(1, e.getNome());
            st.setString(2, e.getDataNasc().toString());
            st.setString(3, e.getEscolaridade());
            st.setString(4, e.getEstCivil());
            st.setString(5, e.getParentesco());
            st.setString(6, e.getOcupacao());
            st.setString(7, e.getNaturalidade());
            st.setString(8, e.getNacionalidade());
            st.setString(9, aC.getCod());
            st.executeUpdate();
        }
    }

    public void add(Candidatura aC) throws SQLException {
        PreparedStatement st;
        ResultSet res;
        String sql;
        /*inserir familia*/
        sql = "insert into Habitat.Familias (rendimento,rua,localidade,codPostal,contacto,funcionario)"
                + "values(?,?,?,?,?,?)";
        st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        Float f = new Float(aC.getRendimentoBruto());
        st.setString(1, f.toString());
        st.setString(2, aC.getRua());
        st.setString(3, aC.getLocalidade());
        st.setString(4, aC.getCodPostal());
        st.setString(5, aC.getContacto());
        st.setString(6, aC.getFuncionario());
        st.executeUpdate();
        res = st.getGeneratedKeys();
        String codFamilia = res.getString(1);
        /*inserir candidato*/
        sql = "insert into Habitat.Elementos (nome,dataNasc,escolaridade,estadoCivil,parentesco,"
                + "ocupacao,naturalidade,nacionalidade,familia)"
                + "values(?,?,?,?,?,?,?,?,?)";
        st = conn.prepareStatement(sql);
        Elemento c = aC.getCandidato();
        st.setString(1, c.getNome());
        st.setString(2, c.getDataNasc().toString());
        st.setString(3, c.getEscolaridade());
        st.setString(4, c.getEstCivil());
        st.setString(5, c.getParentesco());
        st.setString(6, c.getOcupacao());
        st.setString(7, c.getNaturalidade());
        st.setString(8, c.getNacionalidade());
        st.setString(9, codFamilia);
        st.executeUpdate();
        /*associar responsavel a familia*/
        String codCandidato = null;
        res = st.getGeneratedKeys();
        if(res.next())
            codCandidato = res.getString(1);
        sql = "update Habitat.Familias set responsavel = ?"
                + "where id = ?";
        st = conn.prepareStatement(sql);
        st.setString(1, codCandidato);
        st.setString(2, codFamilia);
        st.executeUpdate();
        /*inserir elementos*/
        sql = "insert into Habitat.Elementos (nome,dataNasc,escolaridade,estadoCivil,parentesco,"
                + "ocupacao,naturalidade,nacionalidade,familia)"
                + "values(?,?,?,?,?,?,?,?,?)";
        st = conn.prepareStatement(sql);
        for(Elemento e : aC.getElementos()){
            st.setString(1, e.getNome());
            st.setString(2, e.getDataNasc().toString());
            st.setString(3, e.getEscolaridade());
            st.setString(4, e.getEstCivil());
            st.setString(5, e.getParentesco());
            st.setString(6, e.getOcupacao());
            st.setString(7, e.getNaturalidade());
            st.setString(8, e.getNacionalidade());
            st.setString(9, codFamilia);
            st.executeUpdate();
        }
        /*inserir candidatura*/
        sql = "insert into Habitat.Candidaturas (dataAbertura,dataDecisao,"
                + "observacoes,estado,funcionario)"
                + "values(?,?,?,?,?);";
        st.setString(1, aC.getDataAbertura().toString());
        st.setString(2, aC.getDataDecisao().toString());
        st.setString(3, aC.getObs());
        st.setString(4, aC.getEstado());
        st.setString(5, aC.getFuncionario());
        st.executeUpdate();
        /*inserir respostas*/
        res = st.getGeneratedKeys();
        String codCandidatura = res.getString(1);
        sql = "insert into Habitat.CandidaturaPerguntas(resposta,candidatura,pergunta)"
                + "values(?,?,?);";
        st = conn.prepareStatement(sql);
        for(Questao q : aC.getQuestionario()){
            st.setString(1, q.getResposta());
            st.setString(2, codCandidatura);
            st.setString(3, q.getCod());
            st.executeUpdate();       
        }   
    }
}
