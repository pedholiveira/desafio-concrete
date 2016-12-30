package dao;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import dto.UsuarioDto;
import model.Usuario;
import repository.UsuarioRepository;
import util.HibernateUtil;

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
		session.beginTransaction();

		Usuario usuario = new Usuario(dto);
		usuario.setDataCriacao(LocalDateTime.now());
		usuario.setDataModificacao(LocalDateTime.now());
		
		session.save(usuario);
		
		session.getTransaction().commit();
		fecharSessionFactory();
		
		return usuario;
	}
	
	/**
	 * Retorna um {@link SessionFactory} para acesso ao banco. 
	 * 
	 * @return sessionFactory
	 */
	private SessionFactory obterSessionFactory() {
		return HibernateUtil.obterSessionFactory();
	}
	
	/**
	 * Fecha o {@link SessionFactory}. 
	 */
	private void fecharSessionFactory() {
		HibernateUtil.fechar();
	}
}
