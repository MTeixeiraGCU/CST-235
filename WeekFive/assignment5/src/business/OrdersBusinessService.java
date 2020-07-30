package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Stateless
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface{

	private List<Order> orders;
	
    public OrdersBusinessService() {
    	orders = new ArrayList<Order>();
		orders.add(new Order("1", "Television", 200.0f, 1));
		orders.add(new Order("2", "Lego Set", 75.99f, 1));
		orders.add(new Order("3", "Bicycle Tire", 40.00f, 2));
    }

	@Override
	public void test() {
		System.out.println("Hello from OrdersBusinessService!");
	}

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
