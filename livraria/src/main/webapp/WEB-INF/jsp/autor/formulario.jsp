<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body style="background-color:MistyRose">

<ul class="errors">
<c:forEach items="${errors}" var="error">
<li>
	<!-- o campo em que ocorreu o erro, ou o tipo do erro -->
		${error.category}:
	<!-- a mensagem de erro de valida��o -->
${error.message}
</li>
</c:forEach>
</ul>

	<form  action="<c:url value="/autor/salva"/>" method="post">
		<h2>Formulário de cadastro de autores</h2>
		<ul>
			<li>Nome: <br/>	
					<input type="text" name="autor.nome" value="${autor.nome}"/></li>
			<li>Data de Nascimento: <br/>
						<input type="text" name="autor.dataNascimento" value="${autor.dataNascimento}"/></li>
			<li>N�mero de Livros: <br/>
						<input type="text" name="autor.numeroDeLivros" value="${autor.numeroDeLivros}"/></li>
			<li>Naturalidade: <br/>
						<select name="autor.naturalidade">
 								<c:forEach items="${listaPaises}" var="paises">
									 <option value="${paises}">${paises}</option>
 								</c:forEach>
						</select>	
						<input type="hidden" name="autor.id" value="${autor.id}" />
			</li>
			<li>Ultimo Livro: <br/>
						<input type="text" name="livro.id" value="${livro.id}"/></li>
		</ul>
		<input type="submit" value="Salvar" />
	</form>





</body>
</html>