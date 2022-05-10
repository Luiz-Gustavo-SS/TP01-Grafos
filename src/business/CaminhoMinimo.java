package business;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class CaminhoMinimo {
    private Map<Vertice, Integer> distancias;

    private Grafo grafo;

    private Vertice verticeInicial;

    private List<Vertice> verticesCorte;

    private PriorityQueue<ArestaAux> arestasCorte;

    public CaminhoMinimo (Grafo grafo, Vertice verticeInicial) {
        this.grafo = grafo;
        this.distancias = new TreeMap<>();
        this.verticeInicial = verticeInicial;
        this.arestasCorte = new PriorityQueue<>();
        this.verticesCorte = new LinkedList<>();
        calcular();
    }

    public Map<Vertice, Integer> getDistancias() {
        return distancias;
    }

    private void calcular () {
        setup();
		while (arestasCorte.peek() != null) {
            ArestaAux menorCusto = descobrirMenorCusto();
            if(menorCusto != null) {
                Vertice verticeAssociado = menorCusto.aresta.getDestino();
                distancias.replace(verticeAssociado, menorCusto.custoTotal);
                verticesCorte.add(verticeAssociado);
                descobrirArestasCorte(verticeAssociado);
            }
		}
	}

    private void descobrirArestasCorte (Vertice verticeDescoberto) {
        Aresta[] arestas = verticeDescoberto.getArestas();
        for (Aresta aresta : arestas) {
            if(aresta != null && !verticesCorte.contains(aresta.getDestino())) {
                arestasCorte.add(new ArestaAux(aresta, aresta.getCusto() + distancias.get(verticeDescoberto)));
            }
        }
    }

    private ArestaAux descobrirMenorCusto() {
        ArestaAux menor = null;
        do {
            menor = arestasCorte.poll();
        } while (menor != null && verticesCorte.contains(menor.aresta.getDestino()));
        return menor;
    }

    private void setup () {
        Vertice[] vertices = grafo.getVertices();
		for (Vertice vertice : vertices) {
            if(vertice != null) {
			    distancias.put(vertice, Integer.MAX_VALUE);
            }
		}
        distancias.replace(verticeInicial, 0);
		verticesCorte.add(verticeInicial);
        descobrirArestasCorte(verticeInicial);
    }

    private class ArestaAux implements Comparable<ArestaAux> {
        public Aresta aresta;
        public int custoTotal;
        public ArestaAux(Aresta aresta, int custoTotal) {
            this.aresta = aresta;
            this.custoTotal = custoTotal;
        }
        @Override
        public int compareTo(ArestaAux o) {
            return this.custoTotal - o.custoTotal;
        }
    }
}
