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

public class PostApiSample extends TestBase {
	CreatePC po;
	LoginPages loginPages;
	Logger log = Logger.getLogger(LoginPages.class);

	public PostApiSample() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {

	}

	@Test(invocationCount = 1)
	public void Post() throws Exception {

		String pathurl1 = "/v1/tournaments";

		String baseurl1 = "https://sportapi-qa.sportiqo.com";

		// Add headers to the map
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization",
				"Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjY3YmFiYWFiYTEwNWFkZDZiM2ZiYjlmZjNmZjVmZTNkY2E0Y2VkYTEiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vc3BvcnRpcW9kZXYiLCJhdWQiOiJzcG9ydGlxb2RldiIsImF1dGhfdGltZSI6MTY4NTU5OTcyMiwidXNlcl9pZCI6ImlWUDVSN092WmVVMmVxbDdFNlVWbkNUN28yaDEiLCJzdWIiOiJpVlA1UjdPdlplVTJlcWw3RTZVVm5DVDdvMmgxIiwiaWF0IjoxNjg3MTc0NTQwLCJleHAiOjE2ODcxNzgxNDAsImVtYWlsIjoicnVzaGlrZXNoYkBudTEwLmNvIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJmaXJlYmFzZSI6eyJpZGVudGl0aWVzIjp7ImVtYWlsIjpbInJ1c2hpa2VzaGJAbnUxMC5jbyJdfSwic2lnbl9pbl9wcm92aWRlciI6InBhc3N3b3JkIn19.dRK1v0kNW-JrYVKcxYLhbwbsfN0_4zdI6nkv8esbb52lVmjoxIdfyM2qyTkx9x0afESaZndITs_LTun7dCDpI3kRSaK0668DCnnyV1sh4ofaGEoBaaTwDwcJf_ZAJkm52EV9u0fMmvtffTsXVPR67rFwLC0kN3gdyZ2Jo500WCry2HbA0mzREDfJiUTwPl0qPFIAHGUwmZbaaT_OvVsIEsoAsXMlf9I0svU17potA11C_ejSmafeY6-sooikslN3bD4RLnMNUgSqH3Y07Fy7WJhZQEq0WkvbV4Q80AMKSSvNi1e-CwBFSwWQIXgL-LKjpI-X2VIcRhBH8_vJYprstA");
		headers.put("Content-Type", "application/json");
		headers.put("accept", "application/json");

		String body1 = "{\r\n" + "  \"alias\": \"Dum\",\r\n"
				+ "  \"logoUrl\": \"file://44KBnB5z3gN#%iTkU:R_b+-!612rwSsPqoPF94GmC2PexHiiKtj7LjNo&1G+c%mJAdoV&u@va-ztFKc~%-+5@0+#8upgsKMBNT\",\r\n"
				+ "  \"rewardRule\": \"https://qm=L#nW/X.nG@kQHk#|b~y0A0ae_MLx\",\r\n" + "  \"name\": \"Dummy\",\r\n"
				+ "  \"sportCode\": \"Cric\",\r\n" + "  \"rewardDate\": \"2023-02-02\",\r\n"
				+ "  \"tournamentKey\": \"DLF\",\r\n" + "  \"endDate\": \"2023-06-19\",\r\n"
				+ "  \"startDate\": \"2023-06-19\"\r\n" + "}";

		String res = DbConnectionAndRestAssured.PostApiClient(headers, baseurl1, pathurl1, body1);
		System.out.println(res);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {

	}
}
