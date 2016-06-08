package br.senai.sc.pwAvancada.model.Dominio;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Questoes {

	@Id
	@GeneratedValue
	@Basic(optional = false)
	@Column(name = "idquestoes")
	private Integer idquestoes;
	@Column(name = "descricao")
	private String descricao;
	
	public Integer getIdquestoes() {
		return idquestoes;
	}
	public void setIdquestoes(Integer idquestoes) {
		this.idquestoes = idquestoes;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	
	
}
