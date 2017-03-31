package Ejercicios_listas;

public class Nodo {
	Integer valor;
	Nodo sig;
	
	public Nodo(Integer o, Nodo s) {
		valor = o;
		sig = s;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Nodo getSig() {
		return sig;
	}

	public void  setSig(Nodo sig) {
		this.sig = sig;
	}
	
	public String toString(){
		return valor.toString();
	}

}
