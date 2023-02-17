package done.mm.qa.pages;

import java.awt.AWTException;
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

public class PCOfferingComplete extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[text()='PCO Tracker']")
	WebElement PCOTracker;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Sarfraj Khan']")
	WebElement PC;
	
	@FindBy(how = How.XPATH, using = "//div[5]//div[10]//div[1]//button[1]//*[name()='svg']//*[name()='path' and contains(@d,'M3 17.25V2')]")
	WebElement updatePC;
	//div[5]//div[10]//div[1]//button[1]//*[name()='svg']//*[name()='path' and contains(@d,'M3 17.25V2')]
	
	@FindBy(how = How.XPATH, using = "//div[text()='Action']")
	WebElement clickOnAction;
	
	@FindBy(how = How.XPATH, using = "(//button[@type='button'][text()='Complete'])[1]")
	WebElement complete;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	WebElement yes;
	
	public PCOfferingComplete() {
		PageFactory.initElements(driver, this);

	}

	public void Complete() throws InterruptedException, AWTException {
		
		minimizeScreen(3);
        Thread.sleep(2000);
        
		clickOn(driver, PCOTracker, 10);
		Thread.sleep(2000);

//		JavascriptExecutor je = (JavascriptExecutor) driver;
//		je.executeScript("arguments[0].scrollIntoView(true);",PC);
//		
//		WebElement element = driver.findElement(By.xpath("xpath_Of_Element"));                 
//		je.executeScript("arguments[0].click();",updatePC);

//		Actions actions = new Actions(driver);
//		actions.contextClick(clickOnAction);
		

		
	
		clickOn(driver, complete, 10);

		Thread.sleep(2000);
		clickOn(driver, yes, 10);
	
		Thread.sleep(2000);

	}

}