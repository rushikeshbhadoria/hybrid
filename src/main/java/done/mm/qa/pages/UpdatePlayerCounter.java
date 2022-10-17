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

public class UpdatePlayerCounter extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[text()='Create New Player counter']")
	WebElement PCCreation;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Robin Uttapa']")
	WebElement PC;
	
	@FindBy(how = How.XPATH, using = "//div/div/div/div[3]/div[10]/div/button[1]")
	WebElement updatePC;
	
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

	public void Update() throws InterruptedException {
		



		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();",updatePC);
		
		clickOn(driver, updatePC, 5);


		Thread.sleep(5000);
	    scroll(0, 250);
		clickOn(driver, saveButton, 5);
		Thread.sleep(10000);
		clickOn(driver, mintButton, 5);
	
		Thread.sleep(5000);

	}

}