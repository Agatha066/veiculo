package model;

public class JavaBeansCliente {

	private String nome;
	private String data;
	private String cnh;
	private String cpf;
	
	
	public JavaBeansCliente() {
		super();
		
	}
	
	public JavaBeansCliente(String nome, String data, String cnh, String cpf) {
		super();
		this.nome = nome;
		this.data = data;
		this.cnh = cnh;
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getCnh() {
		return cnh;
	}


	public void setCnh(String cnh) {
		this.cnh = cnh;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
