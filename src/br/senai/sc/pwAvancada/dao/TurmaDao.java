package br.senai.sc.pwAvancada.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Turma;
import br.senai.sc.pwAvancada.model.Dominio.Usuario;

public class TurmaDao {

	public Turma salvar(Turma turma) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        turma = manager.merge(turma);
        manager.getTransaction().commit();
        manager.close();
        return turma;
    }
    
    public Turma consultar(String login, String senha) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery("select u from Turma u where u.login='" + login + "' and u.senha='" + senha + "'  order by u.nome");
        Turma turma = null;
        if (q.getResultList().size()>0){
        	turma = (Turma) q.getResultList().get(0);
        }
        manager.close();
        return turma;
    }
    
    public List<Turma> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Turma> lista = q.getResultList();
        manager.close();
        return  lista;
    }
    
    public Turma consultar(int idTurma) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Turma turma = manager.find(Turma.class, idTurma);
        manager.close();
        return turma;
    }
    
    public void excluir(Integer idturma){
    	EntityManager manage = ConectionFactory.getConnection();
		
    	manage.getTransaction().begin();
    	Turma turma = manage.getReference(Turma.class, idturma);
		manage.remove(turma);
		manage.getTransaction().commit();
		manage.close();
    }
}
