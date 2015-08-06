package livraria;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.entity.Dinheiro;
import br.com.caelum.vraptor.entity.DinheiroConverter;
import br.com.caelum.vraptor.entity.Moeda;


public class DinheiroConverterTest {
	
	@Test
	public void converteUmValorEmReais() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		assertThat(converter.convert("US$49,95", null, null),is(new Dinheiro(Moeda.DOLAR, new BigDecimal("49.95"))));
		}


	}
