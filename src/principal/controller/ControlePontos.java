package principal.controller;

import principal.db.BancoDeDados;
import principal.modelo.Brinde;
import principal.modelo.Cliente;
import principal.util.Mensagem;
import principal.util.Prompt;

public class ControlePontos {
	
	public static String localizar(String nome) {
		Cliente clienteLocalizado = null;
		for(Cliente cliente : BancoDeDados.clientes) {
			if(cliente.nome.equalsIgnoreCase(nome)) {
				clienteLocalizado = cliente;
				break;
			}									
		}
		return clienteLocalizado.toString();
		}
	
		public static void realizarTroca(Cliente cliente, Brinde brinde) {
	    int pontosCliente = cliente.getPontos();
	    int pontosBrinde = brinde.getValorPontos();

	    if (pontosCliente >= pontosBrinde) {
	        cliente.setPontos(pontosCliente - pontosBrinde);
	        System.out.println("Troca realizada com sucesso! " + cliente.getNome() + " trocou seus pontos pelo brinde: " + brinde.getNome());
	    } else {
	        System.out.println("Pontos insuficientes para trocar pelo brinde selecionado.");
	    }
	}
		public static void exibirListaBrindes() {
	    System.out.println(Mensagem.MSG_LISTA_DE_BRINDES);
	    for (Brinde brinde : BancoDeDados.brindes) {
	        System.out.println(brinde.toString());
	    }
	    Prompt.linhaEmBranco();
	}

}
