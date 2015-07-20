package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.repository.Estante;
import br.com.caelum.vraptor.validation.ValidatorLivros;


@Resource
@RequestScoped
public class LivrosController {
	private  Estante estante;
	private Result result;
	private ValidatorLivros validatorLivros;
		
	public LivrosController(Estante estante,Result result,ValidatorLivros validatorLivros) {
		this.estante = estante;
		this.result=result;
		this.validatorLivros=validatorLivros;
		
		
	}

	
	@Path(value = { "/salvaLivro"}, priority=Path.LOWEST)
	public void formulario() {}
	

	@Post("/salvaLivro")
	public void salva(Livro livro) {
		validatorLivros.validaLivros(livro).onErrorRedirectTo(this).formulario();
		estante.guarda(livro);
		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
		}
	

	@Get("/listaLivros")
	public List<Livro> lista() {
		
		return estante.todosOsLivros();
			
	}
	
	
	
	@Get("/editaLivro/{livro.isbn}")
	public void edita(Livro livro) {
		Livro livroEncontrado = estante.buscaPorIsbn(livro.getIsbn());
		if (livroEncontrado == null) {
			result.notFound();
		} else {
			result.include(livroEncontrado);
			result.of(this).formulario();
		}
	}


	/*private void naoEncontrado() {
	
		
	}*/
	
	
	

}
