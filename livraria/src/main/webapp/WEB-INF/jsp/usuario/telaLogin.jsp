<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Login</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body style="background-color:MistyRose">
${error.message}
	<form  method="post" action="<c:url value="/usuario/verificaLogin"/>" >
		<h2>Tela de Login</h2>
		<ul>
			<li>Login: <br/>	
					<input type="text" name="usuario.login" value="${usuario.login}"/></li>
			
			<li>Senha: <br/>
						<input type="text" name="usuario.senha" value="${usuario.senha}"/></li>
				
						
		</ul>
		<input type="submit" value="Salvar" />
	</form>

	


</body>
</html>