package com.desafioconcrete.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

/**
 * Utilitário criado para manipular os 
 * tokens de acesso do sistema.
 * 
 * @author Pedro Henrique
 */
public abstract class JwtUtil {
	
	private static final String ISSUER = "concretesolutions";
	private static final String SECRET = "secret";
	
	/**
	 * Cria um novo token de acesso.
	 * 
	 * @return token
	 * 
	 * @throws Exception 
	 */
	public static String obterToken() throws Exception {
		try {
			String token = JWT.create()
			        			.withIssuer(ISSUER)
			        			.sign(Algorithm.HMAC256(SECRET));
			return token;
		} catch (Exception e) {
			throw new Exception("Falha ao tentar gerar token para o usuário.");
		}
	}
	
	/**
	 * Verifica se um token � valido.
	 * 
	 * @param token
	 * @return true caso o token seja valido.
	 * 
	 * @throws Exception 
	 */
	public boolean validarToken(String token) throws Exception {
		try {
		    JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET))
		    							.withIssuer(ISSUER)
		    							.build();
		    verifier.verify(token);
		} catch (JWTVerificationException exception){
		    return false;
		} catch (Exception e) {
			throw new Exception("Falha ao tentar validar token do usuário.");
		}
		
		return true;
	}
}
