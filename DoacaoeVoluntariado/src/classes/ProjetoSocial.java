package classes;

import java.util.*;

public class ProjetoSocial <T extends Number> implements Cadastro{

    private String nome;
	private String descricao;
    private int prioridade;
    private Date dataCadastro;
    private boolean validado = false;
    private Meta<T> meta;   



    private List<Doador> doadores = new ArrayList<>();
    private List<Voluntario> voluntarios = new ArrayList<>();
    private List<Doacao> doacoes = new ArrayList<>();
    
    

    public ProjetoSocial(String nome, String descricao, int prioridade, Meta<T> meta) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.meta = meta;
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

    public Meta<T> getMeta() {
        return meta;
    }

    public void realizarDoacao(Doador doador, double valor) {
        if (meta.getPercentual() >= 100.0) {
            System.out.println("A meta já foi atingida! Não é possível receber mais doações.");
            return;
        }
        Doacao d = new Doacao(doador, this, valor);
        registrarDoacao(d);
        meta.adicionarDoacao(valor);
        //cadastrar();
        System.out.println(d);
    }

    public void mostrarStatusDaMeta() {
        System.out.println("\n--- Status da Meta ---");
        System.out.println("Meta total: " + meta.getMetaTotal());
        System.out.println("Total arrecadado: " + meta.getProgresso());
        System.out.printf("Progresso: %.2f%%\n", meta.getPercentual());

        if (meta.getPercentual() >= 100) {
            System.out.println("🎉 Meta atingida! Muito obrigado!\n");
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
        System.out.println("Voluntários: " + voluntarios.size());
        System.out.println("Doadores: " + doadores.size());
        mostrarStatusDaMeta();
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
		System.out.println("Cadastro de doação realizado com sucesso!");
		
	}

}


