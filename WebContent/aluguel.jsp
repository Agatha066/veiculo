<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="com.mysql.jdbc.PreparedStatement"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Alugar</title>
<link rel="icon" href="imagens/iconecarro.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Alugar veiculo</h1>
	
	<form name="frmlocacao" action="aluga">
		<table>
			<tr>
				<td>Nome do Cliente: <input type="text" id="nome" name="nomeCl" placeholder="Nome" class="caixa1"></td>
			</tr>
			<tr>
				<td>CPF: <input type="text" id="cpf" name="cpf" placeholder="CPF" class="caixa1"></td>
			</tr>
			<tr>
				<td>Veiculo: <select name="veiculo" class="caixa2">
					<option>Veiculo</option>
					<%
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = null;
							con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/locacao", "root", "");
							String query = "SELECT * FROM veiculos WHERE estado = 'disponivel' OR estado = 'Disponivel'";
							PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
							
							ResultSet rs = pst.executeQuery();
							while (rs.next()) {
								%>
									<option id="veiculo" name="veiculo" value="<%=rs.getString("id")%>"><%=rs.getString("modelo")%></option>
									<option class ="none" id="valor" name="valor" value="<%=rs.getString("diaria")%>" disabled></option>
									<%
								}
							
						}catch (Exception e){
							
						}

					%>
				</select></td>
			</tr>
			<tr>
				<td>Data Retirada: <input type="text" id="R" name="dataR" placeholder="02/12/2021" class="caixa2"></td>
			</tr>
			<tr>
				<td>Data Devolução: <input type="text" id="D" name="dataD" placeholder="04/12/2021" class="caixa2"></td>
			</tr>
			<tr>
				<td>Numero do cartao: <input type="text" id="cartao" name="cartao" placeholder="000 0000 0000 01" class="caixa2"></td>
			</tr>
			<tr>
				<td>Tipo de Pagamento: <select name="tipo" class="caixa2">
					<option>Credito</option>
					<option>Debito</option></select>
				</td>
			</tr>
		</table>
		<input type="button" class="Botao1" value="Alugar" onclick="validar()">
	</form>
	<script src="scripts/confirma.js"></script>
</body>
</html>