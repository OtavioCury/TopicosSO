package algoritmos;

import java.util.ArrayList;
import java.util.List;

public class Elevador {
	private List<Integer> cilindros = new ArrayList<Integer>();
	private int quantCilindros;
	private int primeiroCilindro;


	public Elevador(List<Integer> cilindros, int quantCilindros, int primeiroCilindro) {		
		this.cilindros = cilindros;
		this.quantCilindros = quantCilindros;
		this.primeiroCilindro = primeiroCilindro;
	}

	public void executa(){

		int atual = primeiroCilindro;
		int soma = 0;
		int menor = quantCilindros + 1;

		List<Integer> acima = new ArrayList<Integer>();
		List<Integer> abaixo = new ArrayList<Integer>();

		for (Integer integer : cilindros) {
			if (integer < atual) {
				abaixo.add(integer);
			}else{
				acima.add(integer);
			}

			if (Math.abs(atual - integer) < menor) {
				menor = integer;
			}
		}		

		if (acima.contains(menor)) {

			while (!acima.isEmpty()) {

				int menorDistancia = quantCilindros + 1;
				int index = quantCilindros + 1;

				for (int i = 0; i < acima.size(); i++) {
					if ((Math.abs(atual - acima.get(i))) < menorDistancia) {
						menorDistancia = Math.abs(atual - acima.get(i));
						index = i;
					}
				}			

				soma = soma + menorDistancia;
				atual = acima.get(index);
				acima.remove(index);
			}

			while (!abaixo.isEmpty()) {

				int menorDistancia = quantCilindros + 1;
				int index = quantCilindros + 1;

				for (int i = 0; i < abaixo.size(); i++) {
					if ((Math.abs(atual - abaixo.get(i))) < menorDistancia) {
						menorDistancia = Math.abs(atual - abaixo.get(i));
						index = i;
					}
				}			

				soma = soma + menorDistancia;
				atual = abaixo.get(index);
				abaixo.remove(index);
			}		

		}else{

			while (!abaixo.isEmpty()) {

				int menorDistancia = quantCilindros + 1;
				int index = quantCilindros + 1;

				for (int i = 0; i < abaixo.size(); i++) {
					if ((Math.abs(atual - abaixo.get(i))) < menorDistancia) {
						menorDistancia = Math.abs(atual - abaixo.get(i));
						index = i;
					}
				}			

				soma = soma + menorDistancia;
				atual = abaixo.get(index);
				abaixo.remove(index);
			}		

			while (!acima.isEmpty()) {

				int menorDistancia = quantCilindros + 1;
				int index = quantCilindros + 1;

				for (int i = 0; i < acima.size(); i++) {
					if ((Math.abs(atual - acima.get(i))) < menorDistancia) {
						menorDistancia = Math.abs(atual - acima.get(i));
						index = i;
					}
				}			

				soma = soma + menorDistancia;
				atual = acima.get(index);
				acima.remove(index);
			}

		}		

		System.out.println("ELEVADOR "+soma);
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
