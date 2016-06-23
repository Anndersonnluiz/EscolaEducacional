package br.senai.sc.pwAvancada.model.Dominio;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Imagem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "idimagem")
	private Integer idimagem;
	@Column(name = "nome")
	private String nome;
	@Temporal(TemporalType.DATE)
	@Column(name = "data")
	private Date data;
	
	
	public Integer getIdimagem() {
		return idimagem;
	}
	public void setIdimagem(Integer idimagem) {
		this.idimagem = idimagem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
