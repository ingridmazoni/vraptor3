package br.com.caelum.vraptor.entity;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;

@Convert(Dinheiro.class)
public class DinheiroConverter implements Converter<Dinheiro> {

	public Dinheiro convert(String value, Class<? extends Dinheiro> type,ResourceBundle bundle) {
		
		/*if (value.startsWith("R$")) {
			return new Dinheiro(Moeda.REAL,	new BigDecimal(value.substring(2, value.length())));
		}
		if (value.startsWith("US$")) {
			return new Dinheiro(Moeda.DOLAR,new BigDecimal(value.substring(3, value.length())));
		}
		if (value.startsWith("€")) {
			return new Dinheiro(Moeda.EURO,	new BigDecimal(value.substring(1, value.length())));
		}
		if (value.startsWith("£")) {
			return new Dinheiro(Moeda.LIBRA, new BigDecimal(value.substring(1, value.length())));
		}*/
		
		for (Moeda moeda : Moeda.values()) {
			if (value.startsWith(moeda.getSimbolo())) {
				return new Dinheiro(moeda, new BigDecimal(value.replace(moeda.getSimbolo()," ").replace(',','.').trim()));
			}
		}
		return null;
	}

}
