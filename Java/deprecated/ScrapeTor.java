package scrappy;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scrappy.models.Story;

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
			// now select the link within h2 and get the url
			
			for (Element title : titles) {
				System.out.println(title.text() + " LINK:" + title.select("h2 > a").attr("abs:href"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
