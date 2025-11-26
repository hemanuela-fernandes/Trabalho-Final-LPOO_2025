package colaboradores;

import java.util.*;

public class ProjetoSocial implements Cadastro{

    private String nome;
	private String descricao;
    private int prioridade;
    private Date dataCadastro;
    private boolean validado = false;

    private Double metaDinheiro;
    private int totalArrecadado = 0;

    private List<String> metaItens;
    private List<String> itensRecebidos = new ArrayList<>();

    private List<Doador> doadores = new ArrayList<>();
    private List<Voluntario> voluntarios = new ArrayList<>();
    private List<Doacao> doacoes = new ArrayList<>();
    
    //temos dois construtores pois temos dois tipos de metas

    public ProjetoSocial(String nome, String descricao, int prioridade, Double metaDinheiro) {
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
    
    public int getPrioridade() {
		return prioridade;
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
        String valido;
		if(validado) {
			valido = "Validado";
		}else {
			valido="Não validado";
		}
		System.out.println("Situação: "+ valido);
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
    
    public void validar(String nomeAdmin) {
        this.validado = true;
        System.out.println("Projeto \"" + nome + "\" validado pelo Admin"+nomeAdmin+" com sucesso!");
    }

    public boolean isValidado() {
        return validado;
    }
    
    public static void ordemPrioridade(List<ProjetoSocial> projetos) {
    	Collections.sort(projetos,
    	        Comparator.comparingInt(ProjetoSocial::getPrioridade));
    }
    
	@Override
	public String toString() {
		String valido;
		if(validado) {
			valido = "Validado";
		}else {
			valido="Nao validado";
		}
		return "Projeto: " + nome +
		           " | Descrição: " + descricao;
	}

	@Override
	public void cadastrar() {
		System.out.println("Cadastro de Projeto Social realizado com sucesso!");
		
	}

}


