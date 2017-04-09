package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EersteJspTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		// indien je Selenium 3.0.1 gebruikt
		// Voor Windows (vergeet "\" niet te escapen met een tweede "\")
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\...\\chromedriver.exe");
		// Voor mac: 
		 System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
		// vul hier het pad naar je project in
		driver.get("http://localhost:8080/Servlet_to_jsp/index.html");	
	}
	
	@After
	public void clean(){
//		driver.quit();
	}

	@Test
	public void indexHasLinkToDynamicPage() {
		WebElement link  = driver.findElement(By.cssSelector("a[href='dynamysch.jsp']"));
		link.click();
	}
	
	@Test
	public void eersteJspHasLinkToIndex(){
		WebElement link  = driver.findElement(By.cssSelector("a[href='dynamysch.jsp']"));
		link.click();
		
		WebElement linkToIndex = driver.findElement(By.id("home"));
		linkToIndex.click();		
	}
	
	@Test
	public void eersteJspHasDynamicParagraph() {
		int max = 10;
		boolean sameTextInParagraph = true;
		WebElement link  = driver.findElement(By.cssSelector("a[href='dynamysch.jsp']"));
		link.click();
		WebElement dynamicPar = driver.findElement(By.id("dynamisch"));
		String dynamicParText = dynamicPar.getText();
		
		for (int i=0; i<=max && sameTextInParagraph; i++) {
			driver.navigate().refresh();
			dynamicPar = driver.findElement(By.id("dynamisch"));
			sameTextInParagraph = dynamicParText.equals(dynamicPar.getText());
		}
		assertFalse(sameTextInParagraph);	
	}

}
