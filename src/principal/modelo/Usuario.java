package principal.modelo;

public class Usuario {
	
	public String nome;
	public String CPF;
	public String login;
	public String senha;
	
	public Usuario() {
		
	}	
	
	public Usuario(String nome, String cPF, String login, String senha) {
		this.nome = nome;
		CPF = cPF;
		this.login = login;
		this.senha = senha;
		
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String toString() {
		return "Usuario [nome = " + getNome() + ", cpf = " + getCPF() + ", login = " + getLogin() + "]";
	}
	
			
	
	

}
