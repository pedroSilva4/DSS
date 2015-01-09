package com.habitat.BusinessLayer;

import com.habitat.BusinessLayer.Candidaturas.Candidatura;
import com.habitat.BusinessLayer.Candidaturas.Questao;
import com.habitat.BusinessLayer.Doadores.Doacao;
import com.habitat.BusinessLayer.Doadores.Doador;
import com.habitat.BusinessLayer.Eventos.Evento;
import com.habitat.BusinessLayer.Material.Material;
import com.habitat.BusinessLayer.Projetos.Projeto;
import com.habitat.BusinessLayer.Projetos.ProjetoTarefas;
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
import java.util.HashMap;
import java.util.Observable;

public class BusinessFacade extends Observable{

    private final CandidaturaDAO _candidaturas;
    private final EventosDAO _eventos;
    private final DoadoresDAO _doadores;
    private final DoacoesDAO _doacoes;
    private final MaterialDAO _materiais;
    private final UtilizadorDAO _utilizadores;
    private final VoluntarioDAO _voluntarios;
    private final ProjetosDAO _projetos;
    private final TarefasDAO _tarefas;
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
    public ArrayList<Questao> getQuestoes() throws SQLException{
        return this._candidaturas.getQuestoes();
    }
    public void addQuestao(Questao q) throws SQLException{
        this._candidaturas.addPergunta(q);
        setChanged();
        notifyObservers();
    }
    
    public ArrayList<String> getIdCandidaturasSemProjecto() throws SQLException{
        return this._candidaturas.getAprovadasSemProjecto();
    }
    public ArrayList<Candidatura> getListaCandidaturas() throws SQLException{
        return this._candidaturas.getLista();
    }
    public Candidatura getCandidatura(String aCod) throws SQLException {
        return this._candidaturas.get(aCod);
    }

    public void setCandidatura(Candidatura aCand) throws SQLException {
        this._candidaturas.set(aCand);
    }

    public void addCandidatura(Candidatura aCand) throws SQLException {
        this._candidaturas.add(aCand);
        this.setChanged();
        this.notifyObservers();
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
        this.setChanged();
        this.notifyObservers();
    }

    public void addEvento(Date aData, float aMont, int aNpessoas, String aOrg, String aNota) throws SQLException {
        this._eventos.add(aData, aMont, aNpessoas, aOrg, aNota);
        this.setChanged();
        this.notifyObservers();
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
        this.setChanged();
        this.notifyObservers();
    }

    public boolean updateDoador(Doador aDoador) throws SQLException {
        boolean b = this._doadores.update(aDoador);
        this.setChanged();
        this.notifyObservers();
        return b;
    }
    
    public boolean associarDoacao(String codD, String codE) throws SQLException {
        boolean b = this._doacoes.contains(codD);
        if(b == false) return b;
        return this._doacoes.associarDoacao(codD, codE);
    }
    
    public ArrayList<Doacao> getListaDoacoes(String cDoador,String cProjecto,
                                                String cEvento) throws SQLException{
      // HashMap<String,Doacao> res = new HashMap<String,Doacao>();
        return this._doacoes.getLista(cProjecto, cEvento, cDoador);
       /** HashMap<String,Doacao> doador = this._doacoes.getPorDoador(cDoador);
        HashMap<String,Doacao> projecto = this._doacoes.getPorProjecto(cProjecto);
        HashMap<String,Doacao> evento = this._doacoes.getPorEvento(cEvento);
        if(cDoador != null){
            if(cProjecto == null && cEvento == null)
                return doador;
            
            if(cProjecto != null && cEvento == null){
                for(String s : doador.keySet()){
                    if(projecto.containsKey(s)){
                        res.put(s, doador.get(s));
                    }     
                }
                return res;
            }
            if(cProjecto == null && cEvento != null){
                for(String s : doador.keySet()){
                    if(evento.containsKey(s)){
                        res.put(s, doador.get(s));
                    }     
                }
                return res;
            }
            for(String s : doador.keySet()){
                if(projecto.containsKey(s) && evento.containsKey(s)){
                    res.put(s, doador.get(s));
                } 
                return res;
            }
        }
        if(cProjecto != null && cEvento == null)
            return projecto;
        if(cProjecto != null && cEvento != null)
            for(String s : projecto.keySet()){
                if(evento.containsKey(s))
                    res.put(s, projecto.get(s));
            }
        if(cEvento != null)
            return evento;
        **/
        //return res;
    }

