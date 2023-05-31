package principal;

import principal.db.BancoDeDados;
import principal.tela.TelaInicial;



public class Programa {
	
public static void main(String[] args) {
		
		BancoDeDados.gerarDadosTemporarios();
		TelaInicial.mostrar();
}
}