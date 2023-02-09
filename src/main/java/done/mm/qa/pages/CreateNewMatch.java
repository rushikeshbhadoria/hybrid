package done.mm.qa.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import done.mm.qa.base.TestBase;

public class CreateNewMatch extends TestBase {

	@FindBy(how = How.XPATH, using = "//h6[text()='Matches']")
	WebElement clickMatches;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Create Matches']")
	WebElement createNewMatch;
	
	@FindBy(how = How.XPATH, using = "//select[@name='tournamentId']")
	WebElement clickTournament;
	
	@FindBy(how = How.XPATH, using = "//option[text()='IPL']")
	WebElement selectIPL;

	@FindBy(how = How.XPATH, using = "//select[@name='team1Id']")
	WebElement team1;

	@FindBy(how = How.XPATH, using = "//select[@id=':r14:']//option[@value='9'][text()='Chennai Super King']")
	WebElement selectCSK;
	
	@FindBy(how = How.XPATH, using = "//select[@name='team2Id']")
	WebElement team2;

	@FindBy(how = How.XPATH, using = "//button[text()='Mint']")
	WebElement mintButton;
	
	@FindBy(how = How.XPATH, using = "//select[@id=':r15:']//option[@value='10'][text()='Sunrises Hyderabad']")
	WebElement selectSRH;
	
	@FindBy(how = How.XPATH, using = "//select[@name='matchKey']")
	WebElement matchkey;
	
	@FindBy(how = How.XPATH, using = "//option[@value='iplt20_2022_g1']")
	WebElement selectMatchkey;
	
	@FindBy(how = How.XPATH, using = "//input[@name='matchDate']")
	WebElement date;
	
	@FindBy(how = How.XPATH, using = "//input[@name='matchTime']")
	WebElement time;
	
	@FindBy(how = How.XPATH, using = "//select[@name='matchTimeZone']")
	WebElement seltimeZone;
	
	@FindBy(how = How.XPATH, using = "//option[text()='IST']")
	WebElement timeZone;
	
	@FindBy(how = How.XPATH, using = "//input[@name='venue']")
	WebElement venue;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Create']")
	WebElement createButton;
	
	@FindBy(how = How.XPATH, using = "//input[@name='abbreviation']")
	WebElement abbreviation;
	
	@FindBy(how = How.XPATH, using = "//option[text()='Select']")
	WebElement selectTournament;
	
	@FindBy(how = How.XPATH, using = "//div[1]/div[9]/div[1]/div[1]/button[2]")
	WebElement updatetournamnet;
	
	
	
	
	public CreateNewMatch() {
		
		PageFactory.initElements(driver, this);

	}

	public void CreateMatch() throws Exception {
		
		Thread.sleep(2000);
		clickOn(driver,clickMatches, 5);
		Thread.sleep(2000);
		
		clickOn(driver,createNewMatch, 5);
		Thread.sleep(2000);
		
		selectByVisibleText(clickTournament, "IPL");
		Thread.sleep(2000);
		minimizeScreen(3);
		selectByIndex(team1, 1);
		Thread.sleep(2000);
		
		selectByIndex(team2, 2);
		Thread.sleep(2000);
		
		clickOn(driver,matchkey, 5);
		Thread.sleep(2000);
		
		selectByIndex(matchkey, 1);
		Thread.sleep(5000);
		
		scroll(0, 500);
		Thread.sleep(2000);
		
		sendKey(driver, time,"0230AM", 5);
		Thread.sleep(2000);
		
		sendKey(driver, date,"12292022", 5);
		Thread.sleep(2000);
		
	
		selectByIndex(seltimeZone, 1);
		Thread.sleep(2000);
		
		sendKey(driver,venue,"Banglore", 5);
		
		String randomString=givenUsingApache_whenGeneratingRandomAlphabeticString_thenCorrect();
		Thread.sleep(2000);
		sendKey(driver,abbreviation,randomString, 5);
		
		clickOn(driver,createButton, 5);
		readMessege("Match created successfully.");
		
}
	
	
	
	
	
}
