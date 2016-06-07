package br.senai.sc.pwAvancada.model.Dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Questoesrespostas {
	
	@Id
	@GeneratedValue
	private Integer idquestoesrespostas;
	private String descricao;
	private Integer correta;
	@JoinColumn(name = "questoes_idquestoes", referencedColumnName = "idquestoes")
    @ManyToOne(optional = false)
    private Questoes questoes;
	
	public Integer getIdquestoesrespostas() {
		return idquestoesrespostas;
	}
	public void setIdquestoesrespostas(Integer idquestoesrespostas) {
		this.idquestoesrespostas = idquestoesrespostas;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getCorreta() {
		return correta;
	}
	public void setCorreta(Integer correta) {
		this.correta = correta;
	}
	public Questoes getQuestoes() {
		return questoes;
	}
	public void setQuestoes(Questoes questoes) {
		this.questoes = questoes;
	}
	
	
}
