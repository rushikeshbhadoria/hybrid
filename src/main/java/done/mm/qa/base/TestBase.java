package done.mm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import done.mm.qa.util.TestUtil;
import done.mm.qa.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/done/mm/qa/testcases/" + "/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

	}
	
	public static void sendKey(WebDriver driver, WebElement locator,String value, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.sendKeys(value);

	}
	
	public static void selectByVisibleText( WebElement locator,String value) {
		Select drpSelectCoin = new Select(locator);
		drpSelectCoin.selectByVisibleText(value);
		

	}
	
	
	public static void scroll( int start,int  end) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+start+","+end+")");
		

	}
	public static void moveToElement( WebElement value ) {
		Actions actions = new Actions(driver);
		actions.moveToElement(value).perform();
		

	}
	

	public static void initialization() throws InterruptedException {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\nu10\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\nu10\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		e_driver = new EventFiringWebDriver(driver);
		// Now object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(500);

	}

}