package br.senai.sc.pwAvancada.model.Dominio;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.senai.sc.pwAvancada.dao.UsuarioDao;

public class UsuarioRN {

	private UsuarioDao usuarioDao;	
	
	public UsuarioRN() {
		usuarioDao = new UsuarioDao();
	}
	
	
	public Usuario salvar(Usuario usuario) throws SQLException{
		return usuarioDao.salvar(usuario);
	}
	
	public Usuario consultar(int id) throws SQLException{
		return usuarioDao.consultar(id);
	}
	
	public Usuario consultarSql(String sql) throws SQLException{
		return usuarioDao.consultarSql(sql);
	}
	
	public List<Usuario> listaUsuario(String sql) throws SQLException{
		return usuarioDao.listar(sql);	
	}
	
	public void excluir(int id){
		usuarioDao.excluir(id);
	}
	
	public Usuario consultar(String login, String senha) {
        usuarioDao = new UsuarioDao();
        try {
            return usuarioDao.consultar(login, senha);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRN.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
