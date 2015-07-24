package br.com.caelum.vraptor.estante;

import java.util.List;

import br.com.caelum.vraptor.dao.AutorDao;
import br.com.caelum.vraptor.entity.Autor;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.repository.RepositoryAutor;

@Component
public class AutorNoBanco implements RepositoryAutor {
	
	private AutorDao daoAutor;
	
	public AutorNoBanco(AutorDao autordao){
		daoAutor=autordao;
	}

	public void guarda(Autor autor) {
		daoAutor.adiciona(autor);
		
	}

	public List<Autor> todosOsAutores() {
		return daoAutor.todos();
	}

	public Autor buscaPorId(Long id) {
		return daoAutor.buscaPorId(id);
	}

	

}
