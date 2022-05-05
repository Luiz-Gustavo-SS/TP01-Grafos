package business;

public class Grafo {
	private Vertice vertices[];
	private Aresta arestas[];
	private int numVertices=0;
	private int numArestas=0;
	
	
	
	public Vertice[] getVertices() {
		return vertices;
	}
	public void addVertices(Vertice vertice) {
		this.vertices[this.numVertices++] = vertice;
	}
	public Aresta[] getArestas() {
		return arestas;
	}
	public void addArestas(Aresta aresta) {
		this.arestas[this.numArestas++] = aresta;
	}
	
	
}
