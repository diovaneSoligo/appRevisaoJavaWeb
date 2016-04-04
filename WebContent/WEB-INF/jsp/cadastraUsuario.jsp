<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Usuários</title>
</head>
<body>
	<section>
	<form action="/appRevisaoJavaWeb/mvc?logica=InserirUsuarioLogica"
		method="post">
		<label for="login">Login:</label> <input type="text" id="login"
			name="login" /> <br /> <label for="senha">Senha:</label> <input
			type="text" id="senha" name="senha"> <br />
		<button type="submit">Adicionar:</button>
	</form>
	</section>
	<section>

	<table class="table table-striped table-bordered">
		<thead>
			<tr>
			<tr>
				<th>Login</th>
				<th>Senha</th>
				
				<th>Ações</th>
			</tr>

		</thead>
		<tfoot>
			<tr>
			<tr>
				<th>Login</th>
				<th>Senha</th>				
				<th>Ações</th>
			</tr>
		</tfoot>
		<tbody>

			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td>${usuario.login}</td>
					<td>${usuario.senha}</td>
					
					<td><a class="btn btn-danger"
						href="http://localhost:8080/appJavaWebRevisao/tarefaController?buscarTarefa=true&&id=${tarefa.id}">Alterar</a>
						<a class="btn btn-danger"
						href="http://localhost:8080/appJavaWebRevisao/tarefaController?removeTarefa=true&&id=${tarefa.id}">Remover</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	</section>


</body>
</html>