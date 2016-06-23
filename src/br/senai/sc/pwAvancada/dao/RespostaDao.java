package br.senai.sc.pwAvancada.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Atividade;
import br.senai.sc.pwAvancada.model.Dominio.Respostas;

public class RespostaDao {

	public Respostas salvar(Respostas respostas) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        respostas = manager.merge(respostas);
        manager.getTransaction().commit();
        manager.close();
        return respostas;
    }
    
    public Respostas consultar(String login, String senha) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery("select r from Resposta r");
        Respostas respostas = null;
        if (q.getResultList().size()>0){
        	respostas = (Respostas) q.getResultList().get(0);
        }
        manager.close();
        return respostas;
    }
    
    public List<Respostas> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Respostas> lista = q.getResultList();
        manager.close();
        return  lista;
    }
    
    public Respostas consultar(int idresposta) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Respostas respostas = manager.find(Respostas.class, idresposta);
        manager.close();
        return respostas;
    }
    
    public void excluir(Integer idresposta){
    	EntityManager manage = ConectionFactory.getConnection();
		
    	manage.getTransaction().begin();
    	Respostas respostas = manage.getReference(Respostas.class, idresposta);
		manage.remove(respostas);
		manage.getTransaction().commit();
		manage.close();
    }
}
