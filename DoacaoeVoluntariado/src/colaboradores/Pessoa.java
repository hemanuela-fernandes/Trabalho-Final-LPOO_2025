package colaboradores;

public abstract class Pessoa implements Cadastro {

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


    @Override
    public void cadastrar() {
        System.out.println("Cadastro realizado com sucesso!");
    }

    public abstract void exibirPerfil();
}
