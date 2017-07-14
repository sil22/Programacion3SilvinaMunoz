package Practico4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Mochila {

	private int capacidad;
	private int contPeso;
	
	

	public Mochila(int cap) {
		capacidad = cap;
		contPeso = 0;
		
	}
	
	public int getContPeso() {
		return contPeso;
	}

	public void setContPeso(int contPeso) {
		this.contPeso = contPeso;
	}

	public int getCapacidad() {
		return capacidad;
	}

	private Item seleccionarMejorItem(ArrayList<Item> itemList) {

		return itemList.get(0);

	}

	public HashMap<String, Integer> cargarMochila(ArrayList<Item> s) {
		HashMap<String, Integer> items2 = new HashMap<String, Integer>();
		Collections.sort(s); // ordeno arraylist que me pasan x parametro
		Collections.reverse(s);

		while (!s.isEmpty() && !solucion()) {
			Item x = seleccionarMejorItem(s); 
			s.remove(x);
			int cantPorItem = getCantidad(x);
				if(cantPorItem != 0) {
					items2.put(x.getNombre(), cantPorItem);
					contPeso += cantPorItem * x.getPeso();
				}
				
		}
		return items2;

	}

	private int getCantidad(Item p) {

		int capRestante = capacidad - contPeso;
		int cant = p.getCantidad();
		while(capRestante < p.getPeso() * cant && cant != 0) {
			cant--;
		}
		return cant;
	}
	
	private boolean solucion() {
		return contPeso >= capacidad;
	}

	public static void main(String[] args) {
		Mochila mochi = new Mochila(16);
		ArrayList<Item> items = new ArrayList<Item>();

		Item i1 = new Item("Sillon", 1, 350, 2);
		Item i2 = new Item("Mesa", 5, 2000, 3);
		Item i3 = new Item("Cama", 3, 300, 10);
		items.add(i1);
		items.add(i2);
		items.add(i3);
		
		System.out.println(items.toString());

		System.out.println("Objeto y Cantidad agregados en la mochila");
		System.out.println(mochi.cargarMochila(items));
		
	}


}
