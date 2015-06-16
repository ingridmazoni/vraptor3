package br.com.caelum.vraptor.repository;

import java.util.List;

import br.com.caelum.vraptor.entity.Livro;

public interface Estante {
	
	void guarda(Livro livro);
	List<Livro> todosOsLivros();
	Livro buscaPorIsbn(String isbn);

}
