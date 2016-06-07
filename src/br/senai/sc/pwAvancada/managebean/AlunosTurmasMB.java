package br.senai.sc.pwAvancada.managebean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

import br.senai.sc.pwAvancada.model.Dominio.Turma;
import br.senai.sc.pwAvancada.model.Dominio.TurmaRN;
import br.senai.sc.pwAvancada.model.Dominio.Usuario;
import br.senai.sc.pwAvancada.model.Dominio.UsuarioRN;

@ManagedBean(name="alunosTurmasMB")
@ViewScoped
public class AlunosTurmasMB {

	private Usuario usuario;
	private UsuarioRN usuarioRN;
	private Turma turma;
	private TurmaRN turmaRN;
	private List<Usuario> listaUsuario;
	private Usuario nomeProfessor;
	
	
	@PostConstruct
	public void init(){
		FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        turma = (Turma) session.getAttribute("turma");
        session.removeAttribute("turma");
		usuarioRN = new UsuarioRN();
		turmaRN = new TurmaRN();
		gerarListaAlunosTurma();
		consultarProfessorTurma();
	}

	
	

	public Usuario getNomeProfessor() {
		return nomeProfessor;
	}




	public void setNomeProfessor(Usuario nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
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


	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public TurmaRN getTurmaRN() {
		return turmaRN;
	}


	public void setTurmaRN(TurmaRN turmaRN) {
		this.turmaRN = turmaRN;
	}


	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}


	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	
	public void gerarListaAlunosTurma(){
		String sql = "Select u from Usuario u where u.perfil.idperfil=1 and u.turma.idturma=" + turma.getIdturma();
		try {
			listaUsuario = usuarioRN.listaUsuario(sql);
			if (listaUsuario == null) {
				listaUsuario = new ArrayList<Usuario>();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void consultarProfessorTurma(){
		String sql = "Select u from Usuario u where u.perfil.idperfil=2 and u.turma.idturma=" + turma.getIdturma();
		try {
			nomeProfessor = new Usuario();
			nomeProfessor = usuarioRN.consultarSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
