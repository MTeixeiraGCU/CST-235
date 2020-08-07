package data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.ejb.Local;

@Local
public interface DataAccessInterface<T> {
	
	/**
	 * retrieves a connection to the current api
	 * @return the given connection to use for the dao methods, must be closed manually outside of this method.
	 */
	public static HttpURLConnection getURLConnection(String parameters) {
		HttpURLConnection conn = null;
		
		try {
			//this is the string for BibleRestWebService connection
			URL url = new URL("http://localhost:8080/BibleRestWebService/rest/bible/findVerse/" + parameters);
			
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/plain");
			
			int response = conn.getResponseCode();
			if(response != 200) {
				throw new RuntimeException("Problem with connection - code: " + response + "\n request: " + url.toString());
			}
		}
		catch(IOException ex) {
			System.out.println("Could not connect! : " + ex.getMessage());
		}
		return conn;
	}
	
	// CRUD pattern methods
	public T get(String id);
	List<T> getAll();
	void save(T t);
	void update(String id, T t);
	void delete(T t);
}
