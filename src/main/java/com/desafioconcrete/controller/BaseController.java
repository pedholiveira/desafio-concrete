package com.desafioconcrete.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafioconcrete.dto.ErroDto;
import com.desafioconcrete.exception.RestException;

/**
 * Classe abstrata dos controladores do sistema.
 * 
 * @author Pedro Henrique
 */
public abstract class BaseController {
	
	/**
	 * Método manipulador 
	 * 
	 * @return dto com a mensagem de erro da exceção.
	 */
	@ExceptionHandler(Exception.class)
	public ErroDto exceptionHandler(Exception e, HttpServletResponse response) {
		if(e instanceof RestException) {
			response.setStatus(((RestException) e).getStatusHttp());
		}
		return new ErroDto(e);
	}
}
