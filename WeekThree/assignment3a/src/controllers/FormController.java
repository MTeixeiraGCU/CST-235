package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean(name="formController")
@ViewScoped
public class FormController {

	//accepts a user and adds it to the current FacesContext request Map
	public String onSubmit(User user) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	
	//accepts a user and adds it to the current FacesContext flash redirect
	public String onFlash(User user) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
}