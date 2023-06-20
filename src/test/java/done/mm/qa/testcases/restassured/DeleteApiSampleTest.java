package done.mm.qa.testcases.restassured;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import done.mm.qa.base.DbConnectionAndRestAssured_TestBase;
import done.mm.qa.base.TestBase;

import done.mm.qa.pages.CreatePC;

import done.mm.qa.pages.LoginPages;
import done.mm.qa.util.TestUtil;
import stepDefinations.DeleteApiSample;

public class DeleteApiSampleTest extends TestBase {
	DeleteApiSample po = new DeleteApiSample();
	Logger log = Logger.getLogger(LoginPages.class);

	public DeleteApiSampleTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {

	}

	@Test(invocationCount = 1)
	public void Delete() throws Exception {
		po.DeleteApiSampleMethod();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {

	}
}
