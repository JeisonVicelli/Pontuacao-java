package principal.tela;

import java.util.Scanner;


import principal.controller.CadastroProduto;
import principal.db.BancoDeDados;
import principal.modelo.Produto;
import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaCadastroProdutos {
	
	public static void mostrar() {
	
	try (Scanner leitor = new Scanner(System.in)) {
		System.out.println();
		System.out.println(Mensagem.TELA_CADASTRO_DE_PRODUTOS);
		System.out.println(Mensagem.MSG_ESCOLHA);
		System.out.println("[1] " + Mensagem.MENU_LISTAR_PRODUTOS);
		System.out.println("[2] " + Mensagem.MENU_INCLUIR_PRODUTO);
		System.out.println("[3] " + Mensagem.MENU_ALTERAR_PRODUTO);
		System.out.println("[4] " + Mensagem.MENU_EXCLUIR_PRODUTO);
		System.out.println("[5] " + Mensagem.MENU_VOLTAR);
		System.out.println();
				
		Integer opcao = leitor.nextInt();
		
		switch (opcao) {
			case 1: {
				TelaCadastroProdutos.listar();
				break;
			}
			case 2: {
				TelaCadastroProdutos.incluir();
				break;
			}
			case 3: {
				TelaCadastroProdutos.alterar();
				break;
			}
			case 4: {
				TelaCadastroProdutos.excluir();
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
		System.out.println(Mensagem.MSG_LISTA_DE_PRODUTOS);
		
		if(BancoDeDados.produtos.isEmpty()) {
			System.out.println(Mensagem.MSG_NENHUM_PRODUTO);
		}else {
			for(Produto produto : BancoDeDados.produtos){
				System.out.println(produto.toString());				
			}
		}
		System.out.println();
		Prompt.pressionarEnter();
			TelaCadastroProdutos.mostrar();
			}			
		
		
		private static void incluir() {
			
			try (Scanner leitor1 = new Scanner(System.in)) {
				System.out.println();
				System.out.println(Mensagem.MSG_INCLUSAO_PRODUTO);
				System.out.println(Mensagem.MSG_INFORME_NOME);
				String nome = leitor1.nextLine();		
				System.out.println(Mensagem.MSG_INFORME_MARCA);
				String marca = leitor1.nextLine();			
				System.out.println(Mensagem.MSG_INFORME_CODBARRA);
				String codBarra = leitor1.nextLine();
				System.out.println(Mensagem.MSG_INFORME_VALOR);
				double valor = leitor1.nextDouble();
				System.out.println("Informe os pontos");
				int pontos = Prompt.lerInteiro();
				
				
				if (!nome.isEmpty() && !marca.isEmpty() && !codBarra.isEmpty()) {   
					CadastroProduto.adicionar(new Produto(nome, marca, codBarra, valor, pontos));
															
					System.out.println();
					try (Scanner entrada = new Scanner(System.in)) {
						String input;
						
						TelaCadastroProdutos.listar();
						
						
						do {
						    System.out.print("Pressione Enter para continuar: ");
						    input = entrada.nextLine();

						    if (!input.isEmpty()) {
						        System.out.println("Erro: entrada inválida!");
						    }
						} while (!input.isEmpty());
						
						TelaCadastroProdutos.mostrar();
					}
											
					}
			
				}
			}
				
				
				
		

		private static void alterar() {

			System.out.println();
			System.out.println(Mensagem.MSG_ALTERACAO_PRODUTO);
			System.out.println(Mensagem.MSG_INFORME_NOME_ORIGINALALTERAR);
			try (Scanner leitor2 = new Scanner(System.in)) {
				String produtoOriginal = leitor2.nextLine();
				if (!produtoOriginal.isEmpty()) {
					Produto produtoAlterar = CadastroProduto.localizar(produtoOriginal);
					System.out.println(produtoOriginal);
					
					if (produtoAlterar != null) {
						System.out.println(Mensagem.MSG_INFORME_DADOS_ALTERAR);
						System.out.println(Mensagem.MSG_INFORME_NOME);
						String nome = leitor2.nextLine();
						System.out.println(Mensagem.MSG_INFORME_MARCA);
						String marca = leitor2.nextLine();
						System.out.println(Mensagem.MSG_INFORME_CODBARRA);
						String codBarra = leitor2.nextLine();
						System.out.println(Mensagem.MSG_INFORME_VALOR);
						double valor = leitor2.nextDouble();
						
						if (!nome.isEmpty() && !marca.isEmpty()&& !codBarra.isEmpty()) { //falta colocar valor
							produtoAlterar.nome = nome;
							produtoAlterar.marca = marca;
							produtoAlterar.codBarra = codBarra;
							produtoAlterar.valor = valor;
							
														
							CadastroProduto.atualizar(produtoOriginal, produtoAlterar);
				
							System.out.println();
							System.out.println(Mensagem.MSG_PRODUTO_ALTERADO);
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
						
						TelaCadastroProdutos.mostrar();
				}
			}
			}
			
		
		}

		private static void excluir() {
			
			System.out.println();
			System.out.println(Mensagem.MSG_EXCLUSAO_PRODUTO);
			System.out.println(Mensagem.MSG_INFORME_NOME_ORIGINALEXCLUIR);	
			try (Scanner leitor3 = new Scanner(System.in)) {
				String nome = leitor3.nextLine();
				
				if (!nome.isEmpty()) {
					boolean produtoExcluido = CadastroProduto.excluir(nome);
					System.out.println();
					if (produtoExcluido) {
						System.out.println(Mensagem.MSG_PRODUTO_EXCLUIDO);
					} else {
						System.out.println(Mensagem.MSG_PRODUTO_NAO_ENCONTRADO);
					}
					System.out.println();
					
				TelaCadastroClientes.listar();
				}
			}
		}

}

