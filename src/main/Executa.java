package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import algoritmos.FCFS;
import algoritmos.SSF;
import algoritmos.Elevador;

public class Executa {
	public static void main(String[] args) {
		List<Integer> cilindros = new ArrayList<Integer>();
		List<Integer> cilindros2 = new ArrayList<Integer>();
		int quantCilindros = 0, primeiroCilindro = 0, i = 0;

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		String x = null;

		try {
			while( (x = f.readLine()) != null )
			{				
				Integer numero = Integer.parseInt(x.trim());
				if (i == 0) {
					quantCilindros = numero;
					i++;
				}else if (i == 1) {
					primeiroCilindro = numero;
					i++;
				}else{
					cilindros.add(numero);
					cilindros2.add(numero);
					i++;
				}	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FCFS fcfs = new FCFS(cilindros, quantCilindros, primeiroCilindro);
		fcfs.executa();

		SSF ssf = new SSF(cilindros, quantCilindros, primeiroCilindro);
		ssf.executa();

		Elevador elevador = new Elevador(cilindros2, quantCilindros, primeiroCilindro);
		elevador.executa();
	}
}
