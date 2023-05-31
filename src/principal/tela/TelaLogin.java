package principal.tela;

import principal.controller.ControleLogin;
import principal.util.Mensagem;
import principal.util.Prompt;


public class TelaLogin {
	
public static void mostrar() {
		
			System.out.println(Mensagem.TELA_LOGIN);
			System.out.println(Mensagem.MSG_INFORME_LOGIN);
			String login = Prompt.lerLinha();
			System.out.println(Mensagem.MSG_INFORME_SENHA);
			String senha = Prompt.lerLinha();

			ControleLogin.autenticar(login, senha);
		
		if (ControleLogin.isUsuarioLogado()) {
			TelaPrincipalUsuario.mostrar();
		} else {
			System.out.println();
			System.out.println(Mensagem.MSG_LOGIN_INVALIDO);
			System.out.println();
			Prompt.pressionarEnter();
	        TelaLogin.mostrar();
		}
	}

}
