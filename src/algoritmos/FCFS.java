package algoritmos;

import java.util.ArrayList;
import java.util.List;

public class FCFS {
	private List<Integer> cilindros = new ArrayList<Integer>();
	private int quantCilindros;
	private int primeiroCilindro;

	public FCFS(List<Integer> cilindros, int quantCilindros, int primeiroCilindro) {
		super();
		this.cilindros = cilindros;
		this.quantCilindros = quantCilindros;
		this.primeiroCilindro = primeiroCilindro;
	}

	public void executa(){
		int atual = primeiroCilindro;
		int soma = 0;
		for (Integer integer : cilindros) { 
			soma = soma + Math.abs(atual - integer);
			atual = integer;
		}
		System.out.println("FCFS "+soma);
	}

	public List<Integer> getCilindros() {
		return cilindros;
	}

	public void setCilindros(List<Integer> cilindros) {
		this.cilindros = cilindros;
	}

	public int getQuantCilindros() {
		return quantCilindros;
	}

	public void setQuantCilindros(int quantCilindros) {
		this.quantCilindros = quantCilindros;
	}

	public int getPrimeiroCilindro() {
		return primeiroCilindro;
	}

	public void setPrimeiroCilindro(int primeiroCilindro) {
		this.primeiroCilindro = primeiroCilindro;
	}

}
