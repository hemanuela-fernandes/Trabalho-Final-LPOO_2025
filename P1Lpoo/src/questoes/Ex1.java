package questoes;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vet[],aux[],n,j;
		n = sc.nextInt();
		vet = new int[n];
		aux = new int[n];
		j =n-1;
		
		for(int i =0; i<n;i++) {
			vet[i]=sc.nextInt();
			aux[j]=vet[i];
			j--;
		}
		
		for(int i =0; i<n;i++) {
			System.out.printf("vet[%d]=%d ",i, aux[i]);
		}
		
		sc.close();
		
		
	}

}
