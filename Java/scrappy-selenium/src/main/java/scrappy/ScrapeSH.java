package scrappy;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrapeSH {

	public static void main(String[] args) {
		
		// open up browser
		File file = new File("C:/ALICE/ALEPH/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		ChromeDriver browser = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(browser, 30);
		
		// go to webpage
		browser.get("http://strangehorizons.com/fiction/");

		// for extra convenience, set a String value for button that needs pressing
		String loadMorePath = "//div[@class='load-more']"; // finds it
		
		String storyBlockPath = "//div[contains(@class, 'masonry-item')]"; // finds all story blocks
		
		// post element is class="post masonry-item" and includes
		// div title with title and a link to story and div author with author name
		// loop all story blocks
		// extract title, author, link
		// click button
		// get new stories
		
		WebElement el1 = browser.findElement(By.xpath(loadMorePath));
		String ee1 = el1.getText();
		System.out.println(ee1 + " -- found button, now getting story block elements\n");
		
		List<WebElement> el2 = browser.findElements(By.xpath(storyBlockPath));		
		
		System.out.println("\n" + el2.get(1).getText() + ", \nGetting this story block info...\n");
		
		WebElement storyBlock = el2.get(1);
		
		String title = storyBlock.findElement(By.xpath("div[@class='title']")).getText();
		System.out.println("Story block title is " + title);
		
		String link = storyBlock.findElement(By.xpath("div[@class='title']/a")).getAttribute("href");
		System.out.println("Story block link is " + link);
		
		String author = storyBlock.findElement(By.xpath("div[@class='author']")).getText();
		System.out.println("Story block author is " + author);
		
		browser.close();
	}

}
