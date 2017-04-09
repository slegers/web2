package ui.view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import domain.db.StudyTracker;
public class EigenProject5Test {
	// verander de url naar jouw url naam
	private static final String url = "http://localhost:8080/Website/";
	WebDriver driver;

	// Hulpfuncties
	private boolean allTdContains(String string, ArrayList<WebElement> allTd) {
		for (WebElement w : allTd) {
			if (w.getText().toLowerCase().equals(string.toLowerCase()))
				return true;
		}
		return false;
	}

	private void vulFormulierIn(String vak, String uur, String dag) {
		
		Select vakSelect = new Select(driver.findElement(By.id("vak")));
		vakSelect.selectByVisibleText(vak);
		
		Select dropdown = new Select(driver.findElement(By.id("dag_week")));
		dropdown.selectByVisibleText(dag); 
		
		WebElement naamField = driver.findElement(By.id("uur"));
		naamField.clear();
		naamField.sendKeys(uur);

		WebElement button = driver.findElement(By.cssSelector("input[type='submit']"));
		button.click();

	}
	

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
	}

	@After
	public void clean() {
		 driver.quit();
	}

	@Test
	public void indexHeeftBerekendeWaarde() {
		WebElement calculatedValue = driver.findElement(By.id("aantalUur"));
		// berekende waarde handmatig berekenen
		assertEquals("Het aantal uren dat je reeds gestudeerd hebt is " + StudyTracker.getStudyMoment().getAantalUur() +".", calculatedValue.getText());

	}

	@Test
	public void alsFormulierLeegIngevuldIsWordtFormulierOpnieuwGetoond() {
		driver.get(url + "form.html");
		vulFormulierIn("Web2","","maandag");
		assertEquals("Add vak", driver.findElement(By.tagName("h2")).getText());
		assertEquals("Form", driver.getTitle());
	}

	@Test
	public void alsFormulierCorrectIngevuldIsWordtOverzichtMetNieuweWaardeGetoond() {
		driver.get(url + "form.html");
		Random rand = new Random();
		int uur = rand.nextInt(100000);
		String vak = "Web2";
		String dag = "maandag";
		vulFormulierIn(vak, uur+"", dag);

		assertEquals("Overview", driver.getTitle());
		ArrayList<WebElement> allTd = (ArrayList<WebElement>) driver.findElements(By.cssSelector("main td"));

		assertTrue(allTdContains(vak, allTd));
		assertTrue(allTdContains(uur+"", allTd));
		assertTrue(allTdContains(dag, allTd)); 

	}

	@Test
	public void overzichtspaginaIsCorrect() {
		driver.get(url + "Add");
		ArrayList<WebElement> tableElements = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));

		int teller = 0;
		
		for (int i = 0; i < StudyTracker.getStudie().size(); i++) {
			assertEquals(StudyTracker.getStudie().get(i).getVak(), tableElements.get(teller).getText());
			teller++;
			assertEquals(StudyTracker.getStudie().get(i).getDag(), tableElements.get(teller).getText().toLowerCase());
			teller++;
			assertEquals(StudyTracker.getStudie().get(i).getUur(), Integer.parseInt(tableElements.get(teller).getText()));
			teller++;
		}

	}

}
