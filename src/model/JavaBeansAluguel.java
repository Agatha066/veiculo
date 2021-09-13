package model;

public class JavaBeansAluguel {

	private String nomeCl;
	private String dataR;
	private String dataD;
	private String veiculo;
	private String cpf;
	
	
	public JavaBeansAluguel() {
		super();
		
	}
	
	public JavaBeansAluguel(String nomeCl, String dataR, String dataD, String veiculo,String cpf) {
		super();
		this.nomeCl = nomeCl;
		this.dataR = dataR;
		this.dataD = dataD;
		this.veiculo = veiculo;
		this.veiculo = cpf;
	}

	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCl() {
		return nomeCl;
	}
	public void setNomeCl(String nomeCl) {
		this.nomeCl = nomeCl;
	}
	public String getDataR() {
		return dataR;
	}
	public void setDataR(String dataR) {
		this.dataR = dataR;
	}
	public String getDataD() {
		return dataD;
	}
	public void setDataD(String dataD) {
		this.dataD = dataD;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
}
