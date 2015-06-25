package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.repository.Estante;
import br.com.caelum.vraptor.validation.ValidatorLivros;

@Resource
public class LivrosController {
	private  Estante estante;
	private Result result;
	private ValidatorLivros validatorLivros;
	
	public LivrosController(Estante estante,Result result,ValidatorLivros validatorLivros) {
		this.estante = estante;
		this.result=result;
		this.validatorLivros=validatorLivros;
	}

	
	public void formulario() {}
	
	
	public void salva(Livro livro) {
		validatorLivros.validaLivros(livro).onErrorRedirectTo(this).formulario();
		estante.guarda(livro);
		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
		}
	
	
	public List<Livro> lista() {
		
		return estante.todosOsLivros();
			
	}
	
	
	public void edita(String isbn) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		if (livroEncontrado == null) {
			result.notFound();
		} else {
			result.include(livroEncontrado);
			result.of(this).formulario();
		}
	}


	private void naoEncontrado() {
	
		
	}
	
	
	

}
