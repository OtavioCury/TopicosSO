package modelo;

public class Pagina {
	
	private int id;
	private int proximaReferencia;	
	
	public Pagina(int id, int proximaReferencia){
		this.id = id;
		this.proximaReferencia = proximaReferencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProximaReferencia() {
		return proximaReferencia;
	}

	public void setProximaReferencia(int proximaReferencia) {
		this.proximaReferencia = proximaReferencia;
	}
		
}
