package scrappy;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scrappy.models.Item;

public class ScrapeTor {

	public static void main(String[] args) {
		
		// homepage link that does not change ever
		final String HOME = "https://www.tor.com/category/all-fiction/";
		
		try {
			
			Document doc = Jsoup.connect(HOME).get();
			doc.setBaseUri("https://www.tor.com");
			
			// get elements under the class "entry-title"
			Elements titles = doc.getElementsByClass("entry-title");
			// now a title is:
			// <h2 class="entry-title"> <a href="https://www.tor.com/2019/07/10/for-he-can-creep-siobhan-carroll/">For He Can Creep</a> </h2>
			// this has a CHILD which is a href
			
			for (Element title : titles) {
				//Item linkItem = new Item(title.text(), title.children().first().attr("abs:href"));
				System.out.println(title.text() + " LINK:" + title.children().first().attr("abs:href"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
