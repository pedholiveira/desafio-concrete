package com.desafioconcrete.test.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.desafioconcrete.util.JwtUtil;

/**
 * Testes unitários da classe {@link JwtUtil}.
 * 
 * @author Pedro Henrique
 */
@RunWith(MockitoJUnitRunner.class)
public class JwtUtilTest {
	
	@Test
	public void testarValidacao() throws Exception {
		String token = JwtUtil.obterToken();
		Assert.assertTrue("Verificação do token deverá retornar true.", JwtUtil.validarToken(token));
	}
	
	@Test
	public void testarErroValidacao() throws Exception {
		String token = "token invalido";
		Assert.assertFalse("Verificação do token deverá retornar false.", JwtUtil.validarToken(token));
	}
}
