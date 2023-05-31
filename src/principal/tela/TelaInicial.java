package principal.tela;

import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaInicial {
	
	public static void mostrar() {
		
			System.out.println();
			System.out.println(Mensagem.TELA_INICIAL);
			System.out.println();
			System.out.println(Mensagem.MSG_ESCOLHA);
			System.out.println("[1] " + Mensagem.MENU_USUARIO);
			System.out.println("[2] " + Mensagem.MENU_CLIENTE);
			
			System.out.println();
					
			Integer opcao = Prompt.lerInteiro();
			
			switch (opcao) {
				case 1: {
					TelaLogin.mostrar();
					break;
				}
				case 2: {
					TelaCliente.mostrar();
					break;
				}
			}
		}
	}

			


