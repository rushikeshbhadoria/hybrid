package done.mm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import done.mm.qa.base.TestBase;

import done.mm.qa.pages.LaunchPCOffering;
import done.mm.qa.pages.UpdatePlayerCounter;
import done.mm.qa.pages.LoginPages;
import done.mm.qa.pages.PCOfferingComplete;
import done.mm.qa.pages.PCStatusLivePause;

public class PCStatusChangeTest extends TestBase {
	
	PCStatusLivePause pls;
	LoginPages loginPages;

	public PCStatusChangeTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPages = new LoginPages();
		pls = new PCStatusLivePause();
	}

	@Test(invocationCount = 1)
	public void createMasterTest() throws Exception {
		loginPages.Login(prop.getProperty("username"), prop.getProperty("password"));

		pls.ChangeStaus();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
