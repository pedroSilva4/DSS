package Class_Diagram_Habitat_Independent.BusinessLayer.Eventos;

public class Evento {
	private String _cod;
	private GregorianCalendar _data;
	private float _angariacao;
	private int _npessoas;
	private String _organizador;
	private String _nota;

	public void Evento() {
		throw new UnsupportedOperationException();
	}

	public void setCod(String aCod) {
		this._cod = aCod;
	}

	public void setAngariacao(float aAnga) {
		this._angariacao = aAnga;
	}

	public void setData(GregorianCalendar aDate) {
		this._data = aDate;
	}

	public void setNPessoas(int aN) {
		throw new UnsupportedOperationException();
	}

	public void setOrganisador(String aOrg) {
		throw new UnsupportedOperationException();
	}

	public void setNota(String aNota) {
		this._nota = aNota;
	}

	public String getCod() {
		return this._cod;
	}

	public float getAngariacao() {
		return this._angariacao;
	}

	public GregorianCalendar getData() {
		return this._data;
	}

	public int getNPessoas() {
		throw new UnsupportedOperationException();
	}

	public String getorganisador() {
		throw new UnsupportedOperationException();
	}

	public String getNota() {
		return this._nota;
	}
}