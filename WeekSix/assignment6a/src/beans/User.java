package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
