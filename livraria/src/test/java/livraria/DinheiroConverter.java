package livraria;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.entity.Dinheiro;
import br.com.caelum.vraptor.entity.Moeda;

@Convert(Dinheiro.class)
public class DinheiroConverter implements Converter<Dinheiro> {

	public Dinheiro convert(String value, Class<? extends Dinheiro> type,ResourceBundle bundle) {
		
		return new Dinheiro(Moeda.REAL, new BigDecimal("1.00"));
	}

}
