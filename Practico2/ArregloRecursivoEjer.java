package Practico2;

public class ArregloRecursivoEjer {
	

	Object arr [];
	int cant;
	
	public ArregloRecursivoEjer(){
		arr= new Object [10];
		cant = 0;
	}
	
	public int size(){
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
	
	public void insertarAlcomienzo(Object o) {
		
		if(arr[arr.length-1] != null){
			Object nuevoArreglo[] = new Object[cant*2];
			for (int i = 0; i < cant; i++) {
				nuevoArreglo[i] = arr[i];
			}
			arr = nuevoArreglo;
		}
		if(!isEmpty()){
			for (int i = cant; i != 0; i--) {
				arr[i] = arr[i-1];
			}
		}
		arr[0] = o;
		cant++;
	}
	
	public Object getElement(int p) {
		if(p < cant) {
			return arr[p];
		}
		return null;
	}
	
	public boolean estaOrdenado() {
		if(arr.length > 2) {
			return estaOrdenado(0);
		}
		return true;
	}

	private boolean estaOrdenado(int pos) {
		Integer siguiente = pos + 1;
			if(arr[siguiente] != null && (int)arr[siguiente] < (int)cant) {
				if((int)arr[pos] < (int)arr[siguiente]) {
					estaOrdenado(siguiente);
				}
				else {
					return false;
				}
			}
			return true;
	}
	
	public Object getElementRecursivo(int pos){
		int cont = 0;
		
		if(pos >= 0 && pos < cant) {
			
			if(pos == cont) {
				return arr[cont];
			}
			cont++;
			return getElementRecursivo(pos, cont);
	
		}
			return null;
	}

	private Object getElementRecursivo(int pos, int cont) {
		if(pos == cont) {
			return arr[cont];
		}
		cont++;
		return getElementRecursivo(pos, cont);
			
	}
	
	public Object getMin() {
		if(!isEmpty()) {
			if(cant == 1){
				return arr[0];
			}
			Object min = arr[0];
			for (Object o : arr) {
				if((int)min > (int)o) {
					min = o;
					return min;
				}	
			}
		}
		return null;
	}
	
	public void eliminarPrimerInstancia(Object o) {
		if(!isEmpty()) {
			for (int i = 0; i < cant; i++) {
				if(arr[i]  == o) {
						arr[i] = arr[i+1];						
				}	
			}
		}
	}
	
	public void ordenarPorSeleccion() {
		Object min = getMin();
		int i = 0;
		while(i < cant ){
			if((int)arr[i] < (int)min){
				min = arr[i];
			}
			i++;
		}
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
		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");

		
//		System.out.println(arr.estaOrdenado());
//		System.out.println(arr.getElementRecursivo(99));

		System.out.println("el minimo es: " + arr.getMin());
//		arr.eliminarPrimerInstancia(3);
//		System.out.println("eliminada la instancia 3");
//		arr.imprimir();
//		arr.ordenarPorSeleccion();
//		arr.imprimir();
		
	
	}
}

