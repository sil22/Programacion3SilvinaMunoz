package Ejercicios_listas;

public class ListaArreglo {
	Object arr [];
	int cant;
	
	public ListaArreglo(){
		arr= new Object [10];
		cant = 0;
	}
	
	public int getTamanio(){
		return cant;
	}
 	
	public boolean isEmpty() {
		return cant == 0;
	}
	
	public void imprimir() {
		for (int i = 0; i < cant; i++) {
			System.out.print(arr[i]+" ");
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
	
	public void eliminarElemento(Object o) {
		if(!isEmpty()) {
			for (int i = 0; i < cant; i++) {
				if(arr[i] == o) {
					arr[i] = arr[i+1];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ListaArreglo la = new ListaArreglo();
		long inicio, fin, tiempoTotal;
		
		// inserto al comienzo
		inicio = System.currentTimeMillis();
		for (int i = 100; i > 0; i--) {
			la.insertarAlcomienzo(i);	
			
		}
		la.imprimir();
		fin = System.currentTimeMillis();
		
		tiempoTotal = fin - inicio;
		System.out.println(" ");
		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");
		
		
		// get un elemento
		inicio = System.currentTimeMillis();
		System.out.print("agarro el elmento en la pos 3: ");
		System.out.println(la.getElement(3));
		fin = System.currentTimeMillis();
		
		tiempoTotal = fin - inicio;
		System.out.println(" ");
		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");
		
		// elimino un elemento
		
		inicio = System.currentTimeMillis();
		la.eliminarElemento(5);
		System.out.println("elimine el elemento 5");
		la.imprimir();
		fin = System.currentTimeMillis();
		
		tiempoTotal = fin - inicio;
		System.out.println(" ");
		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");
		
		// determinar cant
		
		inicio = System.currentTimeMillis();
		System.out.println("tama�o de la lista: " + la.getTamanio());
		fin = System.currentTimeMillis();
		
		tiempoTotal = fin - inicio;
		System.out.println("La tarea llevo "+ tiempoTotal +" milisegundos");
		
		
	}
	
	
	

}
