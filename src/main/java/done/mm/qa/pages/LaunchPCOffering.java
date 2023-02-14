package done.mm.qa.pages;

import java.awt.AWTException;
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

public class LaunchPCOffering extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[text()='PCO Tracker']")
	WebElement PCOTracker;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Create New PC Offering']")
	WebElement createOffering;
	
	@FindBy(how = How.XPATH, using = "//input[@id='playerCounterId']")
	WebElement clickOnDropdown;

	@FindBy(how = How.XPATH, using = "//input[@value='T10-SJD (LCAlfzDiLv Auto)']")
	WebElement selectPC;

	@FindBy(how = How.XPATH, using = "//input[@name='offeredCounters']")
	WebElement offeredPC;

	@FindBy(how = How.XPATH, using = "//input[@name='offerPrice']")
	WebElement offerPrice;
	
	@FindBy(how = How.XPATH, using = "//input[@name='buyMaxQuantityPerUser']")
	WebElement maxPurchase;
	
	@FindBy(how = How.XPATH, using = "//input[@name='buyMinQuantityPerUser']")
	WebElement miniPurchase;
	
	@FindBy(how = How.XPATH, using = "//input[@name='startDate']")
	WebElement startDate;
	
	@FindBy(how = How.XPATH, using = "//input[@name='endDate']")
	WebElement endDate;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Launch PC Offering']")
	WebElement launchButton;
	
	
	public LaunchPCOffering() {
		PageFactory.initElements(driver, this);

	}

	public void LaunchPC () throws InterruptedException, AWTException {

		minimizeScreen(3);
        Thread.sleep(3000);
		
		clickOn(driver, PCOTracker, 5);
		 Thread.sleep(3000);
		clickOn(driver, createOffering, 5);
		Thread.sleep(2000);
		
		sendKey(driver, clickOnDropdown, "SJD", 5);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		sendKey(driver, offeredPC, "500", 5);
		sendKey(driver, offerPrice, "15", 5);
		
		sendKey(driver, maxPurchase, "10", 5);
		sendKey(driver, miniPurchase, "1", 5);
		
		
		sendKey(driver, startDate, "15022023", 5);
		Thread.sleep(5000);
		sendKey(driver, endDate,"20022023", 5);
		
		
//		clickOn(driver, launchButton, 5);
	
		Thread.sleep(5000);

	}

}