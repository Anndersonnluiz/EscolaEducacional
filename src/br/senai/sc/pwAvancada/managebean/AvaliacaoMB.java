package br.senai.sc.pwAvancada.managebean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.senai.sc.pwAvancada.model.Dominio.Avaliacao;
import br.senai.sc.pwAvancada.model.Dominio.AvaliacaoRN;
import br.senai.sc.pwAvancada.model.Dominio.Questoes;
import br.senai.sc.pwAvancada.model.Dominio.QuestoesRN;
import br.senai.sc.pwAvancada.model.Dominio.QuestoesRespostasRN;
import br.senai.sc.pwAvancada.model.Dominio.Questoesrespostas;
import br.senai.sc.pwAvancada.model.Dominio.Respostas;
import br.senai.sc.pwAvancada.model.Dominio.RespostasRN;
import br.senai.sc.pwAvancada.model.Dominio.Usuario;
import br.senai.sc.pwAvancada.util.Criptografia;


@ManagedBean
@ViewScoped
public class AvaliacaoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Avaliacao avaliacao;
	private Respostas respostas;
	private List<Questoesrespostas> listaQuestoesRespostas;
	private Questoes questoes;
	private List<Respostas> listaRespostas;
	private String resposta1;
	private String resposta2;
	private String resposta3;
	private String resposta4;
	private Date data;
	private boolean corretoResposta1;
	private boolean corretoResposta2;
	private boolean corretoResposta3;
	private boolean corretoResposta4;
	private Questoesrespostas questoesrespostas;

	
	@PostConstruct
	public void init(){
		if (listaRespostas == null) {
			listaRespostas = new ArrayList<Respostas>();
		}
		if (listaQuestoesRespostas == null) {
			listaQuestoesRespostas = new ArrayList<Questoesrespostas>();
		}
		if (avaliacao == null) {
			avaliacao = new Avaliacao();
			questoes = new Questoes();
		}
	} 
	
	
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Respostas getRespostas() {
		return respostas;
	}
	public void setRespostas(Respostas respostas) {
		this.respostas = respostas;
	}
	public List<Questoesrespostas> getListaQuestoesRespostas() {
		return listaQuestoesRespostas;
	}
	public void setListaQuestoesRespostas(List<Questoesrespostas> listaQuestoesRespostas) {
		this.listaQuestoesRespostas = listaQuestoesRespostas;
	}


	public Questoes getQuestoes() {
		return questoes;
	}


	public void setQuestoes(Questoes questoes) {
		this.questoes = questoes;
	}


	public List<Respostas> getListaRespostas() {
		return listaRespostas;
	}


	public void setListaRespostas(List<Respostas> listaRespostas) {
		this.listaRespostas = listaRespostas;
	}


	public String getResposta1() {
		return resposta1;
	}


	public void setResposta1(String resposta1) {
		this.resposta1 = resposta1;
	}


	public String getResposta2() {
		return resposta2;
	}


	public void setResposta2(String resposta2) {
		this.resposta2 = resposta2;
	}


	public String getResposta3() {
		return resposta3;
	}


	public void setResposta3(String resposta3) {
		this.resposta3 = resposta3;
	}


	public String getResposta4() {
		return resposta4;
	}


	public void setResposta4(String resposta4) {
		this.resposta4 = resposta4;
	}


	public Date getData() {
		data = new Date();
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public boolean isCorretoResposta1() {
		return corretoResposta1;
	}


	public void setCorretoResposta1(boolean corretoResposta1) {
		this.corretoResposta1 = corretoResposta1;
	}


	public boolean isCorretoResposta2() {
		return corretoResposta2;
	}


	public void setCorretoResposta2(boolean corretoResposta2) {
		this.corretoResposta2 = corretoResposta2;
	}


	public boolean isCorretoResposta3() {
		return corretoResposta3;
	}


	public void setCorretoResposta3(boolean corretoResposta3) {
		this.corretoResposta3 = corretoResposta3;
	}


	public boolean isCorretoResposta4() {
		return corretoResposta4;
	}


	public void setCorretoResposta4(boolean corretoResposta4) {
		this.corretoResposta4 = corretoResposta4;
	}
	
	
	
	
	public Questoesrespostas getQuestoesrespostas() {
		return questoesrespostas;
	}


	public void setQuestoesrespostas(Questoesrespostas questoesrespostas) {
		this.questoesrespostas = questoesrespostas;
	}


	public void adicionar(){
		if (resposta1 != "") {
			respostas = new Respostas();
			respostas.setDescricao(resposta1);
			listaRespostas.add(respostas);
		}
		if (resposta2 != "") {
			respostas = new Respostas();
			respostas.setDescricao(resposta2);
			listaRespostas.add(respostas);
		}
		if (resposta3 != "") {
			respostas = new Respostas();
			respostas.setDescricao(resposta3);
			listaRespostas.add(respostas);
		}
		if (resposta4 != "") {
			respostas = new Respostas();
			respostas.setDescricao(resposta4);
			listaRespostas.add(respostas);
		}
		QuestoesRN questoesRN = new QuestoesRN();
		try {
			questoes = questoesRN.salvar(questoes);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < listaRespostas.size(); i++) {
			RespostasRN respostasRN = new RespostasRN();
			Respostas resp = new Respostas();
			try {
				resp = respostasRN.salvar(listaRespostas.get(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questoesrespostas = new Questoesrespostas();
			questoesrespostas.setQuestoes(questoes);
			questoesrespostas.setRespostas(resp);
			if (i == 0) {
				if (corretoResposta1) {
					questoesrespostas.setCorreto("Sim");
				}else{
					questoesrespostas.setCorreto("Nao");
				}
			}else if(i == 1){
				if (corretoResposta2) {
					questoesrespostas.setCorreto("Sim");
				}else{
					questoesrespostas.setCorreto("Nao");
				}
				
			}else if(i == 2){
				if (corretoResposta3) {
					questoesrespostas.setCorreto("Sim");
				}else{
					questoesrespostas.setCorreto("Nao");
				}
				
			}else if(i == 3){
				if (corretoResposta4) {
					questoesrespostas.setCorreto("Sim");
				}else{
					questoesrespostas.setCorreto("Nao");
				}				
			}
			listaQuestoesRespostas.add(questoesrespostas);
		}
		resposta1 = "";
		resposta2 = "";
		resposta3 = "";
		resposta4 = "";
		questoes = new Questoes();
		listaRespostas = new ArrayList<Respostas>();
	}
	
	
	public String salvar(){
		AvaliacaoRN avaliacaoRN = new AvaliacaoRN();
		avaliacao.setData(new Date());
		try {
			avaliacaoRN.salvar(avaliacao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < listaQuestoesRespostas.size(); i++) {
			listaQuestoesRespostas.get(i).setAvaliacao(avaliacao);
			QuestoesRespostasRN questoesRespostasRN = new QuestoesRespostasRN();
			try {
				questoesRespostasRN.salvar(listaQuestoesRespostas.get(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return"";
	}
	
	
}
