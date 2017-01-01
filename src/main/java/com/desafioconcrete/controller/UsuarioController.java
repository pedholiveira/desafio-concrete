package com.desafioconcrete.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafioconcrete.dto.UsuarioDto;
import com.desafioconcrete.exception.RestException;
import com.desafioconcrete.model.Usuario;
import com.desafioconcrete.service.UsuarioService;

/**
 * Controlador REST da entidade {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
@RestController
public class UsuarioController extends BaseController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(path="/usuario", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Usuario criar(@RequestBody UsuarioDto dto, HttpServletResponse response) throws RestException {
		Usuario usuario = service.criar(dto);
		response.setStatus(HttpStatus.CREATED.value());
		return usuario;
	}
	
	@RequestMapping(path="/usuario/{id}", method=RequestMethod.GET, produces="application/json")
	public Usuario obter(@PathVariable String id, @RequestHeader("token") String token, HttpServletResponse response) throws Exception {
		return service.obter(id, token);
	}
}
