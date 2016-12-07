package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import algoritmos.FIFO;
import algoritmos.LRU;
import algoritmos.OTM;
import modelo.Pagina;

public class Executa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Queue<Pagina> filaPaginaFifo = new LinkedList<Pagina>();
		Queue<Pagina> filaPaginaOtm = new LinkedList<Pagina>();
		Queue<Pagina> filaPaginaLRU = new LinkedList<Pagina>();

		int quantMolduras = 0, i = 0;

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		String x = null;

		try {
			while( (x = f.readLine()) != null )
			{				
				Integer numero = Integer.parseInt(x.trim());
				if (i == 0) {
					quantMolduras = numero;
					i++;
				}else{
					filaPaginaFifo.offer(new Pagina(numero, 0));
					filaPaginaLRU.offer(new Pagina(numero, 0));
					filaPaginaOtm.offer(new Pagina(numero, 0));
					i++;
				}	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				

		FIFO fifo = new FIFO(filaPaginaFifo, quantMolduras);
		fifo.executa();

		OTM otm = new OTM(filaPaginaOtm, quantMolduras);
		otm.executa();

		LRU lru = new LRU(filaPaginaLRU, quantMolduras); 
		lru.executa();
	}

}
