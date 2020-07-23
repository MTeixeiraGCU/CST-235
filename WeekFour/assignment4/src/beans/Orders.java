package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean(name="productOrders")
@ViewScoped
public class Orders implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Order> orders;
	
	public Orders() {
		orders = new ArrayList<Order>();
		orders.add(new Order("1", "Television", 200.0f, 1));
		orders.add(new Order("2", "Lego Set", 75.99f, 1));
		orders.add(new Order("3", "Bicycle Tire", 40.00f, 2));
	}

	//Getters and Setters
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	} 

}
