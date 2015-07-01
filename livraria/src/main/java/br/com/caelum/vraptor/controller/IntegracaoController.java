package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.entity.Autor;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.repository.Estante;
import br.com.caelum.vraptor.repository.RepositoryAutor;
import br.com.caelum.vraptor.view.Results;

@Resource
public class IntegracaoController {
	
	private Estante estante;
	private Result result;
	private RepositoryAutor rautor;
	
	public IntegracaoController(Estante estante, Result result,RepositoryAutor autor) {
		this.estante = estante;
		this.result = result;
		this.rautor=autor;
	}
	
	public void listaLivros() {
		
		List<Livro> livros = estante.todosOsLivros();
		result.use(Results.xml()).from(livros, "livros").serialize();
	}
	
	public void listaAutores() {
		
		List<Autor> autor = rautor.todosOsAutores();
		result.use(Results.xml())
				.from(autor, "autores")
				.include("ultimoLivro")
				.exclude("ultimoLivro.preco")
				.serialize();
	}

}
