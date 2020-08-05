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
public class AnotherOrdersBusinessService implements OrdersBusinessInterface{

	private List<Order> orders;
	
    public AnotherOrdersBusinessService() {
    	orders = new ArrayList<Order>();
		orders.add(new Order("1", "Stuffed Animal", 29.99f, 1));
		orders.add(new Order("2", "T-Shirt", 10.00f, 3));
		orders.add(new Order("3", "Pajama Top", 10.00f, 1));
		orders.add(new Order("4", "Pajama Pants", 10.00f, 1));
    }

	@Override
	public void test() {
		System.out.println("Hello from the AnotherBusinessService!");
	}

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public void sendOrder(Order order) {
		
		
	}

}
