package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

@RequestScoped
@Path("/orders")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class OrdersRestService {

	@Inject
	private OrdersBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson() {
		return service.getOrders();
	}
	
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> getOrdersAsXml() {
		return service.getOrders();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addOrder(Order order) {
		service.sendOrder(order);
	}
	
	/*public void addOrder(Order order) {
		HttpURLConnection conn = null;
		
		try {
			//this is the string for the connection
			URL url = new URL("http://localhost:8080/assignment6a/rest/orders/add");
			
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "text/plain");
			conn.setDoOutput(true);
			
			try(OutputStream os = conn.getOutputStream()) {
			    byte[] input = order.getJson().getBytes("utf-8");
			    os.write(input, 0, input.length);	
			    os.close();
			}
			
			int response = conn.getResponseCode();
			if(response != 200) {
				throw new RuntimeException("Problem with connection - code: " + response + "\n request: " + url.toString());
			}
		}
		catch(IOException ex) {
			System.out.println("Could not connect! : " + ex.getMessage());
		}
		conn.disconnect();
	}*/
}
