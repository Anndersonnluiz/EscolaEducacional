package br.senai.sc.pwAvancada.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.pwAvancada.model.Dominio.Turma;

@FacesConverter(value="TurmaConverter")
public class TurmaConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		List<Turma> listaTurma = (List<Turma>) arg1.getAttributes().get("listaTurma");
	    if (listaTurma != null) {
	        for (Turma turma : listaTurma) {
	            if (turma.getDescricao().equalsIgnoreCase(arg2)) {
	                return turma;
	            }
	        }
	    } else {
	    	Turma turma = new Turma();
	        return turma;
	    }
	    Turma turma = new Turma();
	    return turma;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Turma turma = (Turma) arg2;
	        return turma.getDescricao();
	    }
	}
}
