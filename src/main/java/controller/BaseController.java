package controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import dto.ErroDto;

/**
 * Classe abstrata dos controladores do sistema.
 * 
 * @author Pedro Henrique
 */
public abstract class BaseController {
	
	/**
	 * M�todo manipulador 
	 * 
	 * @return dto com a mensagem de erro da exce��o.
	 */
	@ExceptionHandler(Exception.class)
	public ErroDto exceptionHandler(Exception e) {
		return new ErroDto(e);
	}
}
