package business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bean.Verse;

@RequestScoped
@Path("/bible")
@Produces({ "application/xml", "application/json", "text/plain"})
@Consumes({ "application/xml", "application/json" })
public class BibleRestService {
	
	@Inject
	private BibleBusinessService service;
	
	@GET
	@Path("/findWord/first/{word}")
	@Produces(MediaType.APPLICATION_JSON)
	public Verse findWordFirstOccurence(@PathParam("word") String word) {
		return service.findWord(word);
	}
	
	@GET
	@Path("/findWord/count/{word}")
	@Produces(MediaType.APPLICATION_JSON)
	public int findWordCount(@PathParam("word") String word) {
		return service.countWord(word);
	}
	
	@GET
	@Path("/findVerse/{book}/{chapter}/{verse}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getVerse(@PathParam("book") String bookName, @PathParam("chapter") String chapterNumber, @PathParam("verse") String verseNumber) {
		return service.getVerse(bookName, chapterNumber, verseNumber);
	}
}
