package model;

public class JavaBeans {
		
		//variaveis para veiculo
	
		private String id;
		private String marca;
		private String placa;
		private String modelo;
		private String estado;
		private String ano;
		private String diaria;
		private String cor;
		
		
		public JavaBeans() {
			super();
	
		}
		
		public JavaBeans(String id, String marca, String placa, String modelo, String estado, String ano, String diaria,
				String cor) {
			super();
			this.id = id;
			this.marca = marca;
			this.placa = placa;
			this.modelo = modelo;
			this.estado = estado;
			this.ano = ano;
			this.diaria = diaria;
			this.cor = cor;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
			this.cor = cor;
		}

		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getPlaca() {
			return placa;
		}
		public void setPlaca(String placa) {
			this.placa = placa;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public String getAno() {
			return ano;
		}
		public void setAno(String ano) {
			this.ano = ano;
		}
		public String getDiaria() {
			return diaria;
		}
		public void setDiaria(String diaria) {
			this.diaria = diaria;
		}

	}
	

