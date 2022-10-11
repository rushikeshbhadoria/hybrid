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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import done.mm.qa.base.TestBase;

public class DeletePC extends TestBase {

	@FindBy(how = How.XPATH, using = "//div[@aria-label='PC #']")
	WebElement pcHash;
	@FindBy(how = How.XPATH, using = "//div[@aria-label='PC #']//button[@aria-label='Menu']")
	WebElement menu;
	@FindBy(how = How.XPATH, using = "//li[@data-value='desc']")
	WebElement desc;
	@FindBy(how = How.XPATH, using = "//div[@data-rowindex='0']//*[@data-testid='DeleteOutlineIcon']")
	WebElement deleteOutlineIcon;

	public DeletePC() {
		PageFactory.initElements(driver, this);

	}

	public void delete_master() throws Exception {
		moveToElement(pcHash);

		clickOn(driver, menu, 5);
		clickOn(driver, desc, 5);
		clickOn(driver, deleteOutlineIcon, 10);

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
