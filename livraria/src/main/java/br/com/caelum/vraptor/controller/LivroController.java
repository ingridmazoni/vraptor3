package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.repository.Estante;

@Resource
public class LivroController {

private  Estante estante;
	
	
	/*public LivroController(Estante estante) {
		this.estante=estante;		
		
	}

	
	public void formulario() {}
	
	public void salva(Livro livro, Result result) {
		
		try {
			
			estante.guarda(livro);
		} finally{
			((UmaEstanteNoBancoDeDados) estante).fechaConexao();
		}
			result.redirectTo(this).lista();
	}
	
	
	public List<Livro> lista() {
		
		try {
		
		return estante.todosOsLivros();
		} finally{
		((UmaEstanteNoBancoDeDados)estante).fechaConexao();
		}
			return null;
	}
	
	
	public void edita(String isbn, Result result) {
		
		try {
				
				Livro livroEncontrado = estante.buscaPorIsbn(isbn);
				result.include(livroEncontrado);
		} finally{
				((UmaEstanteNoBancoDeDados) estante).fechaConexao();
		}
		
				result.of(this).formulario();
		}
		
}
	*/
}
