package br.senai.sc.pwAvancada.model.Dominio;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.pwAvancada.dao.PerfilDao;


public class PerfilRN {

private PerfilDao perfilDao;	
	
	public PerfilRN() {
		perfilDao = new PerfilDao();
	}
	
	
	public void salvar(Perfil perfil) throws SQLException{
		perfilDao.salvar(perfil);
	}
	
	public Perfil consultar(int id) throws SQLException{
		return perfilDao.consultar(id);
	}
	
	public List<Perfil> listaPerfil(String sql) throws SQLException{
		return perfilDao.listar(sql);	
	}
	
	public void excluir(int id){
		perfilDao.excluir(id);
	}
}
