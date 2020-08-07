package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import bean.Verse;

@Local(DataAccessInterface.class)
@LocalBean
@Stateless
public class VerseDataAccessObject implements DataAccessInterface<Verse> {
	
	@Override
	public Verse get(String id) {
		
		HttpURLConnection conn = DataAccessInterface.getURLConnection(id);
		Verse verse = new Verse();
		
		//grab the content of the verse
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String text = br.lines().collect(Collectors.joining());
			if(text == null) {
				text = "Verse not found in database!";
			}
	        verse.setContent(text);
	        
	        br.close();
		}
		catch(IOException ex) {
			
		}
		conn.disconnect();
		
		return new Verse(verse);
	}

	@Override
	public List<Verse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Verse t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String id, Verse t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Verse t) {
		// TODO Auto-generated method stub
		
	}
}
