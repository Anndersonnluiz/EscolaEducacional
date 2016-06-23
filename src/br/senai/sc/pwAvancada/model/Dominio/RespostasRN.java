package br.senai.sc.pwAvancada.model.Dominio;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.pwAvancada.dao.RespostaDao;


public class RespostasRN {

	private RespostaDao respostaDao;
	
	public RespostasRN() {
		respostaDao = new RespostaDao();
	}
	
	
	public Respostas salvar(Respostas respostas) throws SQLException{
		return respostaDao.salvar(respostas);
	}
	
	public Respostas consultar(int id) throws SQLException{
		return respostaDao.consultar(id);
	}
	
	public List<Respostas> listaRespostas(String sql) throws SQLException{
		return respostaDao.listar(sql);	
	}
	
	public void excluir(int id){
		respostaDao.excluir(id);
	}
}
