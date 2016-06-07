package br.senai.sc.pwAvancada.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Noticias;
import br.senai.sc.pwAvancada.model.Dominio.Turma;

public class NoticiasDao {

	public Noticias salvar(Noticias noticias) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        noticias = manager.merge(noticias);
        manager.getTransaction().commit();
        manager.close();
        return noticias;
    }
    
    public Noticias consultar(String login, String senha) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery("select u from Noticias u where u.login='" + login + "' and u.senha='" + senha + "'  order by u.nome");
        Noticias noticias = null;
        if (q.getResultList().size()>0){
        	noticias = (Noticias) q.getResultList().get(0);
        }
        manager.close();
        return noticias;
    }
    
    public List<Noticias> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Noticias> lista = q.getResultList();
        manager.close();
        return  lista;
    }
    
    public Noticias consultar(int idnoticias) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Noticias noticias = manager.find(Noticias.class, idnoticias);
        manager.close();
        return noticias;
    }
    
    public void excluir(Integer idnoticias){
    	EntityManager manage = ConectionFactory.getConnection();
		
    	manage.getTransaction().begin();
    	Noticias noticias = manage.getReference(Noticias.class, idnoticias);
		manage.remove(noticias);
		manage.getTransaction().commit();
		manage.close();
    }
}
