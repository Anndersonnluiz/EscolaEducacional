package br.senai.sc.pwAvancada.dao;

import javax.persistence.EntityManager;

import br.senai.sc.pwAvancada.util.JpaUtil;

public abstract class DAO {

	public DAO() {
		super();
	}

	protected EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}
}
