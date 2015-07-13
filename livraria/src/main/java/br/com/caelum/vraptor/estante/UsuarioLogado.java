package br.com.caelum.vraptor.estante;

import javax.enterprise.context.SessionScoped;

import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.entity.Usuario;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.repository.RepositoryUsuario;

@Component
@SessionScoped
public class UsuarioLogado implements RepositoryUsuario{

	private UsuarioDao usuarioDao;
	private Usuario usuario;
	
	
	public UsuarioLogado(UsuarioDao usuarioDao) {
		super();
		this.usuarioDao = usuarioDao;
	}

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogado() {
		return this.usuario != null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void desloga() {
		this.usuario = null;
	}

	public boolean buscaPorUsuarioSenha(Usuario usuario) {
		return usuarioDao.buscaPorUsuarioSenha(usuario);
	}

}
