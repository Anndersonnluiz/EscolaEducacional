package br.senai.sc.pwAvancada.model.Dominio;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Respostas {
	
	
	@Id
	@GeneratedValue
	private Integer idrespostas;
	private String descricao;
	@JoinColumn(name = "questoes_idquestoes", referencedColumnName = "idquestoes")
    @ManyToOne(optional = false)
    private Questoes questoes;
	
	
	public Integer getIdrespostas() {
		return idrespostas;
	}
	public void setIdrespostas(Integer idrespostas) {
		this.idrespostas = idrespostas;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Questoes getQuestoes() {
		return questoes;
	}
	public void setQuestoes(Questoes questoes) {
		this.questoes = questoes;
	}
	
	
	
	

}
