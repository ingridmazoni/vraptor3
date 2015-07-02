package br.com.caelum.vraptor.validation;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.repository.Estante;
import br.com.caelum.vraptor.validator.I18nMessage;

@Component
public class ValidatorLivros {
	
	private Validator validador;
	private Estante estante;
	
	ValidatorLivros(Validator validator,Estante estante) {
		
		this.validador=validator;
		this.estante=estante;
	}
	
	
	
	public Validator validaLivros(Livro livro){
		this.validador.validate(livro);
		
		if(livro.getId()!=null && estante.buscaPorId(livro.getId())==false){
			validador.add(new I18nMessage("livro", "nao.existe", "ID"));
		}
		
	
		return validador;
	}
	

}
