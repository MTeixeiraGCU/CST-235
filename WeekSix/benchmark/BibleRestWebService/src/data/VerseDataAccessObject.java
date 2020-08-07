package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import bean.Verse;

@Local(DataAccessInterface.class)
@LocalBean
@Stateless
public class VerseDataAccessObject implements DataAccessInterface<Verse> {

	@Inject
	private Verse verse;
	
	@Override
	public Verse get(String id) {
		
		//reset verse
		verse = new Verse();
		
		//grab the separate values for the whole key
		List<String> keys = new ArrayList<String>();
		for(String str : id.split("/")) {
			keys.add(str);
		}
		
		//set up the verse info
		verse.setBookName(keys.get(0));
		verse.setChapterNumber(Integer.parseInt(keys.get(1)));
		verse.setVerseNumber(Integer.parseInt(keys.get(2)));
		
		HttpURLConnection conn = DataAccessInterface.getURLConnection(verse.getBookName() + "+" + verse.getChapterNumber() + ":" + verse.getVerseNumber());
		
		//grab the content of the verse
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line);
	        }
	        br.close();
	        verse.setContent(getTextFromJsonString(sb.toString()));
		}
		catch(IOException ex) {
			
		}
		
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
	
	private String getTextFromJsonString(String jsonString) {
		int start = jsonString.indexOf("\"text\":\"") + 8;
		if(start < 8) {
			return "No Content!";
		}
		int end = jsonString.indexOf("\"",start);
		String text = jsonString.substring(start, end);
		//string format here if needed
		return text;
	}

}
