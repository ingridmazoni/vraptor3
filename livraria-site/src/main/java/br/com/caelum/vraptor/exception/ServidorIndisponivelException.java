package br.com.caelum.vraptor.exception;

public class ServidorIndisponivelException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServidorIndisponivelException(String url, Exception e) {
		super("Erro ao fazer requisição ao servidor na url " + url, e);
	}
}
