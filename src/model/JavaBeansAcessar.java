package model;

public class JavaBeansAcessar {
	
	private String email;
	private String senha;
	
	public JavaBeansAcessar() {
		super();

	}
	
	
	public JavaBeansAcessar(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
