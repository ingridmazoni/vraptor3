<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function(){
	$("#livros .remove").on("click", function(event){
		event.preventDefault();
		var livro = $(this).closest(".livro");
				
		$.ajax({
			url: $(this).attr("href"),
			type: 'POST',
			data: { _method: "DELETE"}
		}).done(function(data, textStatus, jqXHR){
				// executada em caso de sucesso
				livro.fadeOut();
			}).fail(function(jqXHR, textStatus, errorThrown){
				// executada em caso de erro
				alert("O Livro não foi removido!");
			}).always(function(){
			// executada assim que a requisição termina,
			// seja com sucesso ou com erro
		});
	});
});
</script>
</head>
<body style="background-color:MistyRose">
	<c:if test="${not empty mensagem}">
		<p class="mensagem">${mensagem}</p>
	</c:if>
	<c:forEach items="${livroList}" var="livro">
		<li>
				${livro.titulo} - ${livro.descricao}
				<a href="/livraria/editaLivro/${livro.isbn}">Modificar</a>
				<a href="${linkTo[LivrosController].remove[livro.isbn]}">Remover</a>
		</li>
		
		
	</c:forEach>


</body>
</html>