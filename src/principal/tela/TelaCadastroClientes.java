package principal.tela;

import java.util.Scanner;
import principal.controller.CadastroClientes;
import principal.db.BancoDeDados;
import principal.modelo.Cliente;
import principal.util.Mensagem;
import principal.util.Prompt;


public class TelaCadastroClientes {


public static void mostrar() {
	
	try (Scanner leitor = new Scanner(System.in)) {
		System.out.println();
		System.out.println(Mensagem.TELA_CADASTRO_DE_CLIENTES);
		System.out.println(Mensagem.MSG_ESCOLHA);
		System.out.println("[1] " + Mensagem.MENU_LISTAR_CLIENTES);
		System.out.println("[2] " + Mensagem.MENU_INCLUIR_CLIENTE);
		System.out.println("[3] " + Mensagem.MENU_ALTERAR_CLIENTE);
		System.out.println("[4] " + Mensagem.MENU_EXCLUIR_CLIENTE);
		System.out.println("[5] " + Mensagem.MENU_VOLTAR);
		System.out.println();
				
		Integer opcao = leitor.nextInt();
		
		switch (opcao) {
			case 1: {
				TelaCadastroClientes.listar();
				break;
			}
			case 2: {
				TelaCadastroClientes.incluir();
				break;
			}
			case 3: {
				TelaCadastroClientes.alterar();
				break;
			}
			case 4: {
				TelaCadastroClientes.excluir();
				break;
			}
			case 5: {
				TelaPrincipalUsuario.mostrar();
				break;
			}
		}
	}
	}

	public static void listar() {
		
		System.out.println();
		System.out.println(Mensagem.MSG_LISTA_DE_CLIENTES);
		
		if(BancoDeDados.clientes.isEmpty()) {
			System.out.println(Mensagem.MSG_NENHUM_CLIENTE);
		}else {
			for(Cliente cliente : BancoDeDados.clientes){
				System.out.println(cliente.toString());				
			}
		}
		System.out.println();
		System.out.println();
		Prompt.pressionarEnter();
			
			TelaCadastroClientes.mostrar();
		}
			
		
		
		private static void incluir() {
			
			try (Scanner leitor1 = new Scanner(System.in)) {
				System.out.println();
				System.out.println(Mensagem.MSG_INCLUSAO_CLIENTE);
				System.out.println(Mensagem.MSG_INFORME_NOME);
				String nome = leitor1.nextLine();		
				System.out.println(Mensagem.MSG_INFORME_CPF);
				String cpf = leitor1.nextLine();			
				System.out.println(Mensagem.MSG_INFORME_DATANASCIMENTO);
				String dataNascimento = leitor1.nextLine();
				System.out.println(Mensagem.MSG_INFORME_TELEFONE);
				String telefone = leitor1.nextLine();
				System.out.println("Informe valor de pontos inicial dio cliente");
				int pontos = Prompt.lerInteiro();
				
				
				if (!nome.isEmpty() && !cpf.isEmpty() && !dataNascimento.isEmpty() && !telefone.isEmpty()) {
					CadastroClientes.incluir(new Cliente(nome, cpf, dataNascimento, telefone, pontos));
					System.out.println(Mensagem.MSG_CADASTRO_SUCESSO);
															
					System.out.println();
					System.out.println();
					Prompt.pressionarEnter();
					TelaCadastroClientes.mostrar();
					}
					}
				}
							
		

		private static void alterar() {

			System.out.println();
			System.out.println(Mensagem.MSG_ALTERACAO_CLIENTE);
			System.out.println(Mensagem.MSG_INFORME_NOME_ORIGINALALTERAR);
			try (Scanner leitor2 = new Scanner(System.in)) {
				String clienteOriginal = leitor2.nextLine();
				if (!clienteOriginal.isEmpty()) {
					Cliente clienteAlterar = CadastroClientes.localizar(clienteOriginal);
					
					if (clienteAlterar != null) {
						System.out.println(Mensagem.MSG_INFORME_NOME);
						String nome = leitor2.nextLine();
						System.out.println(Mensagem.MSG_INFORME_CPF);
						String cpf = leitor2.nextLine();
						System.out.println(Mensagem.MSG_INFORME_TELEFONE);
						String telefone = leitor2.nextLine();
						System.out.println(Mensagem.MSG_INFORME_DATANASCIMENTO);
						String dataNascimento = leitor2.nextLine();
						System.out.println("Informe valor de pontos inicial dio cliente");
						int pontos = Prompt.lerInteiro();
						
						if (!nome.isEmpty() && !cpf.isEmpty()) {
							clienteAlterar.nome = nome;
							clienteAlterar.CPF = cpf;
							clienteAlterar.telefone = telefone;
							clienteAlterar.dataNascimento = dataNascimento;
							clienteAlterar.pontos = pontos;
							
							CadastroClientes.atualizar(clienteOriginal, clienteAlterar);
				
							System.out.println();
							System.out.println(Mensagem.MSG_CLIENTE_ALTERADO);
						}	
					} else {
						System.out.println();
						System.out.println(Mensagem.MSG_CLIENTE_NAO_ENCONTRADO);
					}	
					System.out.println();
					try (Scanner entrada = new Scanner(System.in)) {
						String input;
						
						
						do {
						    System.out.print("Pressione Enter para continuar: ");
						    input = entrada.nextLine();

						    if (!input.isEmpty()) {
						        System.out.println("Erro: entrada inválida!");
						    }
						} while (!input.isEmpty());
					}
			        TelaCadastroClientes.mostrar();
			    }
			}
			
			
		}

		private static void excluir() {
			
			System.out.println();
			System.out.println(Mensagem.MSG_EXCLUSAO_CLIENTE);
			System.out.println(Mensagem.MSG_INFORME_NOME_ORIGINALEXCLUIR);	
			try (Scanner leitor3 = new Scanner(System.in)) {
				String nome = leitor3.nextLine();
				
				if (!nome.isEmpty()) {
					boolean clienteExcluido = CadastroClientes.excluir(nome);
					System.out.println();
					if (clienteExcluido) {
						System.out.println(Mensagem.MSG_CLIENTE_EXCLUIDO);
					} else {
						System.out.println(Mensagem.MSG_CLIENTE_NAO_ENCONTRADO);
					}
					System.out.println();
					
				TelaCadastroClientes.listar();
				}
			}
		}
		
}
			
		
		
		
	






