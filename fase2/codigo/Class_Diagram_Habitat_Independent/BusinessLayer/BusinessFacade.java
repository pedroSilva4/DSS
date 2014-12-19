package Class_Diagram_Habitat_Independent.BusinessLayer;

import Class_Diagram_Habitat_Independent.DataLayer.CandidaturaDAO;
import Class_Diagram_Habitat_Independent.DataLayer.EventosDAO;
import Class_Diagram_Habitat_Independent.DataLayer.DoadoresDAO;
import Class_Diagram_Habitat_Independent.DataLayer.DoacoesDAO;
import Class_Diagram_Habitat_Independent.DataLayer.MaterialDAO;
import Class_Diagram_Habitat_Independent.DataLayer.UtilizadorDAO;
import Class_Diagram_Habitat_Independent.DataLayer.VoluntarioDAO;
import Class_Diagram_Habitat_Independent.DataLayer.ProjetosDAO;
import Class_Diagram_Habitat_Independent.DataLayer.TarefasDAO;
import Class_Diagram_Habitat_Independent.BusinessLayer.Candidaturas.Candidatura;
import Class_Diagram_Habitat_Independent.BusinessLayer.Eventos.Evento;
import Class_Diagram_Habitat_Independent.BusinessLayer.Doadores.Doador;
import Class_Diagram_Habitat_Independent.BusinessLayer.Doadores.Doacao;
import Class_Diagram_Habitat_Independent.BusinessLayer.Material.Material;
import Class_Diagram_Habitat_Independent.BusinessLayer.Utilizadores.Utilizador;
import Class_Diagram_Habitat_Independent.BusinessLayer.Voluntarios.Voluntario;
import Class_Diagram_Habitat_Independent.BusinessLayer.Projetos.Projeto;
import Modelo_de_Dominio.Tarefa;

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

	public Candidatura getCandidatura(String aCod) {
		throw new UnsupportedOperationException();
	}

	public void setCandidatura(Object aCandidatura) {
		throw new UnsupportedOperationException();
	}

	public void addCandidatura(Object aCandidatura) {
		throw new UnsupportedOperationException();
	}

	public Evento getEvento(String aCod) {
		throw new UnsupportedOperationException();
	}

	public boolean updateEvento(Evento aEvento) {
		throw new UnsupportedOperationException();
	}

	public boolean addEvento(GregorianCalendar aData, float aMont, int aNpessoas, String aOrg, String aNota) {
		throw new UnsupportedOperationException();
	}

	public Doador getDoador(String aCod) {
		throw new UnsupportedOperationException();
	}

	public boolean addDoador(String aNome, String aNif, String aMorada, GregorianCalendar aData, String aSetor, String aSite, String aPescontac) {
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
		throw new UnsupportedOperationException();
	}

	public boolean addUtilizador(String aUsername, String aPassword, String aNome, String aNif, String aRua, String aLocal, String aCod_postal) {
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

	public boolean addVolunt‡rio(String aNome, String aRua, String aLocal, String aCod_postal, String aProfissao, String aContacto) {
		throw new UnsupportedOperationException();
	}

	public Voluntario getVolunt‡rio(Object aId) {
		throw new UnsupportedOperationException();
	}

	public void updateVoluntario(Voluntario aVol) {
		throw new UnsupportedOperationException();
	}

	public boolean validaCandidatura(String aCandidatura) {
		throw new UnsupportedOperationException();
	}

	public void addTarefaProjeto(String aTarefa, String aProjeto, Dare aDataI, Date aDataF, double aTempo) {
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
		throw new UnsupportedOperationException();
	}

	public void logout() {
		throw new UnsupportedOperationException();
	}
}