package tp_grafos_02;

import java.util.*;

public class Solucao {
	// Java program to find maximum number
	// of edge disjoint paths
	private int V;
	private HashMap<Integer, Deque<Integer>> pathTable;
	private int source;
	private int terminal;
	private int numCaminhos = 0;

	public HashMap<Integer, Deque<Integer>> getPathTable() {
		return pathTable;
	}
	
	// class GFG {

	Solucao(int graph[][], int source, int terminal) {
		this.V = graph.length;
		this.source = source;
		this.terminal = terminal;
		this.pathTable = new HashMap<Integer, Deque<Integer>>(maxCaminhos(graph));
	}

	private int maxCaminhos(int graph[][]) {
		int grauSaidaSource = 0;
		int grauEntradaTerminal = 0;
		for (int i = 0; i < V; i++) {
			if (graph[source][i] == 1)
				grauSaidaSource++;
			if (graph[i][terminal] == 1)
				grauEntradaTerminal++;
		}
		return Math.min(grauEntradaTerminal, grauSaidaSource);
	}

	// Number of vertices in given graph

	/*
	 * Returns true if there is a path from source 's' to sink 't' in residual
	 * graph. Also fills parent[] to store the path
	 */
	public boolean breadthFirstSearch(int residualGraph[][], int parent[]) {
		// Create a visited array and
		// mark all vertices as not visited
		boolean[] visited = new boolean[V];

		// Create a queue, enqueue source vertex and
		// mark source vertex as visited
		Queue<Integer> q = new LinkedList<>();
		q.add(this.source);
		visited[this.source] = true;
		parent[this.source] = -1;

		// Standard BFS Loop
		while (!q.isEmpty()) {
			int u = q.peek();
			q.remove();
			// System.out.print("Caminho: ");
			for (int v = 0; v < V; v++) {
				if (visited[v] == false && residualGraph[u][v] > 0) {
					q.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}
		pathTable.put(this.numCaminhos++, getPath(parent, this.terminal));
		// If we reached sink in BFS
		// starting from source, then
		// return true, else false
		return (visited[this.terminal] == true);
	}

	// Returns the maximum number of edge-disjoint
	// paths from s to t. This function is copy of
	// forFulkerson() discussed at http://goo.gl/wtQ4Ks
	public int findDisjointPaths(int graph[][], int s, int t) {
		int u, v;

		// Create a residual graph and fill the
		// residual graph with given capacities
		// in the original graph as residual capacities
		// in residual graph

		// Residual graph where rGraph[i][j] indicates
		// residual capacity of edge from i to j (if there
		// is an edge. If rGraph[i][j] is 0, then there is not)
		int[][] residualGraph = new int[V][V];
		for (u = 0; u < V; u++)
			for (v = 0; v < V; v++)
				residualGraph[u][v] = graph[u][v];

		// This array is filled by BFS and to store path
		int[] parent = new int[V];

		int max_flow = 0; // There is no flow initially

		// Augment the flow while there is path
		// from source to sink
		while (breadthFirstSearch(residualGraph, parent)) {
			// Find minimum residual capacity of the edges
			// along the path filled by BFS. Or we can say
			// find the maximum flow through the path found.
			int path_flow = Integer.MAX_VALUE;

			for (v = this.terminal; v != this.source; v = parent[v]) {
				u = parent[v];
				path_flow = Math.min(path_flow, residualGraph[u][v]);
			}

			// update residual capacities of the edges and
			// reverse edges along the path
			for (v = this.terminal; v != this.source; v = parent[v]) {
				u = parent[v];
				residualGraph[u][v] -= path_flow;
				residualGraph[v][u] += path_flow;
			}

			// Add path flow to overall flow
			max_flow += path_flow;
		}

		// Return the overall flow (max_flow is equal to
		// maximum number of edge-disjoint paths)
		return max_flow;
	}

	private Deque<Integer> getPath(int parents[], int edge) {
		Deque<Integer> path = new ArrayDeque<Integer>(this.V);
		while (edge != -1) {
			System.out.print(edge + "/");
			path.addFirst(edge);
			edge = parents[edge];
		}
		System.out.println();
		return path;
	}

	// Driver Code
	public static void main(String[] args) {
		// Let us create a graph shown in the above example
		int graph[][] = { { 0, 1, 1, 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };

		int s = 0;
		int t = 7;
		Solucao solucao = new Solucao(graph, s, t);
		System.out.println("There can be maximum " + solucao.findDisjointPaths(graph, s, t)
				+ " edge-disjoint paths from " + s + " to " + t);
		System.out.println(solucao.pathTable.toString());
	}
	// }

	// This code is contributed by PrinciRaj1992
}
