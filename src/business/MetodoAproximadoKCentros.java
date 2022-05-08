package business;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MetodoAproximadoKCentros {
    private Grafo grafo;

    private int qtdCentros;

    private Vertice[] centros;

    private int raio;

    public MetodoAproximadoKCentros(Grafo grafo, int qtdCentros) {
        this.grafo = grafo;
        this.qtdCentros = qtdCentros;
        this.centros = new Vertice[qtdCentros];
        executar();
    }

    public int getRaio() {
        return raio;
    }

    public Vertice[] getCentros() {
        return centros.clone();
    }

    private void executar() {
        centros[0] = grafo.getVertices()[0];
        List<Map<Vertice, Integer>> distPossiveisVertices = new LinkedList<>();
        for (int i = 1; i < qtdCentros; i++) {
            distPossiveisVertices.add(new CaminhoMinimo(grafo, centros[i -1]).getDistancias());
            centros[i] = escolherCentro(distPossiveisVertices);
        }
    }

    private Vertice escolherCentro(List<Map<Vertice, Integer>> distPossiveisVertices) {
        raio = 0;
        Vertice[] vertices = grafo.getVertices();
        int maiorRaio = 0;
        Vertice escolhido = null;
        for (Vertice vertice : vertices) {
            if(vertice != null) {
                int menorDist = calcularMenorDist(distPossiveisVertices, vertice);
                if(maiorRaio < menorDist) {
                    maiorRaio = menorDist;
                    escolhido = vertice;
                }
            }
        }
        for (Vertice vertice : vertices) {
            if(vertice != null)
                raio = Math.max(raio, calcularMenorDist(distPossiveisVertices, vertice));
        }
        return escolhido;
    }

    private int calcularMenorDist(List<Map<Vertice, Integer>> distPossiveisVertices, Vertice vertice) {
        int menorDist = Integer.MAX_VALUE;
        for(Map<Vertice, Integer> map : distPossiveisVertices) {
            menorDist = Math.min(menorDist, map.get(vertice));
        }
        return menorDist;
    }
}
