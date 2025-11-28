package classes;

public abstract class Pessoa {

    protected String nome;
    protected String CPF;
    protected String email;

    public Pessoa(String nome, String CPF, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    
    public abstract void exibirPerfil();
}
