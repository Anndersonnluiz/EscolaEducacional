package br.senai.sc.pwAvancada.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Turmausuario;

public class TurmaUsuarioDao {

	public Turmausuario salvar(Turmausuario turmausuario) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        turmausuario = manager.merge(turmausuario);
        manager.getTransaction().commit();
        manager.close();
        return turmausuario;
    }
    
    public Turmausuario consultar(String login, String senha) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery("select r from Questoesrespostas r");
        Turmausuario turmausuario = null;
        if (q.getResultList().size()>0){
        	turmausuario = (Turmausuario) q.getResultList().get(0);
        }
        manager.close();
        return turmausuario;
    }
    
    public List<Turmausuario> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Turmausuario> lista = q.getResultList();
        manager.close();
        return  lista;
    }
    
    public Turmausuario consultar(int idturmausuario) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Turmausuario turmausuario = manager.find(Turmausuario.class, idturmausuario);
        manager.close();
        return turmausuario;
    }
    
    public void excluir(Integer idturmausuario){
    	EntityManager manage = ConectionFactory.getConnection();
		
    	manage.getTransaction().begin();
    	Turmausuario turmausuario = manage.getReference(Turmausuario.class, idturmausuario);
		manage.remove(turmausuario);
		manage.getTransaction().commit();
		manage.close();
    }
}
