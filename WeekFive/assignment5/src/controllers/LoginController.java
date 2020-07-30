package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

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
	
	//accepts a user and adds it to the current FacesContext request Map
	public String onSubmit(User user) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getRequestMap().put("user", user);
		service.test();
		timer.setTimer(10000);
		getAllOrders();
		insertOrder();
		getAllOrders();
		return "TestResponse.xhtml";
	}
	
	//accepts a user and adds it to the current FacesContext flash redirect
	public String onFlash(User user) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
	
	private void insertOrder() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Idunno11!@#");
			System.out.println("Connection Made!");
			
			String statement = "INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) "
							 + "VALUES('001122334455', 'This was inserted new!', 25.00, 100)";
			Statement query = conn.createStatement();
			int rows = query.executeUpdate(statement);
			
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
	
	private void getAllOrders() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Idunno11!@#");
			System.out.println("Connection Made!");
			
			String statement = "SELECT * FROM testapp.Orders";
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(statement);
			
			while(rs.next()) {
				System.out.print("ID: " + rs.getInt("ID"));
				System.out.print(", Product Name: " + rs.getString("PRODUCT_NAME"));
				System.out.print(", Price: " + rs.getFloat("PRICE") + "\n");
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
	}
}