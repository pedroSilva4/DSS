package com.habitat.BusinessLayer;

import com.habitat.BusinessLayer.Candidaturas.Candidatura;
import com.habitat.BusinessLayer.Candidaturas.Questao;
import com.habitat.BusinessLayer.Doadores.Doacao;
import com.habitat.BusinessLayer.Doadores.Doador;
import com.habitat.BusinessLayer.Eventos.Evento;
import com.habitat.BusinessLayer.Material.Material;
import com.habitat.BusinessLayer.Projetos.Projeto;
import com.habitat.BusinessLayer.Tarefas.Tarefa;
import com.habitat.BusinessLayer.Utilizadores.Utilizador;
import com.habitat.BusinessLayer.Voluntarios.Morada;
import com.habitat.BusinessLayer.Voluntarios.Voluntario;
import com.habitat.DataLayer.CandidaturaDAO;
import com.habitat.DataLayer.DoacoesDAO;
import com.habitat.DataLayer.DoadoresDAO;
import com.habitat.DataLayer.EventosDAO;
import com.habitat.DataLayer.MaterialDAO;
import com.habitat.DataLayer.ProjetosDAO;
import com.habitat.DataLayer.TarefasDAO;
import com.habitat.DataLayer.UtilizadorDAO;
import com.habitat.DataLayer.VoluntarioDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observable;

public class BusinessFacade extends Observable{

    public CandidaturaDAO _candidaturas;
    public EventosDAO _eventos;
    public DoadoresDAO _doadores;
    public DoacoesDAO _doacoes;
    public MaterialDAO _materiais;
    public UtilizadorDAO _utilizadores;
    public VoluntarioDAO _voluntarios;
    public ProjetosDAO _projetos;
    public TarefasDAO _tarefas;
    private Utilizador activeUser;
    private Connection conn;
    /*Constructor*/

