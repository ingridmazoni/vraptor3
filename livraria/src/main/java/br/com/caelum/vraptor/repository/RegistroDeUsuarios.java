package br.com.caelum.vraptor.repository;

import br.com.caelum.vraptor.entity.Usuario;

public interface RegistroDeUsuarios {
	
	public void loga(Usuario usuario);
	public boolean isLogado();
	public Usuario getUsuario();
	public void desloga();
	Usuario comLoginESenha(String login, String senha);

}
