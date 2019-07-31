package scrappy.models;

public class Story {
	
	private String title;
	
	private String author;
	
	private String link;

	public Story() {
		super();
	}

	public Story(String title, String author, String link) {
		super();
		this.title = title;
		this.author = author;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Story:\n" + title + " " + author + " --> " + link + "\n";
	}
	
	
	
	
}