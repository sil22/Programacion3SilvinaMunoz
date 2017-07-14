	package Practico2;
	
	public class ArbolBinario {
	
		NodoArbol root;
		int size;
	
		public ArbolBinario(int valor) {
			this.root = new NodoArbol(valor);
			size = 0;
		}
	
		public ArbolBinario(NodoArbol raiz) {
			this.root = raiz;
		}
	
		public NodoArbol getRoot() {
			return root;
		}
		
		public boolean isEmpty(){
			return root != null;
		}
		
		public int size() {
			return size;
		}
		
		public void insert(NodoArbol a, NodoArbol raiz) {
			if (raiz == null) {
				raiz = a;
				size++;
			} else if (a.getValor() <= raiz.getValor()) {
				if (raiz.getIzq() == null) {
					raiz.setIzq(a);
					size++;
				} else {
					insert(a, raiz.getIzq());
					size++;
				}
			} else {
				if (raiz.getDer() == null) {
					raiz.setDer(a);
					size++;
				} else {
					insert(a, raiz.getDer());
					size++;
				}
			}
		}
	
		public void addNodo(NodoArbol d) {
			this.insert(d, this.root);
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

		public boolean hasElem(Integer e) {
				return hasElement(root,e);
		}

	
		private boolean hasElement(NodoArbol nodo, Integer e) {
			if(nodo != null) {
				if(nodo.getValor().equals(e)){
					return true;
				}
				else if(e > root.getValor()) {
					if(hasElement(nodo.getDer(), e)){
						return true;
					}
				}
				else if(e < root.getValor()){
					if(hasElement(nodo.getIzq(), e)){
					return true;
					}
				}
			}	
			
			return false;
		}
		
		public boolean delete(Integer e) {
				if(e == root.getValor()) {
					root = null;
					return true;
				}
				
				NodoArbol search = searchNode(e);
				if(search != null) {
					search.setIzq(search.getIzq().getIzq());
					return true;
				}
			
			return false;
			}
							
		private NodoArbol searchNode(Integer e) { // llamada recursiva
			
			return searchNode(root, e);	
		}

		private NodoArbol searchNode(NodoArbol node, Integer e) { // devuelve el padre del nodo o null si no lo encuentra
				if(e > node.getValor()) {
					if(node.getDer() != null){
						if(node.getDer().getValor() == e){
							return node; // retorna el padre
						}
						else{
							return searchNode(node.getDer(), e);
						}
					}
					return null;
				}
				else if(e < node.getValor()){
					if(node.getIzq() != null) {
						if(node.getIzq().getValor() == e) {
							return node;
						}
						else {
							return searchNode(node.getIzq(), e);
						}
					}
					return null;
				}
				return null;
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
			
			
//			a1.imprimirEnOrden();
			a1.imprimirPreOrden();
//			a1.imprimirPostOrden();
//			System.out.println(a1.hasElem(8)); 
			System.out.println(a1.delete(4));
			a1.imprimirPreOrden();

		}
	
	}
