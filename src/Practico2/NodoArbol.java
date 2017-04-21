package Practico2;

public class NodoArbol {
	Integer valor;
	NodoArbol izq;
	NodoArbol der;
	
	public NodoArbol(Integer v) {
		valor = v;
	}
	
	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public NodoArbol getIzq() {
		return izq;
	}

	public void setIzq(NodoArbol izq) {
		this.izq = izq;
	}

	public NodoArbol getDer() {
		return der;
	}

	public void setDer(NodoArbol der) {
		this.der = der;
	}

	@Override
	public String toString() {
		return valor.toString();
	}

}
