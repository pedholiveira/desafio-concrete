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
	 * Atualiza um registro de um usuário.
	 * 
	 * @param usuario
	 * @return usuario atualizad
	 */
	public Usuario atualizar(Usuario usuario);
	
	/**
	 * Recupera um usuário salvo a partir do seu id.
	 * 
	 * @param is
	 * @return usuario encontrado
	 */
	public Usuario recuperar(String id);
	
	/**
	 * Busca um registro de usuário a partir de um email.
	 * 
	 * @param email
	 * @return usuario encontrado
	 */
	public Usuario buscar(String email);
	
	/**
	 * Busca um registro de usuário a partir de um email e senha.
	 * 
	 * @param email
	 * @param senha
	 * @return usuario encontrado
	 */
	public Usuario buscar(String email, String senha);
}
