package principal;

import principal.db.BancoDeDados;
import principal.tela.TelaPrincipalUsuario;



public class Programa {
	
public static void main(String[] args) {
		
		BancoDeDados.gerarDadosTemporarios();
		TelaPrincipalUsuario.mostrar();
}
}