package br.com.caelum.vraptor.daoImplementation;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.entity.Usuario;
import br.com.caelum.vraptor.ioc.Component;

@Component
@SessionScoped
public class JPAUsuarioDao implements UsuarioDao {
	
	private EntityManager manager;
	
	
	public JPAUsuarioDao(EntityManager manager) {
		super();
		this.manager = manager;
		this.manager.getTransaction().begin();
	}


public boolean buscaPorUsuarioSenha(Usuario usuario) {
		
		
	return manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha",Usuario.class)
					.setParameter("login", usuario.getLogin())
					.setParameter("senha", usuario.getSenha())
					.getSingleResult() != null;
			
	
	}
	
}
