package br.com.caelum.vraptor.dao;

import java.util.List;

import br.com.caelum.vraptor.entity.Livro;

public interface LivroDao {
	
	public void adiciona(Livro livro);
	public List<Livro> todos();
	public Livro buscaPorIsbn(String isbn);
	public boolean buscaPorId(Long id);
	public void retira(Livro livro);

}
