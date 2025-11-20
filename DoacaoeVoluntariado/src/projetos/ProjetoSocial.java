package projetos;

import java.util.*;
import colaboradores.Doador;
import colaboradores.Voluntario;

public class ProjetoSocial {

    private String nome;
    private String descricao;
    private int prioridade;
    private Date dataCadastro;

    private Integer metaDinheiro;
    private int totalArrecadado = 0;

    private List<String> metaItens;
    private List<String> itensRecebidos = new ArrayList<>();

    private List<Doador> doadores = new ArrayList<>();
    private List<Voluntario> voluntarios = new ArrayList<>();
    private List<Doacao> doacoes = new ArrayList<>();

    public ProjetoSocial(String nome, String descricao, int prioridade, int metaDinheiro) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.metaDinheiro = metaDinheiro;
        this.dataCadastro = new Date();
    }

    public ProjetoSocial(String nome, String descricao, int prioridade, List<String> metaItens) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.metaItens = metaItens;
        this.dataCadastro = new Date();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarVoluntario(Voluntario v) {
        voluntarios.add(v);
    }

    public void registrarDoacao(Doacao d) {
        doacoes.add(d);
        if (!doadores.contains(d.getDoador())) {
            doadores.add(d.getDoador());
        }
    }

    public void doarDinheiro(Doador doador, int valor) {
        if (metaDinheiro == null) {
            System.out.println("Projeto aceita apenas itens!");
            return;
        }
        totalArrecadado += valor;
        registrarDoacao(new Doacao(doador, this, valor));

        if (totalArrecadado >= metaDinheiro) {
            System.out.println("\n🎉 META ATINGIDA! Obrigado!");
        }
    }

    public void doarItem(Doador doador, String item) {
        if (metaItens == null) {
            System.out.println("Projeto aceita apenas dinheiro!");
            return;
        }
        itensRecebidos.add(item);
        registrarDoacao(new Doacao(doador, this, item));

        if (itensRecebidos.containsAll(metaItens)) {
            System.out.println("\n🎉 META DE ITENS ATINGIDA!");
        }
    }

    public void exibirInfo() {
        System.out.println("\n=== PROJETO: " + nome + " ===");
        System.out.println("Descrição: " + descricao);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("Data: " + dataCadastro);

        if (metaDinheiro != null) {
            System.out.println("Meta financeira: R$" + metaDinheiro);
            System.out.println("Arrecadado: R$" + totalArrecadado);
        } else {
            System.out.println("Meta de itens: " + metaItens);
            System.out.println("Itens recebidos: " + itensRecebidos);
        }

        System.out.println("Voluntários: " + voluntarios.size());
        System.out.println("Doadores: " + doadores.size());
    }
}
