package done.mm.qa.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import done.mm.qa.base.TestBase;

public class LoginPages extends TestBase {

	@FindBy(how = How.XPATH, using = "//button[text()='Login']")
	WebElement Loginwithgoogle;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Continue with Google']")
	WebElement ContinuewithGoogle;
	
	@FindBy(how = How.XPATH, using = "//input[@type='email']")
	WebElement Login;

	@FindBy(how = How.XPATH, using = "//span[text()='Next']")
	WebElement Next;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	WebElement Password;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement SignUpButton;
	
	public LoginPages() {
		PageFactory.initElements(driver, this);

	}

	public void Login(String un, String pwd) throws InterruptedException {
		String parentwin = driver.getWindowHandle();
		Thread.sleep(4000);
		clickOn(driver, Loginwithgoogle, 5);
		Thread.sleep(4000);

		Set<String> allwins = driver.getWindowHandles();

		for (String targetwin : allwins) {

			if (targetwin != parentwin) {

				driver.switchTo().window(targetwin);
			}

		}
		clickOn(driver, ContinuewithGoogle, 5);
		sendKey(driver, Login, un, 20);
		clickOn(driver, Next, 5);
		sendKey(driver, Password, pwd, 5);
		clickOn(driver, Next, 5);

		Thread.sleep(5000);
		driver.switchTo().window(parentwin);
		Thread.sleep(20000);

	}

}