package br.senai.sc.pwAvancada.model.Dominio;

import java.util.List;

import br.senai.sc.pwAvancada.dao.ArquivoDAO;

public class ArquivoRN {

	private ArquivoDAO dao;

	public ArquivoRN() {
		dao = new ArquivoDAO();
	}

	public void adicionar(Imagem foto) {
		dao.salvar(foto);
	}

	public List<Imagem> listarImagens(Integer idEscursao) {
		return dao.listarImagens(idEscursao);
	}

	public void excluir(Imagem imagem) {
		dao.excluir(imagem);
	}
}
