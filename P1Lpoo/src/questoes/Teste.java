package questoes;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nome;
		double valor,aliquota, frete, seguro;
		
		nome = sc.next();
		valor = sc.nextDouble();
		aliquota = sc.nextDouble();
		ProdutoNatural prod1 = new ProdutoNatural(nome, valor, aliquota);
		
		nome = sc.next();
		valor = sc.nextDouble();
		frete = sc.nextDouble();
		seguro = sc.nextDouble();
		ProdutoIndustrializado prod2 = new ProdutoIndustrializado(nome, valor, frete, seguro);
		
		System.out.println(prod1);
		System.out.println(prod2);
		prod2.setFrete(sc.nextDouble());
		System.out.println(prod2);
		
		sc.close();
	}

}
