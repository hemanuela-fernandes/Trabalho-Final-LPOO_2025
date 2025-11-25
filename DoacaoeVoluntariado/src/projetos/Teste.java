package projetos;

import java.util.*;
import colaboradores.*;


public class Teste {

    private static Scanner sc = new Scanner(System.in);

    private static List<ProjetoSocial> projetos = new ArrayList<>();
    private static List<Doador> doadores = new ArrayList<>();
    private static List<Voluntario> voluntarios = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Criar projeto");
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
                case 1 -> criarProjeto();
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

    private static void criarProjeto() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Descrição: ");
        String desc = sc.nextLine();

        System.out.print("Prioridade: ");
        int prioridade = sc.nextInt();
        sc.nextLine();

        System.out.println("Tipo de meta: 1-Dinheiro | 2-Itens");
        int tipo = sc.nextInt();
        sc.nextLine();

        ProjetoSocial p;

        if (tipo == 1) {
            System.out.print("Meta R$: ");
            int meta = sc.nextInt();
            sc.nextLine();

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
        System.out.println("Projeto criado!");
    }

    private static void cadastrarDoador() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        String cpf;
        while (true) {
            System.out.print("CPF: ");
            cpf = sc.nextLine();

            try {
                if (cpf.length()<11) {
                    throw new IllegalArgumentException("CPF inválido! Digite novamente.");
                }
                break; // sai do loop se estiver correto
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // ---------- Email ----------
        String email;
        while (true) {
            System.out.print("Email: ");
            email = sc.nextLine();

            try {
                if (!email.contains("@")) {
                    throw new IllegalArgumentException("Email inválido! Digite novamente.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto disponível!");
            return;
        }

        System.out.println("Escolha o projeto:");
        for (int i = 0; i < projetos.size(); i++)
            System.out.println(i + " - " + projetos.get(i).getNome());

        int pIndex = sc.nextInt();
        sc.nextLine();

        ProjetoSocial projeto = projetos.get(pIndex);

        Doador d = new Doador(nome, cpf, email, projeto);
 
        doadores.add(d);
        System.out.println("Doador cadastrado!");
    }

    private static void cadastrarVoluntario() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        String cpf;
        while (true) {
            System.out.print("CPF: ");
            cpf = sc.nextLine();

            try {
                if (cpf.length()<11) {
                    throw new IllegalArgumentException("CPF inválido! Digite novamente.");
                }
                break; // sai do loop se estiver correto
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String email;
        while (true) {
            System.out.print("Email: ");
            email = sc.nextLine();

            try {
                if (!email.contains("@")) {
                    throw new IllegalArgumentException("Email inválido! Digite novamente.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Disponibilidade: ");
        String disp = sc.nextLine();

        System.out.print("Ação: ");
        String acao = sc.nextLine();

        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto disponível!");
            return;
        }

        System.out.println("Escolha o projeto:");
        for (int i = 0; i < projetos.size(); i++)
            System.out.println(i + " - " + projetos.get(i).getNome());

        int pIndex = sc.nextInt();
        sc.nextLine();

        Voluntario v = new Voluntario(nome, cpf, email, disp, acao, projetos.get(pIndex));

        voluntarios.add(v);
        System.out.println("Voluntário cadastrado!");
    }
    
    public static void validarProjeto() {
        try {
        	System.out.print("Nome do Admin: ");
            String nomeAdmin = sc.nextLine();
            
            System.out.print("Código de Acesso: ");
            String senha = sc.nextLine();
            
            Admin admin = new Admin(nomeAdmin);
        	
            boolean ok = admin.autenticar(senha);

            if (!ok) {
                System.out.println("Código de acesso incorreto. Validação negada.");
                return;
            }
            
            if (projetos.isEmpty()) {
                System.out.println("Nenhum projeto disponível!");
                return;
            }

            System.out.println("Escolha o projeto:");
            for (int i = 0; i < projetos.size(); i++)
                System.out.println(i + " - " + projetos.get(i).getNome());

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
    
    public static void ordemPrioridade(List<ProjetoSocial> projetos) {
    	Collections.sort(projetos,
    	        Comparator.comparingInt(ProjetoSocial::getPrioridade));
    }

    private static void exibirProjetos() {
    	ordemPrioridade(projetos);
   	
        for (ProjetoSocial p : projetos)
            p.exibirInfo();
    }
}
