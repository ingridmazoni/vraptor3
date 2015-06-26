package br.com.caelum.vraptor.dao;

import java.util.List;

import br.com.caelum.vraptor.entity.Autor;

public interface AutorDao {
	
	public void adiciona(Autor Autor);
	public List<Autor> todos();
	public Autor buscaPorId(Long id);

}
