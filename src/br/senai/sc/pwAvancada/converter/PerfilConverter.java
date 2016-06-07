package br.senai.sc.pwAvancada.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.pwAvancada.model.Dominio.Perfil;

@FacesConverter(value="PerfilConverter")
public class PerfilConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		List<Perfil> listaPerfil = (List<Perfil>) arg1.getAttributes().get("listarPerfil");
	    if (listaPerfil != null) {
	        for (Perfil perfil : listaPerfil) {
	            if (perfil.getColocacao().equalsIgnoreCase(arg2)) {
	                return perfil;
	            }
	        }
	    } else {
	    	Perfil perfil = new Perfil();
	        return perfil;
	    }
	    Perfil perfil = new Perfil();
	    return perfil;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Perfil perfil = (Perfil) arg2;
	        return perfil.getColocacao();
	    }
	}

}
