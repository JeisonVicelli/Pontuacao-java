package principal.db;



import java.util.ArrayList;
import java.util.List;

import principal.controller.ControlePedidos;
import principal.modelo.Brinde;
import principal.modelo.Cliente;
import principal.modelo.Pedido;
import principal.modelo.Produto;
import principal.modelo.Usuario;


public class BancoDeDados {
	
	public static List<Usuario> usuarios = new ArrayList<>();
	public static List<Cliente> clientes = new ArrayList<>();
	public static List<Brinde> brindes = new ArrayList<>();
	public static List<Produto> produtos = new ArrayList<>();
	public static List<Pedido> pedidos = new ArrayList<>();
	
	
	
	public static void gerarDadosTemporarios() {
		
		
		Usuario usuario = new Usuario("Jeison", "04716350908","jeisonvicelli@gmail.com", "senha");
		usuarios.add(usuario);
		usuarios.add(new Usuario("Gabriel","12312312312", "gabrielcesaro@hotmail.com","senha"));
		usuarios.add(new Usuario("Paulo Victor","23423423423","victorpam9@hotmail.com", "senha"));
		

		Cliente cliente = new Cliente("Pedro", "123456","22/12/2000", "(41)998765546", 100);
		clientes.add(cliente);
		clientes.add(new Cliente("Ana", "123455", "30/01/2016", "(41)987657890", 3));		
		
		
		Produto produto = new Produto("Jaqueta", "Volcom", "6", 399.00, 100);
		produtos.add(produto);
		produtos.add(new Produto("Tenis", "Nike,", "1", 199.00, 366));
		produtos.add(new Produto("Camisa", "Adidas,", "2", 149.90, 50));
		produtos.add(new Produto("Calça", "Hurley,", "3", 399.00, 27));
		produtos.add(new Produto("Moletom", "DC,", "4", 299.00, 20));
		produtos.add(new Produto("Bone", "New Era,", "5", 99.00,11));	
		
		
		Brinde brinde = new Brinde("Copo", 25);
		brindes.add(brinde);
		brindes.add(new Brinde("Adesivo", 10));
        brindes.add(new Brinde("Chaveiro",15));
        brindes.add(new Brinde("Bone", 100));
        brindes.add(new Brinde("Camisa", 150));
        
       
        
        
        Integer id = ControlePedidos.getNovoId();
        Pedido pedido = new Pedido();
        pedido.id = id;
        pedido.cliente = cliente;
        pedido.valorTotal = produto.getValor();        
        pedido.adicionar(produto);        
        pedidos.add(pedido);

	}
		
		
	}


				
		
		
		
	


	
	
	
	
	
			
