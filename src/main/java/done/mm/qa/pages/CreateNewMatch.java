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

	@FindBy(how = How.XPATH, using = "//p[text()='Matches']")
	WebElement clickMatches;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Create Matches']")
	WebElement createNewMatch;
	
	@FindBy(how = How.XPATH, using = "//select[@name='tournamentId']")
	WebElement clickTournament;
	
	@FindBy(how = How.XPATH, using = "//option[text()='IPL']")
	WebElement selectIPL;

	@FindBy(how = How.XPATH, using = "//select[@name='team1Id']")   
	WebElement team1;

	@FindBy(how = How.XPATH, using = "(//option[text()='Chennai Super Kings'])[1]")
	WebElement selectCSK;
	//select[@id=':r14:']//option[@value='9'][text()='Chennai Super King']
	
	@FindBy(how = How.XPATH, using = "//select[@name='team2Id']")
	WebElement team2;

	@FindBy(how = How.XPATH, using = "//button[text()='Mint']")
	WebElement mintButton;
	
	@FindBy(how = How.XPATH, using = "(//option[text()='Sunrisers Hydrabad'])[2]")
	WebElement selectSRH;
	//select[@id=':r15:']//option[@value='10'][text()='Sunrises Hyderabad']
	
	@FindBy(how = How.XPATH, using = "//select[@name='matchKey']")
	WebElement matchkey;
	
	@FindBy(how = How.XPATH, using = "//option[@value='T20MW_2023_Match1326']")
	WebElement selectMatchkey;
	
	@FindBy(how = How.XPATH, using = "//input[@name='matchDate']")
	WebElement date;
	
	@FindBy(how = How.XPATH, using = "//input[@name='matchTime']")
	WebElement time;
	
	@FindBy(how = How.XPATH, using = "//select[@name='matchTimeZone']")
	WebElement seltimeZone;
	
	@FindBy(how = How.XPATH, using = "//option[text()='Asia/Kolkata (GMT+05:30)']")
	WebElement timeZone;
	
	@FindBy(how = How.XPATH, using = "//input[@name='venue']")
	WebElement venue;
	
	@FindBy(how = How.XPATH, using = "//input[@name='abbreviation']")
	WebElement abbreviation;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Create']")
	WebElement createButton;

	@FindBy(how = How.XPATH, using = "//option[text()='Select']")
	WebElement clcikTournament;
	
	@FindBy(how = How.XPATH, using = "//option[text()='IPL']")
	WebElement selTournament;
	
	@FindBy(how = How.XPATH, using = "//div[1]/div[9]/div[1]/div[1]/button[1]/*[name()='svg'][1]")
	WebElement updateButton;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	WebElement saveButton;
	
	
	
	

	public CreateNewMatch() {
		
		PageFactory.initElements(driver, this);

	}

	public void CreateMatch() throws Exception {
		
		minimizeScreen(3);
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		clickOn(driver,clickMatches, 5);
		Thread.sleep(2000);
		
		clickOn(driver,createNewMatch, 5);
		Thread.sleep(2000);
		
		selectByVisibleText(clickTournament, "IPL");
		Thread.sleep(2000);
		
//		minimizeScreen(3);
		
//		selectByIndex(team1, 1);
//		selectByIndex(team2, 2);
		
		clickOn(driver,team1, 5);
		clickOn(driver,selectCSK, 5);
		clickOn(driver,team2, 5);
		clickOn(driver,selectSRH, 5);
		
		
		clickOn(driver,matchkey, 5);
		clickOn(driver,selectMatchkey, 5);
		Thread.sleep(2000);
		
		scroll(0, 500);
		Thread.sleep(2000);
		
		sendKey(driver, time,"1600AM", 5);
		Thread.sleep(2000);
		
		sendKey(driver, date,"10022023", 5);
		Thread.sleep(2000);
		
	
//		selectByIndex(seltimeZone, 1);
//		Thread.sleep(2000);
		clickOn(driver,seltimeZone, 5);
		clickOn(driver,timeZone, 5);
		
		sendKey(driver,venue,"Banglore", 5);
		
//		String randomString=givenUsingApache_whenGeneratingRandomAlphabeticString_thenCorrect();
		Thread.sleep(2000);
		sendKey(driver,abbreviation,"CSR", 5);
		Thread.sleep(5000);
		
//		clickOn(driver,createButton, 5);
//		readMessege("Match created successfully.");
		
}
	
	public void UpdateMatch() throws Exception {
		
		minimizeScreen(3);
		Thread.sleep(3000);
		
		clickOn(driver,clickMatches, 5);
		Thread.sleep(2000);
		
		clickOn(driver,clcikTournament, 5);
		Thread.sleep(2000);
		
		clickOn(driver,selTournament, 5);
		Thread.sleep(3000);
		
		clickOn(driver,updateButton, 5);
		Thread.sleep(2000);
		
		selectByVisibleText(team1, "Mumbai Indians");
		Thread.sleep(2000);
		selectByVisibleText(team2, "Royal Challenger Blore");
		Thread.sleep(2000);
		
		scroll(0, 400);  
		
//		clearMethod(venue);
//		Thread.sleep(2000);
//		sendKey(driver,venue,"Banglore", 5);

//		clearMethod(abbreviation);
//		sendKey(driver,abbreviation,"MRC", 5);
		
		sendKey(driver, date,"12022023", 5);
		sendKey(driver, time,"1800AM", 5);
		
		clickOn(driver,saveButton, 5);
		
//		Thread.sleep(3000);
//		readMessege("Match updated successfully.");
		
	
	}
	
	
}