package done.mm.qa.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import done.mm.qa.base.TestBase;

import done.mm.qa.pages.CreatePC;
import done.mm.qa.pages.DbConnectionAndRestAssured;
import done.mm.qa.pages.LoginPages;
import done.mm.qa.util.TestUtil;

public class GetApiSample extends TestBase {
	CreatePC po;
	LoginPages loginPages;
	Logger log = Logger.getLogger(LoginPages.class);

	public GetApiSample() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {

	}

	@Test(invocationCount = 1)
	public void Get() throws Exception {

		String pathurl1 = "/v1/tournaments";

		String baseurl1 = "https://sportapi-qa.sportiqo.com";

		// Add headers to the map
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", TestUtil.token);
		headers.put("Content-Type", "application/json");
		headers.put("accept", "application/json");

		String res = DbConnectionAndRestAssured.GetApiClient(headers, baseurl1, pathurl1);
//		System.out.println(res);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {

	}
}
