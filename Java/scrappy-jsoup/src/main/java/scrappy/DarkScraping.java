package scrappy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DarkScraping {

	private List<String> pageLinks;
	private List<String> storyTitles;;
	private List<String> storyLinks;

	public DarkScraping() {
		this.pageLinks = new ArrayList<>();
		this.storyTitles = new ArrayList<>();
		this.storyLinks = new ArrayList<>();
	}
	

	public List<String> getPageLinks() {
		return pageLinks;
	}


	public void setPageLinks(List<String> pageLinks) {
		this.pageLinks = pageLinks;
	}

	public List<String> getStoryTitles() {
		return storyTitles;
	}

	public void setStoryTitles(List<String> storyTitles) {
		this.storyTitles = storyTitles;
	}

	public List<String> getStoryLinks() {
		return storyLinks;
	}

	public void setStoryLinks(List<String> storyLinks) {
		this.storyLinks = storyLinks;
	}

	
	
	public void getLinks(String url, String baseUri) {

		try {

			Document doc = Jsoup.connect(url).get();
			doc.setBaseUri(baseUri);
			
			pageLinks.add(url);
			System.out.println("Added: " + url + "\n");

			Elements olderPosts = doc.getElementsByClass("next-posts");
			String olderPostLink = "";
			
			if (!olderPosts.isEmpty()) {
				for (Element link : olderPosts) {
					//olderPostLink = link.children().first().attr("abs:href"); // ERROR WHEN IT REACHES LAST PAGE 
					// BECAUSE NEXT-POSTS EXISTS BUT HAS NO CHILDREN
					if (!link.children().isEmpty()) {
						olderPostLink = link.children().first().attr("abs:href"); 
						//pageLinks.add(olderPostLink);
						//System.out.println("This is the older posts link: " + olderPostLink );		
						getLinks(olderPostLink, baseUri);
					}	
				}
			}
			

		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}
	
	public void getStories() {
		
		pageLinks.forEach( page -> {
			Document document;
			try {
				
				document = Jsoup.connect(page).get();
				Elements storyBlocks = document.getElementsByTag("hgroup");
				
				for (Element e : storyBlocks) {
					String title = e.select("h2").text();
					String link = e.select("h2 > a").attr("href");
					String author = e.select(".byline").text();
					System.out.println("Story: " + title + ", byline: " + author + ", link: " + link + "\n");
				}
						
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}				
				);		
	}

}
