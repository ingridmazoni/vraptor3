package br.com.caelum.vraptor.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.dao.LivroDao;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.ioc.Component;


@Component
public class JPALivroDao implements LivroDao {
	
	private EntityManager manager;
	
	
	public JPALivroDao(EntityManager manager) {
		super();
		this.manager = manager;
	}


	public List<Livro> todos() {
		this.manager.getTransaction().begin();
		return this.manager
				.createQuery("select l from Livro l", Livro.class)
				.getResultList();
	}

	
	



	public void adiciona(Livro livro) {
		if (livro.getId() == null) {
			this.manager.getTransaction().begin();
			this.manager.persist(livro);
			this.manager.getTransaction().commit();
		} else {
			this.manager.getTransaction().begin();
			this.manager.merge(livro);
			this.manager.getTransaction().commit();
		}
		
	}


	public Livro buscaPorIsbn(String isbn) {
		try {
			this.manager.getTransaction().begin();
			return	manager.createQuery("select l from Livro l where l.isbn = :isbn",Livro.class)
					.setParameter("isbn", isbn)
					.getSingleResult();
			
		} catch (NoResultException e) {
				
				return null;
		}
	}


	public boolean buscaPorId(Long id) {
		
		try {
			this.manager.getTransaction().begin();
					manager.createQuery("select l from Livro l where l.id = :id",Livro.class)
					.setParameter("id", id)
					.getSingleResult();
			this.manager.close();		
			return true;
			
		} catch (NoResultException e) {
				
				return false;
		}
		
	}




}
