package br.senai.sc.pwAvancada.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Questoes;

public class QuestoesDao {

	public Questoes salvar(Questoes questoes) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        questoes = manager.merge(questoes);
        manager.getTransaction().commit();
        manager.close();
        return questoes;
    }
    
    public Questoes consultar(String login, String senha) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery("select r from Resposta r");
        Questoes questoes = null;
        if (q.getResultList().size()>0){
        	questoes = (Questoes) q.getResultList().get(0);
        }
        manager.close();
        return questoes;
    }
    
    public List<Questoes> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Questoes> lista = q.getResultList();
        manager.close();
        return  lista;
    }
    
    public Questoes consultar(int idquestoes) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Questoes questoes = manager.find(Questoes.class, idquestoes);
        manager.close();
        return questoes;
    }
    
    public void excluir(Integer idquestoes){
    	EntityManager manage = ConectionFactory.getConnection();
		
    	manage.getTransaction().begin();
    	Questoes questoes = manage.getReference(Questoes.class, idquestoes);
		manage.remove(questoes);
		manage.getTransaction().commit();
		manage.close();
    }
}
