package br.senai.sc.pwAvancada.model.Dominio;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.pwAvancada.dao.TurmaDao;


public class TurmaRN {

	private TurmaDao turmaDao;	
	
	public TurmaRN() {
		turmaDao = new TurmaDao();
	}
	
	
	public Turma salvar(Turma turma) throws SQLException{
		return turmaDao.salvar(turma);
	}
	
	public Turma consultar(Integer id) throws SQLException{
		return turmaDao.consultar(id);
	}
	
	public List<Turma> listaTurma(String sql) throws SQLException{
		return turmaDao.listar(sql);	
	}
	
	public void excluir(Integer id){
		turmaDao.excluir(id);
	}
}
