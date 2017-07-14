package Practico4;

import java.util.*;

public class CajeroAutomatico {
	private int contValor;
	private int objetivo;
	private static ArrayList<Billete> billetes;
	
	public CajeroAutomatico() {
		objetivo = 0;
		contValor = 0;
		billetes = new ArrayList<Billete>();
	}
	
	public ArrayList<Billete> sacarPlata(int valor) {
		
		ArrayList<Billete> solucion = new ArrayList<Billete>();
		
		Collections.sort(billetes);
		Collections.reverse(billetes);
		objetivo = valor;
		
		while(!billetes.isEmpty() && !solucion()) {
			Billete x = seleccionarMejor(billetes);
			if(factible(x)) {
				solucion.add(x);
				contValor += x.getValor();
			}
			else {
				billetes.remove(x);
			}
		}
		if(solucion()) {
			return solucion;
		}
		
		return null;
	}
	
	private boolean factible(Billete x) {
		return (contValor + x.getValor()) <= objetivo;
	}

	private Billete seleccionarMejor(ArrayList<Billete> billetes) {
		return billetes.get(0);
	}

	private boolean solucion() {
		return contValor == objetivo;
	}

	public void addBillete(Billete e) {
		billetes.add(e);
	}

	public static void main(String[] args) {
		CajeroAutomatico cajero = new CajeroAutomatico();
	
		Billete m1 = new Billete(100);
		Billete m2 = new Billete(25);
		Billete m3 = new Billete(10);
		Billete m4 = new Billete(5);
		Billete m5 = new Billete(1);

		cajero.addBillete(m1);
		cajero.addBillete(m2);
		cajero.addBillete(m3);
		cajero.addBillete(m4);
		cajero.addBillete(m5);

		

		ArrayList<Billete> solucion = cajero.sacarPlata(289);
		for (int i = 0; i < solucion.size(); i++) {
			System.out.println(solucion.get(i).getValor());
		}
		
	}
}
