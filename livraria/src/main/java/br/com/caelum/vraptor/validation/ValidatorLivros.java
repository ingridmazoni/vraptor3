package br.com.caelum.vraptor.validation;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.entity.Livro;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Component
public class ValidatorLivros {
	
	private Validator validador;

	public ValidatorLivros(Validator validator) {
		
		this.validador=validator;
	}
	
	
	
	public Validator validaLivros(Livro livro){
			if(livro.getTitulo()==null){
				validador.add(new ValidationMessage("título é obrigatório", "Titulo"));
			}
	
		return validador;
	}
	

}
