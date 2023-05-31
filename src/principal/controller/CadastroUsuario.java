package principal.controller;

import principal.db.BancoDeDados;
import principal.modelo.Usuario;

public class CadastroUsuario {
	
	public static void adicionar(Usuario usuario) {
		BancoDeDados.usuarios.add(usuario);
	}	
	 
 
	public static void atualizar(int UsuarioAlterar, Usuario usuarioAlterado) {
		BancoDeDados.usuarios.set(UsuarioAlterar, usuarioAlterado);
	}
	
	public static void atualizar(String usuarioOriginal, Usuario usuarioAlterado) {
		for (int i = 0; i < BancoDeDados.usuarios.size(); i++) {
			Usuario usuario = BancoDeDados.usuarios.get(i);
			if (usuario.nome.equalsIgnoreCase(usuarioOriginal)) {
				BancoDeDados.usuarios.set(i, usuarioAlterado);
				break;
			}
		}
	}

	public static Usuario localizar(String nome) {
		Usuario usuarioLocalizado = null;
		for (Usuario usuario : BancoDeDados.usuarios) {
			if (usuario.nome.equalsIgnoreCase(nome)) {
				usuarioLocalizado = usuario;
				break;
			}
		}
		return usuarioLocalizado;
	}

	public static boolean excluir(String nome) {
		boolean usuarioExcluido = false;
		for (int i = 0; i < BancoDeDados.usuarios.size(); i++) {
			Usuario usuario = BancoDeDados.usuarios.get(i);
			if (usuario.nome.equalsIgnoreCase(nome)) {
				BancoDeDados.usuarios.remove(i);
				usuarioExcluido = true;
				break;
			}
		}
		return usuarioExcluido;
	}


}
