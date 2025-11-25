package colaboradores;

import projetos.ProjetoSocial;

public class Voluntario extends Pessoa {

    private String disponibilidade;
    private String acao;
    private ProjetoSocial projeto;

    public Voluntario(String nome, String CPF, String email,
                      String disponibilidade, String acao, ProjetoSocial projeto) {

        super(nome, CPF, email);
        this.disponibilidade = disponibilidade;
        this.acao = acao;
        this.projeto = projeto;

        projeto.adicionarVoluntario(this);
    }

    @Override
    public void exibirPerfil() {
        System.out.println("Voluntário: " + nome + " | Ação: " + acao);
    }
}
