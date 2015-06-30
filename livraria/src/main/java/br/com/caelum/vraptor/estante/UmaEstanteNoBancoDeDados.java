package br.com.caelum.vraptor.estante;

import java.util.List;

import javax.annotation.Resource;

import br.com.caelum.vraptor.dao.*;
import br.com.caelum.vraptor.entity.*;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.repository.*;

@Component
public class UmaEstanteNoBancoDeDados implements Estante{
	
	private final LivroDao dao;
	
	public UmaEstanteNoBancoDeDados(LivroDao dao) {
			this.dao = dao;
	}

	public void guarda(Livro livro) {
		this.dao.adiciona(livro);
		
	}

	public List<Livro> todosOsLivros() {
	
		return this.dao.todos();
	}

	public Livro buscaPorIsbn(String isbn) {
		
		return this.dao.buscaPorIsbn(isbn);
	}

	public boolean buscaPorId(Long id) {
		return this.dao.buscaPorId(id);
	}

	
	

}
