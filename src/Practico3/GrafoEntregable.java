package Practico3;
import java.util.ArrayList;

public class GrafoEntregable {
	private ArrayList<ListaNodo> vertices;
	private int numVertices;
	
	public GrafoEntregable(int numV) {
		vertices = new ArrayList<ListaNodo>();
		numVertices = numV;
	
	}
	
	public ArrayList<ListaNodo> getVertices() {
		return vertices;
	}

	public int getNumVertices() {
		return numVertices;
	}
	
	public void addVertice(int n) {
		vertices.add(n, new ListaNodo());
	}
	
	public void addArco(int i, int j) {
		if(i < vertices.size() && j < vertices.size()) {
			vertices.get(i).insertarAlFinal(j);
		}
	}
	
	public String toString() {

			String aux = "";
			for (int i = 0; i < vertices.size(); i++) {

				aux += "Pos " + i + ": " + vertices.get(i) + "\n";

			}
			return aux;
		
	}
	
	public static void main(String[] args) {
		GrafoEntregable g = new GrafoEntregable(10);

		for (int i = 0; i < g.getNumVertices(); i++) {
			g.addVertice(i);
		}
		
		for (int i = 0; i < g.getNumVertices()-1; i++) {
			g.addArco(i, i+1);
			g.addArco(i, i+2);

		}
		
		System.out.println(g.toString());		
//		//Para probar con un grafo que haga ciclo
//		g.addArco(1, 0);
//		System.out.println(g.toString());
//		DFS dfs= new DFS();
//		System.out.println(dfs.dfsRecursivo(g));
//		System.out.println(dfs.dfsIterativo(g));
		
		BFS bfs = new BFS();
		ArrayList<Integer> enAnchura = bfs.bfs(g);
		for (int i = 0; i < enAnchura.size(); i++) {
			System.out.println(enAnchura.get(i));
			
		}
	}
	
	
	//Conclusion
	// dfs iterativo : la prueba fue con 10000 grafos y los imprime sin problemas, y probe con 100000 y tardo mucho tiempo, pero en ninguno tiro error.
	// dfs recursivo : con la cnatidad de 10000 grafos, los imprime pero tira el erros de saturacion de la pila, cuando llamamos al metodo recursivo.
	
}
