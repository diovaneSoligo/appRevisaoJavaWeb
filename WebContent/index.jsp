<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>LOGAR NA APLICAÇÃO</title>
	</head>
	<body>
		
		<c:if test="${not empty msg }">
				<h2>Usuário ou Senha inválidos</h2>
		</c:if>
		
		
		<form action="mvc?logica=LogarLogica" method="post">
			<label for="login">Login:</label>
			<input type="text" id="login" name="login" /> <br />
			<label for="senha">Senha:</label>
			<input type="text" id="senha" name="senha"> <br />
			<button type="submit" name="opcao" 
			value = "logar">LOGAR:</button>			
		</form>
		
		
	</body>
</html>