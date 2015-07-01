package br.com.caelum.vraptor.exception;

public class ServidorIndisponivelException extends RuntimeException {

	
	public ServidorIndisponivelException(String url, Exception e) {
		super("Erro ao fazer requisição ao servidor na url " + url, e);
	}
}
