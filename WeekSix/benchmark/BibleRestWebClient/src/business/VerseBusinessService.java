package business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bean.Verse;
import data.DataAccessInterface;

@Stateless
public class VerseBusinessService {
	
	@Inject
	private DataAccessInterface<Verse> dao;
	
	public Verse getVerse(Verse verse) {
		
		String urlID = verse.getBook() + "/" + verse.getChapter() + "/" + verse.getVerse();
		String text = dao.get(urlID).getContent();
		text = formatTextForHTML(text);
		verse.setContent(text);
		return verse;
	}
	
	private String formatTextForHTML(String line) {
		line = line.replace("\\n", "<br/>");
		return line;
	}
}
