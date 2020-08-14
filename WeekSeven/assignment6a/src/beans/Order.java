package beans;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Stateless
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String orderNumber;
	private String productName;
	private float price;
	private int quantity;

	public Order() {
		orderNumber = "";
		productName = "";
		price = 0.0f;
		quantity = 0;
	}
	
	public Order(Order order) {
		this.orderNumber = order.getOrderNumber();
		this.productName = order.getProductName();
		this.price = order.getPrice();
		this.quantity = order.getQuantity();
	}
	
	public Order(String orderNumber, String productName, float price, int quantity) {
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getJson() {
		return "";
	}

	//Getters and Setters
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
