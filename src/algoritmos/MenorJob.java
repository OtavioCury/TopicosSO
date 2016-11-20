package algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import modelo.Processo;

public class MenorJob {
	private List<Processo> listaProcessos;
	private Queue<Processo> filaExecucao;
	private int tempoGlobal;

	public MenorJob(List<Processo> listaProcessos){
		this.listaProcessos = listaProcessos;
		filaExecucao = new LinkedList<Processo>();
		this.tempoGlobal = 0;
	}

	public void executa(){

		adicionaNaFila();

		while (filaExecucao.isEmpty()) {
			tempoGlobal = tempoGlobal + 2;
			adicionaNaFila();			
		}

		while (!filaExecucao.isEmpty()) {		

			if (filaExecucao.peek().getTempoExecutado() == 0) {
				ordena(filaExecucao);
				filaExecucao.peek().setTempoResposta(tempoGlobal - filaExecucao.peek().getInicio());				
			}

			if ((filaExecucao.peek().getDuracao() - filaExecucao.peek().getTempoExecutado()) < 2) {
				filaExecucao.peek().setTempoExecutado(filaExecucao.peek().getTempoExecutado() + 1);
				tempoGlobal = tempoGlobal + 1;
			}else {
				filaExecucao.peek().setTempoExecutado(filaExecucao.peek().getTempoExecutado() + 2);
				tempoGlobal = tempoGlobal + 2;
			}

			adicionaNaFila();

			if (filaExecucao.peek().getDuracao() == filaExecucao.peek().getTempoExecutado()) {

				filaExecucao.peek().setTempoRetorno(tempoGlobal - filaExecucao.peek().getInicio());
				filaExecucao.peek().setTempoEspera(tempoGlobal - (filaExecucao.peek().getTempoExecutado() + filaExecucao.peek().getInicio()));				
				filaExecucao.poll();				
				adicionaNaFila();

			}

		}

		System.out.print("\n\nSJF: ");
		tempoMedioRetorno();
		tempoMedioResposta();
		tempoMedioEspera();					

	}

	private void tempoMedioEspera() {
		// TODO Auto-generated method stub
		double soma = 0;
		int quant = 0;
		for (Processo processo : listaProcessos) {
			soma = soma + processo.getTempoEspera();
			quant++;
		}
		double media = soma/quant;
		System.out.print(media);
	}

	private void tempoMedioResposta() {
		// TODO Auto-generated method stub
		double soma = 0;
		int quant = 0;
		for (Processo processo : listaProcessos) {
			soma = soma + processo.getTempoResposta();
			quant++;
		}
		double media = soma/quant;
		System.out.print(media+" ");
	}

	private void tempoMedioRetorno() {
		// TODO Auto-generated method stub
		double soma = 0;
		int quant = 0;
		for (Processo processo : listaProcessos) {
			soma = soma + processo.getTempoRetorno();
			quant++;
		}
		double media = soma/quant;
		System.out.print(media+" ");
	}



	public void adicionaNaFila(){

		List<Processo> listAux = new ArrayList<Processo>();		

		for (Processo processo : listaProcessos) {
			boolean aux = false;
			for (Processo processoAux : filaExecucao) {
				if (processoAux.getId() == processo.getId()) {
					aux = true;
				}
			}
			if (processo.getInicio() == tempoGlobal && aux == false) {
				listAux.add(processo);
			}
		}


		if (!listAux.isEmpty()) {
			ordenaLista(listAux);

			for (Processo processo : listAux) {
				filaExecucao.offer(processo);
			}
		}

	}	

	public void ordenaLista(List<Processo> lista){
		Comparator<Processo> comparator = new Comparator<Processo>() {

			@Override
			public int compare(Processo o1, Processo o2) {
				// TODO Auto-generated method stub
				int tempoProcesso1 = o1.getDuracao() - o1.getInicio();
				int tempoProcesso2 = o2.getDuracao() - o2.getInicio();
				return tempoProcesso1-tempoProcesso2;
			}
		};

		Collections.sort(lista,comparator);
	}

	public void ordena(Queue<Processo> fila){
		List<Processo> aux = new ArrayList<Processo>();
		for (Processo processo : fila) {
			aux.add(processo);			
		}

		ordenaLista(aux);

		fila.clear();

		for (Processo processo : aux) {
			fila.offer(processo);
		}
	}


	public List<Processo> getListaProcessos() {
		return listaProcessos;
	}
	public void setListaProcessos(List<Processo> listaProcessos) {
		this.listaProcessos = listaProcessos;
	}
	public Queue<Processo> getFilaExecucao() {
		return filaExecucao;
	}
	public void setFilaExecucao(Queue<Processo> filaExecucao) {
		this.filaExecucao = filaExecucao;
	}
	public int getTempoGlobal() {
		return tempoGlobal;
	}
	public void setTempoGlobal(int tempoGlobal) {
		this.tempoGlobal = tempoGlobal;
	}			
}
