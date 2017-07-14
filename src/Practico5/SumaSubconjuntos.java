package Practico5;

import java.util.ArrayList;

import Practico3.ListaNodo;

public class SumaSubconjuntos {
	
	public ArrayList<ListaNodo> solucion(ArrayList<Integer> lista, int m){
		int suma = 0;
		ArrayList<ListaNodo> solucion = new ArrayList<ListaNodo>();
		
		for (int j = 0; j < lista.size(); j++) {
			int a = lista.get(j);
			suma += a;
			
			if(suma == m) {
				solucion.add(j, new ListaNodo());
				solucion.get(j).insertarAlFinal(a);
				
				System.out.println(solucion);
			}
			else {
				solucion(lista, m);
			}
		}
		return solucion;
	} 
	
//	public boolean daIgual(int a, int numeroM) {
//		if(a )
//		
//	}

	public static void main(String[] args) {
		ArrayList<Integer> solucion = new ArrayList<Integer>();
		int numeroM = 6;
		
		solucion.add(2);
		solucion.add(3);
		solucion.add(5);
		solucion.add(6);
		solucion.add(1);

//		for (int i = 0; i < 10; i++) {
//			solucion.add((int) (Math.random() * 9));
//		}

		SumaSubconjuntos suma = new SumaSubconjuntos();
		suma.solucion(solucion, numeroM);
	}

}
