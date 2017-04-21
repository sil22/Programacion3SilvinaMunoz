package Grafos;

import java.util.ArrayList;


public class Vertice {
	ArrayList<Vertice> vertices;
	ArrayList<Vertice> ady;

	int valor;

	public Vertice(int v) {
		valor = v;
		vertices = new ArrayList<Vertice>();
		ady = new ArrayList<Vertice>();
	}

	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	
	public ArrayList<Vertice> getAdyacentes(Vertice i) {
		ady.addAll(i.getVertices());
//		for (int j = 1; j < i.vertices.size(); j++) {
//			ady.addAll(i.vertices.get(j).getVertices());
//		}
		return ady;
	}

	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void addVertice(Vertice v) {
		vertices.add(v);
	}
	
	  public  void mostrar(Vertice v) {
		    System.out.println(v.valor);
		    
		    for (int i = 0; i < v.vertices.size(); i++) {
		      mostrar(v.vertices.get(i));
		    }
		  }
	
	public String toString() {
		String info = "";
		info +=  valor ;
		
		return info;
	}
	

}
