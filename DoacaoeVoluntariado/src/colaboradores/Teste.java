package colaboradores;

import java.util.*;


public class Teste {

    private static Scanner sc = new Scanner(System.in);

    protected static List<ProjetoSocial> projetos = new ArrayList<>();
    protected static List<Doador> doadores = new ArrayList<>();
    protected static List<Voluntario> voluntarios = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar projeto");
            System.out.println("2 - Cadastrar doador");
            System.out.println("3 - Cadastrar voluntário");
            System.out.println("4 - Fazer doação");
            System.out.println("5 - Exibir projetos");
            System.out.println("6 - Admin");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarProjeto();
                case 2 -> cadastrarDoador();
                case 3 -> cadastrarVoluntario();
                case 4 -> fazerDoacao();
                case 5 -> exibirProjetos();
                case 6 -> validarProjeto();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    
    private static String nomeValido() {
    	String nome;
        while (true) {
            System.out.print("Nome: ");
            nome = sc.nextLine();

            try {
                if (nome == null || nome.trim().isEmpty()) {
                    throw new IllegalArgumentException("Nome não pode estar vazio.");
                }

                if (nome.trim().length() < 3) {
                    throw new IllegalArgumentException("O nome deve ter pelo menos 3 caracteres.");
                }

                if (!nome.matches("[A-Za-zÀ-ÿ ]+")) {
                    throw new IllegalArgumentException("O nome deve conter apenas letras.");
                }

                return nome; // válido → sai do while
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    	
    }
    
    private static Double doubleValido() {
    	double meta = 0.0;
    	while (true) {
    	    try {
    	        System.out.print("Digite a meta (valor decimal): ");
    	        String entrada = sc.nextLine();

    	        meta = Double.parseDouble(entrada);  // tenta converter para double

    	        return meta;  

    	    } catch (NumberFormatException e) {
    	        System.out.println("Erro: valor inválido! Digite um número decimal válido (ex: 2000.50).");
    	    }
    	}

    }
    
    private static int intValido() {
    	int prioridade;
        while (true) {
            System.out.print("Prioridade (número inteiro): ");

            try {
                String entrada = sc.nextLine();

                // tenta converter para inteiro
                prioridade = Integer.parseInt(entrada);

                // se chegou aqui, é válido → sai do while
                return prioridade;

            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite apenas números inteiros.");
            }
        }
	  
    }
  
	private static String cpfValido() {
		  String cpf;
	      while (true) {
	          System.out.print("CPF: ");
	          cpf = sc.nextLine();
	
	          try {
	              if (cpf.length()<11) {
	                  throw new IllegalArgumentException("CPF inválido! Digite novamente.");
	              }
	              return cpf; // sai do loop se estiver correto
	          } catch (Exception e) {
	              System.out.println(e.getMessage());
	          }
	      }
	  }
	 
	private static String emailValido() {
		 String email;
	        while (true) {
	            System.out.print("Email: ");
	            email = sc.nextLine();

	            try {
	                if (!email.contains("@")) {
	                    throw new IllegalArgumentException("Email inválido! Digite novamente.");
	                }
	                return email;//válido → sai do while
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        }
		 
	 }
	
	private static void listaProjetos() {
		if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto disponível!");
            return;
        }

        System.out.println("Escolha o projeto:");
        for (int i = 0; i < projetos.size(); i++)
            System.out.println(i + " - " + projetos.get(i).getNome());
		
	}
  
  

    private static void cadastrarProjeto() {
    	String nome= nomeValido();        

        System.out.print("Descrição: ");
        String desc = sc.nextLine();      
        
        
        int prioridade = intValido();


        System.out.println("Tipo de meta: 1-Dinheiro | 2-Itens");
        int tipo = sc.nextInt();
        sc.nextLine();

        ProjetoSocial p;

        if (tipo == 1) {
            System.out.print("Meta R$: ");
            double meta = doubleValido();
            System.out.print("Digite a meta (valor decimal): ");

            p = new ProjetoSocial(nome, desc, prioridade, meta);

        } else {
            List<String> itens = new ArrayList<>();
            System.out.println("Digite itens ('fim' para encerrar):");

            while (true) {
                String item = sc.nextLine();
                if (item.equals("fim")) break;
                itens.add(item);
            }

            p = new ProjetoSocial(nome, desc, prioridade, itens);
        }

        projetos.add(p);
        p.cadastrar();
    }

    private static void cadastrarDoador() {
    	String nome= nomeValido();

        String cpf = cpfValido();
        // ---------- Email ----------
        String email = emailValido();

        listaProjetos();

        int pIndex = sc.nextInt();
        sc.nextLine();

        ProjetoSocial projeto = projetos.get(pIndex);

        Doador d = new Doador(nome, cpf, email, projeto);
 
        doadores.add(d);
        d.cadastrar();
    }

    private static void cadastrarVoluntario() {
    	String nome= nomeValido();

        String cpf = cpfValido();

        String email = emailValido();

        System.out.print("Disponibilidade: ");
        String disp = sc.nextLine();

        System.out.print("Ação: ");
        String acao = sc.nextLine();

        listaProjetos();

        int pIndex = sc.nextInt();
        sc.nextLine();

        Voluntario v = new Voluntario(nome, cpf, email, disp, acao, projetos.get(pIndex));

        voluntarios.add(v);
        v.cadastrar();
    }
    
    public static void validarProjeto() {
        try {            
            String nomeAdmin = nomeValido();            
            
            System.out.print("Código de Acesso: ");
            String senha = sc.nextLine();
            
            Admin admin = new Admin(nomeAdmin);
        	
            boolean ok = admin.autenticar(senha);

            if (!ok) {
                System.out.println("Código de acesso incorreto. Validação negada.");
                return;
            }
            
            listaProjetos();

            int pIndex = sc.nextInt();
            sc.nextLine();

            ProjetoSocial projeto = projetos.get(pIndex);
            
            projeto.validar(nomeAdmin);
            

        } catch (Exception e) {
            System.out.println("Erro ao validar projeto: " + e.getMessage());
        }
    }

    private static void fazerDoacao() {
        if (doadores.isEmpty()) {
            System.out.println("Nenhum doador cadastrado!");
            return;
        }

        System.out.println("Escolha o doador:");
        for (int i = 0; i < doadores.size(); i++)
            System.out.println(i + " - " + doadores.get(i).getNome());

        int index = sc.nextInt();
        sc.nextLine();

        Doador d = doadores.get(index);
        ProjetoSocial p = d.getProjeto();

        System.out.println("Tipo de doação: 1 - Dinheiro | 2 - Item");
        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo == 1) {
            System.out.print("Valor R$: ");
            int valor = sc.nextInt();
            sc.nextLine();

            p.doarDinheiro(d, valor);

        } else {
            System.out.print("Item: ");
            String item = sc.nextLine();

            p.doarItem(d, item);
        }
    }


    private static void exibirProjetos() {
    	ProjetoSocial.ordemPrioridade(projetos);
   	
        for (ProjetoSocial p : projetos)
            p.exibirInfo();
    }
}
