package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.entity.Autor;
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
	
	public void formulario() {}
	
	
	public void salva(Autor autor) {
		validatorAutor.validaAutor(autor).onErrorRedirectTo(this).formulario();
		repositoryAutor.guarda(autor);
		result.include("mensagem", "Autor salvo com sucesso!");
		result.redirectTo(this).lista();
		}
	
	
	public List<Autor> lista() {
		
		return repositoryAutor.todosOsAutores();
			
	}
	
	
	public void edita(Long id) {
		Autor autorEncontrado = repositoryAutor.buscaPorId(id);
		if (autorEncontrado == null) {
			result.notFound();
		} else {
			result.include(autorEncontrado);
			result.of(this).formulario();
		}
	}


	private void naoEncontrado() {
	
		
	}
	
	
	

}
