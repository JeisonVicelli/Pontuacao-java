package principal.tela;

import java.util.Scanner;

import principal.controller.ControlePedidos;
import principal.db.BancoDeDados;
import principal.modelo.Pedido;
import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaControlePedidos {
	
public static void mostrar() {
	
		System.out.println();		
		System.out.println(Mensagem.TELA_PEDIDOS);
		try (Scanner leitor = new Scanner(System.in)) {
			System.out.println(Mensagem.MSG_ESCOLHA);
			System.out.println("[1] " + Mensagem.MENU_LISTAR_PEDIDOS);
			System.out.println("[2] " + Mensagem.MENU_CANCELAR_PEDIDO);
			System.out.println("[3] " + Mensagem.MENU_VOLTAR);
			
			int opcao = Prompt.lerInteiro();

			switch (opcao) {
				case 1: {
					TelaControlePedidos.listar();
					break;
				}
				case 2: {
					TelaControlePedidos.cancelar();
					break;
				}
				case 3: {
					TelaPrincipalUsuario.mostrar();
					break;
				}
			}
		}
	}

	public static void listar() {

		System.out.println();
		System.out.println(Mensagem.MSG_LISTA_DE_PEDIDOS);
		
		if (BancoDeDados.pedidos.isEmpty()) {
			System.out.println(Mensagem.MSG_NENHUM_PEDIDO); 
		} else {
			for (Pedido pedido : BancoDeDados.pedidos) {
				System.out.println(pedido.toString());
			}
		}
		
		System.out.println();
		Prompt.pressionarEnter();
		TelaControlePedidos.mostrar();
	}
	

	private static void cancelar() {

		System.out.println();
		System.out.println(Mensagem.MSG_LISTA_DE_PEDIDOS);
		System.out.println(Mensagem.MSG_ESCOLHA);
		if (BancoDeDados.pedidos.isEmpty()) {
			System.out.println(Mensagem.MSG_NENHUM_PEDIDO); 
		} else {
			for (Pedido pedido : BancoDeDados.pedidos) {
				//System.out.println("[" + pedido.id + "] " + pedido.toString());
				System.out.println( pedido.toString());
			}
		}
		System.out.println();
			System.out.println(Mensagem.MSG_INFORME_CODIGO);
			int codigo = Prompt.lerInteiro();
				
			if (codigo > 0) {
				Pedido pedidoCancelar = ControlePedidos.buscar(codigo);
				
				System.out.println();
				if (pedidoCancelar != null) {
					ControlePedidos.cancelar(codigo, pedidoCancelar);
					System.out.println(Mensagem.MSG_PEDIDO_CANCELADO);
				} else {
					System.out.println(Mensagem.MSG_PEDIDO_NAO_ENCONTRADO);
				}
				System.out.println();
				Prompt.pressionarEnter();
				TelaControlePedidos.listar();
			}
	}
}































