package br.com.caelum.vraptor.entity;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;

@Convert(Dinheiro.class)
public class DinheiroConverter implements Converter<Dinheiro> {

	public Dinheiro convert(String value, Class<? extends Dinheiro> type,ResourceBundle bundle) {
				
		for (Moeda moeda : Moeda.values()) {
			if (value.startsWith(moeda.getSimbolo())) {
				return new Dinheiro(moeda, new BigDecimal(value.replace(moeda.getSimbolo()," ").replace(',','.').trim()));
			}
		}
		return null;
	}

}
