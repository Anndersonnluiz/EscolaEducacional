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
	private String correto;
	@JoinColumn(name = "questoes_idquestoes", referencedColumnName = "idquestoes")
    @ManyToOne(optional = false)
    private Questoes questoes;
	@JoinColumn(name = "respostas_idrespostas", referencedColumnName = "idresposta")
    @ManyToOne(optional = false)
    private Respostas respostas;
	@JoinColumn(name = "avaliacao_idavaliacao", referencedColumnName = "idavaliacao")
    @ManyToOne(optional = false)
    private Avaliacao avaliacao;
	
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
	
	public Questoes getQuestoes() {
		return questoes;
	}
	public void setQuestoes(Questoes questoes) {
		this.questoes = questoes;
	}
	public String getCorreto() {
		return correto;
	}
	public void setCorreto(String correto) {
		this.correto = correto;
	}
	public Respostas getRespostas() {
		return respostas;
	}
	public void setRespostas(Respostas respostas) {
		this.respostas = respostas;
	}
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
	
	
	
}
