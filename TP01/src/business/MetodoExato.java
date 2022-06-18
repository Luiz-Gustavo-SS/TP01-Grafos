package business;

import java.util.HashMap;
import java.util.Map;

public class MetodoExato {

	private Grafo grafo;
	private int qtdCentros;
	private Vertice[] centros;
	private int raio;
	private Map<Vertice, Vertice> mapaCentros;
	public Map<Vertice, Map<Vertice, Integer>> distancias;

	public MetodoExato(Grafo grafo, int qtdCentros) {
		this.grafo = grafo;
		this.qtdCentros = qtdCentros;
		this.centros = new Vertice[qtdCentros];
		this.mapaCentros = new HashMap<>(this.grafo.getNumVertices());
		executar();
	}

	public int getRaio() {
		return raio;
	}

	private void setRaio(int raio) {
		this.raio = raio;
	}

	public Vertice[] getCentros() {
		return centros.clone();
	}

	/*
	 * resp = CaminhoMinimo.getAll(grafo);
	 * System.out.println(resp.get(grafo.getVerticeById(1)).get(grafo.getVerticeById
	 * (2)));
	 */
	public void executar() {
		distancias = CaminhoMinimo.getAll(grafo);
		for (int k = 1; k <= qtdCentros; k++) {
			Vertice[][] possibilidadesCentros;
			/*
			 * for (int i = 0; i < this.grafo.getNumVertices(); i++) { for (int j = 0; j <
			 * this.grafo.getNumVertices(); j++) {
			 * 
			 * } }
			 */

		}
	}

	public void listarPosibilidades(int qtdeCentroEscolher, int daquiPraFrente, int linha) {
		for (int i = daquiPraFrente; i < grafo.getNumVertices(); i++) {
			// daquiPraFrente DEFINE TANTO A COLUNA PRA SER INSERIDO, COMO O VÉRTICE A SER
			// INSERIDO
			// colocar um if else, se for a ultima coluna, a gente varia as linhas com for
			// do J, se n for, chama recursivamente
			if (daquiPraFrente == qtdeCentroEscolher) {
				for (int j = i+1; j < grafo.getNumVertices(); j++) {
					// Matriz[linha+j][daquiPraFrente]=
					// preencher com A
				}
			} else {

			}

		}
	}
}
