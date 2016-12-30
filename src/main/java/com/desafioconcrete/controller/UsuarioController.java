package com.desafioconcrete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafioconcrete.dto.UsuarioDto;
import com.desafioconcrete.model.Usuario;
import com.desafioconcrete.service.UsuarioService;

/**
 * Controlador REST da entidade {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
@RestController("/rest/usuario")
//TODO - Incluir status http nas respostas.
public class UsuarioController extends BaseController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Usuario criar(@RequestBody UsuarioDto dto) throws Exception {
		return service.criar(dto);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String teste(UsuarioDto dto) throws Exception {
		return "testando";
	}
}
