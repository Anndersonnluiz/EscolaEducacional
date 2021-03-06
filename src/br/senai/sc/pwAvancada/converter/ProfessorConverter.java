package br.senai.sc.pwAvancada.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.pwAvancada.model.Dominio.Usuario;

@FacesConverter(value="ProfessorConverter")
public class ProfessorConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		List<Usuario> listaProfessor = (List<Usuario>) arg1.getAttributes().get("listaProfessor");
	    if (listaProfessor != null) {
	        for (Usuario usuario : listaProfessor) {
	            if (usuario.getNome().equalsIgnoreCase(arg2)) {
	                return usuario;
	            }
	        }
	    } else {
	    	Usuario usuario = new Usuario();
	        return usuario;
	    }
	    Usuario usuario = new Usuario();
	    return usuario;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Usuario usuario = (Usuario) arg2;
	        return usuario.getNome();
	    }
	}
}
