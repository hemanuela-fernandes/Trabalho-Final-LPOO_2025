package colaboradores;

public abstract class Pessoa implements Verificavel, Cadastro {

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
    public boolean validar() {
        return nome != null && !nome.isBlank() &&
               CPF != null && CPF.length() == 11 &&
               email.contains("@");
    }

    @Override
    public void solicitarNovo() {
        System.out.println("Dados inválidos. Favor conferir novamente.");
    }

    @Override
    public void cadastrar() {
        System.out.println("Cadastro realizado com sucesso!");
    }

    public abstract void exibirPerfil();
}
