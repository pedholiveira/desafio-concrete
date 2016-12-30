package dto;

import model.Telefone;

/**
 * Dto da entidade {@link Telefone}.
 * 
 * @author Pedro Henrique
 */
public class TelefoneDto {
	private String ddd;
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
