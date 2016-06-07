package br.senai.sc.pwAvancada.managebean;



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


@ManagedBean
@ViewScoped
public class PerfilMB{
	
	private Integer editarId;
	private Perfil perfil;
	private List<Perfil> listarPerfil;
	private PerfilRN perfilRN;
	
	@PostConstruct
	public void init(){
		perfil = new Perfil();
		perfilRN = new PerfilRN();
	}

	
	

	


	public PerfilRN getPerfilRN() {
		return perfilRN;
	}







	public void setPerfilRN(PerfilRN perfilRN) {
		this.perfilRN = perfilRN;
	}







	public List<Perfil> getListarPerfil() {
		String sql = "Select p from Perfil p";
		if (listarPerfil == null) {
			try {
				listarPerfil = perfilRN.listaPerfil(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (listarPerfil == null) {
				listarPerfil = new ArrayList<Perfil>();
			}
		}
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

	
	public Integer getEditarId() {
		return editarId;
	}



	public void setEditarId(Integer editarId) {
		this.editarId = editarId;
	}



	public void carregarPerfil(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		try {
			perfil = perfilRN.consultar(editarId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String excluir(){
		String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idperfil");
		Integer id = Integer.parseInt(idParam);
		perfilRN.excluir(id);
		listarPerfil = null;
		return "";
	}
	
	public String salvar(){
		if (perfil.getIdperfil() == 0) {
			perfil.setIdperfil(null);
		}
		try {
			perfilRN.salvar(perfil);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listarPerfil = null;
		return "";
	}
	
	

}
