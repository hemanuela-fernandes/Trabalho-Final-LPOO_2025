package classes;

import java.time.LocalDate;

public class Doacao {

    private Doador doador;
    private int itens;
    private Double valor;
    private LocalDate data;
    private ProjetoSocial projeto;

    public Doacao(Doador doador, ProjetoSocial projeto, Double valor) {
        this.doador = doador;
        this.valor = valor;
        this.projeto = projeto;
        this.data = LocalDate.now();
    }

    public Doacao(Doador doador, ProjetoSocial projeto, int itens) {
        this.doador = doador;
        this.itens = itens;
        this.projeto = projeto;
        this.data = LocalDate.now();
    }

    public boolean isDinheiro() {
        return valor != null;
    }

    public double getValor() {
        return valor != null ? valor : 0;
    }

   // public String getItem() {
   //     return item;
   // }

    public Doador getDoador() {
        return doador;
    }

    @Override
    public String toString() {
        if (isDinheiro()) {
            return doador.getNome() + " doou R$" + valor + " ao projeto " + projeto.getNome() + ". Muito obrigado!";
        } else {
            return doador.getNome() + " doou " + itens + " itens ao projeto " + projeto.getNome() + ". Muito obrigada!";
        }
    }
}
