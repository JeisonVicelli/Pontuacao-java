package principal.tela;

import java.util.Scanner;


import principal.util.Mensagem;

public class TelaPrincipalUsuario {
	
public static void mostrar() {
					
		try (Scanner leitor = new Scanner(System.in)) {
			System.out.println();
			System.out.println(Mensagem.TELA_PRINCIPAL);
			System.out.println(Mensagem.MSG_ESCOLHA);
			System.out.println("[1] " + Mensagem.MENU_CADASTROS);
			System.out.println("[2] " + Mensagem.MENU_CONTROLE_PEDIDOS);
			System.out.println("[3] " + Mensagem.MENU_VENDAS);
			System.out.println("[4] " + Mensagem.MENU_CLIENTE);
			System.out.println("[5] " + Mensagem.MENU_SAIR);
			
			Integer opcao = leitor.nextInt();
			
			switch (opcao) {
				case 1: {
					TelaCadastros.mostrar();	
					break;
				}
				case 2: {
					TelaControlePedidos.mostrar();	
					break;
				}
				case 3: {						
					TelaVenda.mostrar();                    	
					break;
				}
				case 4:{
					TelaCliente.mostrar();
				}
				case 5: {
					System.out.println();
					System.out.println(Mensagem.MSG_PROGRAMA_ENCERRADO);	
					break;
				}
			}
		}
	}

}
