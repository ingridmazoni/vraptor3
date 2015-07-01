package br.com.caelum.vraptor.clienteHTTP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.caelum.vraptor.exception.ServidorIndisponivelException;

import com.google.common.io.CharStreams;

public class URLClienteHTTP implements ClienteHTTP{

	public String get(String url) {
			try{
				URL servico = new URL(url);
				InputStream resposta = servico.openStream();
				Reader reader = new InputStreamReader(resposta);
				return CharStreams.toString(reader);
			} catch (MalformedURLException e) {
				e.printStackTrace();
				
				throw new IllegalArgumentException("A url " + url+" está inválida, corrija-a!", e);
			} catch (IOException e) {
				e.printStackTrace();
				
				throw new ServidorIndisponivelException(url, e);
			}
		
	}

}
