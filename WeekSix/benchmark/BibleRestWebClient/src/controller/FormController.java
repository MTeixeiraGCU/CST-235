package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import bean.Verse;
import business.VerseBusinessService;

@ManagedBean(name="formController")
@ViewScoped
public class FormController {
	
	@Inject
	private VerseBusinessService service;
	
	public String onSubmit(Verse verse) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getRequestMap().put("verse", verse);
		
		verse = service.getVerse(verse);
		
		return "verse.xhtml";
	}
}
