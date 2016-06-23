package br.senai.sc.pwAvancada.managebean;

import br.senai.sc.pwAvancada.model.Dominio.ArquivoRN;
import br.senai.sc.pwAvancada.model.Dominio.Imagem;
import br.senai.sc.pwAvancada.util.UploadUtil;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

public class ArquivoMB {

	private Imagem foto;
	
	private Part fotoUploaded;
	private List<Imagem> imagens;
	private ArquivoRN arquivoRN;

	@PostConstruct
	public void init() {
		arquivoRN = new ArquivoRN();
		foto = new Imagem();
	}



	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Imagem getFoto() {
		return foto;
	}

	public void setFoto(Imagem foto) {
		this.foto = foto;
	}

	public Part getFotoUploaded() {
		return fotoUploaded;
	}

	public void setFotoUploaded(Part fotoUploaded) {
		this.fotoUploaded = fotoUploaded;
	}
	
	

	
	public ArquivoRN getArquivoRN() {
		return arquivoRN;
	}



	public void setArquivoRN(ArquivoRN albumRN) {
		this.arquivoRN = albumRN;
	}



	public List<Imagem> getImagens() {
		return imagens;
	}



	//public void excluir(String idImg){
	//	Long id = Long.parseLong(idImg);
	//	Imagem img = arquivoRN.buscarImagemPorId(id);
		
	//	UploadUtil.removerArquivo(img.getNome());
	//	arquivoRN.excluir(img);
		
	//	imagens = null;
	//}

	public String salvar() {
		try {
			String nome = UploadUtil.moverArquivo(fotoUploaded, foto.getNome());

			foto.setNome(nome);

			arquivoRN.adicionar(foto);

			return "uploadArquivo";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
