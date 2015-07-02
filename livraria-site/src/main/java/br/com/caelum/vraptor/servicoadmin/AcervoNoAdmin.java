package br.com.caelum.vraptor.servicoadmin;

import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.com.caelum.vraptor.Entity.Livro;
import br.com.caelum.vraptor.clienteHTTP.ClienteHTTP;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.repository.Acervo;

@Component
public class AcervoNoAdmin implements Acervo {
	
	private ClienteHTTP http;
	
	public AcervoNoAdmin(ClienteHTTP http) {
		this.http = http;
	}

	public List<Livro> todosOsLivros() {
		String xml = http.get("http://localhost:8080/livraria/integracao/listaLivros");
				XStream xstream = new XStream();
				xstream.alias("livros", List.class);
				xstream.alias("livro", Livro.class);
				List<Livro> livros = (List<Livro>) xstream.fromXML(xml);
				return livros;
	}

}
