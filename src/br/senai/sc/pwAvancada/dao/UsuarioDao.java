package br.senai.sc.pwAvancada.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Usuario;

public class UsuarioDao{

	
	public Usuario salvar(Usuario usuario) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        usuario = manager.merge(usuario);
        manager.getTransaction().commit();
        manager.close();
        return usuario;
    }
    
    public Usuario consultar(String login, String senha) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery("select u from Usuario u where u.login='" + login + "' and u.senha='" + senha + "'  order by u.nome");
        Usuario usuario = null;
        if (q.getResultList().size()>0){
            usuario = (Usuario) q.getResultList().get(0);
        }
        manager.close();
        return usuario;
    }
    
    public List<Usuario> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Usuario> lista = q.getResultList();
        manager.close();
        return  lista;
    }
    
    public Usuario consultar(int idUsuario) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Usuario usuario = manager.find(Usuario.class, idUsuario);
        manager.close();
        return usuario;
    }
    
    public void excluir(Integer idusuario){
    	EntityManager manage = ConectionFactory.getConnection();
		
    	manage.getTransaction().begin();
		Usuario usuario = manage.getReference(Usuario.class, idusuario);
		manage.remove(usuario);
		manage.getTransaction().commit();
		manage.close();
    }
    
    
    public Usuario consultarSql(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        Usuario usuario = null;
        if (q.getResultList().size()>0){
        	usuario = (Usuario) q.getResultList().get(0);
        }
        manager.close();
        return usuario;
    }
    
    
	

}
