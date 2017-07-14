package Practico5;
/*
 * NO FUNCIONAAAAAAA
 */
public class NReinas {
	
	public int n_reinas(int reinas [], int nro_reina) {
		int sol;
		int col;
		if(nro_reina == 2) {
			imprimirSolucion(reinas);
			return 1;
		}
		else {
			sol = 0;
			col = 0;
			while (col < 8 && sol == 0) {
				reinas[nro_reina] = col;
				if(!poda(reinas,nro_reina)){
					sol = n_reinas(reinas, nro_reina++);
				}
				col++;

			}
			return sol;			
		}
	}

	private boolean poda(int[] reinas, int nro_reina) {
		// TODO Auto-generated method stub
		int j = 0;
		while(j < nro_reina){
			if(reinas[j] == reinas[nro_reina] || Math.abs(reinas[j] - reinas[nro_reina]) == nro_reina){
				return true;
			}
			j++;
		}
		return false;
	}

	private void imprimirSolucion(int[] reinas) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < reinas.length; i++) {
			System.out.println(reinas[i]);
		}
	}
	
	public static void main(String[] args) {
		int arr_reinas[] = new int[4];
		int nro_reina = 1;
		NReinas r = new NReinas();
		r.n_reinas(arr_reinas, nro_reina);
	}

}
