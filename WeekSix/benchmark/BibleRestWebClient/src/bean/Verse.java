package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ManagedBean(name="verse")
@ViewScoped
public class Verse {
	
	@NotNull
	private String book;
	
	@NotNull
	@Min(1)
	private int chapter;
	
	@NotNull
	@Min(1)
	private int verse;
	
	private String content;
	
	public Verse() {
		this.book = "";
		this.chapter = 0;
		this.verse = 0;
		this.content = "";
	}
	
	public Verse(Verse verse) {
		this.book = verse.getBook();
		this.chapter = verse.getChapter();
		this.verse = verse.getVerse();
		this.content = verse.getContent();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public int getChapter() {
		return chapter;
	}

	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	public int getVerse() {
		return verse;
	}

	public void setVerse(int verse) {
		this.verse = verse;
	}
}
