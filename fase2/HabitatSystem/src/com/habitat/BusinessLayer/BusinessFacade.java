package com.habitat.BusinessLayer;


import com.habitat.BusinessLayer.Candidaturas.Candidatura;
import com.habitat.BusinessLayer.Doadores.Doacao;
import com.habitat.BusinessLayer.Doadores.Doador;
import com.habitat.BusinessLayer.Eventos.Evento;
import com.habitat.BusinessLayer.Material.Material;
import com.habitat.BusinessLayer.Projetos.Projeto;
import com.habitat.BusinessLayer.Tarefas.Tarefa;
import com.habitat.BusinessLayer.Utilizadores.Utilizador;
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
import java.util.GregorianCalendar;

public class BusinessFacade {
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
        /*Constructor*/
        public BusinessFacade() throws SQLException{
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Habitat?" +
                                           "user=h_user&password=mypass");
           /* _candidaturas = new CandidaturaDAO(conn);
            _eventos = new EventosDAO(conn);
            _doadores = new DoadoresDAO(conn);
            _doacoes = new DoacoesDAO(conn);
            _materiais = new MaterialDAO(conn);*/
            _utilizadores = new UtilizadorDAO(conn);
           /* _voluntarios = new VoluntarioDAO(conn);
            _projetos = new ProjetosDAO(conn);
            _tarefas = new TarefasDAO(conn);*/
        }
        
        public Utilizador getActiveUser(){
            return this.activeUser;
        }
        
	public Candidatura getCandidatura(String aCod) {
		throw new UnsupportedOperationException();
	}

	public void setCandidatura(Candidatura aCand) {
		throw new UnsupportedOperationException();
	}

	public void addCandidatura(Candidatura aCand) {
		throw new UnsupportedOperationException();
	}

	public Evento getEvento(String aCod) {
		throw new UnsupportedOperationException();
	}

	public boolean updateEvento(Evento aEvento) {
		throw new UnsupportedOperationException();
	}

	public boolean addEvento(Date aData, float aMont, int aNpessoas, String aOrg, String aNota) {
		throw new UnsupportedOperationException();
	}

	public Doador getDoador(String aCod) {
		throw new UnsupportedOperationException();
	}

	public boolean addDoador(String aNome, String aNif, String aMorada, Date aData, String aSetor, String aSite, String aPescontac) {
		throw new UnsupportedOperationException();
	}

	public boolean updateDoador(Doador aDoador) {
		throw new UnsupportedOperationException();
	}

	public Doacao getDoacao(String aCod) {
		throw new UnsupportedOperationException();
	}

	public boolean addDoacao(String aDoador, String aTipo, int aMont) {
		throw new UnsupportedOperationException();
	}

	public void containsDoador(String aCod) {
		throw new UnsupportedOperationException();
	}

	public void removeMaterial(String aCod) {
		throw new UnsupportedOperationException();
	}

	public Material getMaterial(String aCod) {
		throw new UnsupportedOperationException();
	}

	public void addMaterial(String aDescricao, String aUnidade, int aQuantidade) {
		throw new UnsupportedOperationException();
	}

	public void setMaterial(String aCod, String aDescricao, String aUnidade, int aQuantidade) {
		throw new UnsupportedOperationException();
	}

	public Utilizador getUtilizador(String aUsername) {
		//this._utilizadores.get(aUsername)
	}

	public boolean addUtilizador(String aUsername, String aPassword, String aNome, String aNif, String email, String tipo ,String aRua, String aLocal, String aCod_postal) {
		throw new UnsupportedOperationException();
	}

	public boolean rmvUtilizador(String aUsername) {
		throw new UnsupportedOperationException();
	}

	public void updateUtilizador(Utilizador aUt) {
		throw new UnsupportedOperationException();
	}

	public String passwordEncript() {
		throw new UnsupportedOperationException();
	}

	public boolean addVoluntario(String aNome, String aRua, String aLocal, String aCod_postal, String aProfissao, String aContacto) {
		throw new UnsupportedOperationException();
	}

	public Voluntario getVoluntario(String aId) {
		throw new UnsupportedOperationException();
	}

	public void updateVoluntario(Voluntario aVol) {
		throw new UnsupportedOperationException();
	}

	public boolean validaCandidatura(String aCandidatura) {
		throw new UnsupportedOperationException();
	}

	public void addTarefaProjeto(String aTarefa, String aProjeto, Date aDataI, Date aDataF, double aTempo) {
		throw new UnsupportedOperationException();
	}

	public Projeto getProjeto(String aProjeto) {
		throw new UnsupportedOperationException();
	}

	public void updateProjeto(Projeto aProjeto) {
		throw new UnsupportedOperationException();
	}

	public void addExeTarefaProjeto(String aTarefa, String aProjeto, Date aData, double aDuracao) {
		throw new UnsupportedOperationException();
	}

	public void addtarefa(Tarefa aTarefa) {
		throw new UnsupportedOperationException();
	}

	public Tarefa getTarefa(String aDescricao) {
		throw new UnsupportedOperationException();
	}

	public void updateTarefa(Tarefa aTarefa) {
		throw new UnsupportedOperationException();
	}

	public boolean login(String aUser, String aPasswd) {
            try{
                this.activeUser = _utilizadores.login(aUser, aPasswd);
		if(this.activeUser!=null) return true;
                else return false;
            }catch(SQLException e){
                e.printStackTrace();
                return false;}
	}

	public void logout() {
		throw new UnsupportedOperationException();
	}
}