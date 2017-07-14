package Practicando;

public class Recusividad {
	
	public void imprimir(int i) {
		if(i > 0) {
			System.out.println(i);
			imprimir(i-1);
		}

	}
	
	public void imprimirAsc(int i) {
		
		if(i > 0) {
			
			imprimirAsc(i-1);
			System.out.println(i);


		}

	}
	
	public int calcular(int x, int n){  //exponente
		if(n <= 0) {
			return 1;
		}
		else {
			return x * (calcular(x, n-1));
		}
	}

	
	
	public static void main(String[] args) {
		Recusividad r = new Recusividad();
		//r.imprimir(6);
		//r.imprimirAsc(6);
		System.out.println(r.calcular(40, 2));

	}

}
