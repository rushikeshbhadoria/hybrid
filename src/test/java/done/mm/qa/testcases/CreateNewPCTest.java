package done.mm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import done.mm.qa.base.TestBase;
import done.mm.qa.pages.CreateNewPCPage;
import done.mm.qa.pages.LoginPages;

public class CreateNewPCTest extends TestBase {
	CreateNewPCPage po;
	LoginPages loginPages;

	public CreateNewPCTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPages = new LoginPages();
		po = new CreateNewPCPage();
	}

	@Test(invocationCount = 1)
	public void createNewPc() throws Exception {
		loginPages.Login(prop.getProperty("username"), prop.getProperty("password"));

		po.CreatePC();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
