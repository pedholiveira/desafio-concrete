package dto;

import java.util.List;

import model.Usuario;

/**
 * Dto da entidade {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
public class UsuarioDto {
	private String nome;
	private String email;
	private String senha;
	private String token;
	private List<TelefoneDto> telefones;

	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

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

	/**
	 * @return token
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * @param token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * @return telefones
	 */
	public List<TelefoneDto> getTelefones() {
		return telefones;
	}

	/**
	 * @param telefones
	 */
	public void setTelefones(List<TelefoneDto> telefones) {
		this.telefones = telefones;
	}

}
