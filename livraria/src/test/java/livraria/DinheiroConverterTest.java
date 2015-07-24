package livraria;

import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.entity.Dinheiro;
import br.com.caelum.vraptor.entity.Moeda;


public class DinheiroConverterTest {
	
	@Test
	public void converteUmValorEmReais() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		assertThat(converter.convert("R$ 1,00", null, null),is(new Dinheiro(Moeda.REAL, new BigDecimal("1.00"))));
		}


}
