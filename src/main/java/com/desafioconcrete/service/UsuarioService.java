package com.desafioconcrete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioconcrete.dto.UsuarioDto;
import com.desafioconcrete.model.Usuario;
import com.desafioconcrete.repository.UsuarioRepository;
import com.desafioconcrete.util.JwtUtil;

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
		if(repository.obterPorEmail(dto.getEmail()) != null) {
			throw new Exception("E-mail já existente.");
		}
		
		String token = JwtUtil.obterToken();
		dto.setToken(token);
		
		return repository.criar(dto);
	}
}
