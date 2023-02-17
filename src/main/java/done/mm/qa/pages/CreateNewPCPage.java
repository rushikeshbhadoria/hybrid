package done.mm.qa.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import done.mm.qa.base.TestBase;

public class CreateNewPCPage extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[text()='Create New Player counter']")
	WebElement CreatePC;
	
	@FindBy(how = How.XPATH, using = "//select[@name='sportId']")
	WebElement sport;

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

	@FindBy(how = How.XPATH, using = "//input[@name='mobileIcon']")
	WebElement mobileIcon;
	
	@FindBy(how = How.XPATH, using = "//input[@name='webIcon']")
	WebElement webIcon;

	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	WebElement submit;

	public CreateNewPCPage() {
		PageFactory.initElements(driver, this);

	}

	public void CreatePC() throws Exception {
		
		minimizeScreen(3);
		Thread.sleep(2000);
		
		// create instance of Random class
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int rand_int1 = rand.nextInt(1000);
		String usernameGenerator = "username" + rand_int1;
		String emailGenarator = "email" + rand_int1 + "@gamil.com";
		
		String generatedString = "Z"+RandomStringUtils.randomAlphabetic(10);
		String add= randomAddrivetion();
	    System.out.println(generatedString);

		clickOn(driver, CreatePC, 5);
		
		selectByVisibleText(sport, "Cricket");

		sendKey(driver, firstName, generatedString, 5);
		sendKey(driver, lastName, "Auto", 5);
		sendKey(driver, abbreviation, add, 5);
		selectByVisibleText(playerRoleId, "Bowler");
		Thread.sleep(1000);
		scroll( 0,500);
		
		selectByVisibleText(country, "India");
		
		sendKey(driver, aboutPlayer,
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
				5);
		
		Thread.sleep(2000);
		selectByVisibleText(tournamentId, "Tournament1");
		selectByVisibleText(team, "Royal Challenger Blore");
		
		selectByVisibleText(playerKey, "suryakumarsplayerkeys");
		
		scroll( 0,500);
		Thread.sleep(2000);
		sendKey(driver, totalSupply, "10000", 5);
		sendKey(driver, houseWalletAddress, "0x5aC670D0A4074450b881A4E3bbf1fa7B4677b1DD", 5);
		String path="C:\\Users\\Dell\\eclipse2-workspace\\SpqAdmin\\20230119_171752.jpg";
		sendKey(driver, mobileIcon, path, 5);
		sendKey(driver, webIcon, path, 5);
		Thread.sleep(3000);
		clickOn(driver, submit, 5);
		Thread.sleep(3000);
		
//		readMessege("Player counter created successfully.");
		

	}

}
