package br.com.caelum.vraptor.validation;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.entity.Autor;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.I18nMessage;

@Component
public class ValidatorAutor {
	
	private Validator validador;

	public ValidatorAutor(Validator validator) {
		
		this.validador=validator;
	}
	
	
	
	public Validator validaAutor(Autor autor){
		this.validador.validate(autor);
		
			/*if(autor.getId()==null){
				validador.add(new I18nMessage("ID", "campo.obrigatorio", "ID"));
				
			}*/
	
		return validador;
	}

}
