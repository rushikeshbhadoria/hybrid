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

public class CreateMaster extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[text()='Create New Player counter']")
	WebElement CreatePC;
	@FindBy(how = How.XPATH, using = "//p[text()='Sport']/following-sibling::div")
	WebElement sport;

	@FindBy(how = How.XPATH, using = "//li[text()='cricket']")
	WebElement cricket;
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	WebElement firstName;
	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	WebElement lastName;
	@FindBy(how = How.XPATH, using = "//input[@name='abbreviation']")
	WebElement abbreviation;
	@FindBy(how = How.XPATH, using = "//p[text()='Player Role']/following-sibling::div")
	WebElement playerRoleId;

	@FindBy(how = How.XPATH, using = "//li[text()='Batsman']")
	WebElement Batsman;
	@FindBy(how = How.XPATH, using = "//p[text()='Nationality']/following-sibling::div//select")
	WebElement Nationality;
	@FindBy(how = How.XPATH, using = "//p[text()='About Player']/following-sibling::div//textarea[1]")
	WebElement aboutPlayer;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Tournament']/following-sibling::div")
	WebElement tournamentId;
	@FindBy(how = How.XPATH, using = "//li[text()='IPL']")
	WebElement tournament;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Team']/following-sibling::div")
	WebElement teamId;
	@FindBy(how = How.XPATH, using = "//li[text()='BangloreRoyalChallengers']")
	WebElement team;
	
	@FindBy(how = How.XPATH, using = "//input[@name='rewardDate']")
	WebElement rewardDate;
	@FindBy(how = How.XPATH, using = "//p[text()='Player Key']/following-sibling::div")
	WebElement playerKey;

	@FindBy(how = How.XPATH, using = "//li[@tabindex='0']")
	WebElement key1;
	@FindBy(how = How.XPATH, using = "//p[text()='Total Supply to be minted']/following-sibling::div//input")
	WebElement totalSupply;

	@FindBy(how = How.XPATH, using = "//p[text()='House Wallet Respository Address']/following-sibling::div//input")
	WebElement houseWalletAddress;

	@FindBy(how = How.XPATH, using = "//input[@name='mobileIcon']")
	WebElement mobileIcon;
	@FindBy(how = How.XPATH, using = "//input[@name='webIcon']")
	WebElement webIcon;

	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	WebElement submit;

	public CreateMaster() {
		PageFactory.initElements(driver, this);

	}

	public void CreateMaster() throws Exception {
		// create instance of Random class
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int rand_int1 = rand.nextInt(1000);
		String usernameGenerator = "username" + rand_int1;
		String emailGenarator = "email" + rand_int1 + "@gamil.com";
		
		String generatedString = RandomStringUtils.randomAlphabetic(10);

	    System.out.println(generatedString);

	    
	    
		clickOn(driver, CreatePC, 5);
		clickOn(driver, sport, 10);
		clickOn(driver, cricket, 5);

		sendKey(driver, firstName, generatedString, 5);
		sendKey(driver, lastName, "Auto", 5);
		sendKey(driver, abbreviation, "RHB", 5);
		clickOn(driver, playerRoleId, 5);
		clickOn(driver, Batsman, 5);
		clickOn(driver, Nationality, 5);

		Select select = new Select(Nationality);
		select.selectByValue("India");
		clickOn(driver, aboutPlayer, 5);
		sendKey(driver, aboutPlayer,
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
				5);
		clickOn(driver, tournamentId, 10);
		clickOn(driver, tournament, 10);
		clickOn(driver, teamId, 5);
		clickOn(driver, team, 5);
		
		clickOn(driver, rewardDate, 5);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_1);
		robot.keyPress(KeyEvent.VK_0);

		robot.keyPress(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_7);

		robot.keyPress(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_2);

		clickOn(driver, playerKey, 5);
		clickOn(driver, key1, 5);
		scroll( 0,500);
		Thread.sleep(3500);
		sendKey(driver, totalSupply, "10000", 5);
		sendKey(driver, houseWalletAddress, "0x5aC670D0A4074450b881A4E3bbf1fa7B4677b1DD", 5);
		sendKey(driver, mobileIcon, "C:\\Users\\Dell\\Pictures\\23.08.2022_16.07.43_REC.png", 5);
		sendKey(driver, webIcon, "C:\\Users\\Dell\\Pictures\\23.08.2022_16.07.43_REC.png", 5);
		Thread.sleep(3500);
		clickOn(driver, submit, 5);
		
		Thread.sleep(3500);

		if (driver.getPageSource().contains("Master account created successfully")) {
			System.out.println("ok");
		}

		else {
			String errorMassege = driver.findElement(By.xpath("//div[@class='MuiAlert-message css-2shwac']")).getText();

			System.out.println(errorMassege);
			throw new Exception(errorMassege);

		}

	}

}
