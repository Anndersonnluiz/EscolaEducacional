package br.senai.sc.pwAvancada.managebean;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import br.senai.sc.pwAvancada.model.Dominio.Usuario;
import br.senai.sc.pwAvancada.model.Dominio.UsuarioRN;
import br.senai.sc.pwAvancada.util.Criptografia;
import br.senai.sc.pwAvancada.util.VerificarLogin;

@ManagedBean
@SessionScoped
public class UsuarioLogadoMB {
	
	@Inject
	private VerificarLogin verificarLogin;
	private Usuario usuario;
    private String novaSenha;
    private String confirmaNovaSenha;
    private boolean tipoUsuario;


   
	public UsuarioLogadoMB() {
    	usuario = new Usuario();
	}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
  
    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmaNovaSenha() {
        return confirmaNovaSenha;
    }

    public void setConfirmaNovaSenha(String confirmaNovaSenha) {
        this.confirmaNovaSenha = confirmaNovaSenha;
    }
    
    
    
    
	public boolean isTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String validarUsuario() throws SQLException{
        if ((usuario.getLogin()==null) && (usuario.getSenha()==null)){
        	FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro", "Acesso Negado."));
        }else{
            String senha = "";
            try {
                senha = Criptografia.encript(usuario.getSenha());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UsuarioLogadoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            usuario.setSenha(senha);
            UsuarioRN usuarioFacade = new UsuarioRN();
            usuario = usuarioFacade.consultar(usuario.getLogin(), usuario.getSenha());
            if (usuario==null){
            	FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Erro", "Acesso Negado."));
            }else{
            	return "inicial";
            }
        }
        usuario = new Usuario();
        return "";
    }
    
    
     public void erroLogin(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(mensagem, ""));
    }
     
    public void validarTrocarSenha(){
        if ((usuario.getLogin()!=null) && (usuario.getSenha()==null)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Login Invalido."));
        }else{
            String senha = "";
            try {
                senha = Criptografia.encript(usuario.getSenha());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UsuarioLogadoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            usuario.setSenha(senha);
            UsuarioRN usuarioRN = new UsuarioRN();
            usuario = usuarioRN.consultar(usuario.getLogin(), usuario.getSenha());
            if (usuario==null){
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
            }
        }
    }
    
    public String confirmaNovaSenha() {
        if ((novaSenha.length() > 0) && (confirmaNovaSenha.length() > 0)) {
            if (novaSenha.equalsIgnoreCase(confirmaNovaSenha)) {
            	UsuarioRN usuarioRN = new UsuarioRN();
                usuario.setSenha(novaSenha);
                try {
					usuario = usuarioRN.salvar(usuario);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                novaSenha = "";
                confirmaNovaSenha = "";
                return "inicial";
            } else {
                novaSenha = "";
                confirmaNovaSenha = "";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
        }
        return "";
    }
    
    public String cancelarTrocaSenha(){
        usuario = new Usuario();
        novaSenha="";
        confirmaNovaSenha="";
        return "index";
    }
    
    
    public String deslogar(){
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  
        sessionMap.clear(); 
        return "index";
    }
    

    
    public String carregarNotificacao(String tipo){
    	FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("tipo", tipo);  
    	Map<String,Object> options = new HashMap<String, Object>();
        options.put("contentWidth",750);
        RequestContext.getCurrentInstance().openDialog("notificacoes", options, null);
        return "";
    }
    
   
    
    public String paginaPrincipal(){
    	return "paginainicial";
    }
     
    public String importar(){
     	Map<String,Object> options = new HashMap<String, Object>();
        options.put("contentWidth",400);
        RequestContext.getCurrentInstance().openDialog("importarOrcamento", options, null);
  //  	Limpar limpar = new Limpar();
   /// 	limpar.limparAcomodacao();
    	return "";
    } 
    
    
    public Boolean admin(){
    	if (usuario.getPerfil().getColocacao().equalsIgnoreCase("Aluno")) {
			tipoUsuario = false;
		}else{
			tipoUsuario = true;
		}
    	return tipoUsuario;
    }
    
    
}
