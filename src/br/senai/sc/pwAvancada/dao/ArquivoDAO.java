package br.senai.sc.pwAvancada.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.pwAvancada.connection.ConectionFactory;
import br.senai.sc.pwAvancada.model.Dominio.Imagem;

public class ArquivoDAO {

	
	public void salvar(Imagem foto) {
		EntityManager manager = ConectionFactory.getConnection();
        manager.getTransaction().begin();
        foto = manager.merge(foto);
        manager.getTransaction().commit();
        manager.close();
	}

	public List<Imagem> listarImagens(Integer idimagem) {
		EntityManager manager = ConectionFactory.getConnection();
		Query query = manager.createQuery(
				"From Imagem "
				, Imagem.class);
		return query.getResultList();
	}

	public void excluir(Imagem imagem) {
		EntityManager manage = ConectionFactory.getConnection();
    	manage.getTransaction().begin();
    	Imagem img = manage.getReference(Imagem.class, imagem.getIdimagem());
		manage.remove(img);
		manage.getTransaction().commit();
		manage.close();
	}
}
