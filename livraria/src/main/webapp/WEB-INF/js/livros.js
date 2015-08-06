
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
