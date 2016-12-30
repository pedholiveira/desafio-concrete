package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dto.TelefoneDto;

/**
 * Entidade para representar um número telefonico de um usuário.
 * 
 * @author Pedro Henrique
 */
@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {
	private static final long serialVersionUID = -586386007409444121L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "ddd", nullable = false)
	private String ddd;
	@Column(name = "numero", nullable = false)
	private String numero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	/**
	 * Construtor default da classe.
	 */
	public Telefone() {
	}
	
	/**
	 * Construtor da classe.
	 * 
	 * @param dto
	 */
	public Telefone(TelefoneDto dto) {
		this.ddd = dto.getDdd();
		this.numero = dto.getNumero();
	}
	
	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	
	/**
	 * @return usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
