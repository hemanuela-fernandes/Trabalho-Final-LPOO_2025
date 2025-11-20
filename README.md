# Trabalho-Final-LPOO_2025

Olá chat, estou fazendo um trabalho de LPOO com o tema Doação e Voluntáriado. Temos a seguinte ideia: 

Interface Registro
- registra Doações, Doador, Voluntario, Projeto Social

Interface Verificavel
- a ideia é que tenha um ADM que consiga acessar as informações para fazer as verificações, porem essa interface seja para verificação quando se escreve errado, tratamento de erros, etc , ou seja, aviso e verificação de formatação
- validar()
-solicitarNovo()

Classe Abstrata Pessoa
- implements Verificavel e Cadastro
- private String nome, CPF, email;
- exibirPerfil();
- getters e setters

Projeto Social implements Cadastro
- String nome, descricao
-  meta (quando atinge o valor da meta, não aceita mais doação e imprime mensagem agradecendo
- possui data de cadastro
- prioridade

quero que seja generico porque a meta pode ser itens em String ou dinheiro em Integer, quero que me ajude a desenvolver isso

Aqui serão cadastrados os pedidos de ajuda

Doador extends Pessoa
- doacoes: <List> Doacao
- precisa estar ligado a um projeto social
- ao usar realizarDoacao() chama a classe Doacao, se possivel

Doacao extends Doador
- precisa saber o doador
- data da doacao
se fosse dinheiro iria receber Integer e se fosse itens seria String, e isso adiciona a List de doações do Doador e incrementa na meta do Projeto Social

- doar(<T> doacoes)
-public String toString() {
		-return nome + "doou " + doação + " para o projeto " + projetoSocial + "\n Muito Obrigada!";

Voluntario extends Pessoa
- String acao, disponibilidade
- solicitarDados()
precisa ser ligado a um projeto social

E por fim, na classe executavel Teste, será tipo um menu com as opcoes: realizar doacao, ser voluntario, lista de ajuda, login adm

no login adm, vai pedir login e senha, e somente assim com um login especifico vai poder validar projetos, por exemplo, colocar um projeto social na lista de espera

na lista de ajuda vai aparecer a lista de projetos sociais com suas informacoes, voluntarios, doadores e total de doacoes
se esse projeto ja atingiu a meta, aparece uma mensagem agradecendo e avisando que nao aceita mais doacoes

no realizar doacoes vai ter opcoes de projetos sociais para doar e a pessoa vai colocar seus dados para ser registrado no sistema

no ser voluntario a pessoa vai se cadastrar em um projeto social e colocar suas informações
 
