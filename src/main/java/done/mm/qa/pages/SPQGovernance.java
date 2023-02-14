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

public class SPQGovernance extends TestBase {

	@FindBy(how = How.XPATH, using = "//p[text()='SPQ Governance']")
	WebElement clickSPQGov;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Edit']")
	WebElement edit;
	
	@FindBy(how = How.XPATH, using = "//input[@name='unitSellPrice']")
	WebElement sellPrice;
	
	@FindBy(how = How.XPATH, using = "//input[@name='unitBuyPrice']")
	WebElement buyPrice;

	@FindBy(how = How.XPATH, using = "//input[@name='buyMaxQuantityPerUser']")
	WebElement buyMax;

	@FindBy(how = How.XPATH, using = "//input[@name='buyMinQuantityPerUser']")
	WebElement BuyMin;

	@FindBy(how = How.XPATH, using = "//input[@name='sellMaxQuantityPerUser']")
	WebElement sellMax;
	
	@FindBy(how = How.XPATH, using = "//input[@name='sellMinQuantityPerUser']")
	WebElement sellMin;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	WebElement saveButton;
	
	
	public SPQGovernance() {
		PageFactory.initElements(driver, this);

	}

	public void EditSPQ() throws Exception {
		
		
		Thread.sleep(3000);
		clickOn(driver, clickSPQGov, 5);
		Thread.sleep(2000);
		clickOn(driver, edit, 5);
		Thread.sleep(2000);
//		sellPrice.clear();
		sendKey(driver, sellPrice, "", 5);
		Thread.sleep(2000);
//		buyPrice.clear();
		sendKey(driver, buyPrice, "", 5);
		Thread.sleep(2000);
		scroll(0, 200);
		Thread.sleep(2000);
//		buyMax.clear();
		sendKey(driver, buyMax, "", 5);
		Thread.sleep(2000);
//		BuyMin.clear();
		sendKey(driver, BuyMin, "", 5);
		Thread.sleep(2000);
		sendKey(driver, sellMax, "", 5);
		Thread.sleep(2000);
		sendKey(driver, sellMin, "", 5);
		Thread.sleep(2000);
		clickOn(driver, saveButton, 5);
		readMessege("Sptr fiat price movement updated.");
		
	}

}