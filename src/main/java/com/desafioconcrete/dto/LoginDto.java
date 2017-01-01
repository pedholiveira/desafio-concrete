package com.desafioconcrete.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dto com os dados de login.
 * 
 * @author Pedro Henrique
 */
public class LoginDto {
	private String email;
	@JsonProperty("password")
	private String senha;

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
