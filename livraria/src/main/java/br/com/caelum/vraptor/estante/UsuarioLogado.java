package br.com.caelum.vraptor.estante;

import javax.enterprise.context.SessionScoped;

import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.entity.Usuario;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.repository.RegistroDeUsuarios;

@Component
public class UsuarioLogado implements RegistroDeUsuarios{

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

	public Usuario comLoginESenha(String login, String senha) {
		return usuarioDao.buscaPorUsuarioSenha(login, senha);
	}

}
