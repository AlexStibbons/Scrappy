package scrappy;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrapeLSM {

	public static void main(String[] args) {
		
		// base url for creating page links
		StringBuffer pagePathBase = new StringBuffer("http://www.lightspeedmagazine.com/fiction/page/");
		
		// xPath to one story block on a page
		String storyBlockPath = "//div[@class='post_wrapper']";
		// xPath to title within one story block
		String titlePath = "div[@class='post_content']//h2[@class='posttitle']";
		// xPath to author within one story block
		String authorPath = "div[@class='post_content']//p[@class='postmetadata']";
		// xPath to link within one story block
		String linkPath = "div[@class='post_content']//h2[@class='posttitle']//a";
		
		// open up browser
		File file = new File("C:/ALICE/ALEPH/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		ChromeDriver browser = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(browser, 30);
		
		// go to webpage
		browser.get("http://www.lightspeedmagazine.com/fiction/");		
		
		// find all story blocks on page 1
//		List<WebElement> allStoryBlocks = browser.findElements(By.xpath(storyBlockPath));
		
		// EXAMPLE
		// extract data from 1 story block
//		WebElement el1 = allStoryBlocks.get(1);
//		String title = el1.findElement(By.xpath(titlePath)).getText();
//		String author = el1.findElement(By.xpath(authorPath)).getText();
//		String link = el1.findElement(By.xpath(linkPath)).getAttribute("href");
		
//		System.out.println(allStoryBlocks.size() + "\nfirst story title: " + title + " " + author + "; \n" + link);
		
		String lastPage = getLastPageNumber(browser);
		int lastPageNumber = Integer.parseInt(lastPage);
		
		// now, visit each page and
		for (int i = 2; i <= lastPageNumber; i++) {
			// get info from all story blocks on that page
			System.out.println("Getting page " + i + "...\n");
			
			// first, turn i into a string value
			String pageNumber = String.valueOf(i);			
			// then, make a valid link
			//String pagePath = pagePathBase.append(pageNumber).toString();
			String pagePath = "http://www.lightspeedmagazine.com/fiction/page/" + pageNumber;
			browser.navigate().to(pagePath);
			
			// now get all elements
			List<WebElement> storyBlocks = browser.findElements(By.xpath(storyBlockPath));
			
			// now loop those elements; for each of those elements
			// ........ aaaand a nested for loop is rarely a good idea		
			storyBlocks.stream().forEach(storyBlock -> {
				String storyTitle = storyBlock.findElement(By.xpath(titlePath)).getText();
				String storyAuthor = storyBlock.findElement(By.xpath(authorPath)).getText();
				String storyLink = storyBlock.findElement(By.xpath(linkPath)).getAttribute("href");
				
				System.out.println("Title: " + storyTitle + " " + storyAuthor + "; \n" + storyLink);
			});
		}

		
		browser.close();
	}
	
	private static String getLastPageNumber(ChromeDriver browser) {
		// find last page
		String lastPageLink = browser.findElement(By.xpath("//a[contains(@class, 'page-number-last')]")).getAttribute("href");
		System.out.println("Link to last page: " + lastPageLink);
		String[] splitString = lastPageLink.split("/");
		String lastPageNumber = splitString[splitString.length - 1];
		System.out.println("last number is: " + lastPageNumber);
		
		return lastPageNumber;
	}
	
}


