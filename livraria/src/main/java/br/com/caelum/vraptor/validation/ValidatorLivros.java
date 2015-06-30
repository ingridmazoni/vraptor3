package br.com.caelum.vraptor.validation;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.I18nMessage;

@Component
public class ValidatorLivros {
	
	private Validator validador;
	private 
	
	ValidatorLivros(Validator validator) {
		
		this.validador=validator;
	}
	
	
	
	public Validator validaLivros(Livro livro){
		this.validador.validate(livro);
		
			if(livro.getTitulo()==null){
				validador.add(new I18nMessage("Título", "campo.obrigatorio", "título"));
				
			}
	
		return validador;
	}
	

}
