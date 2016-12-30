package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Utilit�rio criado para o gerenciamento do {@link SessionFactory}.
 * 
 * @author Pedro Henrique
 */
public abstract class HibernateUtil {
	private static SessionFactory sessionFactory = criarSessionFactory();

	/**
	 * Cria uma nova inst�ncia de um {@link SessionFactory}.
	 * 
	 * @return session factory
	 */
	private static SessionFactory criarSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
			
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		
		return sessionFactory;
	}

	/**
	 * Obt�m uma inst�ncia de um Session Factory.
	 * 
	 * @return
	 */
	public static SessionFactory obterSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Fecha a inst�ncia do Session Factory.
	 */
	public static void fechar() {
		obterSessionFactory().close();
	}
}
