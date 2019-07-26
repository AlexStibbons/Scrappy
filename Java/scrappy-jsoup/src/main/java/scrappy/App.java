package scrappy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scrappy.models.Item;

public class App {

	public static void main(String[] args) {
		
		try {
			
			// connect to a website, get the entire 'page'
			Document doc = Jsoup.connect("https://stackabuse.com/web-scraping-the-java-way/").get();
			
			// find all that contains href
			Elements elements = doc.getElementsByAttribute("href");
			
			List<Item> itemsList = new ArrayList(); // since there is a list, it can now be exported
			
			for (Element e : elements) {
				if (!e.ownText().isEmpty()) {
					Item item = new Item(e.ownText(), e.absUrl("href"));
					itemsList.add(item);
				}
			}
			
			itemsList.stream()
					.forEach(i -> ExportTo.console(i.getText() + ": " + i.getUrl() + "\n"));
			
		} catch (IOException e) {
			System.out.println("No connection\n");
			e.printStackTrace();
		}
		
	}
}
