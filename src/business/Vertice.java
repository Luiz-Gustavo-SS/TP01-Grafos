package business;

public class Vertice {
	private int id;
	private Aresta arestas[];
	private int numArestas=0;
	
	Vertice(int id){
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
	
	
}
