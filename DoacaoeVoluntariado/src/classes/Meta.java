package classes;

public class Meta<T extends Number> {

    private T metaTotal;
    private double progresso; // soma de tudo que já foi doado

    public Meta(T metaTotal) {
        this.metaTotal = metaTotal;
        this.progresso = 0.0;
    }

    public void adicionarDoacao(double valor) {
        this.progresso += valor;
    }

    public T getMetaTotal() {
        return metaTotal;
    }

    public double getProgresso() {
        return progresso;
    }

    public double getPercentual() {
        return (progresso / metaTotal.doubleValue()) * 100.0;
    }
}

