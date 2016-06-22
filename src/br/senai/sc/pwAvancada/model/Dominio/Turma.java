package br.senai.sc.pwAvancada.model.Dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
public class Turma {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "idturma")
	private Integer idturma;
	@Column(name = "descricao")
	private String descricao;
	@Temporal(TemporalType.DATE)
	@Column(name = "dataInicio")
	private Date dataInicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "dataFinalPrevista")
	private Date dataFinalPrevista;
	@ManyToMany
	private List<Usuario> listaAlunos;
	
	public Turma() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdturma() {
		return idturma;
	}

	public void setIdturma(Integer idturma) {
		this.idturma = idturma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinalPrevista() {
		return dataFinalPrevista;
	}

	public void setDataFinalPrevista(Date dataFinalPrevista) {
		this.dataFinalPrevista = dataFinalPrevista;
	}

	public List<Usuario> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(List<Usuario> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	
	
	
	
}
