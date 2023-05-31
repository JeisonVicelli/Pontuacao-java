package principal.controller;

import principal.db.BancoDeDados;
import principal.modelo.Brinde;

public class CadastroBrindes {
	
		public static void incluir(Brinde brinde) {
			BancoDeDados.brindes.add(brinde);
		}
		
		public static void atualizar(int brindeAlterar, Brinde brindeAlterado) {
			BancoDeDados.brindes.set(brindeAlterar, brindeAlterado);
		}
		
		public static void atualizar(String brindeOriginal, Brinde brindeAlterado) {
			for(int i = 0; i < BancoDeDados.brindes.size(); i++) {
				Brinde brinde = BancoDeDados.brindes.get(i);
				if(brinde.nome.equalsIgnoreCase(brindeOriginal)) {
					BancoDeDados.brindes.set(i, brinde);
					break;
				}
				
			}
		}
		
		
		public static Brinde localizar(String nome) {
			Brinde brindeLocalizado = null;
			for(Brinde brinde : BancoDeDados.brindes) {
				if(brinde.nome.equalsIgnoreCase(nome)) {
					brindeLocalizado = brinde;
					break;
				}									
			}
			return brindeLocalizado;
			
		}
		
		
		public static boolean excluir(String nome) {
			boolean brindeExcluido = false;
			for(int i = 0; i < BancoDeDados.brindes.size(); i++) {
				Brinde brinde = BancoDeDados.brindes.get(i);
				if(brinde.nome.equalsIgnoreCase(nome)) {
					BancoDeDados.brindes.remove(i);
					brindeExcluido = true;
									
				}
			}
			return brindeExcluido;
			
			
			
			
		}

}
