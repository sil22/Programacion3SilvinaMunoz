package Practico5;
/*
 * Ejercicio 1. Suma de subconjuntos. Dados n n�meros positivos distintos, se desea encontrar todas las combinaciones 
 * de esos n�meros tal que la suma sea igual a M. Compare los tiempos de ejecuci�n de conjuntos de entrada con n�meros 
 * enteros positivos generados al azar, conjuntos con 50, 100, 500 y 1000 elementos. 
 */
public class BacktrackingEJ1 {

		int M = 15;
		int[] numbers = {6,3,7,4,2,9};

		public BacktrackingEJ1 () {
			// Cada pos del arreglo puede tener el 0 o el 1
			// 0: El n�mero no se encuentra en la posible soluci�n
			// 1: EL n�mero se encuentra en la posible soluci�n
			int[] group = {0,0,0,0,0,0};

			getSolution(numbers,group, 0);
		}

		public void getSolution(int numb[],int group[], int level) {

			if(isSolution(numb,group, level)) {
				for (int i = 0; i < group.length; i++) {
					if(group[i] == 1) {
						System.out.print(numb[i]);

					}				
				}
				System.out.println();

			}

			else {
				for (int i = 0; i < 2 && level < numbers.length; i++) {
					group[level] = i;
					getSolution(numb,group, level+1);	
				}				

			}
		}

		private boolean isSolution(int numb[],int group[], int level) {
			int plus = 0;

			for (int i = 0; i < group.length; i++) {
				// Si es 1 est� en la solucion y si es 0 no.
				if(group[i] == 1) {
					plus += numb[i];
				}
			}

			return plus == M;
		}

		public static void main(String[] args) {
			BacktrackingEJ1 b = new BacktrackingEJ1();
		}
	

}
