package Practicando;

import java.util.*;

public class Grafo {

	ArrayList<ArrayList<Integer>> vertices;
	int numVertices;
	
	public Grafo(int numV) {
		numVertices = numV;
		vertices = new ArrayList<ArrayList<Integer>>();
	}

	public int getNumVertices() {
		return numVertices;
	}
	
	public void addVertex(int a) {
		vertices.add(a, new ArrayList<Integer>());
	}

	public void addArco(int origen, int destino){
		if(origen < vertices.size() && destino < vertices.size()) {
			vertices.get(origen).add(destino);
		}
	}
	
	public String toString(){
		String print = "";
		for (int i = 0; i < vertices.size(); i++) {
			print += vertices.get(i).toString();
		}
		return print;
	}
	
	public static void main(String[] args) {
		Grafo g = new Grafo(10);
		System.out.println(g.getNumVertices());
		for (int i = 0; i < g.getNumVertices(); i++) {
			g.addVertex(i);			
		}
		

//		g.addVertex(2);
//		g.addVertex(3);
//		g.addVertex(4);
//		
		System.out.println(g.toString());
	}
}
