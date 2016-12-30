package com.desafioconcrete.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.desafioconcrete.dto.UsuarioDto;
import com.desafioconcrete.model.Telefone;
import com.desafioconcrete.model.Usuario;
import com.desafioconcrete.repository.UsuarioRepository;

/**
 * Implementação do repositório de dados da entidade {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
@Repository
public class UsuarioDao implements UsuarioRepository {

	@Override
	public Usuario criar(UsuarioDto dto) {
		Session session = obterSessionFactory().openSession();
		try {
			session.beginTransaction();
			
			Usuario usuario = new Usuario(dto);
			usuario.setDataCriacao(LocalDateTime.now());
			usuario.setDataModificacao(LocalDateTime.now());
			
			session.save(usuario);
			
			session.getTransaction().commit();

			return usuario;
		} finally {
			session.close();
		}
	}
	
	@Override
	public Usuario obterPorEmail(String email) {
		Session session = obterSessionFactory().openSession();
		try {
			Query<Usuario> query = session.createQuery(obterQueryBuscaPorEmail(), Usuario.class);
			query.setParameter("email", email);
			List<Usuario> resultado = query.getResultList();
			
			return resultado.size() > 0 ? resultado.get(0) : null;
		} finally {
			session.close();
		}
	}

	/**
	 * Retorna a query de busca de usuários por email.
	 * 
	 * @return query de busca
	 */
	private String obterQueryBuscaPorEmail() {
		return "select u from Usuario u where u.email = :email";
	}
	
	/**
	 * Retorna um {@link SessionFactory} para acesso ao banco. 
	 * 
	 * @return sessionFactory
	 */
	private SessionFactory obterSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Telefone.class)
						.addAnnotatedClass(Usuario.class);
		
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
	}
}
