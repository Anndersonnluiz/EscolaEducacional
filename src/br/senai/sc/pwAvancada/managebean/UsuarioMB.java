package br.senai.sc.pwAvancada.managebean;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;

import br.senai.sc.pwAvancada.model.Dominio.Perfil;
import br.senai.sc.pwAvancada.model.Dominio.PerfilRN;
import br.senai.sc.pwAvancada.model.Dominio.Turma;
import br.senai.sc.pwAvancada.model.Dominio.TurmaRN;
import br.senai.sc.pwAvancada.model.Dominio.Usuario;
import br.senai.sc.pwAvancada.model.Dominio.UsuarioRN;
import br.senai.sc.pwAvancada.util.Criptografia;

@ManagedBean
@ViewScoped
public class UsuarioMB {
	
	private Usuario usuario;
	private UsuarioRN usuarioRN;
	private List<Usuario> listaUsuario;
	private Integer editarId;
	private Perfil perfil;
	private List<Perfil> listarPerfil;
	private PerfilRN perfilRN;
	private Turma turma;
	private List<Turma> listaTurma;
	private TurmaRN turmaRN;
	
	@PostConstruct
	public void init(){
		usuario = new Usuario();
		turma = new Turma();
		usuarioRN = new UsuarioRN();
		perfilRN = new PerfilRN();
		turmaRN = new TurmaRN();
		gerarlistaPerfil();
		gerarlistaTurma();
	}

	
	
	
	


	public TurmaRN getTurmaRN() {
		return turmaRN;
	}







	public void setTurmaRN(TurmaRN turmaRN) {
		this.turmaRN = turmaRN;
	}







	public Turma getTurma() {
		return turma;
	}







	public void setTurma(Turma turma) {
		this.turma = turma;
	}







	public List<Turma> getListaTurma() {
		return listaTurma;
	}







	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}







	public PerfilRN getPerfilRN() {
		return perfilRN;
	}







	public void setPerfilRN(PerfilRN perfilRN) {
		this.perfilRN = perfilRN;
	}







	public List<Perfil> getListarPerfil() {
		return listarPerfil;
	}







	public void setListarPerfil(List<Perfil> listarPerfil) {
		this.listarPerfil = listarPerfil;
	}







	public Perfil getPerfil() {
		return perfil;
	}







	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}







	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public UsuarioRN getUsuarioRN() {
		return usuarioRN;
	}



	public void setUsuarioRN(UsuarioRN usuarioRN) {
		this.usuarioRN = usuarioRN;
	}



	public List<Usuario> getListaUsuario() {
		String sql = "Select u from Usuario u";
		if (listaUsuario == null) {
			try {
				listaUsuario = usuarioRN.listaUsuario(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (listaUsuario == null) {
				listaUsuario = new ArrayList<Usuario>();
			}
		}
		return listaUsuario;
	}



	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	
	
	
	
	public Integer getEditarId() {
		return editarId;
	}



	public void setEditarId(Integer editarId) {
		this.editarId = editarId;
	}



	public void carregarUsuario(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		try {
			usuario = usuarioRN.consultar(editarId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String excluir(){
		String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idusuario");
		Integer id = Integer.parseInt(idParam);
		usuarioRN.excluir(id);
		listaUsuario = null;
		return "";
	}
	
	public String salvar(){
		
		usuario.setPerfil(perfil);
		if (usuario.getIdUsuario() == 0) {
			usuario.setIdUsuario(null);
		}
		String senha  = usuario.getSenha();
		try {
			usuario.setSenha(Criptografia.encript(senha));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			turma = turmaRN.consultar(1);
			usuario.setTurma(turma);
			usuarioRN.salvar(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuario = new Usuario();
		listaUsuario = null;
		return "";
	}
	
	
	public void gerarlistaPerfil(){
		String sql = "Select p from Perfil p";
		try {
			listarPerfil = perfilRN.listaPerfil(sql);
			if (listarPerfil == null) {
				listarPerfil = new ArrayList<Perfil>();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gerarlistaTurma(){
		String sql = "Select t from Turma t";
		try {
			listaTurma = turmaRN.listaTurma(sql);
			if (listaTurma == null) {
				listaTurma = new ArrayList<Turma>();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	

}
