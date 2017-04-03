package Practico2;

public class ArregloRecursivoEjer {

	Integer arr[];
	int cant;

	public ArregloRecursivoEjer() {
		arr = new Integer[10];
		cant = 0;
	}

	public int size() {
		return cant;
	}

	public boolean isEmpty() {
		return cant == 0;
	}

	public void imprimir() {
		for (int i = 0; i < cant; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void insertarAlcomienzo(Integer o) {

		if (arr[arr.length - 1] != null) {
			Integer nuevoArreglo[] = new Integer[cant * 2];
			for (int i = 0; i < cant; i++) {
				nuevoArreglo[i] = arr[i];
			}
			arr = nuevoArreglo;
		}
		if (!isEmpty()) {
			for (int i = cant; i != 0; i--) {
				arr[i] = arr[i - 1];
			}
		}
		arr[0] = o;
		cant++;
	}

	public Integer getElement(int p) {
		if (p < cant) {
			return arr[p];
		}
		return null;
	}

	public boolean estaOrdenado() {
		if (arr.length > 2) {
			return estaOrdenado(0);
		}
		return true;
	}

	private boolean estaOrdenado(int pos) {
		Integer siguiente = pos + 1;
		if (arr[siguiente] != null && arr[siguiente] < cant) {
			if (arr[pos] < arr[siguiente]) {
				estaOrdenado(siguiente);
			} else {
				return false;
			}
		}
		return true;
	}

	public Integer getElementRecursivo(int pos) {
		int cont = 0;

		if (pos >= 0 && pos < cant) {

			if (pos == cont) {
				return arr[cont];
			}
			cont++;
			return getElementRecursivo(pos, cont);

		}
		return null;
	}

	private Integer getElementRecursivo(int pos, int cont) {
		if (pos == cont) {
			return arr[cont];
		}
		cont++;
		return getElementRecursivo(pos, cont);

	}

	public Integer getMin() {
		if (!isEmpty()) {
			if (cant == 1) {
				return (int) arr[0];
			} else {
				Integer min = (Integer) arr[0];

				for (int i = 1; i < cant; i++) {
					if ((int) arr[i] < (int) arr[min]) {
						min = arr[i];
					}
				}
				return min;

			}
		}
		return null;
	}

	public void eliminarPrimerInstancia(Integer o) {
		if (!isEmpty()) {
			for (int i = 0; i < cant; i++) {
				if (arr[i] == o) {
					arr[i] = arr[i + 1];
				}
			}
		}
	}

	public void ordenarPorSeleccion() {
		int pos = 0;
		int aux = 0;
		Integer min;
		for (int i = 0; i < cant; i++) {
			min = arr[i];
			pos = i;

			for (int j = i + 1; j < cant; j++) {
				if (arr[j] < min) {
					min = arr[j];
					pos = j;
				}

			}
			aux = arr[i];
			arr[i] = arr[pos];
			arr[pos] = aux;
		}
	}
	
	public void ordenarPorBurbujeo() {
		int aux = 0;
		for (int i = 0; i < cant-1; i++) {
			for (int j = 0; j < cant-i-1; j++) {
				System.out.println(cant-i-1);
				if(arr[j+1] < arr[j]) {
					aux = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = aux;
				}
			}
			
		}
	}
	
	public void llamadaQuickSort() {
		quickSort(0, cant-1);
	}

	public void quickSort(int izq, int der) {
		int i = izq;
		int j = der;
		int aux = 0;
		int pivote = arr[i];
	
		do {
			while (arr[i] < pivote) {
				i++;
			}
			while (arr[j] > pivote) {
				j--;
			}
			if (i <= j) {
				aux = arr[j];
				arr[j] = arr[i];
				arr[i] = aux;
				i++;
				j--;
			}
			
		} while (i <= j);
		
			if (izq < j) {
				quickSort(izq, j);
			}
			if (der > i) {
				quickSort(i, der);
			}
		
	}
	
	public void mergeSort() {
		
	}
	

	public static void main(String[] args) {
		ArregloRecursivoEjer arr = new ArregloRecursivoEjer();
		long inicio, fin, tiempoTotal;

		inicio = System.currentTimeMillis();

		arr.insertarAlcomienzo(1);
		arr.insertarAlcomienzo(3);
		arr.insertarAlcomienzo(8);
		arr.insertarAlcomienzo(2);
		arr.insertarAlcomienzo(6);
		arr.insertarAlcomienzo(4);
		arr.imprimir();
		fin = System.currentTimeMillis();

		tiempoTotal = fin - inicio;
		System.out.println("La tarea llevo " + tiempoTotal + " milisegundos");

//		 System.out.println(arr.estaOrdenado());
//		 System.out.println(arr.getElementRecursivo(2));
//
//		 System.out.println("el minimo es: " + arr.getMin());
//		 arr.eliminarPrimerInstancia(3);
//		 System.out.println("eliminada la instancia 3");
//		 arr.imprimir();
//		 arr.ordenarPorSeleccion();
//		 arr.imprimir();
//		arr.llamadaQuickSort();
//		arr.imprimir();
		 arr.ordenarPorBurbujeo();
		 arr.imprimir();

	}
}
