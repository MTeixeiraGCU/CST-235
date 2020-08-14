package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean(name="user")
@SessionScoped
public class User {
	
	@NotNull
	@Size(min=5, max=15)
	private String firstName;
	
	@NotNull
	@Size(min=5, max=15)
	private String lastName;
	
	public User() {
		firstName = "Marc";
		lastName = "Teixeira";
	}

	@PostConstruct
	public void init() {
		
		// Get the logged in Principle
		Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		if(principle == null)
		{
			setFirstName("Unknown");
			setLastName("");
		}
		else
		{
			setFirstName(principle.getName());
			setLastName("");
		}

	}
	
	//Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
