package br.senai.sc.pwAvancada.managebean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.pwAvancada.model.Dominio.Turma;
import br.senai.sc.pwAvancada.model.Dominio.TurmaRN;
import br.senai.sc.pwAvancada.model.Dominio.Usuario;
import br.senai.sc.pwAvancada.model.Dominio.UsuarioRN;

@ManagedBean
public class VincularTurmaMB {
	
	private Usuario usuario;
	private List<Usuario> listaAluno;
	private List<Usuario> listaProfessor;
	private List<Turma> listaTurma;
	private Turma turma;
	private TurmaRN turmaRN;
	private UsuarioRN usuarioRN;
	
	
	@PostConstruct
	public void init(){
		usuario = new Usuario();
		turma = new Turma();
		turmaRN = new TurmaRN();
		usuarioRN = new UsuarioRN();
		gerarListaAluno();
		gerarListaProfessor();
		gerarListaTurma();
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Usuario> getListaAluno() {
		return listaAluno;
	}


	public void setListaAluno(List<Usuario> listaAluno) {
		this.listaAluno = listaAluno;
	}


	public List<Usuario> getListaProfessor() {
		return listaProfessor;
	}


	public void setListaProfessor(List<Usuario> listaProfessor) {
		this.listaProfessor = listaProfessor;
	}


	public List<Turma> getListaTurma() {
		return listaTurma;
	}


	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
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


	public UsuarioRN getUsuarioRN() {
		return usuarioRN;
	}


	public void setUsuarioRN(UsuarioRN usuarioRN) {
		this.usuarioRN = usuarioRN;
	}
	
	
	public void gerarListaAluno(){
		String sql = "Select a from Usuario a where a.perfil.idperfil=1 and a.turma.idturma=1";
		try {
			listaAluno =  usuarioRN.listaUsuario(sql);
			if (listaAluno == null) {
				listaAluno = new ArrayList<Usuario>();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gerarListaProfessor(){
		String sql = "Select a from Usuario a where a.perfil.idperfil=2 and a.turma.idturma=1";
		try {
			listaProfessor =  usuarioRN.listaUsuario(sql);
			if (listaProfessor == null) {
				listaProfessor = new ArrayList<Usuario>();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gerarListaTurma(){
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
	
	
	public void salvar(){
		try {
			usuario = usuarioRN.consultar(usuario.getIdUsuario());
			usuario = usuarioRN.salvar(usuario);
			usuario = new Usuario();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
