package Practico1;

public class ListaNodo {
	
	Nodo primero;
	int cantidad = 0;
	
	public ListaNodo() {
		primero = null;
	}
	
	public int size() {
		return cantidad;
	}
	
	public Nodo getPrimero() {
		return primero;
	}
	
	public Integer getValorNodo() {
		return primero.getValor();
	}
	
	public boolean isEmpty() {
		return cantidad==0;
	}
	
	public void insertarNodoAlComienzo(Integer o) {
		Nodo nuevo = new Nodo(o, null);
		nuevo.setSig(primero);
		primero = nuevo;
		cantidad++;
	}
	
	public void insertarAlFinal(Integer o) {
		
		if(isEmpty()){
			insertarNodoAlComienzo(o);
		}
		else {
		Nodo n = primero;
		while(n.getSig() != null){
			n = n.getSig();	
		}
		Nodo nuevo = new Nodo(o, null);
		n.setSig(nuevo);
		cantidad++;
		}
	}
	
	public  void eliminarElemento(int pos) {
		int cont = 0;
		
		if(pos <= cantidad) {
			Nodo t = primero;
			primero = primero.getSig();	
			t.setSig(null);
			cantidad--;
		}
		
		else if(pos < cantidad){
			Nodo aux = primero;
			while (cont != pos) {
				cont++;
				aux = aux.getSig();
			
			}
			Nodo next = aux.getSig();
			aux.setSig(aux.getSig().getSig());
			next.setSig(null);
		}
	}
	
	public void eliminarUltimoElemento() {
	
			if (cantidad <= 1) {
				eliminarElemento(cantidad);
			}
			else {
			int cont = 0;
			Nodo aux = primero;
			while(cont < size()-2) {
				aux = aux.getSig();
				cont++;
			}
			aux.getSig().setSig(null);
			aux.setSig(null);
			cantidad--;
			}
	}
	
//	public Integer getPosElement(int pos) {
//		int cont = 0;
//		if(pos >= 0 && pos < size()) {
//			Nodo elem = primero;
//			
//			while ( pos != cont ) {
//				elem = elem.getSig();
//				cont++;
//			}
//			return elem.getValor();
//		}
//		return null;
//	}

	public Integer getElement(Integer p) {
		int cont = 0;
		if(p >= 0 && p <= size()) {
			Nodo elem = primero;
			
			while ( p != cont ) {
				elem = elem.getSig();
				cont++;
			}
			return elem.getValor();
		}
		return null;
	}
	
	public Integer getMax() {
		Nodo aux = primero;
		while(aux.getSig() != null) {
			aux = aux.getSig();
		}
		return null;
	}
	
	public String toString()  {
		String result = "";
		Nodo aux = primero;
		
		while(aux != null) {
			result += aux.getValor() + " ";
			aux = aux.getSig();
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListaNodo l1 = new ListaNodo();
		l1.insertarAlFinal(1);
		l1.insertarAlFinal(2);
		l1.insertarAlFinal(3);
		l1.insertarAlFinal(4);
		long time_start, time_end;
		time_start = System.currentTimeMillis();

		System.out.println(l1.size());
		System.out.println(l1.isEmpty());
		System.out.println(l1.toString());
		//l1.eliminarElemento(2);
		System.out.println("Elimino el ult elem");
		l1.eliminarUltimoElemento();
		System.out.println(l1.toString());
		
		time_end = System.currentTimeMillis();
		System.out.println("La tarea llevo "+ ( time_end - time_start ) +" milisegundos");

	}

}
