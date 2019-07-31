package scrappy;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scrappy.models.DarkScraping;

public class ScrapeTheDark {
	
	public static void main(String[] args) throws IOException {
		
		DarkScraping scrape = new DarkScraping();
		
		System.out.println("*********\nGetting page links\n*********");
		
		scrape.getLinks("http://thedarkmagazine.com/fiction", "http://thedarkmagazine.com");
		
		System.out.println("*********\nPage links\n*********");
		for (String link : scrape.getPageLinks()) {
			System.out.println(link);
		}
		
		System.out.println("*********\nGetting stories from page links\n*********");
		
		scrape.getStories();
		
		System.out.println("*********\nOtput to text file \n*********");
		
		scrape.exportToTxt("stories");
		
		System.out.println("*********\nFIN\n*********");

	}
}

