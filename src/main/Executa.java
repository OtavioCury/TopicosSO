package main;

import java.util.ArrayList;
import java.util.List;

import algoritmos.Elevador;
import algoritmos.FCFS;
import algoritmos.SSF;

public class Executa {
	public static void main(String[] args) {
		List<Integer> cilindros = new ArrayList<Integer>();
		List<Integer> cilindros2 = new ArrayList<Integer>();
		int quantCilindros = 199, primeiroCilindro = 53;

		cilindros.add(98);
		cilindros.add(183);
		cilindros.add(37);
		cilindros.add(122);
		cilindros.add(14);
		cilindros.add(124);
		cilindros.add(65);
		cilindros.add(67);

		FCFS fcfs = new FCFS(cilindros, quantCilindros, primeiroCilindro);
		fcfs.executa();

		SSF ssf = new SSF(cilindros, quantCilindros, primeiroCilindro);
		ssf.executa();

		cilindros2.add(98);
		cilindros2.add(183);
		cilindros2.add(37);
		cilindros2.add(122);
		cilindros2.add(14);
		cilindros2.add(124);
		cilindros2.add(65);
		cilindros2.add(67);

		Elevador elevador = new Elevador(cilindros2, quantCilindros, primeiroCilindro);
		elevador.executa();
	}
}
