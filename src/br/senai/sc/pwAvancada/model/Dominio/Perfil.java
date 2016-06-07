package br.senai.sc.pwAvancada.model.Dominio;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Perfil {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "idperfil")
	private Integer idperfil;
	@Column(name = "colocacao")
	private String colocacao;
	
	public Perfil() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdperfil() {
		return idperfil;
	}
	public void setIdperfil(Integer idperfil) {
		this.idperfil = idperfil;
	}
	public String getColocacao() {
		return colocacao;
	}
	public void setColocacao(String colocacao) {
		this.colocacao = colocacao;
	}
	
	
}
