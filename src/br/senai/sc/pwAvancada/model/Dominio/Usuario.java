package br.senai.sc.pwAvancada.model.Dominio;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "idusuario")
	private Integer idusuario;
	@Column(name = "nome")
	private String nome;
	@Column(name = "fone")
	private String fone;
	@Column(name = "bairro")
	private String bairro;
	@Column(name = "rua")
	private String rua;
	@Column(name = "login")
	private String login;
	@Column(name = "senha")
	private String senha;
	@Column(name = "tipoAcesso")
	private String tipoAcesso;
	@JoinColumn(name = "perfil_idperfil", referencedColumnName = "idperfil")
    @ManyToOne(optional = false)
    private Perfil perfil;
	@JoinColumn(name = "turma_idturma", referencedColumnName = "idturma")
    @ManyToOne(optional = false)
    private Turma turma;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getIdUsuario() {
		return idusuario;
	}
	public void setIdUsuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTipoAcesso() {
		return tipoAcesso;
	}


	public void setTipoAcesso(String tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}
	
	
	
	
	
}
