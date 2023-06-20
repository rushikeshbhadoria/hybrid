package stepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import done.mm.qa.base.DbConnectionAndRestAssured_TestBase;
import done.mm.qa.base.TestBase;
import done.mm.qa.util.TestUtil;

public class PatchApiSample extends TestBase {

	public PatchApiSample() {

	}

	public void patchApiSampleMethod() throws Exception {

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

		String res = DbConnectionAndRestAssured_TestBase.PatchApiClient(headers, baseurl1, pathurl1, body1);
//		System.out.println(res);
	}

}
