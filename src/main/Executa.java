package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import algoritmos.FCFS;
import algoritmos.MenorJob;
import algoritmos.RoundRobin;
import modelo.Processo;

public class Executa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Fila de processos 
		List<Processo> filaProcessosRR = new ArrayList<Processo>();
		List<Processo> filaProcessosFCFS = new ArrayList<Processo>();
		List<Processo> filaProcessosSJF = new ArrayList<Processo>();		
		int id = 0;

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		String x = null;

		try {
			while( (x = f.readLine()) != null )
			{

				String[] numerosString = x.split(" ");
				List<Integer> numeros = new ArrayList<Integer>();				
				
				for (int i = 0; i < numerosString.length; i++) {
					if (!numerosString[i].equals("")) {
						numeros.add(Integer.parseInt(numerosString[i]));
					}
				}				

				Processo processo = new Processo(id, numeros.get(0), numeros.get(1));
				Processo processo2 = new Processo(id, numeros.get(0), numeros.get(1));
				Processo processo3 = new Processo(id, numeros.get(0), numeros.get(1));

				filaProcessosRR.add(processo);
				filaProcessosFCFS.add(processo2);
				filaProcessosSJF.add(processo3);

				id++;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RoundRobin roundRobin = new RoundRobin(filaProcessosRR);

		FCFS fcfs = new FCFS(filaProcessosFCFS);

		MenorJob menorJob = new MenorJob(filaProcessosSJF);

		fcfs.executa();

		menorJob.executa();

		roundRobin.executa();				

	}

}
