package Grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class DFS {

	int cantVertices;
	static HashMap<Vertice, Boolean> visitados;

	public DFS(int v) {
		cantVertices = v;
		visitados  = new HashMap<Vertice, Boolean>();
	}

	public boolean dfs(Vertice v) {
		
		for (int i = 0; i < v.vertices.size(); i++) {
			if(!visitados.containsKey(v)) {
				return recursiveSearch(v.vertices.get(i));
			}
		}
			
		return false;
	}

	public boolean recursiveSearch(Vertice v) {
		boolean ciclo = false;

		if(visitados.get(v) != null){

			return true;
		}

		else {
			visitados.put(v, true);

			for (int i = 0; i < v.vertices.size(); i++) {
				
				ciclo = recursiveSearch(v.vertices.get(i));

				if(ciclo) {
					return ciclo;
				}

			}
			return ciclo;		

		}

	}

	public boolean iterativeSearch(Vertice v){
		Stack<Vertice> pila = new Stack<Vertice>();

		int visitados [] = new int[cantVertices];
		for(int i = 0; i < cantVertices; i++) 
			visitados[i] = -1; // cargo como no visitado

		pila.push(v);

		while(!pila.isEmpty()) {
			Vertice top = pila.peek();
			pila.pop();
			if(visitados[top.getValor()] == -1) {
				visitados[top.getValor()] = 0;

				ArrayList<Vertice> adyacentes = new ArrayList<Vertice>();
				adyacentes = top.getAdyacentes(top);
				System.out.println(adyacentes);
				int cont = 0;
					while (cont < adyacentes.size()) {
						pila.push(adyacentes.get(cont));
						cont++;
					}
				
				
			}
			else if(visitados[top.getValor()] == 1) {
				return true;
			}
			else {
				visitados[top.getValor()] = 1;
				return true;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		Vertice v1 = new Vertice(1);
		Vertice v2 = new Vertice(2);
		Vertice v3 = new Vertice(3);
		Vertice v4 = new Vertice(4);

		v1.addVertice(v2);
		v1.addVertice(v4);
		v2.addVertice(v4);
		v4.addVertice(v3);
	//	v4.addVertice(v1);

		DFS dfs = new DFS(5);
			
		System.out.println(dfs.dfs(v1));	
		System.out.println("Hay ciclos? iterativo " + dfs.iterativeSearch(v1));

	}
}
