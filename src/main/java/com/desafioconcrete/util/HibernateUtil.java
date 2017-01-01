package com.desafioconcrete.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.desafioconcrete.model.Telefone;
import com.desafioconcrete.model.Usuario;

/**
 * 
 * 
 * @author Pedro Henrique
 */
public abstract class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	static {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Telefone.class)
						.addAnnotatedClass(Usuario.class);
		
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
	}
	
	/**
	 * Retorna o {@link SessionFactory} para acesso ao banco de dados.
	 * 
	 * @return
	 */
	public static SessionFactory obterSessionFactory() {
		return sessionFactory;
	}
}
