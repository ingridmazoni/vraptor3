<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

<form action="<c:url value='/produtos/adiciona'/>">
    Nome:             <input type="text" name="produto.nome" /><br/>
    Descri��o:    <input type="text" name="produto.descricao" /><br/>
    Pre�o:            <input type="text" name="produto.preco" /><br/>
    <input type="submit" value="Salvar" />
</form>


</body>
</html>