<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
<script>
jQuery.validator.setDefaults({
  debug: true,
  success: "valid"
});
$( "#livrosForm" ).validate({
  	  rules: {
			"livro.titulo": {
			required: true,
			minlength: 3
			},
			"livro.descricao": {
			required: true,
			maxlength: 40
			},
			"livro.isbn": {
			required: true,
			maxlength: 40
			},
			"livro.preco": {
			required: true,
			maxlength: 40
			},
			"livro.dataPublicacao": {
			required: true,
			maxlength: 40
			},
			}
});
</script>
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

	<form  id="livrosForm" method="post" action="<c:url value="/salvaLivro"/>" >
		<h2>Formulário de cadastro de livros</h2>
		<ul>
			<li>Titulo: <br/>	
					<input id="livro.titulo" type="text" name="livro.titulo" value="${livro.titulo}" class="required"/></li>
			<li>Descricao: <br/>
						<textarea id="livro.descricao" name="livro.descricao" class="required">${livro.descricao}</textarea></li>
			<li>ISBN: <br/>
						<input id="livro.isbn" type="text" name="livro.isbn" value="${livro.isbn}" class="required"/></li>
			<%-- <li>Moeda: <br/>
						<select name="livro.preco.moeda">
 								<c:forEach items="${listaMoedas}" var="moedas">
									 <option value="${moedas}">${moedas}</option>
 								</c:forEach>
						</select>	 --%>
			<li>Montante: <br/>
						<input id="livro.preco" type="text" name="livro.preco" value="${livro.preco}" class="required"/></li>
			<li>Data de publicacao: <br/>
						<input id="livro.dataPublicacao" type="text" name="livro.dataPublicacao" value="${livro.dataPublicacao}" class="required"/>
						<input id="livro.id" type="hidden" name="livro.id" value="${livro.id}" class="required" />
						
			</li>
						
						
		</ul>
		<input type="submit" value="Salvar" />
	</form>





</body>
</html>