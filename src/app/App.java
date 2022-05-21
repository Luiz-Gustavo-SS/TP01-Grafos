package app;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import business.*;

public class App {
	public static final String CAMINHO_INICIO = "D:\\Eclipse\\tp_grafos\\src\\entradas\\pmed";
	public static final String CAMINHO_FIM = ".txt";

	public static void main(String[] args) {
		for (int j = 1; j <= 1; j++) {
			String caminho = String.format("%s%02d%s", CAMINHO_INICIO, j, CAMINHO_FIM);
			try (Scanner entrada = new Scanner(new FileReader(caminho))) {
				/*
				 * Exemplo de Entrada - duas primeiras linhas: 100 200 5 / 1 2 30
				 */
				int numVertices = entrada.nextInt();
				int numArestas = entrada.nextInt();
				int kCentro = entrada.nextInt();
				Grafo grafo = new Grafo();
				for (int i = 1; i <= numVertices; i++) {
					grafo.addVertices();
				}
				for (int i = 0; i < numArestas; i++) {
					int origem = entrada.nextInt();
					int destino = entrada.nextInt();
					int pesoAresta = entrada.nextInt();
					grafo.addArestas(
							new Aresta(grafo.getVerticeById(origem), grafo.getVerticeById(destino), pesoAresta));
				}
				/*
				 * System.out.println("["+grafo.transformaMatriz()[0][0]+"]");
				 * System.out.println("["+grafo.transformaMatriz()[0][1]+"]");
				 */
				// MetodoAproximadoKCentros aprox = new MetodoAproximadoKCentros(grafo,
				// kCentro);
				// System.out.println(aprox.getRaio());
				// Floyd f=new Floyd();
				// f.floydWarshall(grafo);
			} catch (FileNotFoundException e) {
				System.out.print("Arquivo nao encontrado");
			}
		}
	}
}
