package br.com.caelum.vraptor.entity;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;

@Convert(Dinheiro.class)
public class DinheiroConverter implements Converter<Dinheiro> {

	public Dinheiro convert(String value, Class<? extends Dinheiro> type,ResourceBundle bundle) {
		
		return new Dinheiro(Moeda.REAL, new BigDecimal(value));
	}

}
