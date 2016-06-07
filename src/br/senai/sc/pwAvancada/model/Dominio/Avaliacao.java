package br.senai.sc.pwAvancada.model.Dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue
	private Integer idavaliacao;
	private String descricao;
	private Date data;
	
	public Integer getIdavaliacao() {
		return idavaliacao;
	}
	public void setIdavaliacao(Integer idavaliacao) {
		this.idavaliacao = idavaliacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
