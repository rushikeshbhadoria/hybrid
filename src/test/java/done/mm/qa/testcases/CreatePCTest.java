package done.mm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import done.mm.qa.base.TestBase;

import done.mm.qa.pages.CreatePC;
import done.mm.qa.pages.LoginPages;

public class CreatePCTest extends TestBase {
	CreatePC po;
	LoginPages loginPages;
	Logger log = Logger.getLogger(LoginPages.class);
	
	
	public CreatePCTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
		loginPages = new LoginPages();
		po = new CreatePC();
	}

	@Test(invocationCount = 1)
	public void createMasterTest() throws Exception {
		loginPages.Login(prop.getProperty("username"), prop.getProperty("password"));
		
		po.createPC();
//		log4j material
		
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
