package com.desafioconcrete.dto;

import com.desafioconcrete.model.Telefone;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dto da entidade {@link Telefone}.
 * 
 * @author Pedro Henrique
 */
public class TelefoneDto {
	private String ddd;
	@JsonProperty("number")
	private String numero;

	/**
	 * @return ddd
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * @param ddd
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	/**
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
