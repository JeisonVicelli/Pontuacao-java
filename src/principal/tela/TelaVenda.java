package principal.tela;

import principal.controller.CadastroClientes;
import principal.controller.CadastroProduto;
import principal.controller.ControlePedidos;
import principal.db.BancoDeDados;
import principal.modelo.Cliente;
import principal.modelo.Pedido;
import principal.modelo.Produto;
import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaVenda {


	public static void mostrar() {

		Pedido pedido = ControlePedidos.pedido;
		if (pedido == null) {

			Integer id = ControlePedidos.getNovoId();
			pedido = new Pedido();
			pedido.id = id;

			System.out.println();
			System.out.println(Mensagem.MSG_LISTA_DE_CLIENTES);
			
			if (BancoDeDados.clientes.isEmpty()) {
				System.out.println(Mensagem.MSG_NENHUM_CLIENTE);
			} else {
				for (Cliente cliente : BancoDeDados.clientes) {
					System.out.println(cliente.toString());
				}
				Prompt.linhaEmBranco();
				System.out.println(Mensagem.MSG_INFORME_NOME);				
				String nome = Prompt.lerLinha();
                Cliente clienteLocalizado = CadastroClientes.localizar(nome);

                if (clienteLocalizado == null) {
                    System.out.println("Cliente não encontrado.");
                } else {
                    pedido.cliente = clienteLocalizado;
                }
            }
			Prompt.linhaEmBranco();
			Prompt.separador();
			boolean continuarComprando = true;
			while (continuarComprando) {
				System.out.println(Mensagem.MENU_LISTAR_PRODUTOS);
				for (Produto produto : BancoDeDados.produtos) {
					System.out.println(produto.toString());
				}
				Prompt.linhaEmBranco();
				System.out.println("Informe o nome do produto que deseja adicionar ao carrinho: ");

                String nome = Prompt.lerLinha();
                Produto produtoLocalizado = CadastroProduto.localizar(nome);

                if (produtoLocalizado == null) {
                    System.out.println("Produto não encontrado.");
                } else {
                    pedido.adicionar(produtoLocalizado);
                    System.out.println();
                    System.out.println("Produto adicionado ao carrinho.");
                    System.out.println();
                }
				System.out.println();
				System.out.println("Deseja adicionar mais produtos? (s/n)");
				String resposta = Prompt.lerLinha();
				if (!resposta.equalsIgnoreCase("s")) {
					continuarComprando = false;
				}
			}
		}

		if (pedido.getProdutos().isEmpty()) {
			System.out.println("Carrinho vazio.");
		} else {
			double valorTotal = pedido.getValorTotal();
			int pontos = pedido.addPontos();
			pedido.getCliente().adicionarPontos(pontos);

			System.out.println("Valor total da compra: R$" + valorTotal + " e ganha " + pontos + " pontos.");
			System.out.println();

			System.out.println("Deseja confirmar a compra? (s/n)");			
			String confirmacao = Prompt.lerLinha();				
			if (confirmacao.equalsIgnoreCase("s")) {
					System.out.println();
					System.out.println("Compra finalizada com sucesso.");
				} else {
					System.out.println("Compra cancelada.");
				}
			}
			System.out.println();
			ControlePedidos.adicionar(pedido);
			Prompt.pressionarEnter();
			TelaPrincipalUsuario.mostrar();
		}
}


	

