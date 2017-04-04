package Ejercicios_listas;

public class Pila {
	
	ListaNodo pila;
	
	public Pila() {
		pila = new ListaNodo();
	}
	
	public Pila(ListaNodo p) {
		pila = p;
	}
	
	public int size() {
		return pila.size();
	}
	
	public boolean isEmpty() {
		return pila.isEmpty();
	}
	
	//inserta un elemento a la pila.
	public void push(Integer o) {
		pila.insertarAlFinal(o);
	}
	
	//devuelve el elemento que esta en la cima de la pila sin eliminarlo.
	public Integer top() {
		if(!pila.isEmpty()) {
			return pila.getElement(pila.size()-1);
		}
		return null;
	}
	
	//Elimina el objeto en la parte superior de la pila y devuelve ese objeto como el valor de esta función.
	public Integer pop() {
			int p = this.top();
			pila.eliminarUltimoElemento();
			return p;
	}
	
	public String printStack() {
		String s = "";
		s += pila.imprimir();
	
		return s;
	}
	
	public static void main(String[] args) {
		Pila p = new Pila();
		System.out.println("Pregunto si esta vacia:");
		System.out.println(p.isEmpty());
		System.out.println("Inserto elementos");
		for (int i = 1; i < 10; i++) {
			p.push(i);
		}
		System.out.println(p.printStack());
		
		System.out.println("Pregunto si esta vacia:");
		System.out.println(p.isEmpty());
		
		System.out.println("Consulto el elemento que esta en la cima de la pila");
		System.out.println(p.top());
		
		System.out.println("Elimino el ultimo elemento en ingresar a la pila");
		System.out.println(p.pop());
		System.out.println("Imprimo pila");
		System.out.println(p.printStack());
		
	}
}
