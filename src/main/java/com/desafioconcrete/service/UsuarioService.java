package com.desafioconcrete.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.desafioconcrete.dto.UsuarioDto;
import com.desafioconcrete.exception.RestException;
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
	 * @throws RestException 
	 */
	public Usuario criar(UsuarioDto dto) throws RestException {
		if(repository.buscar(dto.getEmail()) != null) {
			throw new RestException(HttpStatus.CONFLICT, "E-mail já existente.");
		}
		
		try {
			String token = JwtUtil.obterToken();
			dto.setToken(token);
			return repository.criar(dto);
		} catch (Exception e) {
			throw new RestException("Erro ao tentar gerar token para o usuário.");
		}
	}
	
	/**
	 * Busca um usuário a partir do seu id e token.
	 * 
	 * @param id 
	 * @param token
	 * 
	 * @return usuario encontrado.
	 * @throws RestException 
	 */
	public Usuario obter(String id, String token) throws RestException {
		Usuario usuario = repository.recuperar(id);
		boolean sessaoExpirou = !usuario.getUltimoLogin().isAfter(LocalDateTime.now().minusMinutes(30));
		
		if(token == null || !usuario.getToken().equals(token)) {
			throw new RestException(HttpStatus.UNAUTHORIZED, "Não autorizado.");
		} else if(sessaoExpirou) {
			throw new RestException(HttpStatus.UNAUTHORIZED, "Sessão inválida.");
		}
			
		return usuario;
	}
}
