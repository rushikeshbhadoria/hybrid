package done.mm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import done.mm.qa.base.TestBase;

import done.mm.qa.pages.LaunchPCOffering;
import done.mm.qa.pages.LaunchPCSecMarket;
import done.mm.qa.pages.UpdatePlayerCounter;
import done.mm.qa.pages.LoginPages;

public class LaunchPCSecondMarketTest extends TestBase {
	LaunchPCSecMarket pco;
	LoginPages loginPages;

	public LaunchPCSecondMarketTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPages = new LoginPages();
		pco = new LaunchPCSecMarket();
	}

	@Test(invocationCount = 1)
	public void createMasterTest() throws Exception {
		loginPages.Login(prop.getProperty("username"), prop.getProperty("password"));

		pco.LaunchPCSM();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
