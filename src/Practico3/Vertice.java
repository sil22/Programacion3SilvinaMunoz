package Practico3;

public class Vertice {
	
	Estado estado;
	int valor;

	public Vertice(int i){
		valor = i;
		estado = Estado.Unvisited;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getValor() {
		return valor;
	}


	public enum Estado{
		Unvisited, Visiting, Visited; 
	}

}
