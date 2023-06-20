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

public class PutApiSample extends TestBase {
	CreatePC po;
	LoginPages loginPages;
	Logger log = Logger.getLogger(LoginPages.class);

	public PutApiSample() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {

	}

	@Test(invocationCount = 1)
	public void Put() throws Exception {

		String pathurl1 = "/v1/tournaments";

		String baseurl1 = "https://sportapi-qa.sportiqo.com";

		// Add headers to the map
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization",
				TestUtil.token);
		headers.put("Content-Type", "application/json");
		headers.put("accept", "application/json");

		String body1 = "{\r\n" + "  \"alias\": \"Dum\",\r\n"
				+ "  \"logoUrl\": \"file://44KBnB5z3gN#%iTkU:R_b+-!612rwSsPqoPF94GmC2PexHiiKtj7LjNo&1G+c%mJAdoV&u@va-ztFKc~%-+5@0+#8upgsKMBNT\",\r\n"
				+ "  \"rewardRule\": \"https://qm=L#nW/X.nG@kQHk#|b~y0A0ae_MLx\",\r\n" + "  \"name\": \"Dummy\",\r\n"
				+ "  \"sportCode\": \"Cric\",\r\n" + "  \"rewardDate\": \"2023-02-02\",\r\n"
				+ "  \"tournamentKey\": \"DLF\",\r\n" + "  \"endDate\": \"2023-06-19\",\r\n"
				+ "  \"startDate\": \"2023-06-19\"\r\n" + "}";

		String res = DbConnectionAndRestAssured.PutApiClient(headers, baseurl1, pathurl1, body1);
		System.out.println(res);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {

	}
}
