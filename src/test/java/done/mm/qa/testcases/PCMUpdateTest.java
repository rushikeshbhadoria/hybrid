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
import done.mm.qa.pages.PCOUpdatePage;
import done.mm.qa.pages.PCOfferingComplete;
import done.mm.qa.pages.PCSMUpdatePage;
import done.mm.qa.pages.PCStatusLivePause;

public class PCMUpdateTest extends TestBase {
	
	PCSMUpdatePage pcm;
	LoginPages loginPages;

	public PCMUpdateTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPages = new LoginPages();
		pcm = new PCSMUpdatePage();
	}

	@Test(invocationCount = 1)
	public void statusupdate() throws Exception {
		loginPages.Login(prop.getProperty("username"), prop.getProperty("password"));
		
       pcm.UpdatePCSM();
	

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
