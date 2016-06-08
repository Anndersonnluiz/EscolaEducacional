package br.senai.sc.pwAvancada.managebean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

import br.senai.sc.pwAvancada.model.Dominio.Turma;
import br.senai.sc.pwAvancada.model.Dominio.TurmaRN;


@ManagedBean
@ViewScoped
public class TurmaMB {
	
	private Turma turma;
	private TurmaRN turmaRN;
	private Integer editarId;
	private List<Turma> listaTurma;
	
	@PostConstruct
	public void init(){
		if (turma == null) {
			turma = new Turma();
		}
		turmaRN = new TurmaRN();
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





	public Integer getEditarId() {
		return editarId;
	}





	public void setEditarId(Integer editarId) {
		this.editarId = editarId;
	}





	public List<Turma> getListaTurma() {
		String sql = "Select u from Turma u";
		if (listaTurma == null) {
			try {
				listaTurma = turmaRN.listaTurma(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (listaTurma == null) {
				listaTurma = new ArrayList<Turma>();
			}
		}
		return listaTurma;
	}





	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}





	public void carregarTurma(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		try {
			turma = turmaRN.consultar(editarId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public String salvar(){
		if (turma.getIdturma() == 0) {
			turma.setIdturma(null);
		}
		try {
			turmaRN.salvar(turma);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listaTurma = null;
		turma = new Turma();
		return "turmaList";
	}
	
	public String listaAlunosTurma(){
		FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("listaTurma");
        Integer idTurma = Integer.parseInt(id);
        try {
			turma = turmaRN.consultar(idTurma);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        session.setAttribute("turma", turma);
        return"alunosTurma";
	}
	

	
	public String excluir(){
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idturma");
		Integer idturma = Integer.parseInt(id);
		turmaRN.excluir(idturma);
		listaTurma = null;
		
		return "";
	}

}
