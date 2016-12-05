package algoritmos;

import java.util.ArrayList;
import java.util.List;

public class SSF {
	private List<Integer> cilindros = new ArrayList<Integer>();
	private int quantCilindros;
	private int primeiroCilindro;


	public SSF(List<Integer> cilindros, int quantCilindros, int primeiroCilindro) {
		super();
		this.cilindros = cilindros;
		this.quantCilindros = quantCilindros;
		this.primeiroCilindro = primeiroCilindro;
	}

	public void executa(){
		int atual = primeiroCilindro;
		int soma = 0;

		while (!cilindros.isEmpty()) {
			int menorDistancia = quantCilindros + 1;
			int index = quantCilindros + 1;

			for (int i = 0; i < cilindros.size(); i++) {
				if ((Math.abs(atual - cilindros.get(i))) < menorDistancia) {
					menorDistancia = Math.abs(atual - cilindros.get(i));
					index = i;
				}
			}			
			
			soma = soma + menorDistancia;
			atual = cilindros.get(index);
			cilindros.remove(index);
		}

		System.out.println("SSF "+soma);
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
