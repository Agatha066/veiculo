<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Editar</title>
<link rel="icon" href="imagens/iconecarro.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar veiculo</h1>
	<form name="frmlocacao" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="id" class="caixa3" readonly
					value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="placa" id="placa" class="caixa1"
					value="<%out.print(request.getAttribute("placa"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cor" id="cor" class="caixa2"
					value="<%out.print(request.getAttribute("cor"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="marca" id="marca" class="caixa1"
					value="<%out.print(request.getAttribute("marca"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="modelo" id="modelo" class="caixa1"
					value="<%out.print(request.getAttribute("modelo"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="ano" id="ano" class="caixa2"
					value="<%out.print(request.getAttribute("ano"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="diaria" id="diaria" class="caixa2"
					value="<%out.print(request.getAttribute("diaria"));%>"></td>
			</tr>
			<tr>
				<td>Estado do Veiculo: <select id="estado" name="estado" class="caixa2">
						<option value="<%out.print(request.getAttribute("estado"));%>"><%out.print(request.getAttribute("estado"));%></option>
						<option value="Alugado">Alugados</option>
						<option value="Manutencao">Manutencao</option>
						<option value="Disponivel">Disponivel</option>
				</select>
				</td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>