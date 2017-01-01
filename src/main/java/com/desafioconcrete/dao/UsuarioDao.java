package com.desafioconcrete.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.desafioconcrete.dto.UsuarioDto;
import com.desafioconcrete.model.Usuario;
import com.desafioconcrete.repository.UsuarioRepository;
import com.desafioconcrete.util.HibernateUtil;

/**
 * Implementação do repositório de dados da entidade {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
@Repository
public class UsuarioDao implements UsuarioRepository {

	@Override
	public Usuario criar(UsuarioDto dto) {
		Session session = HibernateUtil.obterSessionFactory().openSession();
		try {
			session.beginTransaction();
			
			Usuario usuario = new Usuario(dto);
			usuario.setDataCriacao(LocalDateTime.now());
			usuario.setDataModificacao(LocalDateTime.now());
			
			session.persist(usuario);
			
			session.getTransaction().commit();

			return usuario;
		} finally {
			session.close();
		}
	}
	
	@Override
	public Usuario atualizar(Usuario usuario) {
		Session session = HibernateUtil.obterSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(usuario);
			session.getTransaction().commit();

			return usuario;
		} finally {
			session.close();
		}
	}
	
	@Override
	public Usuario recuperar(String id) {
		String sql = "select u from Usuario u where u.id = :id";
		Session session = HibernateUtil.obterSessionFactory().openSession();
		try {
			Query<Usuario> query = session.createQuery(sql, Usuario.class);
			query.setParameter("id", id);

			List<Usuario> resultado = query.getResultList();
			return resultado.size() > 0 ? resultado.get(0) : null;
		} finally {
			session.close();
		}
	}
	
	@Override
	public Usuario buscar(String email) {
		String sql = "select u from Usuario u where u.email = :email";
		Session session = HibernateUtil.obterSessionFactory().openSession();
		try {
			Query<Usuario> query = session.createQuery(sql, Usuario.class);
			query.setParameter("email", email);

			List<Usuario> resultado = query.getResultList();
			return resultado.size() > 0 ? resultado.get(0) : null;
		} finally {
			session.close();
		}
	}

	@Override
	public Usuario buscar(String email, String senha) {
		String sql = "select u from Usuario u where u.email = :email and u.senha = :senha";
		Session session = HibernateUtil.obterSessionFactory().openSession();
		try {
			Query<Usuario> query = session.createQuery(sql, Usuario.class);
			query.setParameter("email", email);
			query.setParameter("senha", senha);
			
			List<Usuario> resultado = query.getResultList();
			return resultado.size() > 0 ? resultado.get(0) : null;
		} finally {
			session.close();
		}
	}
}
