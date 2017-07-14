/*
 * Dado un conjunto de n numeros enteros se desea encontrar, si existe, una particion en tres subconjuntos disjuntos,
 * tal que la suma de sus elementos sea la misma.
 * Por ejemplo dado el conjunto {4,1,2,6,3,5,9}, existe una particion en tres conjuntos {4,6},{5,3,2},{9,1} tal que cada uno
 * de los tres conjuntos suma el mismo valor: 10.
 */
public class BacktrackingParcial {
	
		public static void main (String[] args) throws java.lang.Exception
		{
			buscarConjuntos(new int[] { 1, 5, 7, 3, 8 });
		}
	 
		private static final int CANT_CONJUNTOS = 3;
	 
		public static void buscarConjuntos(int[] numeros) {
			int[] conjuntos = new int[numeros.length];
			int[] solucion = backtraking(numeros, conjuntos, 0);
			printSolucion(numeros, solucion);
		}
	 
		private static int[] backtraking(int[] numeros, int[] conjuntos, int nivel) {
			if (nivel == numeros.length) {
				if (esSolucion(numeros, conjuntos)) {
					return conjuntos;
				}
			} else {
				for (int i = 0; i < CANT_CONJUNTOS; i++) {
					conjuntos[nivel] = i;
					int[] solucion = backtraking(numeros, conjuntos, nivel + 1);
					if (solucion != null)
						return solucion;
				}
			}
			return null;
		}
	 
		private static boolean esSolucion(int[] numeros, int[] conjuntos) {
			int sumas[] = new int[CANT_CONJUNTOS];
			for (int i = 0; i < numeros.length; i++) {
				sumas[conjuntos[i]] += numeros[i];
			}
			int primerSuma = sumas[0];
			for (int i = 1; i < sumas.length; i++) {
				if (sumas[i] != primerSuma)
					return false;
			}
			return true;
		}
	 
		private static void printSolucion(int[] numeros, int[] conjuntos) {
			System.out.println("SOLUCION ENCONTRADA:");
			for (int i = 0; i < conjuntos.length; i++) {
				System.out.println("El elemento " + numeros[i] + " pertenece al conjunto" + conjuntos[i]);
			}
	 
			System.out.println();
			System.out.println();
		}
	}

