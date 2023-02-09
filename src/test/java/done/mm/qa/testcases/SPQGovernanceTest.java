package done.mm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import done.mm.qa.base.TestBase;
import done.mm.qa.pages.CreateNewPCPage;
import done.mm.qa.pages.LaunchPCOffering;
import done.mm.qa.pages.UpdatePlayerCounter;
import done.mm.qa.pages.LoginPages;
import done.mm.qa.pages.SPQGovernance;

public class SPQGovernanceTest extends TestBase {
	SPQGovernance spqGov;
	LoginPages loginPages;

	public SPQGovernanceTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPages = new LoginPages();
		spqGov = new SPQGovernance();
	}

	@Test(invocationCount = 1)
	public void createMasterTest() throws Exception {
		loginPages.Login(prop.getProperty("username"), prop.getProperty("password"));

		spqGov.EditSPQ();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
