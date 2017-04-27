package Practico3;

import java.util.*;

import Practico3.Vertice.Estado;

public class DFS {
	
	public boolean dfsRecursivo(GrafoEntregable g) {
		
		ArrayList<Vertice> vert = new ArrayList<Vertice>();
	
		for (int i = 0; i < g.getVertices().size(); i++) {		
			vert.add(new Vertice(i));
		}
		
		for (int i = 0; i < g.getVertices().size(); i++) {
			if(vert.get(i).getEstado() == Estado.Unvisited) {
				return visit(g,vert.get(i), vert);
			}
		}
		return false;
	}

	private boolean visit(GrafoEntregable g, Vertice vertice, ArrayList<Vertice> vert) {
		
		vertice.setEstado(Estado.Visiting);
		
		if(g.getVertices().get(vertice.getValor()) != null) {
		
			for (int i = 0; i < g.getVertices().get(vertice.getValor()).size() ; i++) {

				if(vert.get(g.getVertices().get(vertice.getValor()).getElement(i)).getEstado() == Estado.Unvisited) {
				
					if(visit(g,vert.get(g.getVertices().get(vertice.getValor()).getElement(i)),vert)){
						return true;
					}
			
				} else if(vert.get(g.getVertices().get(vertice.getValor()).getElement(i)).getEstado() == Estado.Visiting) {
						return true;
					}
				}
			
			vertice.setEstado(Estado.Visited);
		}

		return false;
	}
	
	public boolean dfsIterativo(GrafoEntregable g) {
		
		ArrayList<Vertice> vertAux = new ArrayList<Vertice>();
		for (int i = 0; i < g.getVertices().size(); i++) {
			vertAux.add(new Vertice(i));
		}
		
		Stack<Integer> pila = new Stack<Integer>();
		pila.push(vertAux.get(0).getValor());
		
		while (!pila.isEmpty()) {
			int top = pila.peek();
			if(vertAux.get(top).getEstado() == Estado.Unvisited){
				vertAux.get(top).setEstado(Estado.Visiting);
				if(g.getVertices().get(top) != null) {
					for (int i = 0; i < g.getVertices().get(top).size(); i++) {
						if(vertAux.get(g.getVertices().get(top).getElement(i)).getEstado() == Estado.Unvisited && vertAux.get(g.getVertices().get(top).getElement(i)).getEstado() != null) {
							pila.push(g.getVertices().get(top).getElement(i));
							
						}
						else {
							if(vertAux.get(g.getVertices().get(top).getElement(i)).getEstado() == Estado.Visiting) {
								return true;
							}
						}
					}
				} else {
					vertAux.get(top).setEstado(Estado.Visited);
					pila.pop();
				}
			}
			else if(vertAux.get(top).getEstado() == Estado.Visited) {
				pila.pop();
			} else {
				vertAux.get(top).setEstado(Estado.Visited);
				pila.pop();
			}
			
		}
		return false;
	}

}