    public BusinessFacade() throws SQLException {
        //Connection conn = null;
        conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/Habitat?"
                + "user=h_user&password=mypass");
        _candidaturas = new CandidaturaDAO(conn);
        _eventos = new EventosDAO(conn);
        _doadores = new DoadoresDAO(conn);
        _doacoes = new DoacoesDAO(conn);
        _materiais = new MaterialDAO(conn);
        _utilizadores = new UtilizadorDAO(conn);
        _voluntarios = new VoluntarioDAO(conn);
        _projetos = new ProjetosDAO(conn);
        _tarefas = new TarefasDAO(conn);
    }

    public Utilizador getActiveUser() {
        return this.activeUser;
    }
    
    public ArrayList<Voluntario> getListaVoluntario() throws SQLException{
        return this._voluntarios.getLista();
    }

    public ArrayList<Questao> getQuestoesActivas() throws SQLException{
        return this._candidaturas.getQuestoesActivas();
    }

    public Candidatura getCandidatura(String aCod) throws SQLException {
        return this._candidaturas.get(aCod);
    }

    public void setCandidatura(Candidatura aCand) throws SQLException {
        this._candidaturas.set(aCand);
    }

    public void addCandidatura(Candidatura aCand) throws SQLException {
        this._candidaturas.add(aCand);
    }

    public Evento getEvento(String aCod) throws SQLException {
        boolean b = this._eventos.contains(aCod);
        if (b == false) {
            return null;
        }
        Evento v = this._eventos.get(aCod);
        return v;
    }

    public void updateEvento(Evento aEvento) throws SQLException {
        this._eventos.update(aEvento);
    }

    public void addEvento(Date aData, float aMont, int aNpessoas, String aOrg, String aNota) throws SQLException {
        this._eventos.add(aData, aMont, aNpessoas, aOrg, aNota);
    }

    public Doador getDoador(String aCod) throws SQLException {
        Doador d;
        boolean b = this._doadores.contains(aCod);
        if (b == false) {
            return null;
        }
        d = this._doadores.get(aCod);
        return d;
    }

    public void addDoador(Doador aDoador) throws SQLException {
        this._doadores.add(aDoador);
    }

    public boolean updateDoador(Doador aDoador) throws SQLException {
        return this._doadores.update(aDoador);
    }
    
    public boolean associarDoacao(String codD, String codE) throws SQLException {
        boolean b = this._doacoes.contains(codD);
        if(b == false) return b;
        return this._doacoes.associarDoacao(codD, codE);
    }
    
    public ArrayList<Doacao> getListaDoacoes() throws SQLException{
        return this._doacoes.getLista();
    }

    public Doacao getDoacao(String aCod) throws SQLException {
        boolean b = this._doacoes.contains(aCod);
        if (b == false) {
            return null;
        }
        return this._doacoes.get(aCod);
    }

    public void addDoacao(String aDoador, Doacao aDoacao) throws SQLException {
        this._doacoes.add(aDoador, aDoacao);
    }

    public boolean containsDoador(String aCod) throws SQLException {
        return this._doacoes.contains(aCod);
    }
    
    public ArrayList<Material> getListaMaterial() throws SQLException{
        return this._materiais.getLista();
    }

     public Material getMaterial(String aCod) throws SQLException {
        return this._materiais.get(aCod);
    }

    public void addMaterial(String aDescricao, String aUnidade, int aQuantidade) throws SQLException {
        this._materiais.add(aDescricao, aUnidade, aQuantidade);
        this.setChanged();
        notifyObservers();
    }

    public void setMaterial(String aCod, String aDescricao, String aUnidade, int aQuantidade) throws SQLException {
        this._materiais.set(aCod, aDescricao, aUnidade, aQuantidade);
        this.setChanged();
        notifyObservers();
    }
    
    public void setMaterial(Material m) throws SQLException {
        this._materiais.set(m);
        this.setChanged();
        notifyObservers();
    }
    public Utilizador getUtilizador(String aUsername) throws SQLException {
        boolean b = this._utilizadores.contains(aUsername);
        if (b == false) {
            return null;
        }
        Utilizador ut = _utilizadores.get(aUsername);
        return ut;
    }

    public boolean addUtilizador(String aUsername, String aPassword, String aNome, String aNif, String tipo, String aRua, String aLocal, String aCod_postal) throws SQLException {
        Utilizador u = new Utilizador(aNome, aPassword, aUsername, aNif, tipo, aRua, aLocal, aCod_postal);
        return this._utilizadores.add(u);
    }

    public boolean rmvUtilizador(String aUsername) throws SQLException {
        return this._utilizadores.remove(aUsername);
    }

    public void updateUtilizador(Utilizador aUt) throws SQLException {
        this._utilizadores.update(aUt);
    }

    public String passwordEncript() {
        throw new UnsupportedOperationException();
    }

    public boolean addVoluntario(String nome, Date dataNasc, Date dataAssoc, String contacto, String equipa, String profissao, Morada m) throws SQLException {
        Voluntario vol = new Voluntario(null, nome, dataNasc, dataAssoc, contacto, equipa, profissao, m);
        boolean b = this._voluntarios.add(vol);
        this.setChanged();
        this.notifyObservers();
        return b;
    }

    public Voluntario getVoluntario(String aId) throws SQLException {
        boolean b = this._voluntarios.contains(aId);
        if (b == false) {
            return null;
        }
        Voluntario v = this._voluntarios.get(aId);
        return v;
    }

    public void updateVoluntario(Voluntario aVol) throws SQLException {
        this._voluntarios.update(aVol);
        this.setChanged();
        this.notifyObservers();
    }

    public boolean validaCandidatura(String aCandidatura) {
        throw new UnsupportedOperationException();
    }
    
    public void addProjeto(Projeto p) throws SQLException{
        this._projetos.add(p);
    }
    
    public boolean existeProjeto(String cod) throws SQLException{
        return this._projetos.existeProjeto(cod);
    }

    public void addTarefaProjeto(String aTarefa, String aProjeto, Date aDataI, Date aDataF) throws SQLException {
        this._projetos.addTarefa(aTarefa, aProjeto, aDataI, aDataF);
    }

    public Projeto getProjeto(String aProjeto) throws SQLException {
        return this._projetos.get(aProjeto);
    }

    public void updateProjeto(Projeto aProjeto) throws SQLException {
        this._projetos.update(aProjeto);
    }
    public boolean associaDoacaoProjeto(String codP,String codD) throws SQLException{
        boolean b = this._projetos.existeProjeto(codP);
        if(b == false) return false;
        this._doacoes.associaProjecto(codP,codD);
        return true;
    }

    public void addExeTarefaProjeto(String aTarefa, String aProjeto, String voluntario, Date aData, double aDuracao) throws SQLException {
        this._projetos.addExeTarefa(aTarefa, aProjeto, voluntario, aData, aDuracao);
    }

    public void addTarefa(Tarefa aTarefa) throws SQLException {
        this._tarefas.add(aTarefa);
    }
    
    public void addTarefa(String aTarefa) throws SQLException {
        this._tarefas.add(aTarefa);
    }

    public Tarefa getTarefa(String aCod) throws SQLException {
        return this._tarefas.get(aCod);
    }

    public void updateTarefa(Tarefa aTarefa) throws SQLException {
        this._tarefas.setTarefa(aTarefa);
    }

    public boolean login(String aUser, String aPasswd) {
        try {
            this.activeUser = _utilizadores.login(aUser, aPasswd);
            if (this.activeUser != null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     public ArrayList<String> getListaIdsEventos() throws SQLException{
         return _eventos.getListaIds();
     }
    public void logout() throws SQLException {
        this.conn.close();
    }
}
