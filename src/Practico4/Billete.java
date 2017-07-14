package Practico4;

public class Billete implements Comparable<Billete>{
	int valor;
	int cantidad;

	public Billete(int v){
		valor = v;
	}
	
	public Billete(int v, int c) {
		valor = v;
		cantidad = c;
	}

	public int getValor() {
		return valor;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public int compareTo(Billete m) {
		return  this.getValor() - m.getValor();
	}


}
