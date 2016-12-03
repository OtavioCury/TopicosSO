package algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import modelo.Pagina;

public class LRU {
	private Queue<Pagina> filaPaginasOriginal;
	private List<Pagina> listaPaginas;	
	private List<Pagina> listaLRU; //lista que guarda as referências
	private int quantMolduras;
	private int faltaPaginas;

	public LRU(Queue<Pagina> filaPaginasOriginal, int quantMolduras) {
		super();
		this.filaPaginasOriginal = filaPaginasOriginal;
		this.quantMolduras = quantMolduras;
		faltaPaginas = 0;
	}

	public void executa() {
		// TODO Auto-generated method stub
		listaPaginas = new ArrayList<Pagina>();
		listaLRU = new ArrayList<Pagina>();

		for (int i = 0; i < quantMolduras; i++) {
			faltaPaginas++;
			listaPaginas.add(filaPaginasOriginal.peek());
			listaLRU.add(filaPaginasOriginal.peek());
			filaPaginasOriginal.poll();			
		}

		while (!filaPaginasOriginal.isEmpty()) {
			boolean presente = false;

			for (Pagina pagina : listaPaginas) {
				if (pagina.getId() == filaPaginasOriginal.peek().getId()) {
					presente = true;
				}
			}

			if (presente == false) {
				faltaPaginas++;
				removePagina(listaLRU.get(0));
				listaLRU.remove(0);
				listaPaginas.add(filaPaginasOriginal.peek());
				atualizaListaLRU(filaPaginasOriginal.peek());
				filaPaginasOriginal.poll();
			}else{
				atualizaListaLRU(filaPaginasOriginal.peek());
				filaPaginasOriginal.poll();
			}
		}

		System.out.println("LRU "+faltaPaginas);

	}

	public void atualizaListaLRU(Pagina pagina){
		int index = -1;
		for (int i = 0; i < listaLRU.size(); i++) {
			if (listaLRU.get(i).getId() == pagina.getId()) {
				index = i;
			}
		}
		if (index != -1) {
			listaLRU.remove(index);
		}
		listaLRU.add(pagina);
	}

	public void removePagina(Pagina pagina){
		Pagina paginaRemovida = null;
		for (Pagina aux : listaPaginas) {
			if (aux.getId() == pagina.getId()) {
				paginaRemovida = aux;
			}
		}
		listaPaginas.remove(paginaRemovida);
	}

	public List<Pagina> getListaPaginas() {
		return listaPaginas;
	}

	public void setListaPaginas(List<Pagina> listaPaginas) {
		this.listaPaginas = listaPaginas;
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

	public List<Pagina> getListaLRU() {
		return listaLRU;
	}

	public void setListaLRU(List<Pagina> listaLRU) {
		this.listaLRU = listaLRU;
	}	
}
