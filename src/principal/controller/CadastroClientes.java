package principal.controller;

import principal.db.BancoDeDados;
import principal.modelo.Cliente;

public class CadastroClientes {
	
	public static void incluir(Cliente cliente) {
		BancoDeDados.clientes.add(cliente);
	}
	
	public static void atualizar(int clienteAlterar, Cliente clienteAlterado) {
		BancoDeDados.clientes.set(clienteAlterar, clienteAlterado);
	}
	
	public static void atualizar(String clienteOriginal, Cliente clinteAlterado) {
		for(int i = 0; i < BancoDeDados.clientes.size(); i++) {
			Cliente cliente = BancoDeDados.clientes.get(i);
			if(cliente.nome.equalsIgnoreCase(clienteOriginal)) {
				BancoDeDados.clientes.set(i, cliente);
				break;
			}
			
		}
	}
	
	public static Cliente localizar(String nome) {
		Cliente clienteLocalizado = null;
		for(Cliente cliente : BancoDeDados.clientes) {
			if(cliente.nome.equalsIgnoreCase(nome)) {
				clienteLocalizado = cliente;
				break;
			}									
		}
		return clienteLocalizado;
		
	}
	
	
	public static boolean excluir(String nome) {
		boolean clienteExcluido = false;
		for(int i = 0; i < BancoDeDados.clientes.size(); i++) {
			Cliente cliente = BancoDeDados.clientes.get(i);
			if(cliente.nome.equalsIgnoreCase(nome)) {
				BancoDeDados.clientes.remove(i);
				clienteExcluido = true;
								
			}
		}
		return clienteExcluido;
		
		
		
		
	}

}
