package done.mm.qa.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import done.mm.qa.base.TestBase;

public class LaunchPCSecMarket extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[text()='Market Tracker']")
	WebElement PCMarket;

	@FindBy(how = How.XPATH, using = "//button[text()='Launch PC To Market']")
	WebElement launchPCMarket;
	
	@FindBy(how = How.XPATH, using = "//div[@aria-expanded='true']")
	WebElement clickOnPC;

	@FindBy(how = How.XPATH, using = "//li[@tabindex='0']")
	WebElement selectPC;
	
	@FindBy(how = How.XPATH, using = "//input[@id='playerTokenId']")
	WebElement clickOnDropdown;
	
	@FindBy(how = How.XPATH, using = "//input[@name='buyPrice']")
	WebElement buyprice;

	@FindBy(how = How.XPATH, using = "//input[@name='sellPrice']")
	WebElement sellprice;
	
	@FindBy(how = How.XPATH, using = "//input[@name='buyMaxQuantityPerUser']")
	WebElement maxBuy;
	
	@FindBy(how = How.XPATH, using = "//input[@name='buyMinQuantityPerUser']")
	WebElement minBuy;
	
	@FindBy(how = How.XPATH, using = "//input[@name='sellMaxQuantityPerUser']")
	WebElement maxSell;
	
	@FindBy(how = How.XPATH, using = "//input[@name='sellMinQuantityPerUser']")
	WebElement minSell;
	
	@FindBy(how = How.XPATH, using = "//div[2]/button[2]")
	WebElement launchButton;
	
	public LaunchPCSecMarket() {
		PageFactory.initElements(driver, this);

	}

	public void LaunchPCSM () throws Exception {
		
		minimizeScreen(3);
        Thread.sleep(3000);

		clickOn(driver, PCMarket, 5);
		Thread.sleep(3000);
		clickOn(driver, launchPCMarket, 5);
		Thread.sleep(3000);
		
//		clickOn(driver, clickOnDropdown, 5);
		sendKey(driver, clickOnDropdown, "WQE", 5);
		Thread.sleep(2000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		sendKey(driver, buyprice, "15", 5);
		sendKey(driver, sellprice, "14", 5);
		
		scroll(0, 200);
		
		sendKey(driver, maxBuy, "50", 5);
		sendKey(driver, minBuy, "1", 5);
		
		sendKey(driver, maxSell, "50", 5);
		sendKey(driver, minSell, "1", 5);
	
		clickOn(driver, launchButton, 5);
	
		Thread.sleep(3000);
//		readMessege("Player Token Launch to Secondary Market.");

	}

}