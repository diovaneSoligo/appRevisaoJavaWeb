<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="backgroud-color:#444;">
<center><h2>CADASTRAR USER</h2></center>
		<center><form action="/appRevisaoJavaWeb/mvc?Logica=CriarUsuario" method="post">
			<label for="login">Login:</label>
			<input type="text" id="login" name="login" /><br>
			<label for="senha">Senha:</label>
			<input type="password" id="senha" name="senha"/><br>
			<button type="submit" name="opcao" value="cadastroUsuario">CADASTRAR</button>
		</form>
		</center>	

</body>
</html>