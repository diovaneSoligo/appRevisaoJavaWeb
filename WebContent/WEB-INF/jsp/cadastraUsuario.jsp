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
	<form action="/appRevisaoJavaWeb/mvc?Logica=InserirUsuarioLogica"
		method="post">
		
		<c:if test="${not empty usuario }">
				<h2>Alterar usuário: ${usuario.login}</h2>
				<input type="hidden" name="id" value="${usuario.id }"/>
		</c:if>
		
		
		<label for="login">Login:</label> 
		<input type="text" id="login" name="login" value="${usuario.login }" /> <br /> 
		<label for="senha">Senha:</label> 
		<input type="text" id="senha" name="senha" value="${usuario.senha }"> <br />
		<button type="submit">Adicionar:</button>
	</form>
	</section>
	<section>

	<table class="table table-striped table-bordered">
		<thead>
			<tr>
			<tr>
				<th>ID</th>
				<th>Login</th>
				<th>Senha</th>
				<th>Ações</th>
			</tr>

		</thead>
		<tfoot>
			<tr>
			<tr>
				<th>ID</th>
				<th>Login</th>
				<th>Senha</th>				
				<th>Ações</th>
			</tr>
		</tfoot>
		<tbody>

			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.login}</td>
					<td>${usuario.senha}</td>
					
					<td><a class="btn btn-danger"
						href="mvc?Logica=BuscarUsuario&&id=${usuario.id}">Alterar</a>
						<a class="btn btn-danger"
						href="mvc?Logica=RemoverUsuario&&id=${usuario.id}">Remover</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	</section>


</body>
</html>