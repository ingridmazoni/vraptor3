package br.com.caelum.vraptor.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.caelum.vraptor.dao.LivroDao;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.ioc.Component;


@Component
public class JPALivroDao implements LivroDao {
	
	private EntityManager manager;
	
	void JPALivroDAO(EntityManager manager) {
		this.manager = manager;
		}


	public List<Livro> todos() {
		return this.manager
				.createQuery("select l from Livro l", Livro.class)
				.getResultList();
	}

	
	
	public void adiciona(Livro livro) {
		if (livro.getId() == null) {
			this.manager.persist(livro);
		} else {
			this.manager.merge(livro);
		}
		
	}


	public Livro buscaPorIsbn(String isbn) {
		try {
			return this.manager
					.createQuery("select l from Livro l where l.isbn = :isbn",Livro.class)
					.setParameter("isbn", isbn)
					.getSingleResult();
		} catch (NoResultException e) {
				
				return null;
		}
	}




}
