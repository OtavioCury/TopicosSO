package algoritmos;

import java.util.LinkedList;
import java.util.Queue;

import modelo.Pagina;

public class FIFO {

	private Queue<Pagina> filaPaginasOriginal;
	private Queue<Pagina> filaPaginas;
	private int quantMolduras;
	private int faltaPaginas;

	public FIFO(Queue<Pagina> filaPaginasOriginal, int quantMolduras) {
		super();
		this.filaPaginasOriginal = filaPaginasOriginal;
		this.quantMolduras = quantMolduras;
		faltaPaginas = 0;
	}


	public void executa() {
		// TODO Auto-generated method stub
		filaPaginas = new LinkedList<Pagina>();

		for (int i = 0; i < quantMolduras; i++) {
			faltaPaginas++;
			filaPaginas.offer(filaPaginasOriginal.peek());
			filaPaginasOriginal.poll();
		}

		while (!filaPaginasOriginal.isEmpty()) {
			boolean presente = false;

			for (Pagina pagina : filaPaginas) {
				if (pagina.getId() == filaPaginasOriginal.peek().getId()) {
					presente = true;
				}
			}

			if (presente == false) {
				faltaPaginas++;
				filaPaginas.poll();
				filaPaginas.offer(filaPaginasOriginal.peek());
				filaPaginasOriginal.poll();
			}else{
				filaPaginasOriginal.poll();
			}
		}

		System.out.println("FIFO "+faltaPaginas);


	}

	public Queue<Pagina> getFilaPaginas() {
		return filaPaginas;
	}


	public void setFilaPaginas(Queue<Pagina> filaPaginas) {
		this.filaPaginas = filaPaginas;
	}


	public int getQuantMolduras() {
		return quantMolduras;
	}

	public void setQuantMolduras(int quantMolduras) {
		this.quantMolduras = quantMolduras;
	}


	public Queue<Pagina> getFilaPaginasOriginal() {
		return filaPaginasOriginal;
	}


	public void setFilaPaginasOriginal(Queue<Pagina> filaPaginasOriginal) {
		this.filaPaginasOriginal = filaPaginasOriginal;
	}


	public int getFaltaPaginas() {
		return faltaPaginas;
	}

	public void setFaltaPaginas(int faltaPaginas) {
		this.faltaPaginas = faltaPaginas;
	}		

}
