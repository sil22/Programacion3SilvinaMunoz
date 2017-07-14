package Practicando;

public class FactorialRecursivo {
	
	public int calcularFactorial(int numero){
		if(numero > 1) {
			System.out.println(numero);
			return numero * (calcularFactorial(numero-1));
		}

		else {
			return 1;
		}
		

	}
	
	public static void main(String[] args) {
		FactorialRecursivo fac = new FactorialRecursivo();
		System.out.println(fac.calcularFactorial(5));
	}

}
