package business;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Floyd {
	final static int INF = 99999;
	

	
	public void floydWarshall(Grafo g)
    {
        int dist[][] = g.transformaMatriz();
        int i, j, k;
 
        for (k = 0; k < g.getNumVertices(); k++)
        {

            for (i = 0; i < g.getNumVertices(); i++)
            {
              
                for (j = 0; j < g.getNumVertices(); j++)
                {
               
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
 
   
        printSolution(dist);
    }
 
    void printSolution(int dist[][])
    {

        for (int i=0; i<dist.length; ++i)
        {
            for (int j=0; j<dist.length; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
        
    }
 

    public static void main (String[] args)
    {
     
         Grafo g=new  Grafo();
        Floyd a = new Floyd();
 
     
        a.floydWarshall(g);
    }
}
