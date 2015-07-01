package br.com.caelum.vraptor.servicoadmin;

import java.util.List;

import br.com.caelum.vraptor.Entity.Livro;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.repository.Acervo;

@Component
public class AcervoNoAdmin implements Acervo {

	public List<Livro> todosOsLivros() {
		// TODO Auto-generated method stub
		return null;
	}

}
