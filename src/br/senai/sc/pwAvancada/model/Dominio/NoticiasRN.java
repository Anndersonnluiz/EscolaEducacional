package br.senai.sc.pwAvancada.model.Dominio;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.pwAvancada.dao.NoticiasDao;

public class NoticiasRN {
	
	private NoticiasDao noticiasDao;	
	
	public NoticiasRN() {
		noticiasDao = new NoticiasDao();
	}
	
	
	public void salvar(Noticias noticias) throws SQLException{
		noticiasDao.salvar(noticias);
	}
	
	public Noticias consultar(int id) throws SQLException{
		return noticiasDao.consultar(id);
	}
	
	public List<Noticias> listaNoticias(String sql) throws SQLException{
		return noticiasDao.listar(sql);	
	}
	
	public void excluir(int id){
		noticiasDao.excluir(id);
	}
}
