package Practico4;

public class Item implements Comparable<Item>{
	private String nombre;
	private int peso;
	private int valor;
	private int cantidad;
	
	public Item(String n, int p, int v, int c) {
		nombre = n;
		peso = p;
		valor = v;
		cantidad = c;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCapacidad(int capacidad) {
		this.cantidad = capacidad;
	}
	
	public String toString(){
		return this.nombre;
	}

	@Override
	public int compareTo(Item o) {
		return ((this.getValor() / this.getPeso()) - (o.getValor() / o.getPeso()));
	}


	
}
