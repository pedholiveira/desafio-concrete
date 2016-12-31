package com.desafioconcrete.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.desafioconcrete.dto.LoginDto;
import com.desafioconcrete.exception.RestException;
import com.desafioconcrete.model.Usuario;
import com.desafioconcrete.repository.UsuarioRepository;

/**
 * Camada de serviços da autenticação do sistema.
 * 
 * @author Pedro Henrique
 */
@Service
public class AutenticacaoService {
	
	@Autowired
	private UsuarioRepository repository;
	
	/**
	 * Realiza a busca pelo o usuário que realizará o login.
	 * 
	 * @param dto
	 * @return usuário encontrado.
	 * 
	 * @throws RestException
	 */
	public Usuario login(LoginDto dto) throws RestException {
		Usuario usuario = repository.buscar(dto.getEmail(), dto.getSenha());
		if(usuario == null) {
			throw new RestException(HttpStatus.UNAUTHORIZED, "Usuário e/ou senha inválidos");
		}
		usuario.setUltimoLogin(LocalDateTime.now());
		repository.atualizar(usuario);
		return usuario;
	}
}
