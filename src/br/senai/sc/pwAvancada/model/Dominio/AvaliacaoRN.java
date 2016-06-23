package br.senai.sc.pwAvancada.model.Dominio;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.pwAvancada.dao.AvaliacaoDao;


public class AvaliacaoRN {

private AvaliacaoDao avaliacaoDao;	
	
	public AvaliacaoRN() {
		avaliacaoDao = new AvaliacaoDao();
	}
	
	
	public void salvar(Avaliacao avaliacao) throws SQLException{
		avaliacaoDao.salvar(avaliacao);
	}
	
	public Avaliacao consultar(int id) throws SQLException{
		return avaliacaoDao.consultar(id);
	}
	
	public List<Avaliacao> listaNoticias(String sql) throws SQLException{
		return avaliacaoDao.listar(sql);	
	}
	
	public void excluir(int id){
		avaliacaoDao.excluir(id);
	}
}
