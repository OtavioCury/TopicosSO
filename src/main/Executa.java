package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Processo;
import algoritmos.FCFS;
import algoritmos.MenorJob;
import algoritmos.RoundRobin;

public class Executa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Fila de processos 
		List<Processo> filaProcessosRR = new ArrayList<Processo>();
		List<Processo> filaProcessosFCFS = new ArrayList<Processo>();
		List<Processo>
		filaProcessosSJF = new ArrayList<Processo>();
		//Quantidade de processos
		int quantProcessos;

		Scanner quant = new Scanner(System.in);
		System.out.println("Digite a quantidade de processos");
		quantProcessos = quant.nextInt();


		//lê os dados dos processos
		for (int i = 0; i < quantProcessos; i++) {			
			int inicio, fim;

			Scanner chegada = new Scanner(System.in);
			System.out.println("Digite o tempo de chegada processo "+(i+1));
			inicio = chegada.nextInt();			

			Scanner termino = new Scanner(System.in);
			System.out.println("Digite o tempo de término processo "+(i+1));
			fim = termino.nextInt();


			Processo processo = new Processo(i, inicio, fim);
			Processo processo2 = new Processo(i, inicio, fim);
			Processo processo3 = new Processo(i, inicio, fim);

			filaProcessosRR.add(processo);
			filaProcessosFCFS.add(processo2);
			filaProcessosSJF.add(processo3);
		}



		RoundRobin roundRobin = new RoundRobin(filaProcessosRR);

		FCFS fcfs = new FCFS(filaProcessosFCFS);

		MenorJob menorJob = new MenorJob(filaProcessosSJF);

		roundRobin.executa();		

		fcfs.executa();

		menorJob.executa();

		quant.close();

	}

}
