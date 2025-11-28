package classes;

public class Admin {
	private String nome;
    private String codigoAcesso ; // senha/código String

    public Admin(String nome) {
        this.nome = nome;
        this.codigoAcesso = "a2411min";
    }

    
    public boolean autenticar(String codigo) throws Exception {
    	//tratamento da entrada do código
        try {
            if (codigo == null || codigo.isEmpty()) {
                throw new IllegalArgumentException("Código não pode ser vazio.");
            }

            return this.codigoAcesso.equals(codigo);

        } catch (Exception e) {
            throw new Exception("Erro na autenticação: " + e.getMessage());
        }
    }

    public String getNome() { return nome; }
	

}
