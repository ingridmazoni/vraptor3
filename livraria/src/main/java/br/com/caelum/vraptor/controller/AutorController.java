package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.entity.Autor;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.entity.Pais;
import br.com.caelum.vraptor.interceptadores.Transacional;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.repository.RepositoryAutor;
import br.com.caelum.vraptor.validation.ValidatorAutor;


@Resource
public class AutorController {
	private RepositoryAutor repositoryAutor;
	private Result result;
	private ValidatorAutor validatorAutor;
	
	
	public AutorController(RepositoryAutor repositoryAutor, Result result,ValidatorAutor validatorAutor) {
		super();
		this.repositoryAutor = repositoryAutor;
		this.result = result;
		this.validatorAutor=validatorAutor;
		
	}
	
	@Path(value = { "/salvaAutor"}, priority=Path.LOWEST)
	public void formulario() {
		result.include("listaPaises",Pais.values());
		
	}
	
	
	@Post("/salvaAutor")
	public void salva(Autor autor, Livro livro) {
		validatorAutor.validaAutor(autor,livro).onErrorRedirectTo(this).formulario();
		autor.setUltimoLivro(livro);
		repositoryAutor.guarda(autor);
		result.include("mensagem", "Autor salvo com sucesso!");
		result.redirectTo(this).lista();
		}
	
	
	@Get("/listaAutor")
	public List<Autor> lista() {
		
		return repositoryAutor.todosOsAutores();
			
	}
	
	@Get("/editaAutor/{autor.id}")
	public void edita(Autor autor) {
		Autor autorEncontrado = repositoryAutor.buscaPorId(autor.getId());
		if (autorEncontrado == null) {
			result.notFound();
		} else {
			result.include(autorEncontrado);
			result.include("listaPaises",Pais.values());
			result.of(this).formulario();
		}
	}


	private void naoEncontrado() {
	
		
	}
	
	
	

}
