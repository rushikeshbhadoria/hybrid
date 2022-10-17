package done.mm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import done.mm.qa.base.TestBase;

import done.mm.qa.pages.LaunchPCOffering;
import done.mm.qa.pages.LoginPages;

public class LaunchPCOfferingTest extends TestBase {
	LaunchPCOffering pco;
	LoginPages loginPages;

	public LaunchPCOfferingTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPages = new LoginPages();
		pco = new LaunchPCOffering();
	}

	@Test(invocationCount = 1)
	public void createMasterTest() throws Exception {
		loginPages.Login(prop.getProperty("username"), prop.getProperty("password"));

		pco.LaunchPC();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
