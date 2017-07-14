package Practico4;

public class Factura implements Comparable<Factura>{
	
	int calorias;
	
	public Factura(int c) {
		calorias = c;
	}

	public int getCalorias() {
		return calorias;
	}

	@Override
	public int compareTo(Factura fact) {
		
		return this.getCalorias() - fact.getCalorias();
	}
	
	

}
