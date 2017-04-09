package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import domain.Vak;

public class TestTable {

	private WebDriver driver;
	private ArrayList<Vak> vakken = new ArrayList<Vak>();

	@Before
	public void setUp() {
		Vak bop = new Vak("BOP", 6, "1TX");
		vakken.add(bop);
		Vak web2 = new Vak("Web2", 3, "1TX");
		vakken.add(web2);
		Vak web3 = new Vak("Web3", 3, "2TX");
		vakken.add(web3);
		Vak capita = new Vak("Capita Selecta", 3, "3TX");
		vakken.add(capita);	

		// indien je Selenium 3.0.1 gebruikt
		// Voor Windows (vergeet "\" niet te escapen met een tweede "\")
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\...\\chromedriver.exe");
		// Voor mac: 
		 System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
		// vul hier het pad naar je project in
		driver.get("http://localhost:8080/Vak_jsp/VakkenOverzicht.jsp");
	}
	
	@After
	public void clean(){
		driver.quit();
	}
	
	@Test
	public void tableIsAccessible() {
		ArrayList<WebElement> th = (ArrayList<WebElement>) driver.findElements(By.tagName("th"));
		if (th.size()>0) {
		assertEquals("Vak", th.get(0).getText());
		assertEquals("Studiepunten", th.get(1).getText());
		assertEquals("Jaar", th.get(2).getText());
		}
		else {
			fail("No element th found");
		}		
	}
	
	@Test
	public void firstLineIsCorrect() {
		ArrayList<WebElement> td = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
		int teller=0;
		for (Vak vak:vakken) {
			assertEquals(vak.getNaam(), td.get(teller*3).getText());
			assertEquals(vak.getStudiePunten(), Integer.parseInt(td.get(teller*3+1).getText()));
			assertEquals(vak.getJaar(), td.get(teller*3+2).getText());
			teller++;
		}
		if (td.size()==0) {
			fail("No element td found");
		}

	}
	

}
