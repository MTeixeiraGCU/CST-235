package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean(name="loginController")
@ViewScoped
public class LoginController {

	@Inject
	private OrdersBusinessInterface service;
	
	@EJB
	private MyTimerService timer;
	
	//retrieves the current business service class
	public OrdersBusinessInterface getService() {
		return service;
	}
	
	public String onLogoff() {
		
		//Invalidate the current Session
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		//Redirect to a protected page
		return "TestResponse.xhtml?faces-redirect=true";
	}
	
	//accepts a user and adds it to the current FacesContext request Map
	/*public String onSubmit(User user) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getRequestMap().put("user", user);
		service.test();
		timer.setTimer(10000);
		return "TestResponse.xhtml";
	}*/
	
	//accepts a user and adds it to the current FacesContext flash redirect
	public String onFlash(User user) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
	
	
	public String onSendOrder() {
		service.sendOrder(new Order("9999", "New Product", 100.00f, 20));
		return "OrderResponse.xhtml";
	}
	
}