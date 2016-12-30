package com.desafioconcrete.repository;

import com.desafioconcrete.dto.UsuarioDto;
import com.desafioconcrete.model.Usuario;

/**
 * Repositório de dados da entidade {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
public interface UsuarioRepository {
	
	/**
	 * Cria um novo registro de usuário no banco.
	 * 
	 * @param dto
	 * @return usuario
	 */
	public Usuario criar(UsuarioDto dto);
	
	/**
	 * Retorna um registro de usuário a partir de um email.
	 * 
	 * @param email
	 * @return usuario encontrado
	 */
	public Usuario obterPorEmail(String email);
}
