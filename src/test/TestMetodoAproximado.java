package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Aresta;
import business.Grafo;
import business.MetodoAproximadoKCentros;
import business.Vertice;

public class TestMetodoAproximado {

    private Grafo grafo;

    @BeforeEach
    public void init() {
        grafo = new Grafo();
        Vertice vertice0 = new Vertice(0);
        Vertice vertice1 = new Vertice(1);
        Vertice vertice2 = new Vertice(2);
        Vertice vertice3 = new Vertice(3);
        grafo.addVertices(vertice0);
        grafo.addVertices(vertice1);
        grafo.addVertices(vertice2);
        grafo.addVertices(vertice3);
        grafo.addArestas(new Aresta(vertice0, vertice1, 10));
        grafo.addArestas(new Aresta(vertice1, vertice0, 10));
        grafo.addArestas(new Aresta(vertice0, vertice2, 7));
        grafo.addArestas(new Aresta(vertice2, vertice0, 7));
        grafo.addArestas(new Aresta(vertice0, vertice3, 6));
        grafo.addArestas(new Aresta(vertice3, vertice0, 6));
        grafo.addArestas(new Aresta(vertice1, vertice2, 8));
        grafo.addArestas(new Aresta(vertice2, vertice1, 8));
        grafo.addArestas(new Aresta(vertice1, vertice3, 5));
        grafo.addArestas(new Aresta(vertice3, vertice1, 5));
        grafo.addArestas(new Aresta(vertice2, vertice3, 12));
        grafo.addArestas(new Aresta(vertice3, vertice2, 12));
    }

    @Test
    public void metodoAproximado() {
        MetodoAproximadoKCentros metodo = new MetodoAproximadoKCentros(grafo, 3);
        System.out.println(metodo.getRaio());
    }
}
