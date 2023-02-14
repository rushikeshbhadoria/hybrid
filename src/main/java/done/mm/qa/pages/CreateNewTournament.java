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

public class CreateNewTournament extends TestBase {

	@FindBy(how = How.XPATH, using = "//p[text()='Tournaments']")
	WebElement clickTournaments;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Create New Tournament']")
	WebElement createNewTour;
	
	@FindBy(how = How.XPATH, using = "(//button[@type='button'])[19]")
	WebElement updateTour;
	
	@FindBy(how = How.XPATH, using = "//select[@name='sportCode']")
	WebElement clicksport;
	
	@FindBy(how = How.XPATH, using = "//option[text()='Cricket']")
	WebElement selSport;
	
	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	WebElement tname;

	@FindBy(how = How.XPATH, using = "//input[@name='alias']")
	WebElement alias;

	@FindBy(how = How.XPATH, using = "//input[@name='startDate']")
	WebElement startDate;
	
	@FindBy(how = How.XPATH, using = "//input[@name='endDate']")
	WebElement endDate;
	
	@FindBy(how = How.XPATH, using = "//input[@name='rewardDate']")
	WebElement rewardDate;
	
	@FindBy(how = How.XPATH, using = "//input[@name='rewardRule']")
	WebElement rewardRule;
	
	@FindBy(how = How.XPATH, using = "//input[@Id='logoUrl']")
	WebElement logourl;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	WebElement save;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement update;
	
	public CreateNewTournament() {
		
		PageFactory.initElements(driver, this);

	}

	public void CreateTournament() throws Exception {
		
		minimizeScreen(3);
		Thread.sleep(2000);
		
		clickOn(driver,clickTournaments, 5);
		Thread.sleep(2000);
		
		clickOn(driver,createNewTour, 5);
		Thread.sleep(2000);
		
		selectByVisibleText(clicksport, "Cricket");
		Thread.sleep(2000);
		
		sendKey(driver, tname,"DemoLeague", 5);
		
		sendKey(driver, alias,"DLG", 5);
		Thread.sleep(2000);
		
		sendKey(driver, startDate,"20022023", 5);
		Thread.sleep(5000);
		
		scroll(0, 400);
		Thread.sleep(2000);
	
		sendKey(driver, endDate,"20122023", 5);
		Thread.sleep(2000);
		
		sendKey(driver, rewardDate,"20122023", 5);
		sendKey(driver, logourl,"C:\\Users\\dell03022022\\Downloads\\bowler.png", 5);
		
		
		sendKey(driver, rewardRule, "C:\\Users\\dell03022022\\Downloads\\cricket Reward.pdf", 5);
		Thread.sleep(2000);
		
//		clickOn(driver,save, 5);
//		Thread.sleep(2000);
		
		
//		if (driver.getPageSource().contains("Tournament created successfully.")) {
//			System.out.println("ok");
//		}
//
//		else {
//			String errorMassege = driver.findElement(By.xpath("//div[@class='MuiContainer-root MuiContainer-maxWidthXl css-1ekb41w']")).getText();
//
//			System.out.println(errorMassege);
//			throw new Exception(errorMassege);
//		}
	}
		
		public void UpdateTournament() throws Exception {
			
			minimizeScreen(3);
			Thread.sleep(2000);
			
			clickOn(driver,clickTournaments, 5);
			clickOn(driver,updateTour, 5);
			Thread.sleep(2000);
			
			tname.clear();
			sendKey(driver, tname,"IndianCricetLeague", 5);
			
			alias.clear();
			sendKey(driver, alias,"BABLG", 5);
			Thread.sleep(2000);
			
			scroll(0, 200);
			Thread.sleep(2000);
			
			sendKey(driver, startDate,"12122022", 5);
			sendKey(driver, endDate,"22122022", 5);
			Thread.sleep(2000);
			
//			clickOn(driver,update, 5);
//			Thread.sleep(2000);
//			
//			if (driver.getPageSource().contains("Tournament updated successfully.")) {
//				System.out.println("ok");
//			}
//
//			else {
//				String errorMassege = driver.findElement(By.xpath("//div[@class='MuiContainer-root MuiContainer-maxWidthXl css-1ekb41w']")).getText();
//
//				System.out.println(errorMassege);
//				throw new Exception(errorMassege);
//				
//			}
}
}