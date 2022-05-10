package business;

public class Grafo {
	private Vertice vertices[];
	private Aresta arestas[];
	private int numVertices=0;
	private int numArestas=0;
	
	public Grafo(){
		vertices = new Vertice[1000];
		arestas = new Aresta[16500];
	}
	
	public Vertice[] getVertices() {
		return vertices;
	}
	
	public Vertice getVerticeById(int id) {
		return vertices[id];
	}
	
	public void addVertices(Vertice vertice) {
		this.vertices[this.numVertices++] = vertice;
	}
	
	public void addVertices() {
		this.vertices[++this.numVertices] = new Vertice(this.numVertices);
	}
	
	public Aresta[] getArestas() {
		return arestas;
	}
	
	public void addArestas(Aresta aresta) {
		this.arestas[++this.numArestas] = aresta;
	}
}
