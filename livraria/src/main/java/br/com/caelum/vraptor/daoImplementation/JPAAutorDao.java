package br.com.caelum.vraptor.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.caelum.vraptor.dao.AutorDao;
import br.com.caelum.vraptor.entity.Autor;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class JPAAutorDao implements AutorDao {
	
	private EntityManager manager;
	
	

	public JPAAutorDao(EntityManager manager) {
		super();
		this.manager = manager;
	}

	public void adiciona(Autor autor) {
		if (autor.getId() == null) {
			this.manager.getTransaction().begin();
			this.manager.persist(autor);
			this.manager.getTransaction().commit();
		} else {
			this.manager.getTransaction().begin();
			this.manager.merge(autor);
			this.manager.getTransaction().commit();
		}
		
	}

	public List<Autor> todos() {
		this.manager.getTransaction().begin();
		return this.manager
				.createQuery("select a from Autor a", Autor.class)
				.getResultList();
		
		
	}

	public Autor buscaPorId(Long id) {
		try {
			this.manager.getTransaction().begin();
			return	manager.createQuery("select a from Autor a where a.id = :id",Autor.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (NoResultException e) {
				
				return null;
		}
	}
	

}
