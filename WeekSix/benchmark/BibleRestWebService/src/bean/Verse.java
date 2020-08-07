package bean;

import javax.ejb.Stateless;

@Stateless
public class Verse {
	private String bookName;
	private int chapterNumber;
	private int verseNumber;
	private String content;
	
	public Verse() {
		this.bookName = "";
		this.chapterNumber = 0;
		this.verseNumber = 0;
		this.content = "No content!";
	}
	
	public Verse(Verse verse) {
		this.bookName = verse.getBookName();
		this.chapterNumber = verse.getChapterNumber();
		this.verseNumber = verse.getVerseNumber();
		this.content = verse.getContent();
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public int getVerseNumber() {
		return verseNumber;
	}

	public void setVerseNumber(int verseNumber) {
		this.verseNumber = verseNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
