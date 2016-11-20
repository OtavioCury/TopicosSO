package modelo;

public class Processo {

	private int id;
	private int inicio;
	private int duracao;
	private int tempoExecutado;
	private int tempoResposta;
	private int tempoRetorno;
	private int tempoEspera;

	public Processo(int id, int inicio, int duracao){
		this.id = id;
		this.inicio = inicio;
		this.duracao = duracao;
		setTempoExecutado(0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getTempoExecutado() {
		return tempoExecutado;
	}

	public void setTempoExecutado(int tempoExecutado) {
		this.tempoExecutado = tempoExecutado;
	}

	public int getTempoResposta() {
		return tempoResposta;
	}

	public void setTempoResposta(int tempoResposta) {
		this.tempoResposta = tempoResposta;
	}

	public int getTempoRetorno() {
		return tempoRetorno;
	}

	public void setTempoRetorno(int tempoRetorno) {
		this.tempoRetorno = tempoRetorno;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}			

}
