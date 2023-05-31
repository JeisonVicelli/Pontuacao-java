package principal.tela;

import principal.controller.CadastroBrindes;
import principal.controller.CadastroClientes;
import principal.controller.ControlePontos;
import principal.db.BancoDeDados;
import principal.modelo.Brinde;
import principal.modelo.Cliente;
import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaCliente {
	
	public static void mostrar() {
		
		//System.out.println();
		//System.out.println(Mensagem.TELA_INICIAL);
		System.out.println();
		System.out.println(Mensagem.MSG_ESCOLHA);
		System.out.println("[1] " + Mensagem.MENU_LISTAR_PONTOS);
		System.out.println("[2] " + Mensagem.MENU_TROCAR_PONTOS);
		System.out.println("[3] " + Mensagem.MENU_VOLTAR);
		
		System.out.println();
				
		Integer opcao = Prompt.lerInteiro();
		
		switch (opcao) {
			case 1: {
				TelaCliente.listarPontos();
				break;
			}
			case 2: {
				TelaCliente.trocarPontos();
				break;
			}
			case 3: {
				TelaInicial.mostrar();
			}
		}
		Prompt.linhaEmBranco();
	}
			
		public static void listarPontos() {		
		System.out.println(Mensagem.MSG_INFORME_NOME);
		String nome = Prompt.lerLinha();
		
		if(BancoDeDados.clientes.isEmpty()) {
			System.out.println(Mensagem.MSG_NENHUM_CLIENTE);
		}else {
			Cliente cliente = CadastroClientes.localizar(nome);	
			
			if(cliente == null) {				
				System.out.println(Mensagem.MSG_CLIENTE_NAO_ENCONTRADO);
			}else {
				System.out.println("Pontos de " + cliente.getNome() + ": " + cliente.getPontos());
			}
			
			Prompt.pressionarEnter();
			TelaCliente.mostrar();
		}
		}			
		
		public static void trocarPontos() {
			System.out.println(Mensagem.MSG_INFORME_NOME);
			String nome = Prompt.lerLinha();
			
			if(BancoDeDados.clientes.isEmpty()) {
				System.out.println(Mensagem.MSG_NENHUM_CLIENTE);
			}else {
				Cliente cliente = CadastroClientes.localizar(nome);	
				
				if(cliente == null) {				
					System.out.println(Mensagem.MSG_CLIENTE_NAO_ENCONTRADO);
				}else {
					System.out.println("Pontos de " + cliente.getNome() + ": " + cliente.getPontos());
				}
				
				ControlePontos.exibirListaBrindes();
					
					System.out.println("Informe o nome do brinde que deseja trocar por seus pontos: ");
			        String nomeBrinde = Prompt.lerLinha();
			        Brinde brinde = CadastroBrindes.localizar(nomeBrinde);

			        if (brinde == null) {
			            System.out.println("Brinde não encontrado.");
			            
			        } else {
			            ControlePontos.realizarTroca(cliente, brinde);
			        }	
			        TelaCliente.mostrar();
			}
		}
}
		
			
		