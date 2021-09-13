package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;
import model.JavaBeansAluguel;
import model.JavaBeansAcessar;
import model.JavaBeansCliente;


@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" , "/aluguel" , "/aluga", "/login", "/off", "/cliente" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans veiculo = new JavaBeans();  
	JavaBeansAluguel aluguel = new JavaBeansAluguel(); 
	JavaBeansAcessar login = new JavaBeansAcessar(); 
	JavaBeansCliente cliente = new JavaBeansCliente(); 
	
    public Controller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// teste de conexao
		dao.testeconexao();
		

		// teste carregar paginas
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			veiculos(request, response);
		}
		else if (action.equals("/insert")) {
			novoVeiculo(request, response);
		}
		else if (action.equals("/select")) {
			listarVeiculo(request, response);
		}
		else if(action.equals("/update")) {
			editarVeiculo(request, response);
		}
		else if(action.equals("/delete")) {
			removerVeiculo(request, response);
		}
		else if(action.equals("/aluguel")) {
			alugaVeiculo(request, response);
		}
		else if(action.equals("/aluga")) {
			novoAluguel(request, response);
		}
		else if (action.equals("/login")) {
			acessar(request, response);
		}
		else if (action.equals("/off")) {
			sair(request, response);
		}
		else if (action.equals("/cliente")) {
			cliente(request, response);
		}
		else {
			response.sendRedirect("Index.html");
		}
	}	
	
	// listar veiculos e menu
		protected void veiculos(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			//response.sendRedirect("veiculo.jsp");
			
			//criando um objeto que ira receber os dados JavaBeans
			ArrayList<JavaBeans> lista = dao.listarVeiculos();
			
			//teste de recebimento da lista
			/*for(int i=0; i < lista.size(); i++) {
				System.out.println(lista.get(i).getId());
				System.out.println(lista.get(i).getMarca());
				System.out.println(lista.get(i).getPlaca());
				System.out.println(lista.get(i).getModelo());
				System.out.println(lista.get(i).getAno());
				System.out.println(lista.get(i).getDiaria());
				System.out.println(lista.get(i).getEstado());
				System.out.println(lista.get(i).getCor());*/
			
			
			//encaminhar a lista para o documento veiculo.jsp
			request.setAttribute("veiculos", lista);
			RequestDispatcher rd = request.getRequestDispatcher("veiculo.jsp");
			rd.forward(request, response);
			
		}
		
		// novo veiculo
				protected void novoVeiculo(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					/*System.out.println(request.getParameter("marca"));
					System.out.println(request.getParameter("placa"));
					System.out.println(request.getParameter("modelo"));*/
					
					//setar as variaveis JavaBeans
					veiculo.setMarca(request.getParameter("marca"));
					veiculo.setPlaca(request.getParameter("placa"));
					veiculo.setModelo(request.getParameter("modelo"));
					veiculo.setAno(request.getParameter("ano"));
					veiculo.setDiaria(request.getParameter("diaria"));
					veiculo.setEstado(request.getParameter("estado"));
					veiculo.setCor(request.getParameter("cor"));
					
					//invocar o metodo inserir passando o objeto aluguel
					dao.inserir(veiculo);
					
					//redirecionar para o documento veiculo.jsp
					response.sendRedirect("main");
				}
				
				//editar veiculo
				protected void listarVeiculo(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					//recebimento do id do veiculo que vai ser editado
					String id = request.getParameter("id");
					//System.out.println(id);
					
					//setar a variavel JavaBeans
					veiculo.setId(id);
					
					//executato metodo selecionarVeiculo(DAO)
					dao.selecionarVeiculo(veiculo);
					
					//teste de recebimento
					/*System.out.println(veiculo.getId());
					System.out.println(veiculo.getMarca());
					System.out.println(veiculo.getPlaca());
					System.out.println(veiculo.getModelo());
					System.out.println(veiculo.getAno());
					System.out.println(veiculo.getDiaria());
					System.out.println(veiculo.getEstado());
					System.out.println(veiculo.getCor());*/
					
					//setar os atributos do formulario com o conteudo JavaBeans
					request.setAttribute("id", veiculo.getId());
					request.setAttribute("marca", veiculo.getMarca());
					request.setAttribute("placa", veiculo.getPlaca());
					request.setAttribute("modelo", veiculo.getModelo());
					request.setAttribute("ano", veiculo.getAno());
					request.setAttribute("diaria", veiculo.getDiaria());
					request.setAttribute("estado", veiculo.getEstado());
					request.setAttribute("cor", veiculo.getCor());
					
					//encaminhar ao documento editar.jsp
					RequestDispatcher rd =request.getRequestDispatcher("editar.jsp");
					rd.forward(request, response);
						
				}
				
				protected void editarVeiculo(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					//teste de recebimento
					System.out.println(request.getParameter("id"));
					System.out.println(request.getParameter("marca"));
					System.out.println(request.getParameter("placa"));
					System.out.println(request.getParameter("modelo"));
					System.out.println(request.getParameter("ano"));
					System.out.println(request.getParameter("diaria"));
					System.out.println(request.getParameter("estado"));
					System.out.println(request.getParameter("cor"));
					
					//setar as variaveis JavaBeans
					veiculo.setId(request.getParameter("id"));
					veiculo.setMarca(request.getParameter("marca"));
					veiculo.setPlaca(request.getParameter("placa"));
					veiculo.setModelo(request.getParameter("modelo"));
					veiculo.setAno(request.getParameter("ano"));
					veiculo.setDiaria(request.getParameter("diaria"));
					veiculo.setEstado(request.getParameter("estado"));
					veiculo.setCor(request.getParameter("cor"));
					
					//executar o metodo alterarVeiculo
					dao.alterarVeiculo(veiculo);
					
					//redircionarpara o documento veiculo.jsp atualizando as altera��es
					response.sendRedirect("main");
				}
				
				//remover um veiculo
				
				protected void removerVeiculo(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					//recebimento do id do veiculo
					String id = request.getParameter("id");
					
					//System.out.println(id);
					
					//setar a variavel id JavaBeans
					veiculo.setId(id);
					
					//executar o metodo deletarVeiculo
					dao.deletarVeiculo(veiculo);
					
					//redircionarpara o documento veiculo.jsp atualizando as altera��es
					response.sendRedirect("main");
				}
				
				//carregar pagina aluguel
				
				protected void alugaVeiculo(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					response.sendRedirect("aluguel.jsp");
					
				}
				
				// criar aluguel
				
				protected void novoAluguel(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					//recebimento do id do veiculo que vai ser editado
					String id = request.getParameter("veiculo");
					
					//setar as variaveis JavaBeans
			
					aluguel.setNomeCl(request.getParameter("nomeCl"));
					aluguel.setCpf(request.getParameter("cpf"));
					aluguel.setDataR(request.getParameter("dataR"));
					aluguel.setDataD(request.getParameter("dataD"));
					aluguel.setVeiculo(request.getParameter("veiculo"));
					
					System.out.println(request.getParameter("nomeCl"));
					System.out.println(request.getParameter("cpf"));
					System.out.println(request.getParameter("dataR"));
					System.out.println(request.getParameter("dataD"));
					System.out.println(request.getParameter("veiculo"));
				
					
					System.out.println(id);
					
					//invocar o metodo inserir passando o objeto aluguel
					dao.alugar(aluguel);
					
					//setar a variavel JavaBeans
					veiculo.setId(id);
					
					//invocar o metodo updadte passando o objeto aluguel
					dao.upAlugar(id);
					
					//redirecionar para o documento veiculo.jsp
					response.sendRedirect("Index.html");
				}
				
				// acessar pagina

				protected void acessar(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					//recebimento dos valores de login
			
					login.setEmail(request.getParameter("email"));
					login.setSenha(request.getParameter("senha"));
					
					System.out.println(request.getParameter("email"));
					System.out.println(request.getParameter("senha"));
					
					//invocar o metodo inserir passando o objeto aluguel
					int resposta = dao.acessar(login); 
					
					System.out.println(resposta);
					
					if(resposta == 1){
						//redirecionar para o documento veiculo.jsp
						response.sendRedirect("Index.html");
					}
					else{
						PrintWriter out = response.getWriter();
				
						out.println("<!doctype html>");
						out.println("<html>");
						out.println("<body>");
						out.println("<br><h1>Senha Incorreta Volte e Tente Novamente </h1>");
						out.println("</body>");
						out.println("</html>");
					}
					
				}
				
				// novo cliente
				protected void cliente(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					//setar as variaveis JavaBeansCliente
					cliente.setNome(request.getParameter("nome"));
					cliente.setCpf(request.getParameter("cpf"));
					cliente.setCnh(request.getParameter("cnh"));
					cliente.setData(request.getParameter("data"));
					
					//invocar o metodo inserir passando o objeto aluguel
					dao.inseriCliente(cliente);
					
					//redirecionar para o documento veiculo.jsp
					response.sendRedirect("veiculo.jsp");
				}
				
				//sair do sistema
				
				protected void sair(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					response.sendRedirect("login.html");
					
				}
				
}