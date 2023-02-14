package done.mm.qa.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import done.mm.qa.base.TestBase;

public class PCSMUpdatePage extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[text()='Market Tracker']")
	WebElement PCMarket;

	@FindBy(how = How.XPATH, using = "//*[@data-rowindex='0']//*[@data-testid='EditIcon']")
	WebElement update;

	@FindBy(how = How.XPATH, using = "//input[@id='playerTokenId']")
	WebElement clickOnPC;

	@FindBy(how = How.XPATH, using = "//input[@name='buyPrice']")
	WebElement buyprice;

	@FindBy(how = How.XPATH, using = "//input[@name='sellPrice']")
	WebElement sellprice;

	@FindBy(how = How.XPATH, using = "//input[@name='buyMaxQuantityPerUser']")
	WebElement maxbuy;

	@FindBy(how = How.XPATH, using = "//input[@name='buyMinQuantityPerUser']")
	WebElement minbuy;

	@FindBy(how = How.XPATH, using = "//input[@name='sellMaxQuantityPerUser']")
	WebElement maxsell;

	@FindBy(how = How.XPATH, using = "//input[@name='sellMinQuantityPerUser']")
	WebElement minsell;

	@FindBy(how = How.XPATH, using = "//button[text()='Update PC']")
	WebElement updatePCM;

	public PCSMUpdatePage() {
		PageFactory.initElements(driver, this);

	}

	public void UpdatePCSM() throws Exception {
		
		minimizeScreen(3);

		clickOn(driver, PCMarket, 5);
		Thread.sleep(5000);
		clickOn(driver, update, 5);
		Thread.sleep(5000);
		clearMethod(buyprice);

		Thread.sleep(500);
		sendKey(driver, buyprice, "", 5);
		clearMethod(sellprice);

		sendKey(driver, sellprice, "", 5);

		Thread.sleep(2000);
		scroll(0, 200);

		clearMethod(maxbuy);
		sendKey(driver, maxbuy, "", 5);
		clearMethod(minbuy);
		sendKey(driver, minbuy, "", 5);
		Thread.sleep(2000);

		sendKey(driver, maxsell, "", 5);
		sendKey(driver, minsell, "", 5);

		clickOn(driver, updatePCM, 5);
//		readMessege("Player Token Secondary Market Updated.");
		

	}

}
