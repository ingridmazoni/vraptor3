package br.com.caelum.vraptor.daoImplementation;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.entity.Usuario;
import br.com.caelum.vraptor.interceptadores.Transacional;
import br.com.caelum.vraptor.ioc.Component;

@Component
@SessionScoped
public class JPAUsuarioDao implements UsuarioDao {
	
	private EntityManager manager;
	
	
	public JPAUsuarioDao(EntityManager manager) {
		this.manager = manager;
	
			
	}


@Transacional	
public Usuario buscaPorUsuarioSenha(String login, String senha) {
		
		Usuario u;
		
		try{
		
			u=manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha",Usuario.class)
					.setParameter("login", login)
					.setParameter("senha", senha)
					.getSingleResult();
			
		}
		catch(NoResultException erro){
			u=null;
		}
		
	return u;
	}
	
}
