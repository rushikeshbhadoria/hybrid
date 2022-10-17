package done.mm.qa.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import done.mm.qa.base.TestBase;

public class LaunchPCSecMarket extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[text()='	Market Tracker']")
	WebElement PCMarket;

	@FindBy(how = How.XPATH, using = "//button[text()='Launch PC To Market']")
	WebElement launchPCMarket;
	
	@FindBy(how = How.XPATH, using = "//div[@aria-expanded='true']")
	WebElement clickOnPC;

	@FindBy(how = How.XPATH, using = "//li[@tabindex='0']")
	WebElement selectPC;

	@FindBy(how = How.XPATH, using = "//input[@name='buyPrice']")
	WebElement buyprice;

	@FindBy(how = How.XPATH, using = "//input[@name='sellPrice']")
	WebElement sellprice;
	
	@FindBy(how = How.XPATH, using = "//input[@name='maxPurchaseQty']")
	WebElement maxPurchase;
	
	@FindBy(how = How.XPATH, using = "//input[@name='minPurchaseQty']")
	WebElement minpurchase;
	
	@FindBy(how = How.XPATH, using = "//div[2]/button[2]")
	WebElement launchButton;
	
	public LaunchPCSecMarket() {
		PageFactory.initElements(driver, this);

	}

	public void LaunchPCSM () throws InterruptedException {

		clickOn(driver, PCMarket, 5);
		clickOn(driver, launchPCMarket, 5);
//		clickOn(driver, clickOnPC, 5);
//		clickOn(driver, selectPC, 5);
		
		sendKey(driver, buyprice, "10", 5);
		sendKey(driver, sellprice, "12", 5);
		
		scroll(0, 200);
		
		sendKey(driver, maxPurchase, "50", 5);
		sendKey(driver, minpurchase, "5", 5);
	
		clickOn(driver, launchButton, 5);
	
		Thread.sleep(5000);

	}

}