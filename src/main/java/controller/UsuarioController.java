package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.UsuarioDto;
import model.Usuario;
import service.UsuarioService;

/**
 * Controlador REST da entidade {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
@RestController("/rest/usuario")
public class UsuarioController extends BaseController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public Usuario criar(UsuarioDto dto) throws Exception {
		return service.criar(dto);
	}
}
