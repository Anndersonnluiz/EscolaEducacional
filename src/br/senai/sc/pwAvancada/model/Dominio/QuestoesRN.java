package br.senai.sc.pwAvancada.model.Dominio;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.pwAvancada.dao.QuestoesDao;


public class QuestoesRN {

private QuestoesDao questoesDao;
	
	public QuestoesRN() {
		questoesDao = new QuestoesDao();
	}
	
	
	public Questoes salvar(Questoes questoes) throws SQLException{
		return questoesDao.salvar(questoes);
	}
	
	public Questoes consultar(int id) throws SQLException{
		return questoesDao.consultar(id);
	}
	
	public List<Questoes> listaQuestoes(String sql) throws SQLException{
		return questoesDao.listar(sql);	
	}
	
	public void excluir(int id){
		questoesDao.excluir(id);
	}
}
