package business;

public class Vertice implements Comparable<Vertice>{
	private int id;
	private Aresta arestas[];
	private int numArestas=0;
	
	public Vertice(int id){
		this.id=id;
		arestas = new Aresta[5];
	}

	public int getId() {
		return id;
	}

	public Aresta[] getArestas() {
		return arestas;
	}

	public void addArestas(Aresta aresta) {
		this.arestas[this.numArestas++] = aresta;
	}
	
	@Override
	public int compareTo(Vertice o) {
		return this.id - o.getId();
	}
}
