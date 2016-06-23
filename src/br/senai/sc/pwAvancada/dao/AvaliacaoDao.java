package br.senai.sc.pwAvancada.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Avaliacao;

public class AvaliacaoDao {

	public Avaliacao salvar(Avaliacao avaliacao) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        avaliacao = manager.merge(avaliacao);
        manager.getTransaction().commit();
        manager.close();
        return avaliacao;
    }
    
    public Avaliacao consultar(String login, String senha) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery("select a from Avaliacao a ");
        Avaliacao avaliacao = null;
        if (q.getResultList().size()>0){
        	avaliacao = (Avaliacao) q.getResultList().get(0);
        }
        manager.close();
        return avaliacao;
    }
    
    public List<Avaliacao> listar(String sql) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Avaliacao> lista = q.getResultList();
        manager.close();
        return  lista;
    }
    
    public Avaliacao consultar(int idavaliacao) throws SQLException{
        EntityManager manager = ConectionFactory.getConnection();
        Avaliacao avaliacao = manager.find(Avaliacao.class, idavaliacao);
        manager.close();
        return avaliacao;
    }
    
    public void excluir(Integer idavaliacao){
    	EntityManager manage = ConectionFactory.getConnection();
		
    	manage.getTransaction().begin();
    	Avaliacao avaliacao = manage.getReference(Avaliacao.class, idavaliacao);
		manage.remove(avaliacao);
		manage.getTransaction().commit();
		manage.close();
    }
}
