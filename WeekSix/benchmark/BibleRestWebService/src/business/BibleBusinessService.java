package business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bean.Verse;
import data.DataAccessInterface;

@Stateless
public class BibleBusinessService {
	
	@Inject
	private DataAccessInterface<Verse> dao;
	
	public String getVerse(String bookName, String chapterNumber, String verseNumber) {
		//create id string
		if(bookName == null || chapterNumber == null || verseNumber == null) {
			return "No such verse found!";
		}
		String id = bookName + "/" + chapterNumber + "/" + verseNumber;
		
		return dao.get(id).getContent();
	}
	
	public int countWord(String word) {
		return 0;
	}
	
	public Verse findWord(String word) {
		return new Verse();
	}
}
