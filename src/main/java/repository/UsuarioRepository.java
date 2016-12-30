package repository;

import dto.UsuarioDto;
import model.Usuario;

/**
 * Reposit�rio de dados da entidade {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
public interface UsuarioRepository {
	
	/**
	 * Cria um novo registro de usu�rio no banco.
	 * 
	 * @param dto
	 * @return usuario
	 */
	public Usuario criar(UsuarioDto dto);
}
