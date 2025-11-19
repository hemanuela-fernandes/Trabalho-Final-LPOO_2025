package questoes;

public class ProdutoNatural extends Produto{
	private double aliquota;

	public ProdutoNatural(String nome, double valor, double aliquota) {
		super(nome, valor);
		this.aliquota = aliquota;
	}

	@Override
	public double getImposto() {
		return aliquota;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getNome()+" "+super.getValor()+", Imposto "+getImposto();	
	}

}
