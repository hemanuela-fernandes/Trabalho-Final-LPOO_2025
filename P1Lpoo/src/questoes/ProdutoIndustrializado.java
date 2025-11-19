package questoes;

public class ProdutoIndustrializado extends Produto{
	private double frete;
	private double seguro;

	public ProdutoIndustrializado(String nome, double valor, double frete, double seguro) {
		super(nome, valor);
		this.frete = frete;
		this.seguro = seguro;
	}
	

	public double getFrete() {
		return frete;
	}



	public void setFrete(double frete) {
		this.frete = frete;
	}



	@Override
	public double getImposto() {
		double baseDeCalculo, valorDoIPI;
		
		baseDeCalculo = super.getValor() + getFrete() + seguro;
		valorDoIPI = baseDeCalculo * (10.0/100.0);
		return valorDoIPI;
	}


	@Override
	public String toString() {
		return super.getNome()+" "+super.getValor()+"  IPI="+String.format("%.1f", getImposto());
	}
	
	

}
