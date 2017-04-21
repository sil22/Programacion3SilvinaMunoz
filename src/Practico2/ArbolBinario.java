	package Practico2;
	
	public class ArbolBinario {
	
		NodoArbol root;
	
		public ArbolBinario() {
	
		}
	
		public ArbolBinario(int valor) {
			this.root = new NodoArbol(valor);
		}
	
		public ArbolBinario(NodoArbol raiz) {
			this.root = raiz;
		}
	
		public NodoArbol getRoot() {
			return root;
		}
	
		public void addNodo(NodoArbol a, NodoArbol raiz) {
			if (raiz == null) {
				raiz = a;
			} else if (a.getValor() <= raiz.getValor()) {
				if (raiz.getIzq() == null) {
					raiz.setIzq(a);
				} else {
					addNodo(a, raiz.getIzq());
				}
			} else {
				if (raiz.getDer() == null) {
					raiz.setDer(a);
				} else {
					addNodo(a, raiz.getDer());
				}
			}
		}
	
		public void addNodo(NodoArbol d) {
			this.addNodo(d, this.root);
		}
	
		public void imprimirEnOrden() {
			imprimirEnOrden(root);
		}
	
		private void imprimirEnOrden(NodoArbol nodo) {
			if (nodo.getIzq() != null) {
				imprimirEnOrden(nodo.getIzq());
			}
			System.out.println(nodo.toString());
			if (nodo.getDer() != null) {
				imprimirEnOrden(nodo.getDer());
			}
		}
		
		public void imprimirPreOrden() {
			imprimirPreOrden(root);
		}
		
		private void imprimirPreOrden(NodoArbol nodo) {
			System.out.println(nodo.toString());
			if(nodo.getIzq() != null) {
				imprimirPreOrden(nodo.getIzq());
			}
			if(nodo.getDer() != null) {
				imprimirPreOrden(nodo.getDer());
			}
		}
		
		public void imprimirPostOrden() {
			imprimirPostOrden(root);
		}
	
		private void imprimirPostOrden(NodoArbol nodo) {
			if(nodo.getIzq() != null) {
				imprimirPostOrden(nodo.getIzq());
			}
			if(nodo.getDer() != null) {
				imprimirPostOrden(nodo.getDer());
			}
			System.out.println(nodo.toString());
			
		}

		public boolean hasElem(Integer n) {
			if (root.getValor() == n) {
				return true;
			}
			
			return false;
	
		}
	
		public static void main(String[] args) {
			NodoArbol n1 = new NodoArbol(7);
			NodoArbol n2 = new NodoArbol(4);
			NodoArbol n3 = new NodoArbol(8);
			NodoArbol n4 = new NodoArbol(1);
	
			ArbolBinario a1 = new ArbolBinario(n1);
			a1.addNodo(n2);
			a1.addNodo(n3);
			a1.addNodo(n4);
	
			//a1.imprimirEnOrden();
			//a1.imprimirPreOrden();
			//a1.imprimirPostOrden();
			
			
		}
	
	}
