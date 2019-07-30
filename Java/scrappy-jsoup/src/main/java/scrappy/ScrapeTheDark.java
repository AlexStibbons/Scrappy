package scrappy;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeTheDark {
	
	public static void print(String string) {
		System.out.println(string);
	}

	public static void main(String[] args) {
		
		//DarkScraping test = new DarkScraping();
		// test.getLinks("http://thedarkmagazine.com/fiction", "http://thedarkmagazine.com");
		// test.getStories();
		
		Document doc;
		try {
			doc = Jsoup.connect("http://thedarkmagazine.com/fiction").get();
			doc.setBaseUri("http://thedarkmagazine.com");
			
			Elements elements = doc.getElementsByTag("hgroup");
			
			for (Element e : elements) {
				String title = e.select("h2").text();
				String link = e.select("h2 > a").attr("href");
				String author = e.select(".byline").text();
				print("Story: " + title + ", byline: " + author + ", link: " + link + "\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
