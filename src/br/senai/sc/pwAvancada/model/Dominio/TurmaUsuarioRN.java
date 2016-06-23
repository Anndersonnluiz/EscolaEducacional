package br.senai.sc.pwAvancada.model.Dominio;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.pwAvancada.dao.TurmaUsuarioDao;


public class TurmaUsuarioRN {

	
private TurmaUsuarioDao turmaUsuarioDao;	
	
	public TurmaUsuarioRN() {
		turmaUsuarioDao = new TurmaUsuarioDao();
	}
	
	
	public void salvar(Turmausuario turmausuario) throws SQLException{
		turmaUsuarioDao.salvar(turmausuario);
	}
	
	public Turmausuario consultar(Integer id) throws SQLException{
		return turmaUsuarioDao.consultar(id);
	}
	
	public List<Turmausuario> listaTurma(String sql) throws SQLException{
		return turmaUsuarioDao.listar(sql);	
	}
	
	public void excluir(Integer id){
		turmaUsuarioDao.excluir(id);
	}
}
