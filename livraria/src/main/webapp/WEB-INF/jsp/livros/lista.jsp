<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body style="background-color:MistyRose">
	<c:if test="${not empty mensagem}">
		<p class="mensagem">${mensagem}</p>
	</c:if>
	<c:forEach items="${livroList}" var="livro">
		<li>
				${livro.titulo} - ${livro.descricao}
				<a href="/livraria/editaLivro/${livro.isbn}">Modificar</a>
		</li>
	</c:forEach>


</body>
</html>