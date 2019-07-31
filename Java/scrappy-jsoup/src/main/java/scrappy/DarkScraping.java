package scrappy;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scrappy.models.Story;

public class DarkScraping {

	private List<String> pageLinks;
	private List<Story> storyList;

	public DarkScraping() {
		this.pageLinks = new ArrayList<>();
		this.storyList = new ArrayList<>();
	}
	

	public List<String> getPageLinks() {
		return pageLinks;
	}
	
	public List<Story> getStoryList() {
		return storyList;
	}
	
	public void getLinks(String url, String baseUri) {

		try {

			Document doc = Jsoup.connect(url).get();
			doc.setBaseUri(baseUri);
			
			pageLinks.add(url);
			//System.out.println("Added: " + url);
			System.out.println("...");

			Elements olderPosts = doc.getElementsByClass("next-posts");
			String olderPostLink = "";
			
			if (!olderPosts.isEmpty()) {
				
				for (Element link : olderPosts) {
					
					if (!link.children().isEmpty()) {
						olderPostLink = link.children().first().attr("abs:href"); 		
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
					Story story = new Story(title, author, link);
					storyList.add(story);
					System.out.println("Story: " + title + ", byline: " + author + ", link: " + link + "\n");
				}
						
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}				
				);		
	}
	
	public void exportToTxt(String fileName) throws IOException {
		
		String filePath = "src/main/resources/" + fileName + ".txt";
		PrintWriter output = null;
		
		try {
			
			output = new PrintWriter(new FileWriter(filePath));
			
			for (int i = 0; i < storyList.size(); i++) {
				output.println(i+1 + ". " + storyList.get(i).toString() + "\n");
			}
			
//			for (Story story : storyList) {
//				output.println(story.toString());
//			}
		
//			storyList.forEach(story -> {
//				output.println(story.toString());
//			});
		
		} finally {
			
			if (output != null) {
				output.close();
			}
		}
	}

}
