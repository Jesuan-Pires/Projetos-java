<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar item</h1>
	<form name="frmItem" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="Caixa1" readonly value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" name="codigo" class="Caixa2" value="<%out.print(request.getAttribute("codigo"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" name="categoria" class="Caixa2" value="<%out.print(request.getAttribute("categoria"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="valor" class="Caixa2" value="<%out.print(request.getAttribute("valor"));%>"></td>
			</tr>
			<tr>
				<td><input type="number" name="quantidade" class="Caixa2" value="<%out.print(request.getAttribute("quantidade"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" Class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>