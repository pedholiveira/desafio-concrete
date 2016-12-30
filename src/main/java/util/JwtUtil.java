package util;

import java.io.UnsupportedEncodingException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
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
	 * @throws UnsupportedEncodingException 
	 * @throws JWTCreationException 
	 * @throws IllegalArgumentException 
	 */
	public static String obterToken() throws IllegalArgumentException, JWTCreationException, UnsupportedEncodingException {
		String token = JWT.create()
		        			.withIssuer(ISSUER)
		        			.sign(Algorithm.HMAC256(SECRET));
		return token;
	}
	
	/**
	 * Verifica se um token é valido.
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
		}
		return true;
	}
}
