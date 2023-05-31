package principal.modelo;


import java.util.ArrayList;
import java.util.List;

import principal.controller.ControlePedidos;


public class Pedido {
	

	public int id;
    public Cliente cliente;
    public double valorTotal;
    List<Produto> produtos = new ArrayList<>();
    
	public Pedido(int id, Cliente cliente, List<Produto> produtos, double valorTotal) {
		this.id = ControlePedidos.getNovoId();
		this.cliente = cliente;
		this.produtos = new ArrayList<>();
		
	}

    public Pedido() {
       
    }
    public Cliente ListarCliente() {
        return cliente;
    }


    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        double valorTotal = 0;
        for (Produto produto : produtos) {
            valorTotal += produto.getValor();
        }
        return valorTotal;
    }
    
    public int addPontos() {
        int pontos = 0;
        for (Produto produto : produtos) {
            pontos += produto.getPontos();
        }
        return pontos;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public Integer getId() {
        return id;
    }

	@Override
	public String toString() {
		return "Pedido [Codigo=" + id + ", cliente=" + cliente + ", valorTotal=" + valorTotal + ", produtos=" + produtos
				+ "]";
	}
    


}
