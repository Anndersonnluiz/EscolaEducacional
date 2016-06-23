package br.senai.sc.pwAvancada.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Questoesrespostas;

public class QuestoesRespostasDao {

	public Questoesrespostas salvar(Questoesrespostas questoesrespostas) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        questoesrespostas = manager.merge(questoesrespostas);
        manager.getTransaction().commit();
        manager.close();
        return questoesrespostas;
    }
    
    public Questoesrespostas consultar(String login, String senha) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery("select r from Questoesrespostas r");
        Questoesrespostas questoesrespostas = null;
        if (q.getResultList().size()>0){
        	questoesrespostas = (Questoesrespostas) q.getResultList().get(0);
        }
        manager.close();
        return questoesrespostas;
    }
    
    public List<Questoesrespostas> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Questoesrespostas> lista = q.getResultList();
        manager.close();
        return  lista;
    }
    
    public Questoesrespostas consultar(int idquestoesresposta) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Questoesrespostas questoesrespostas = manager.find(Questoesrespostas.class, idquestoesresposta);
        manager.close();
        return questoesrespostas;
    }
    
    public void excluir(Integer idquestoesresposta){
    	EntityManager manage = ConectionFactory.getConnection();
		
    	manage.getTransaction().begin();
    	Questoesrespostas questoesrespostas = manage.getReference(Questoesrespostas.class, idquestoesresposta);
		manage.remove(questoesrespostas);
		manage.getTransaction().commit();
		manage.close();
    }
}
