package br.senai.sc.pwAvancada.managebean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;

import br.senai.sc.pwAvancada.model.Dominio.Noticias;
import br.senai.sc.pwAvancada.model.Dominio.NoticiasRN;

@ManagedBean
@ViewScoped
public class NoticiasMB {

	private Noticias noticias;
	private List<Noticias> listarNoticias;
	private NoticiasRN noticiasRN;
	private Integer editarId;
	
	
	@PostConstruct
	public void init(){
		noticias = new Noticias();
		noticiasRN = new NoticiasRN();
	}


	public Noticias getNoticias() {
		return noticias;
	}


	public void setNoticias(Noticias noticias) {
		this.noticias = noticias;
	}


	public List<Noticias> getListarNoticias() {
		String sql = "Select n from Noticias n order by n.idnoticias DESC";
		if (listarNoticias == null) {
			try {
				listarNoticias = noticiasRN.listaNoticias(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (listarNoticias == null) {
				listarNoticias = new ArrayList<Noticias>();
			}
		}
		return listarNoticias;
	}


	public void setListarNoticias(List<Noticias> listarNoticias) {
		this.listarNoticias = listarNoticias;
	}


	public NoticiasRN getNoticiasRN() {
		return noticiasRN;
	}


	public void setNoticiasRN(NoticiasRN noticiasRN) {
		this.noticiasRN = noticiasRN;
	}


	public Integer getEditarId() {
		return editarId;
	}


	public void setEditarId(Integer editarId) {
		this.editarId = editarId;
	}
	
	
	public void carregarNoticias(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		try {
			noticias = noticiasRN.consultar(editarId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String excluir(){
		String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idnoticias");
		Integer id = Integer.parseInt(idParam);
		noticiasRN.excluir(id);
		listarNoticias = null;
		return "";
	}
	
	public String salvar(){
		if (noticias.getIdnoticias() == 0) {
			noticias.setIdnoticias(null);
		}
		try {
			noticiasRN.salvar(noticias);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listarNoticias = null;
		noticias = new Noticias();
		return "";
	}
	
	
	
}
