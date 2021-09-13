package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;

public class DAO {
	/** Modulo de conexao **/

	// Parametros de conexao
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/locacao";
	private static String user = "root";
	private static String password = "";
	
	
	// Metodo conexao

	public static Connection conectar() {

		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			return null;
		}
		return con;
	}

	// teste de conexao
	public void testeconexao() {
		try {
			Connection con = conectar();
			if (con != null) {
				System.out.println(con);
				System.out.println("Conexao obtida com sucesso!");
				con.close();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*
	 * CRUD CREATE
	 * 
	 */

	public void inserir(JavaBeans veiculo) {
		String create = "INSERT INTO veiculos(marca,placa,modelo,ano,diaria,estado,cor) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			// Criar uma conex�o com o banco de dados
			Connection con = conectar();

			// Criamos uma PreparedStatement, para executar uma query
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(create);

			// Adicionar os valores que s�o esperados pela query
			pst.setString(1, veiculo.getMarca());
			pst.setString(2, veiculo.getPlaca());
			pst.setString(3, veiculo.getModelo());
			pst.setString(4, veiculo.getAno());
			pst.setString(5, veiculo.getDiaria());
			pst.setString(6, veiculo.getEstado());
			pst.setString(7, veiculo.getCor());

			// Executar a query
			pst.executeUpdate();

			// encerrar a conexao com o Banco
			con.close();

			System.out.println("Veiculo salvo com sucesso!");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	//inseri cliente
	
	public void inseriCliente(JavaBeansCliente cliente) {
		
		String create = "INSERT INTO clientes(nome,cpf,cnh,dataEm) VALUES (?, ?, ?, ?)";

		try {
			// Criar uma conex�o com o banco de dados
			Connection con = conectar();

			// Criamos uma PreparedStatement, para executar uma query
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(create);

			// Adicionar os valores que s�o esperados pela query
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getCpf());
			pst.setString(3, cliente.getCnh());
			pst.setString(4, cliente.getData());
			

			// Executar a query
			pst.executeUpdate();

			// encerrar a conexao com o Banco
			con.close();

			System.out.println("Cliente salvo com sucesso!");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	
	/*
	 * CRUD READ
	 * 
	 */
	
	public ArrayList<JavaBeans> listarVeiculos() {
		
		//criando um objetopara acessar a classe JavaBeans
		ArrayList<JavaBeans> veiculos = new ArrayList<>();
		
		String read = "SELECT * FROM veiculos";
		
		try {
			// Criar uma conex�o com o banco de dados
			Connection con = conectar();

			// Criamos uma PreparedStatement, para executar uma query
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(read);
			
			// rs armazena dados vindo do banco
			ResultSet rs = pst.executeQuery();
			
			//o laco sera executado enquanto ouver veiculos
			while (rs.next()) {
				//variaveis de apoio que recebem os dados do banco
				String id = rs.getString(1);
				String marca = rs.getString(2);
				String placa = rs.getString(3);
				String modelo = rs.getString(4);
				String ano = rs.getString(5);
				String diaria = rs.getString(6);
				String estado = rs.getString(7);
				String cor = rs.getString(8);
				
				
				//armazenar no ArrayList
				veiculos.add(new JavaBeans(id,marca,placa,modelo,ano,diaria,estado,cor));
			}
			con.close();
			return veiculos;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	//listar veiculos disponiveis para alugar
	
		/*public ArrayList<JavaBeans> listar() {
			
			//criando um objetopara acessar a classe JavaBeans
			ArrayList<JavaBeans> veiculos = new ArrayList<>();
			
			String read = "SELECT * FROM veiculos WHERE estado = 'disponivel' OR estado = 'Disponivel';";
			
			try {
				// Criar uma conex�o com o banco de dados
				Connection con = conectar();

				// Criamos uma Prepared, para executar uma query
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(read);
				
				// rs armazena dados vindo do banco
				ResultSet rs = pst.executeQuery();
				
				//o laco sera executado enquanto ouver veiculos
				while (rs.next()) {
					//variaveis de apoio que recebem os dados do banco
					String id = rs.getString(1);
					String marca = rs.getString(2);
					String placa = rs.getString(3);
					String modelo = rs.getString(4);
					String ano = rs.getString(5);
					String diaria = rs.getString(6);
					String estado = rs.getString(7);
					String cor = rs.getString(8);
					
					
					//armazenar no ArrayList
					veiculos.add(new JavaBeans(id,marca,placa,modelo,ano,diaria,estado,cor));
				}
				con.close();
				return veiculos;
			}
			catch (Exception e) {
				System.out.println(e);
				return null;
			}
			
		}*/

	
	/*
	 * CRUD UPDATE
	 * 
	 */
	
	//selecionar veiculo
	
	public void selecionarVeiculo(JavaBeans veiculo) {
		
		String read2 = "SELECT * FROM veiculos WHERE id = ?";
		
		try {
			// Criar uma conex�o com o banco de dados
			Connection con = conectar();

			// Criamos uma PreparedStatement, para executar uma query
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(read2);
			
			pst.setString(1, veiculo.getId());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()){
				
				//setar as variaveis JavaBeans
				veiculo.setId(rs.getString(1));
				veiculo.setMarca(rs.getString(2));
				veiculo.setPlaca(rs.getString(3));
				veiculo.setModelo(rs.getString(4));
				veiculo.setAno(rs.getString(5));
				veiculo.setDiaria(rs.getString(6));
				veiculo.setEstado(rs.getString(7));
				veiculo.setCor(rs.getString(8));
				
			}
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//editar veiculo
	public void alterarVeiculo(JavaBeans veiculo) {
		
		String update = "UPDATE veiculos SET marca=?,placa=?,modelo=?,ano=?,diaria=?,estado=?,cor=? WHERE id=?";
		
		try {
			// Criar uma conex�o com o banco de dados
			Connection con = conectar();

			// Criamos uma PreparedStatement, para executar uma query
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(update);
			
			pst.setString(1, veiculo.getMarca());
			pst.setString(2, veiculo.getPlaca());
			pst.setString(3, veiculo.getModelo());
			pst.setString(4, veiculo.getAno());
			pst.setString(5, veiculo.getDiaria());
			pst.setString(6, veiculo.getEstado());
			pst.setString(7, veiculo.getCor());
			pst.setString(8, veiculo.getId());
			
			/*System.out.println(veiculo.getMarca());
			System.out.println(veiculo.getPlaca());
			System.out.println(veiculo.getModelo());
			System.out.println(veiculo.getAno());
			System.out.println(veiculo.getDiaria());
			System.out.println(veiculo.getEstado());
			System.out.println(veiculo.getCor());
			System.out.println(veiculo.getId());*/
			
			pst.executeUpdate();
			
			//finalizar conexao
			con.close();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*
	 * CRUD DELETE
	 * 
	 */
	
	public void deletarVeiculo(JavaBeans veiculo) {
		
		String delete = "DELETE FROM veiculos WHERE id = ?";
		
		try {
			// Criar uma conex�o com o banco de dados
			Connection con = conectar();

			// Criamos uma PreparedStatement, para executar uma query
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(delete);
			
			pst.setString(1, veiculo.getId());
			
			pst.executeUpdate();
			
			//finalizar conexao
			con.close();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//alugar
	
		public void alugar(JavaBeansAluguel aluguel) {
		
			String create = "INSERT INTO aluguel(nomeCl,cpf,veiculo,dataret,datadev) VALUES (?, ?, ?, ?, ?)";
			
			try {
				// Criar uma conex�o com o banco de dados
				Connection con = conectar();

				// Criamos uma PreparedStatement, para executar uma query
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(create);

				// Adicionar os valores que s�o esperados pela query
				pst.setString(1, aluguel.getNomeCl());
				pst.setString(2, aluguel.getCpf());
				pst.setString(3, aluguel.getVeiculo());
				pst.setString(4, aluguel.getDataR());
				pst.setString(5, aluguel.getDataD());

				// Executar a query
				pst.executeUpdate();

				// encerrar a conexao com o Banco
				con.close();

				System.out.println("Aluguel salvo com sucesso!");

			} catch (Exception e) {
				System.out.println(e);
			}

		}
		
		//update no veiculo
		
		public void upAlugar(String id) {
			
			String update = "UPDATE veiculos SET estado='Alugado' WHERE id=?";
			
			try {
				// Criar uma conex�o com o banco de dados
				Connection con = conectar();

				// Criamos uma PreparedStatement, para executar uma query
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(update);
				
				pst.setString(1, id);
				
				pst.executeUpdate();
				
				//finalizar conexao
				con.close();
				
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
		//acessar DAO

		public int acessar(JavaBeansAcessar login) {
				
				String query = "SELECT * FROM acesso WHERE email=? AND senha=?";
				
				try {
					// Criar uma conex�o com o banco de dados
					Connection con = conectar();

					// Criamos uma PreparedStatement, para executar uma query
					PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
					
					pst.setString(1, login.getEmail());
					pst.setString(2, login.getSenha());
					
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()){
						//se senha e email igual a true entao vai para home
						return 1;
					}
					con.close();
				}
				catch (Exception e) {
					System.out.println(e);
				}
				return 0;
			}

	
}

