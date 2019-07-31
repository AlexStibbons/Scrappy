package scrappy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scrappy.models.Story;

public class App {

	public static void main(String[] args) {
		
		try {
			
			// connect to a website, get the entire 'page'
			Document doc = Jsoup.connect("https://stackabuse.com/web-scraping-the-java-way/").get();
			
			// find all that contains href
			Elements elements = doc.getElementsByAttribute("href"); 
			
			List<Story> itemsList = new ArrayList(); // since there is a list, it can now be exported
			
			for (Element e : elements) {
				if (!e.ownText().isEmpty()) {
					Story item = new Story(e.ownText(), "no author", e.absUrl("href"));
					itemsList.add(item);
				}
			}
			
			itemsList.stream()
					//.forEach(i -> ExportTo.console(i.getTitle() + ": " + i.getLink() + "\n"));
					.forEach(i -> System.out.println(i.toString()));
			
		} catch (IOException e) {
			System.out.println("No connection\n");
			e.printStackTrace();
		}
		
	}
}
