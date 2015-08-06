package br.com.caelum.vraptor.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.dao.LivroDao;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.interceptadores.Transacional;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;


@Component
public class JPALivroDao implements LivroDao {
	
	private EntityManager manager;
	
	
	public JPALivroDao(EntityManager manager) {
		this.manager = manager;
	
	}


	public List<Livro> todos() {
		return this.manager
				.createQuery("select l from Livro l", Livro.class)
				.getResultList();
	}

	
	


	/*@Transacional*/
	public void adiciona(Livro livro) {
		this.manager.getTransaction().begin();
		
		if (livro.getId() == null) {
		
			this.manager.persist(livro);
		
		
		} else {
			this.manager.merge(livro);
			
		
		}
		this.manager.getTransaction().commit();
		
	}

	
	public Livro buscaPorIsbn(String isbn) {
		try {
			return	manager.createQuery("select l from Livro l where l.isbn = :isbn",Livro.class)
					.setParameter("isbn", isbn)
					.getSingleResult();
					
		} catch (NoResultException e) {
				
				return null;
		}
	}


	public boolean buscaPorId(Long id) {
		
		try {
				manager.createQuery("select l from Livro l where l.id = :id",Livro.class)
					.setParameter("id", id)
					.getSingleResult();
				
			return true;
			
		} catch (NoResultException e) {
				
				return false;
		}
		
	}


	public void retira(Livro livro) {
				
		if (livro.getId() == null) {
			this.manager.getTransaction().begin();
			this.manager.remove(livro);
			this.manager.getTransaction().commit();
			
		} 
	}




}
