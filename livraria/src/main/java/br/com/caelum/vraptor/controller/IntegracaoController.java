package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.repository.Estante;
import br.com.caelum.vraptor.view.Results;

@Resource
public class IntegracaoController {
	
	private Estante estante;
	private Result result;
	
	public IntegracaoController(Estante estante, Result result) {
		this.estante = estante;
		this.result = result;
	}
	
	public void listaLivros() {
		
		List<Livro> livros = estante.todosOsLivros();
		result.use(Results.xml()).from(livros, "livros").serialize();
	}

}
