package com.desafioconcrete.exception;

import org.springframework.http.HttpStatus;

/**
 * Exceção ocorrida no sistema.
 * 
 * @author Pedro Henrique
 */
public class RestException extends Exception {
	private static final long serialVersionUID = -1338636300473603066L;

	private int statusHttp;
	private String mensagem;

	/**
	 * Construtor da exceção.
	 * 
	 * @param mensagem
	 */
	public RestException(String mensagem) {
		super(mensagem);
		this.statusHttp = HttpStatus.INTERNAL_SERVER_ERROR.value();
		this.mensagem = mensagem;
	}
	
	/**
	 * Construtor da exceção.
	 * 
	 * @param statusHttp
	 * @param mensagem
	 */
	public RestException(int statusHttp, String mensagem) {
		super(mensagem);
		this.statusHttp = statusHttp;
		this.mensagem = mensagem;
	}
	
	/**
	 * Construtor da exceção.
	 * 
	 * @param statusHttp
	 * @param mensagem
	 */
	public RestException(HttpStatus statusHttp, String mensagem) {
		super(mensagem);
		this.statusHttp = statusHttp.value();
		this.mensagem = mensagem;
	}
	
	/**
	 * Construtor da exceção.
	 * 
	 * @param statusHttp
	 * @param mensagem
	 * @param throwable
	 */
	public RestException(int statusHttp, String mensagem, Throwable throwable) {
		super(mensagem, throwable);
		this.statusHttp = statusHttp;
		this.mensagem = mensagem;
	}

	/**
	 * Retorna a mensagem de erro da exceção.
	 * 
	 * @return a mensagem de erro.
	 */
	public String getMensagem() {
		return mensagem;
	}
	
	/**
	 * Retorna o status http referente ao erro.
	 * 
	 * @return status http
	 */
	public int getStatusHttp() {
		return statusHttp;
	}
}
