package br.senai.sc.pwAvancada.model.Dominio;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.pwAvancada.dao.AtividadeDao;
import br.senai.sc.pwAvancada.dao.NoticiasDao;

public class AtividadeRN {

private AtividadeDao atividadeDao;	
	
	public AtividadeRN() {
		atividadeDao = new AtividadeDao();
	}
	
	
	public void salvar(Atividade atividade) throws SQLException{
		atividadeDao.salvar(atividade);
	}
	
	public Atividade consultar(int id) throws SQLException{
		return atividadeDao.consultar(id);
	}
	
	public List<Atividade> listaAtividade(String sql) throws SQLException{
		return atividadeDao.listar(sql);	
	}
	
	public void excluir(int id){
		atividadeDao.excluir(id);
	}
}
