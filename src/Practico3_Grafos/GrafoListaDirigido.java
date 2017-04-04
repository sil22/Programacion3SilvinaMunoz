package Practico3_Grafos;
import Ejercicios_listas.*;

public class GrafoListaDirigido {

	ListaNodo[] grafo;
	int size;

	public GrafoListaDirigido() {
		grafo = new ListaNodo[5];
		size = 0;
	}
	
	public void agregarArco(int origen, int destino){
		if(grafo[origen] == null) {
			grafo[origen] = new ListaNodo();
	
		}
		grafo[origen].insertarAlFinal(destino);	
		
		size++;
	}
	
	
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String imprimir() {
		String aux = " ";
		for (int i = 0; i < size; i++) {
			aux += grafo[i].imprimir() + "\n";
		}
		return aux;
	}
	
	

	public static void main(String[] args) {
		GrafoListaDirigido g = new GrafoListaDirigido();	
		g.agregarArco(0, 1);
		g.agregarArco(1, 3);
		System.out.println(g.imprimir());
	}

}
