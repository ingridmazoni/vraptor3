package br.com.caelum.vraptor.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.caelum.vraptor.dao.AutorDao;
import br.com.caelum.vraptor.entity.Autor;
import br.com.caelum.vraptor.interceptadores.Transacional;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
public class JPAAutorDao implements AutorDao {
	
	private EntityManager manager;
	
	

	public JPAAutorDao(EntityManager manager) {
		this.manager = manager;
	}
	
	//@Transacional
	public void adiciona(Autor autor) {
		this.manager.getTransaction().begin();
		if (autor.getId() == null) {
			
			this.manager.persist(autor);
					
		} else {
			this.manager.merge(autor);
		
		}
		this.manager.getTransaction().commit();
	}

	
	public List<Autor> todos() {
		return this.manager
				.createQuery("select a from Autor a", Autor.class)
				.getResultList();
		
		
	}

	
	public Autor buscaPorId(Long id) {
		try {
			return	manager.createQuery("select a from Autor a where a.id = :id",Autor.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (NoResultException e) {
				
				return null;
		}
	}
	

}
