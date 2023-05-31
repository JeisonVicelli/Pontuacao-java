package principal.tela;

import java.util.Scanner;

import principal.controller.CadastroUsuario;
import principal.db.BancoDeDados;
import principal.modelo.Usuario;
import principal.util.Mensagem;


public class TelaCadastroUsuarios {
	
public static void mostrar() {
		
		try (Scanner leitor = new Scanner(System.in)) {
			System.out.println();
			System.out.println(Mensagem.TELA_CADASTRO_DE_USUARIOS);
			System.out.println(Mensagem.MSG_ESCOLHA);
			System.out.println("[1] " + Mensagem.MENU_LISTAR_USUARIOS);
			System.out.println("[2] " + Mensagem.MENU_INCLUIR_USUARIO);
			System.out.println("[3] " + Mensagem.MENU_ALTERAR_USUARIO);
			System.out.println("[4] " + Mensagem.MENU_EXCLUIR_USUARIO);
			System.out.println("[5] " + Mensagem.MENU_VOLTAR);
			
			Integer opcao = leitor.nextInt();
			
			switch (opcao) {
				case 1: {
					TelaCadastroUsuarios.listar();
					break;
				}
				case 2: {
					TelaCadastroUsuarios.incluir();
					break;
				}
				case 3: {
					TelaCadastroUsuarios.alterar();
					break;
				}
				case 4: {
					TelaCadastroUsuarios.excluir();
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
		System.out.println(Mensagem.MSG_LISTA_DE_USUARIOS);
		
		if (BancoDeDados.usuarios.isEmpty()) {
			System.out.println(Mensagem.MSG_NENHUM_USUARIO); 
		} else {
			for (Usuario usuario : BancoDeDados.usuarios) {
				System.out.println(usuario.toString());
			}
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
			
			TelaCadastroUsuarios.mostrar();
		}
	}
		
	
		

	private static void incluir() {
		
		System.out.println();
		System.out.println(Mensagem.MSG_INCLUSAO_USUARIO);		
		System.out.println(Mensagem.MSG_INFORME_NOME);
		try (Scanner leitor = new Scanner(System.in)) {
			String nome = leitor.nextLine();
			System.out.println(Mensagem.MSG_INFORME_CPF);
			String cpf = leitor.nextLine();
			System.out.println(Mensagem.MSG_INFORME_LOGIN);		
			String login = leitor.nextLine();
			System.out.println(Mensagem.MSG_INFORME_SENHA);
			String senha = leitor.nextLine();
			
			if (!nome.isEmpty() && !cpf.isEmpty() && !login.isEmpty() && !senha.isEmpty()){
				CadastroUsuario.adicionar(new Usuario(nome, cpf, login, senha));
				System.out.println(Mensagem.MSG_CADASTRO_SUCESSO);
				
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
					
					TelaCadastroUsuarios.mostrar();
				}
			}
		}
	}
	

	private static void alterar() {
		
		System.out.println();
		System.out.println(Mensagem.MSG_ALTERACAO_USUARIO);
		System.out.println(Mensagem.MSG_INFORME_NOME_ORIGINALALTERAR);
		try (Scanner leitor2 = new Scanner(System.in)) {
			String nomeOriginal = leitor2.nextLine();
			
			if (!nomeOriginal.isEmpty()) {
				Usuario usuarioAlterar = CadastroUsuario.localizar(nomeOriginal);
				System.out.println(nomeOriginal);
				
				if (usuarioAlterar != null) {
					System.out.println(Mensagem.MSG_INFORME_NOME);
					String nome = leitor2.nextLine();
					System.out.println(Mensagem.MSG_INFORME_CPF);
					String cpf = leitor2.nextLine();
					System.out.println(Mensagem.MSG_INFORME_LOGIN);
					String login = leitor2.nextLine();
					System.out.println(Mensagem.MSG_INFORME_SENHA);
					String senha = leitor2.nextLine();							
					
					if (!nome.isEmpty() && !cpf.isEmpty() && !login.isEmpty() && !senha.isEmpty()){
						usuarioAlterar.nome = nome;
						usuarioAlterar.CPF = cpf;
						usuarioAlterar.login = login;
						usuarioAlterar.senha = senha;
						
						CadastroUsuario.atualizar(nomeOriginal, usuarioAlterar);
			
						System.out.println();
						System.out.println(Mensagem.MSG_USUARIO_ALTERADO);
					}
				} else {
					System.out.println();
					System.out.println(Mensagem.MSG_USUARIO_NAO_ENCONTRADO);
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
					
					TelaCadastroUsuarios.listar();
				}
			}
		}
	}
	

	private static void excluir() {
		
		System.out.println();
		System.out.println(Mensagem.MSG_EXCLUSAO_USUARIO);
		System.out.println(Mensagem.MSG_INFORME_NOME_ORIGINALEXCLUIR);
		try (Scanner leitor3 = new Scanner(System.in)) {
			String nome = leitor3.nextLine();
			
			if (!nome.isEmpty()) {
				boolean usuarioExcluido = CadastroUsuario.excluir(nome);
				
				System.out.println();
				if (usuarioExcluido) {
					System.out.println(Mensagem.MSG_USUARIO_EXCLUIDO);
				} else {
					System.out.println(Mensagem.MSG_USUARIO_NAO_ENCONTRADO);
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
					
					TelaCadastroUsuarios.listar();
				}
			}
		}
	}
}
	


