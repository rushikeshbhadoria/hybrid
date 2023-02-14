package done.mm.qa.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import done.mm.qa.base.TestBase;

public class UpdatePlayerCounter extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[text()='Create New Player counter']")
	WebElement PCCreation;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Action']")
	WebElement clickOnAction;
	
	@FindBy(how = How.XPATH, using = "//*[@data-rowindex='0']//*[@data-testid='EditIcon']")
	WebElement updatePC;
	
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='abbreviation']")
	WebElement abbreviation;
	
	@FindBy(how = How.XPATH, using = "//select[@name='playerRoleId']")
	WebElement playerRoleId;

	@FindBy(how = How.XPATH, using = "//select[@name='country']")
	WebElement country;
	
	@FindBy(how = How.XPATH, using = "//textarea[@name='aboutPlayer']")
	WebElement aboutPlayer;
	
	@FindBy(how = How.XPATH, using = "//select[@name='tournamentId']")
	WebElement tournamentId;
	
	@FindBy(how = How.XPATH, using = "//option[text()='IPL']")
	WebElement tournament;
	
	@FindBy(how = How.XPATH, using = "//select[@name='teamId']")
	WebElement team;
	
	@FindBy(how = How.XPATH, using = "//select[@name='playerKey']")
	WebElement playerKey;

	@FindBy(how = How.XPATH, using = "//input[@name='totalSupply']")
	WebElement totalSupply;

	@FindBy(how = How.XPATH, using = "//input[@name='houseWalletAddress']")
	WebElement houseWalletAddress;
	
	@FindBy(how = How.XPATH, using = "//textarea[@name='aboutPlayer']")
	WebElement aboutplayer;

	@FindBy(how = How.XPATH, using = "//input[@name='totalSupply']")
	WebElement totalsupply;

	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	WebElement saveButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Mint']")
	WebElement mintButton;
	
	public UpdatePlayerCounter() {
		PageFactory.initElements(driver, this);

	}

	public void Update() throws Exception {

//		JavascriptExecutor je = (JavascriptExecutor) driver;
//		je.executeScript("arguments[0].scrollIntoView();",updatePC);

		minimizeScreen(3);
        Thread.sleep(2000);
        
//		Actions actions = new Actions(driver);
//		actions.contextClick(clickOnAction);
//		Thread.sleep(2000);
        
        clickOn(driver, clickOnAction, 5);
        clickOn(driver, clickOnAction, 5);
        Thread.sleep(2000);
		
		clickOn(driver, updatePC, 5);
		
		selectByVisibleText(tournamentId, "IPL");
		selectByVisibleText(team, "Royal Challenger Blore");
		
		selectByVisibleText(playerKey, "suryakumarsplayerkeys");
		
		clearMethod(aboutplayer);
		sendKey(driver, aboutplayer, "", 5);
		
		clearMethod(totalsupply);
		sendKey(driver, totalsupply, "", 5);


		Thread.sleep(2000);
	    scroll(0, 250);
		clickOn(driver, saveButton, 5);
		Thread.sleep(5000);
		readMessege("Player Token Updated Successfully.");
//		clickOn(driver, mintButton, 5);
	
		Thread.sleep(5000);

	}

}