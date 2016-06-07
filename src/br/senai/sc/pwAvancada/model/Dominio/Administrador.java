package br.senai.sc.pwAvancada.model.Dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
public class Administrador {

	@Id
	@GeneratedValue
	private Integer idadministrador;
	private String nome;
	private String email;
	
	
	public Integer getIdadministrador() {
		return idadministrador;
	}
	public void setIdadministrador(Integer idadministrador) {
		this.idadministrador = idadministrador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
