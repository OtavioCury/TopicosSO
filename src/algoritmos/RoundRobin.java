package algoritmos;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import modelo.Processo;

public class RoundRobin {

	private List<Processo> listaProcessos;
	private Queue<Processo> filaExecucao;
	private int tempoGlobal;	

	public RoundRobin(List<Processo> listaProcessos) {		
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
				filaExecucao.peek().setTempoResposta(tempoGlobal - filaExecucao.peek().getInicio());				
			}

			if ((filaExecucao.peek().getDuracao() - filaExecucao.peek().getTempoExecutado()) < 2) {
				filaExecucao.peek().setTempoExecutado(filaExecucao.peek().getTempoExecutado() + 1);
				tempoGlobal = tempoGlobal + 1;
			}else {
				filaExecucao.peek().setTempoExecutado(filaExecucao.peek().getTempoExecutado() + 2);
				tempoGlobal = tempoGlobal + 2;
			}

			if (filaExecucao.peek().getDuracao() == filaExecucao.peek().getTempoExecutado()) {

				filaExecucao.peek().setTempoRetorno(tempoGlobal - filaExecucao.peek().getInicio());
				filaExecucao.peek().setTempoEspera(tempoGlobal - (filaExecucao.peek().getTempoExecutado() + filaExecucao.peek().getInicio()));				
				filaExecucao.poll();				
				adicionaNaFila();

			}else{
				Processo processo = filaExecucao.peek();
				filaExecucao.poll();
				filaExecucao.offer(processo);

				adicionaNaFila();

			}

		}

		System.out.print("\nRR: ");
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

		for (Processo processo : listaProcessos) {
			boolean aux = false;
			for (Processo processoAux : filaExecucao) {
				if (processoAux.getId() == processo.getId()) {
					aux = true;
				}
			}
			if (processo.getInicio() == tempoGlobal && aux == false) {
				filaExecucao.add(processo);
			}
		}

	}

	public List<Processo> getListaProcessos() {
		return listaProcessos;
	}

	public void setListaProcessos(List<Processo> listaProcessos) {
		this.listaProcessos = listaProcessos;
	}

	public int getTempoGlobal() {
		return tempoGlobal;
	}


	public void setTempoGlobal(int tempoGlobal) {
		this.tempoGlobal = tempoGlobal;
	}

	public Queue<Processo> getFilaExecucao() {
		return filaExecucao;
	}

	public void setFilaExecucao(Queue<Processo> filaExecucao) {
		this.filaExecucao = filaExecucao;
	}		

}
