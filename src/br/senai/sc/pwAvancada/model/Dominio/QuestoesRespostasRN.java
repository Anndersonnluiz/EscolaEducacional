package br.senai.sc.pwAvancada.model.Dominio;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.pwAvancada.dao.QuestoesRespostasDao;


public class QuestoesRespostasRN {
	
private QuestoesRespostasDao questoesRespostasDao;
	
	public QuestoesRespostasRN() {
		questoesRespostasDao = new QuestoesRespostasDao();
	}
	
	
	public void salvar(Questoesrespostas questoesrespostas) throws SQLException{
		questoesRespostasDao.salvar(questoesrespostas);
	}
	
	public Questoesrespostas consultar(int id) throws SQLException{
		return questoesRespostasDao.consultar(id);
	}
	
	public List<Questoesrespostas> listaRespostas(String sql) throws SQLException{
		return questoesRespostasDao.listar(sql);	
	}
	
	public void excluir(int id){
		questoesRespostasDao.excluir(id);
	}

}
