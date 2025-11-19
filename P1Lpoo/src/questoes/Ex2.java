package questoes;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lin,col, mat[][], c,aux[][];
		double media =0;
		
		lin = sc.nextInt();
		col = sc.nextInt();
		c = sc.nextInt();
		mat = new int[lin][col];
		aux = new int[col][lin];
		
		for(int i =0; i<lin;i++) {
			for(int j =0; j<col;j++) {
				mat[i][j]=sc.nextInt();
				aux[j][i]=mat[i][j];
			}
		}
		
		
		for(int i =0; i<col;i++) {
			for(int j =0; j<lin;j++) {
				System.out.printf("%3d ",aux[i][j]);
			}
			media = media + aux[i][c];
			System.out.print("\n");
		}
		
		
		media = media/col;
		System.out.printf("Media=%.1f", media);
		
		sc.close();
		
	}

}
