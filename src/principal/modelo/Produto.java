package principal.modelo;

public class Produto {
	
	public static Object toString;
	public String nome;
	public String marca;
	public String codBarra;
	public double valor;
	public int pontos;
	
	public Produto() {
		
	}
	
	public Produto(String nome, String marca, String codBarra, double valor, int pontos) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.codBarra = codBarra;
		this.valor = valor;
		this.pontos = pontos;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", marca=" + marca + ", codBarra=" + codBarra + ", valor=" + valor
				+ ", pontos=" + pontos + "]";
	}
	
	
}
