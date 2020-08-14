package business;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;

@Stateless
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface{

	@Inject
	private Order order;
	
	private List<Order> orders;
	
	//Message queue varaibles
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;
	
	
    public OrdersBusinessService() {
    	orders = new ArrayList<Order>();
    }

	@Override
	public void test() {
		System.out.println("Hello from OrdersBusinessService!");
	}

	@Override
	public List<Order> getOrders() {
		orders = new ArrayList<Order>();
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Idunno11!@#");
			System.out.println("Connection Made!");
			
			String statement = "SELECT * FROM testapp.Orders";
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(statement);
			
			while(rs.next()) {
				order.setOrderNumber(new Integer(rs.getInt("ID")).toString());
				order.setProductName(rs.getString("PRODUCT_NAME"));
				order.setPrice(rs.getFloat("PRICE"));
				orders.add(new Order(order));
			}
		}
		catch(SQLException ex) {
			System.out.println("Failure!");
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
		return orders;
	}

	@Override
	public void sendOrder(Order order) {
		try 
		{
			javax.jms.Connection connection = connectionFactory.createConnection();
			Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is test message");
			messageProducer.send(message1);
			ObjectMessage message2 = session.createObjectMessage();
			message2.setObject(order);
			messageProducer.send(message2);
			connection.close();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}		
	}
	
	public void insertOrder(Order order) {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Idunno11!@#");
			System.out.println("Connection Made!");
			
			String statement = "INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) "
							 + "VALUES(?, ?, ?, ?)";
			PreparedStatement query = conn.prepareStatement(statement);
			query.setString(1, order.getOrderNumber());
			query.setString(2, order.getProductName());
			query.setBigDecimal(3, BigDecimal.valueOf(order.getPrice()));
			query.setInt(4, order.getQuantity());
			int rows = query.executeUpdate();
			
			if(rows < 1) {
				System.out.println("No Update Was Performed!");
			}
			else {
				System.out.println(rows + " row(s) have been updated!");
			}
		}
		catch(SQLException ex) {
			System.out.println("Failure! " + ex.getMessage());
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
	}
	
	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
