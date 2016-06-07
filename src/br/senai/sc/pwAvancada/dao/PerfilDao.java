package br.senai.sc.pwAvancada.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Perfil;

public class PerfilDao {

	public Perfil salvar(Perfil perfil) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        perfil = manager.merge(perfil);
        manager.getTransaction().commit();
        manager.close();
        return perfil;
    }
    
    public Perfil consultar(String login, String senha) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery("select u from Usuario u where u.login='" + login + "' and u.senha='" + senha + "'  order by u.nome");
        Perfil perfil = null;
        if (q.getResultList().size()>0){
        	perfil = (Perfil) q.getResultList().get(0);
        }
        manager.close();
        return perfil;
    }
    
    public List<Perfil> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Perfil> lista = q.getResultList();
        manager.close();
        return  lista;
    }
    
    public Perfil consultar(int idPerfil) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Perfil perfil = manager.find(Perfil.class, idPerfil);
        manager.close();
        return perfil;
    }
    
    public void excluir(Integer idPerfil){
    	EntityManager manage = ConectionFactory.getConnection();
		
    	manage.getTransaction().begin();
    	Perfil perfil = manage.getReference(Perfil.class, idPerfil);
		manage.remove(perfil);
		manage.getTransaction().commit();
		manage.close();
    }
	
}
