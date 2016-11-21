package main;

import java.util.LinkedList;
import java.util.Queue;

import algoritmos.FIFO;
import algoritmos.OTM;
import modelo.Pagina;

public class Executa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Queue<Pagina> filaPaginaFifo = new LinkedList<Pagina>();
		Queue<Pagina> filaPaginaOtm = new LinkedList<Pagina>();
		int quantMolduras = 4;

		filaPaginaFifo.offer(new Pagina(1, 0));
		filaPaginaFifo.offer(new Pagina(2, 0));
		filaPaginaFifo.offer(new Pagina(3, 0));
		filaPaginaFifo.offer(new Pagina(4, 0));
		filaPaginaFifo.offer(new Pagina(1, 0));
		filaPaginaFifo.offer(new Pagina(2, 0));
		filaPaginaFifo.offer(new Pagina(5, 0));
		filaPaginaFifo.offer(new Pagina(1, 0));
		filaPaginaFifo.offer(new Pagina(2, 0));
		filaPaginaFifo.offer(new Pagina(3, 0));
		filaPaginaFifo.offer(new Pagina(4, 0));
		filaPaginaFifo.offer(new Pagina(5, 0));

		FIFO fifo = new FIFO(filaPaginaFifo, quantMolduras);

		fifo.executa();

		filaPaginaOtm.offer(new Pagina(1, 0));
		filaPaginaOtm.offer(new Pagina(2, 0));
		filaPaginaOtm.offer(new Pagina(3, 0));
		filaPaginaOtm.offer(new Pagina(4, 0));
		filaPaginaOtm.offer(new Pagina(1, 0));
		filaPaginaOtm.offer(new Pagina(2, 0));
		filaPaginaOtm.offer(new Pagina(5, 0));
		filaPaginaOtm.offer(new Pagina(1, 0));
		filaPaginaOtm.offer(new Pagina(2, 0));
		filaPaginaOtm.offer(new Pagina(3, 0));
		filaPaginaOtm.offer(new Pagina(4, 0));
		filaPaginaOtm.offer(new Pagina(5, 0));

		OTM otm = new OTM(filaPaginaOtm, quantMolduras);
		otm.executa();

	}

}
