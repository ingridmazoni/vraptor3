package br.com.caelum.vraptor.repository;

import java.util.List;

import br.com.caelum.vraptor.entity.Autor;

public interface RepositoryAutor {
	
	public void guarda(Autor autor);
	public List<Autor> todosOsAutores();
	public Autor buscaPorId(Long id);

}
