package br.senai.sc.pwAvancada.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Atividade;

public class AtividadeDao {
	
	public Atividade salvar(Atividade atividade) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        atividade = manager.merge(atividade);
        manager.getTransaction().commit();
        manager.close();
        return atividade;
    }
    
    public Atividade consultar(String login, String senha) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery("select u from Noticias u where u.login='" + login + "' and u.senha='" + senha + "'  order by u.nome");
        Atividade atividade = null;
        if (q.getResultList().size()>0){
        	atividade = (Atividade) q.getResultList().get(0);
        }
        manager.close();
        return atividade;
    }
    
    public List<Atividade> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Atividade> lista = q.getResultList();
        manager.close();
        return  lista;
    }
    
    public Atividade consultar(int idatividade) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Atividade atividade = manager.find(Atividade.class, idatividade);
        manager.close();
        return atividade;
    }
    
    public void excluir(Integer idatividade){
    	EntityManager manage = ConectionFactory.getConnection();
		
    	manage.getTransaction().begin();
    	Atividade atividade = manage.getReference(Atividade.class, idatividade);
		manage.remove(atividade);
		manage.getTransaction().commit();
		manage.close();
    }
}
