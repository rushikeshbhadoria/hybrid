package done.mm.qa.pages;

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
	
	@FindBy(how = How.XPATH, using = "//div[@aria-haspopup='listbox']")
	WebElement clickOnPC;

	@FindBy(how = How.XPATH, using = "//li[@tabindex='0']")
	WebElement selectPC;

	@FindBy(how = How.XPATH, using = "//input[@name='offeredCounters']")
	WebElement offeredPC;

	@FindBy(how = How.XPATH, using = "//input[@name='offerPrice']")
	WebElement offerPrice;
	
	@FindBy(how = How.XPATH, using = "//input[@name='minPurchase']")
	WebElement minimumPurchase;
	
	@FindBy(how = How.XPATH, using = "//input[@name='startDate']")
	WebElement startDate;
	
	@FindBy(how = How.XPATH, using = "//input[@name='endDate']")
	WebElement endDate;
	
	@FindBy(how = How.XPATH, using = "//div[2]/button[2]")
	WebElement launchButton;
	
	public LaunchPCOffering() {
		PageFactory.initElements(driver, this);

	}

	public void LaunchPC () throws InterruptedException {

		
		
		clickOn(driver, PCOTracker, 5);
		clickOn(driver, createOffering, 5);
//		clickOn(driver, clickOnPC, 5);
//		clickOn(driver, selectPC, 5);
		sendKey(driver, offeredPC, "10000", 5);
		sendKey(driver, offerPrice, "12", 5);
		sendKey(driver, minimumPurchase, "10", 5);
		
		
		sendKey(driver, startDate, "10102022", 5);
		Thread.sleep(5000);
		sendKey(driver, endDate,"10122022", 5);
		
		
		clickOn(driver, launchButton, 5);
	
		Thread.sleep(5000);

	}

}