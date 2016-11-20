package main;

import java.util.LinkedList;
import java.util.Queue;

import algoritmos.FIFO;
import modelo.Pagina;

public class Executa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Queue<Pagina> filaPagina = new LinkedList<Pagina>();
		int quantMolduras = 4;

		filaPagina.offer(new Pagina(1, 0));
		filaPagina.offer(new Pagina(2, 0));
		filaPagina.offer(new Pagina(3, 0));
		filaPagina.offer(new Pagina(4, 0));
		filaPagina.offer(new Pagina(1, 0));
		filaPagina.offer(new Pagina(2, 0));
		filaPagina.offer(new Pagina(5, 0));
		filaPagina.offer(new Pagina(1, 0));
		filaPagina.offer(new Pagina(2, 0));
		filaPagina.offer(new Pagina(3, 0));
		filaPagina.offer(new Pagina(4, 0));
		filaPagina.offer(new Pagina(5, 0));

		FIFO fifo = new FIFO(filaPagina, quantMolduras);

		fifo.executa();

	}

}
