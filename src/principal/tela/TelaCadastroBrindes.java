package principal.tela;

import java.util.Scanner;

import principal.controller.CadastroBrindes;
import principal.db.BancoDeDados;
import principal.modelo.Brinde;
import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaCadastroBrindes {
	
public static void mostrar() {
	
	try (Scanner leitor = new Scanner(System.in)) {
		System.out.println();
		System.out.println(Mensagem.TELA_CADASTRO_DE_BRINDES);
		System.out.println(Mensagem.MSG_ESCOLHA);
		System.out.println("[1] " + Mensagem.MENU_LISTAR_BRINDES);
		System.out.println("[2] " + Mensagem.MENU_INCLUIR_BRINDE);
		System.out.println("[3] " + Mensagem.MENU_ALTERAR_BRINDE);
		System.out.println("[4] " + Mensagem.MENU_EXCLUIR_BRINDE);
		System.out.println("[5] " + Mensagem.MENU_VOLTAR);
		System.out.println();
				
		Integer opcao = leitor.nextInt();
		
		switch (opcao) {
			case 1: {
				TelaCadastroBrindes.listar();
				break;
			}
			case 2: {
				TelaCadastroBrindes.incluir();
				break;
			}
			case 3: {
				TelaCadastroBrindes.alterar();
				break;
			}
			case 4: {
				TelaCadastroBrindes.excluir();
				break;
			}
			case 5: {
				TelaCadastros.mostrar();
				break;
			}
			
		}
		leitor.close();
	}
	
	}

	public static void listar() {
		
		System.out.println();
		System.out.println(Mensagem.MSG_LISTA_DE_BRINDES);
		
		if(BancoDeDados.brindes.isEmpty()) {
			System.out.println(Mensagem.MSG_NENHUM_BRINDE);
		}else {
			for(Brinde brinde : BancoDeDados.brindes){
				System.out.println(brinde.toString());				
			}
		}
		System.out.println();
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
			TelaCadastroBrindes.mostrar();
			
		}
		
		}	
		
		
		private static void incluir() {
			
			
				System.out.println();
				System.out.println(Mensagem.MSG_INCLUSAO_BRINDE);
				System.out.println(Mensagem.MSG_INFORME_NOME);
				String nome = Prompt.lerLinha();		
				System.out.println(Mensagem.MSG_INFORME_PONTO);
				int valorPontos = Prompt.lerInteiro();										
				
				if (!nome.isEmpty() && valorPontos != 0) { //colocar condição para obrigar a colocar valor de ponto
					CadastroBrindes.incluir(new Brinde(nome, valorPontos));
					System.out.println(Mensagem.MSG_CADASTRO_SUCESSO);
				} else {
				    System.out.println("Por favor, preencha todos os campos corretamente.");
				}															
					System.out.println();
					System.out.println();
					Prompt.pressionarEnter();
					TelaCadastroBrindes.mostrar();			
						
					}
				

		private static void alterar() {

			System.out.println();
			System.out.println(Mensagem.MSG_ALTERACAO_BRINDE);
			System.out.println(Mensagem.MSG_INFORME_NOME_ORIGINALALTERAR);
			try (Scanner leitor2 = new Scanner(System.in)) {
				String brindeOriginal = leitor2.nextLine();
				if (!brindeOriginal.isEmpty()) {
					Brinde brindeAlterar = CadastroBrindes.localizar(brindeOriginal);
					
					if (brindeAlterar != null) {
						System.out.println(Mensagem.MSG_INFORME_NOME);
						String nome = Prompt.lerLinha();
						System.out.println(Mensagem.MSG_INFORME_PONTO);
						int valorPontos = Prompt.lerInteiro();						
						
						if (!nome.isEmpty() && valorPontos != 0) {
							brindeAlterar.nome = nome;
							brindeAlterar.valorPontos = valorPontos;
							
							
							CadastroBrindes.atualizar(brindeOriginal, brindeAlterar);
				
							System.out.println();
							System.out.println(Mensagem.MSG_BRINDE_ALTERADO);
						}	
					} else {
						System.out.println();
						System.out.println(Mensagem.MSG_BRINDE_NAO_ENCONTRADO);
					}	
					System.out.println();
					Prompt.pressionarEnter();
					TelaCadastroBrindes.mostrar();
					}
			}
		}
		

		private static void excluir() {
			
			System.out.println();
			System.out.println(Mensagem.MSG_EXCLUSAO_BRINDE);
			System.out.println(Mensagem.MSG_INFORME_NOME_ORIGINALEXCLUIR);	
			try (Scanner leitor3 = new Scanner(System.in)) {
				String nome = leitor3.nextLine();
				
				if (!nome.isEmpty()) {
					boolean brindeExcluido = CadastroBrindes.excluir(nome);
					System.out.println();
					if (brindeExcluido) {
						System.out.println(Mensagem.MSG_BRINDE_EXCLUIDO);
					} else {
						System.out.println(Mensagem.MSG_BRINDE_NAO_ENCONTRADO);
					}
					System.out.println();
					
				
				}
				TelaCadastroBrindes.listar();
				leitor3.close();

			}

		}
		
		

}
