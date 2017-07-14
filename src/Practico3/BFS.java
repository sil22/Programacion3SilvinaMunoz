package Practico3;

import java.util.*;

import Practico3.Vertice.Estado;

public class BFS {

	public ArrayList<Integer> bfs(GrafoEntregable g) {
		Queue<Integer> fila = new LinkedList<Integer>();
		ArrayList<Vertice> vertices = new ArrayList<Vertice>();
		ArrayList<Integer> recorridos = new ArrayList<Integer>();

		for (int i = 0; i < g.getVertices().size(); i++) {
			vertices.add(new Vertice(i));
		}

		fila.add(vertices.get(0).getValor());
		vertices.get(0).setEstado(Estado.Visited);
		recorridos.add(vertices.get(0).getValor());

		while(!fila.isEmpty()) {
			int head = fila.remove();
			if(vertices.get(head).getEstado() == Estado.Unvisited){
				vertices.get(head).setEstado(Estado.Visited);
			}
			if(g.getVertices().get(head) != null) {

				for (int i = 0; i < g.getVertices().get(head).size(); i++) {

					if(vertices.get(g.getVertices().get(head).getElement(i)).getEstado() == Estado.Unvisited){
						fila.add(vertices.get(g.getVertices().get(head).getElement(i)).getValor());
						vertices.get(g.getVertices().get(head).getElement(i)).setEstado(Estado.Visited);
						recorridos.add(g.getVertices().get(head).getElement(i));
					}									
				}

			}
		}
		return recorridos;
	}

}
