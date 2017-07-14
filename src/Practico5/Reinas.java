package Practico5;

import java.util.ArrayList;

public class Reinas {
	int maxFil = 3;
	int maxCol = 3;
	int [][] reinas;
	
	public Reinas() {
		reinas = new int [maxFil][maxCol];
	
	}

	public ArrayList<Integer> nReinas(int r[][], ArrayList<Integer> cantReinas, int reina) {
		int cont = 0;
		boolean esSol= false;
		if(cont == cantReinas.size()) {
			esSol = checkSolucion(r);
			
			if(esSol) {
				
			}
			else{
				return null;
			}
		}
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				Integer a = cantReinas.get(0);
				cantReinas.remove(a);
				if(r[i][j]== 0) {
					r[i][j]=a;
				}
				nReinas(r,cantReinas, reina++);

			}
		}
		return null;
	}

	private boolean checkSolucion(int[][] r) {
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				if(r[i][j] != 0) {
					int pos = 0;
					while(r[pos][j] == 0 && r[i][pos] == 0 && pos <= maxFil && pos <= maxCol)  {
						pos++;
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Reinas reinas = new Reinas();
		int maxFil = 3;
		int maxCol = 3;
		int [][] matReinas = new int [maxFil][maxCol];
		
		ArrayList<Integer> cantR = new ArrayList<Integer>();
		cantR.add(1);
		cantR.add(2);
		cantR.add(3);
		cantR.add(4);
		System.out.println(cantR.size());
		int reina = 0;
		System.out.println(reinas.nReinas(matReinas, cantR, reina));
	}
		
}
