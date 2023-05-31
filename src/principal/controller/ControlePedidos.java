package principal.controller;

import principal.db.BancoDeDados;
import principal.modelo.Pedido;
import principal.modelo.Produto;

public class ControlePedidos {
	
	public static Pedido pedido;

	public static void adicionar(Pedido pedido) {
		BancoDeDados.pedidos.add(pedido);
	}
	
	public static void adicionar(Produto produto) {
		ControlePedidos.pedido.adicionar(produto);
	}

	public static Pedido buscar(int id) {
		for (Pedido pedido : BancoDeDados.pedidos) {
			
			if (pedido.id == id) {
				return pedido;
			}
		}
		return null;
	}
	
	public static Integer getNovoId() {
		Integer novoId = 0;
		for (Pedido pedido : BancoDeDados.pedidos) {
			if (pedido.id > novoId) {
				novoId = pedido.id;
			}
		}
		return novoId + 1;
	}
	

	public static void cancelar(int id, Pedido pedidoCancelar) {
		for (int i = 0; i < BancoDeDados.pedidos.size(); i++) {
			Pedido pedido = BancoDeDados.pedidos.get(i);
			if (pedido.id == id) {
				BancoDeDados.pedidos.remove(i);
				break;
			}
		}
	}




}
