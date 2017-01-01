package com.desafioconcrete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafioconcrete.dto.LoginDto;
import com.desafioconcrete.exception.RestException;
import com.desafioconcrete.model.Usuario;
import com.desafioconcrete.service.AutenticacaoService;

/**
 * Controller REST para a autenticação do sistema.
 * 
 * @author Pedro Henrique
 */
@RestController
public class AutenticacaoController extends BaseController {
	
	@Autowired
	private AutenticacaoService service;
	
	@RequestMapping(path="/autenticacao/login", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Usuario login(@RequestBody LoginDto dto) throws RestException {
		return service.login(dto);
	}
}
