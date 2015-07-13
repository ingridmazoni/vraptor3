package br.com.caelum.vraptor.repository;

import br.com.caelum.vraptor.entity.Usuario;

public interface RepositoryUsuario {
	
	public void loga(Usuario usuario);
	public boolean isLogado();
	public Usuario getUsuario();
	public void desloga();
	boolean buscaPorUsuarioSenha(Usuario usuario);

}