    public Doacao getDoacao(String aCod) throws SQLException {
        boolean b = this._doacoes.contains(aCod);
        if (b == false) {
            return null;
        }
        return this._doacoes.get(aCod);
    }

    public String addDoacao(String aDoador, Doacao aDoacao) throws SQLException {
        return this._doacoes.add(aDoador, aDoacao);
    }

    public boolean containsDoador(String aCod) throws SQLException {
        return this._doacoes.contains(aCod);
    }
    
    public ArrayList<Material> getListaMaterial() throws SQLException{
        return this._materiais.getLista();
    }
    public HashMap<String,Material> getMapMaterial() throws SQLException{
        return this._materiais.getMap();
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
        this.setChanged();
        notifyObservers();
    }
    
    public boolean existeProjeto(String cod) throws SQLException{
        return this._projetos.existeProjeto(cod);
    }

    public void addTarefaProjeto(String aTarefa, String aProjeto, Date aDataI, Date aDataF) throws SQLException {
        this._projetos.addTarefa(aTarefa, aProjeto, aDataI, aDataF);
        setChanged();
        notifyObservers();
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
        setChanged();
        notifyObservers();
    }

    public void addTarefa(Tarefa aTarefa) throws SQLException {
        this._tarefas.add(aTarefa);
        setChanged();
        notifyObservers();
    }
    

    public Tarefa getTarefa(String aCod) throws SQLException {
        return this._tarefas.get(aCod);
    }

    public void updateTarefa(Tarefa aTarefa) throws SQLException {
        this._tarefas.setTarefa(aTarefa);
    }
    public ArrayList<Tarefa> getTarefasAssociadas(String codProj) throws SQLException{
        return this._tarefas.getTarefasAssociadas(codProj);
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
    
     public HashMap<String,String> getListaIdDoadores() throws SQLException{
         return this._doadores.getListaIdDoadores();
     }
     
     public ArrayList<Doador> getListaDoadores() throws SQLException{
         return this._doadores.getListaDoadores();
     }
     
     public ArrayList<String> getListaIdProjectos() throws SQLException{
         return this._projetos.getListaIdProjectos();
     }
     
     public ArrayList<Evento> getListaEventos() throws SQLException{
         return this._eventos.getListaEventos();
     }
     public ArrayList<Tarefa> getListaTarefas() throws SQLException{
         return this._tarefas.getTarefas();
     }
     public HashMap<String,ProjetoTarefas> getListaProjetoTarefa(String codProj) throws SQLException{
         return this._tarefas.getProjetoTarefa(codProj);
     }
     public ArrayList<Voluntario> getListaVolProjTar(String cProj, String cTar) throws SQLException{
         return this._voluntarios.getListaVolProjTar(cProj, cTar);
     }
     
     public Date getDataParticipacao(String cTar, String cProj, String cVol) throws SQLException{
         return this._voluntarios.getDataParticipacao(cTar, cProj, cVol);
     }
     public String getDuracaoParticipacao(String cTar, String cProj, String cVol) throws SQLException{
         return this._voluntarios.getDuracaoParticipacao(cTar, cProj, cVol);
     }
     
     public void associaMaterialProjecto(String cMat, String cProj,int quant) throws SQLException{
         this._projetos.associaMaterial(cMat, cProj, quant);
         setChanged();
         notifyObservers();
     }
     
     public void setProjectoTarefa(Date dataFim, String cProjecto, String cTarefa) throws SQLException{
         this._tarefas.setProjectoTarefa(dataFim, cProjecto, cTarefa);
     }
     public void addParticipacaoTarefa(String cVol, String cTar, String cProj, 
             Date dataR, int dHoras) throws SQLException{
         this._voluntarios.addParticipacao(cVol, cTar, cProj, dataR, dHoras);
         setChanged();
         notifyObservers();
     }
     
     public void updateQuestao(Questao q) throws SQLException{
         this._candidaturas.updatePergunta(q);
         this.setChanged();
         this.notifyObservers();
     }
}
