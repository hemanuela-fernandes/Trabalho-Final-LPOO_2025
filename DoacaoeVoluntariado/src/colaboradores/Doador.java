package colaboradores;

import java.util.*;

public class Doador extends Pessoa implements Cadastro{

    private List<Doacao> doacoes = new ArrayList<>();
    private ProjetoSocial projeto;

    public Doador(String nome, String CPF, String email, ProjetoSocial projeto) {
        super(nome, CPF, email);
        this.projeto = projeto;
    }

    public ProjetoSocial getProjeto() {
        return projeto;
    }

    public void realizarDoacao(Doacao d) {
        doacoes.add(d);
        projeto.registrarDoacao(d);
        System.out.println(d);
    }

    @Override
    public void exibirPerfil() {
        System.out.println("Doador: " + nome + " | CPF: " + CPF);
    }
    
    @Override
    public void cadastrar() {
        System.out.println("Cadastro do Doador realizado com sucesso!");
    }
}
