package principal.tela;

import java.util.Scanner;

import principal.util.Mensagem;

public class TelaCadastros {
	
public static void mostrar() {
		
		try (Scanner leitor = new Scanner(System.in)) {
			System.out.println();
			System.out.println(Mensagem.TELA_CADASTROS);
			System.out.println(Mensagem.MSG_ESCOLHA);
			System.out.println("[1] " + Mensagem.MENU_CADASTRO_DE_PRODUTOS);
			System.out.println("[2] " + Mensagem.MENU_CADASTRO_DE_CLIENTES);
			System.out.println("[3] " + Mensagem.MENU_CADASTRO_DE_USUARIOS);
			System.out.println("[4] " + Mensagem.MENU_VOLTAR);
			
			Integer opcao = leitor.nextInt();
			
			switch (opcao) {
				case 1: {
					TelaCadastroProdutos.mostrar();
					break;
				}
				case 2: {
					TelaCadastroClientes.mostrar();
					break;
				}
				case 3: {
					TelaCadastroUsuarios.mostrar();
					break;
				}
				case 4: {
					TelaPrincipalUsuario.mostrar();
					break;
				}
			}
		}
	}

}
