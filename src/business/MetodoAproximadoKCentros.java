package business;

import java.util.Map;
import java.util.TreeMap;

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
        Vertice[] vertices = grafo.getVertices();
        raio = 0;
        Map<Vertice, Integer> distPossiveisVertices = new TreeMap<>();
        for (Vertice vertice : vertices) {
            if(vertice != null) {
                distPossiveisVertices.put(vertice, Integer.MAX_VALUE);
            }
        }
        for (int i = 1; i < qtdCentros; i++) {
            centros[i] = escolherCentro(distPossiveisVertices, new CaminhoMinimo(grafo, centros[i - 1]).getDistancias());
        }
        calcularRaio(distPossiveisVertices);
    }

    private Vertice escolherCentro(Map<Vertice, Integer> distPossiveisVertices, Map<Vertice, Integer> distNovoCentro) {
        Vertice[] vertices = grafo.getVertices();
        int maiorRaio = 0;
        Vertice escolhido = null;
        for (Vertice vertice : vertices) {
            if(vertice != null) {
                int menorDist = calcularMenorDist(distPossiveisVertices, distNovoCentro, vertice);
                distPossiveisVertices.replace(vertice, menorDist);
                if(maiorRaio < menorDist) {
                    maiorRaio = menorDist;
                    escolhido = vertice;
                }
            }
        }
        return escolhido;
    }

    private int calcularMenorDist(Map<Vertice, Integer> distPossiveisVertices, Map<Vertice, Integer> distNovoCentro, Vertice vertice) {
        return Math.min(distPossiveisVertices.get(vertice), distNovoCentro.get(vertice));
    }

    private void calcularRaio(Map<Vertice, Integer> distPossiveisVertices) {
        raio = distPossiveisVertices.get(escolherCentro(distPossiveisVertices, new CaminhoMinimo(grafo, centros[qtdCentros - 1]).getDistancias()));
    }
}
