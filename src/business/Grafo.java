package business;

public class Grafo {
	private Vertice vertices[];
	private Aresta arestas[];
	private int numVertices = 0;
	private int numArestas = 0;

	public Grafo() {
		vertices = new Vertice[1000];
		arestas = new Aresta[16500];
	}

	public Vertice[] getVertices() {
		return vertices;
	}

	public int getNumVertices() {
		return numVertices;
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

	public int[][] transformaMatriz() {
		int matriz[][] = new int[this.numVertices][this.numVertices];
		for (int i = 0; i < this.numVertices; i++) {
			for (int j = 0; j < this.numVertices; j++) {
				matriz[i][j] = 99999;
				if (i == j) {
					matriz[i][j] = 0;
				} else {
					for (Aresta a : arestas) {
						if (a != null) {
							if (a.getOrigem() == vertices[i + 1] && a.getDestino() == vertices[j + 1]) {
								matriz[i][j] = a.getCusto();
							}
						}
					}
				}
			}
		}
		return matriz;
	}
}
