<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("veiculos");
%>

<!DOCTYPE>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Locacao</title>
<link rel="icon" href="imagens/iconecarro.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Locação de Veículos</h1>
	<br><div class="center">
		<a href="novo.html" class="Botao1">Cadastrar Veiculo</a>
		<a href="aluguel" class="Botao1">Alugar</a>
		<a href="cliente.html" class="Botao1">Cadastrar Cliente</a>
		<a href="dano.html" class="Botao1">Devolver Veiculo</a>
		<a href="off" class="Botao2">Sair</a>
	</div><br><hr>

	<table id="tabela">
		<thead>
			<tr>
				<th>id</th>
				<th>Marca</th>
				<th>Placa</th>
				<th>Modelo</th>
				<th>Ano</th>
				<th>Diaria</th>
				<th>Estado</th>
				<th>Cor</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) {%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getMarca()%></td>
				<td><%=lista.get(i).getPlaca()%></td>
				<td><%=lista.get(i).getModelo()%></td>
				<td><%=lista.get(i).getAno()%></td>
				<td><%=lista.get(i).getDiaria()%></td>
				<td><%=lista.get(i).getEstado()%></td>
				<td><%=lista.get(i).getCor()%></td>
				<td><a href="select?id=<%=lista.get(i).getId()%>" class="Botao1">Editar</a> 
				<a href="javascript: confirmar(<%=lista.get(i).getId()%>)" class="Botao2">Deletar</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>