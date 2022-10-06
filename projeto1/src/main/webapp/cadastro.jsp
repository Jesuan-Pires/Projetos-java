<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
 ArrayList<JavaBeans>lista=(ArrayList<JavaBeans>)request.getAttribute("javabeans");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>cadastro</title>
<link rel="styLesheet" href="style.css">
</head>
<body>
	<h1>Cadastrar novo item</h1>
	<a href="novo.html" class="Botao1">Novo intem</a>
	<table id="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Código</th>
				<th>Categoria</th>
				<th>Valor</th>
				<th>Quantidade</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++){ %>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCodigo()%></td>
				<td><%=lista.get(i).getCategoria()%></td>
				<td><%=lista.get(i).getValor()%></td>
				<td><%=lista.get(i).getQuantidade()%></td>
				<td><a href="select?id=<%=lista.get(i).getId() %>" Class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getId() %>)" Class="Botao2">Excluir</a>
				</td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>