package business;

public class MetodoExato {
	private Grafo grafo;
    private int qtdCentros;
    private Vertice[] centros;
    private int raio;
    private Floyd floyd;
    public MetodoExato(Grafo grafo, int qtdCentros) {
        this.grafo = grafo;
        this.qtdCentros = qtdCentros;
        this.centros = new Vertice[qtdCentros];
       
    }
    public void execut(Grafo grafo)
    {
    	this.floyd.floydWarshall(grafo);
    	
    }
   /* 
    int calcula()
    {
    	int high=grafo.getArestas()[0].getCusto();
    	int low=1;
    	int mid;
    	while (high-low>=1)
    	{
    		mid=((high+low)/2);
    		c
    		 * 
    		 * 
    		 * 
    		
    		if (mid==high)
    		{
    			low=high;
    		}
    		if()
    			
    		else 
    		{
    			low=mid;
    		}
    	}
    	 
    	}
    	return 0;
    }
    */
    public static void main (String[] args)
    {
     
         Grafo g=new  Grafo();
        Floyd a = new Floyd();
        MetodoExato b=new MetodoExato(g,1);
    b.execut(g); 
    }
}
