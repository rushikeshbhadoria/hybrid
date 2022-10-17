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

public class CompletePCOTest extends TestBase {
	PCOfferingComplete pco;
	LoginPages loginPages;

	public CompletePCOTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPages = new LoginPages();
		pco = new PCOfferingComplete();
	}

	@Test(invocationCount = 1)
	public void createMasterTest() throws Exception {
		loginPages.Login(prop.getProperty("username"), prop.getProperty("password"));

		pco.Complete();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
