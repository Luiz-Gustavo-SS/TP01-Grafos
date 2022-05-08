package business;

public class Aresta implements Comparable<Aresta> {
	private Vertice origem;
	private Vertice destino;
	private int custo;
	
	public Aresta(Vertice origem, Vertice destino, int custo) {
		this.setOrigem(origem);
		this.setDestino(destino);
		this.setCusto(custo);
	}

	public Vertice getOrigem() {
		return origem;
	}

	public void setOrigem(Vertice origem) {
		origem.addArestas(this);
		this.origem = origem;
	}

	public Vertice getDestino() {
		return destino;
	}

	public void setDestino(Vertice destino) {
		this.destino = destino;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}
	
	@Override
	public int compareTo(Aresta o) {
		return this.custo - o.getCusto();
	}
}
