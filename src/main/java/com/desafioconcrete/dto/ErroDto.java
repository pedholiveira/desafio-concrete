package com.desafioconcrete.dto;

/**
 * DTO para retornar as mensagem das exceções ocorridas no sistema.
 * 
 * @author Pedro Henrique
 */
public class ErroDto {
	private String mensagem;

	/**
	 * Contrutor default da classe.
	 */
	public ErroDto() {
	}
	
	/**
	 * Construtor da classe.
	 * 
	 * @param e
	 */
	public ErroDto(Exception e) {
		mensagem = e.getMessage();
	}
	
	/**
	 * @return mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}