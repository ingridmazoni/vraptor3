package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.entity.Usuario;
import br.com.caelum.vraptor.repository.RepositoryUsuario;

@Resource
public class UsuarioController {
	
	 private RepositoryUsuario repositoryUser;
	 private Result result;
	 
	 public UsuarioController(RepositoryUsuario repositoryUser, Result result) {
	        this.repositoryUser = repositoryUser;
	        this.result = result;
	    }
	 
	 public void telaLogin() {
	    
	 }
	 
	 
	 public void verificaLogin(Usuario usuario){
		 
		 if(repositoryUser.buscaPorUsuarioSenha(usuario)){
			 result.of(LivrosController.class).formulario();
		 }
		 else{
			 result.include("error","Usuário ou senha estão incorretos");
			 result.of(this).telaLogin();
			 
		 }
		 
	 }
	 
	 

	
	
	
	

}
