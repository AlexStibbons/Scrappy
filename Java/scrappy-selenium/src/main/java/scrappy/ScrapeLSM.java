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
		
		// Link for Nightmare magazine:
		// http://www.nightmare-magazine.com/fiction/page/
		StringBuffer pagePathBase = new StringBuffer("http://www.lightspeedmagazine.com/fiction/page/");

		// open up browser
		File file = new File("C:/ALICE/ALEPH/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		ChromeDriver browser = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(browser, 30);

		// go to webpage
		
		// Link for Nightmare magazine:
		// http://www.nightmare-magazine.com/fiction/
		browser.get("http://www.lightspeedmagazine.com/fiction/");

		// find all story blocks on page 1
		System.out.println("Getting page 1...\n");
		getStories(browser);

		String lastPage = getLastPageNumber(browser);
		int lastPageNumber = Integer.parseInt(lastPage);

		// now, visit each page
		for (int i = 2; i <= lastPageNumber; i++) {
			
			System.out.println("Getting page " + i + "...\n");
			
			String pageNumber = String.valueOf(i);

			// Link for Nightmare magazine:
			// http://www.nightmare-magazine.com/fiction/page/
		
			String pagePath = "http://www.lightspeedmagazine.com/fiction/page/" + pageNumber;
			
			browser.navigate().to(pagePath);
			
			getStories(browser);
		
		}

		browser.close();
	}

	// XPATHS TO ELEMENTS
	private static String storyBlockPath = "//div[@class='post_wrapper']";
	private static String titlePath = "div[@class='post_content']//h2[@class='posttitle']";
	private static String authorPath = "div[@class='post_content']//p[@class='postmetadata']";
	private static String linkPath = "div[@class='post_content']//h2[@class='posttitle']//a";

	private static String getLastPageNumber(ChromeDriver browser) {
		// find last page
		String lastPageLink = browser.findElement(By.xpath("//a[contains(@class, 'page-number-last')]"))
				.getAttribute("href");
		System.out.println("Link to last page: " + lastPageLink);
		String[] splitString = lastPageLink.split("/");
		String lastPageNumber = splitString[splitString.length - 1];
		System.out.println("last number is: " + lastPageNumber);

		return lastPageNumber;
	}

	private static void getStories(ChromeDriver browser) {

		// now get all elements
		List<WebElement> storyBlocks = browser.findElements(By.xpath(storyBlockPath));

		// now loop those elements; for each of those elements
		// this is basically a for loop, right? 
		// and it's nested in a for loop above --> how good/bad of an idea is this?
		storyBlocks.stream().forEach(storyBlock -> {
			String storyTitle = storyBlock.findElement(By.xpath(titlePath)).getText();
			String storyAuthor = storyBlock.findElement(By.xpath(authorPath)).getText();
			String storyLink = storyBlock.findElement(By.xpath(linkPath)).getAttribute("href");

			System.out.println(storyTitle + " " + storyAuthor + "; \n" + storyLink + "\n");
		});

	}

}
