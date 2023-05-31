package principal.modelo;

public class Cliente {
	
	public String nome;
	public String CPF;
	public String dataNascimento;
	public String telefone;
	public int pontos;
		
	public Cliente(String nome, String cPF, String dataNascimento, String telefone, int pontos) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.pontos = pontos;
	}
		
		public Cliente() {
	}
		
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public void adicionarPontos(int pontos) {
		//this.pontos = this.pontos + pontos;
		this.pontos += pontos;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", CPF=" + CPF + ", dataNascimento=" + dataNascimento + ", telefone="
				+ telefone + ", pontos=" + pontos + "]";
	}
	

	
}
