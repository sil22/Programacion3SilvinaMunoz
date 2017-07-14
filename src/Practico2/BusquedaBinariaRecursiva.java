package Practico2;

public class BusquedaBinariaRecursiva {
	int numeros[] = {1,2,3,4,5,6,7,8};
	
	public BusquedaBinariaRecursiva(int numero) {
		System.out.println("Tu numero esta en la posicion: " + busqBinariaRecur(numeros, numero, 0, numeros.length-1));
	}
	
	public int busqBinariaRecur(int arr[], int numAbuscar, int inicio, int fin){
		int medio;
		if(inicio > fin){
			return -1;
		}
		else {
			medio = (inicio + fin) / 2;
			System.out.println("medio" + medio);
			if(numAbuscar > arr[medio]){
				return busqBinariaRecur(arr, numAbuscar, medio+1, fin);
			}
			else {
				if(numAbuscar < arr[medio]){

					return busqBinariaRecur(arr, numAbuscar, inicio, medio-1);
				}
				else {
					return medio;
				}
			}
		}

	}
	
	public static void main(String[] args) {
		BusquedaBinariaRecursiva b = new BusquedaBinariaRecursiva(8);
	
	}

}
