package Practico4;

import java.util.ArrayList;
import java.util.Collections;

public class Marcelo {
	final static int PESO = 85;
	int cantFacturas;
	int cantKm;
		
	public Marcelo(int fact){
		cantFacturas = fact;
	}

	public ArrayList<Factura> greedy(ArrayList<Factura>facturas){
		
		ArrayList<Factura> solucion = new ArrayList<Factura>();
		Collections.sort(facturas);
		
		while(!facturas.isEmpty() && !esSolucion(facturas)){
			Factura f1 = seleccionar(facturas);
			facturas.remove(f1);
			solucion.add(f1);	
		}
		if(esSolucion(facturas)){
			return solucion; 
		}
		return null;

	}


	private Factura seleccionar(ArrayList<Factura> f) {
		return f.get(0);
	}


	public boolean esSolucion(ArrayList<Factura> facturas) {
		return facturas.size() == 0;
	}
	
	
	
	
	public static void main(String[] args) {
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		Factura f1 = new Factura(1);
		Factura f2 = new Factura(7);
		Factura f3 = new Factura(5);
		Factura f4 = new Factura(2);
		
		facturas.add(f1);
		facturas.add(f2);
		facturas.add(f3);
		facturas.add(f4);
		

		
		Marcelo m = new Marcelo(4);
		ArrayList<Factura> solucion = m.greedy(facturas);
		for (int i = 0; i < solucion.size(); i++) {
			System.out.println(solucion.get(i).getCalorias());
		}

	}

}
