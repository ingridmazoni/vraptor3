package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.entity.Usuario;

public interface UsuarioDao {
	
	public boolean buscaPorUsuarioSenha(Usuario usuario);

}
