package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UsuarioDto;
import model.Usuario;
import repository.UsuarioRepository;
import util.JwtUtil;

/**
 * Camada de serviços da entidade {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	/**
	 * Cria um novo registro de Usuario.
	 * 
	 * @param usuario
	 * @return registro criado
	 * 
	 * @throws Exception 
	 */
	public Usuario criar(UsuarioDto dto) throws Exception {
		try {
			String token = JwtUtil.obterToken();
			dto.setToken(token);
			
			return repository.criar(dto);
		} catch (Exception e) {
			throw new Exception("Falha ao tentar gerar token para o usu�rio.");
		}
	}
}
