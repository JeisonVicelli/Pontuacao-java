package snippet;

public class Snippet {
	Produto produtoLocalizado = null;
			for (Produto produto : BancoDeDados.produtos) {
				if (produto.nome.equalsIgnoreCase(nome)) {
					produtoLocalizado = produto;
					break;
				}
			}
			return produtoLocalizado;
}

