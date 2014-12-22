package Class_Diagram_Habitat_Independent.BusinessLayer.Candidaturas;

import java.util.ArrayList;
import Class_Diagram_Habitat_Independent.BusinessLayer.Candidaturas.Questao;
import Class_Diagram_Habitat_Independent.BusinessLayer.Candidaturas.Elemento;

public class Candidatura {
	private String _cod;
	private String _obs;
	private String _estado;
	private Callendar _dataAbertura;
	private Callendar _dataDecisao;
	private float _rendimentoBruto;
	private String _rua;
	private String _localidade;
	private String _codPostal;
	private String _funcionario;
	private ArrayList<Questao> _questionario = new ArrayList<Questao>();
	private Elemento _candidato;
	private ArrayList<Elemento> _elementos = new ArrayList<Elemento>();

	public Candidatura() {
		throw new UnsupportedOperationException();
	}

	public void setCod() {
		throw new UnsupportedOperationException();
	}

	public void setObs() {
		throw new UnsupportedOperationException();
	}

	public void setEstado() {
		throw new UnsupportedOperationException();
	}

	public void setAbertura() {
		throw new UnsupportedOperationException();
	}

	public void setDecisao() {
		throw new UnsupportedOperationException();
	}

	public void setRendimento() {
		throw new UnsupportedOperationException();
	}

	public void setRua() {
		throw new UnsupportedOperationException();
	}

	public void setlocalidade() {
		throw new UnsupportedOperationException();
	}

	public void setCodPostal() {
		throw new UnsupportedOperationException();
	}

	public String getFuncionario() {
		return this._funcionario;
	}

	public void setFuncionario(String aFuncionario) {
		this._funcionario = aFuncionario;
	}
}