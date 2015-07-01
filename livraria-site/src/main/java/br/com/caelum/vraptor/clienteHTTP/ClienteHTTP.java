package br.com.caelum.vraptor.clienteHTTP;
import br.com.caelum.vraptor.exception.*;

public interface ClienteHTTP{
	
	String get(String url) throws ServidorIndisponivelException;
}
