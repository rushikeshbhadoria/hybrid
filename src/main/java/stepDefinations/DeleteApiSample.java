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

public class DeleteApiSample extends TestBase {

	public DeleteApiSample() {

	}

	public void DeleteApiSampleMethod() throws Exception {

		String pathurl1 = "/v1/tournaments";

		String baseurl1 = "https://sportapi-qa.sportiqo.com";

		// Add headers to the map
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", TestUtil.token);
		headers.put("Content-Type", "application/json");
		headers.put("accept", "application/json");

		String res = DbConnectionAndRestAssured_TestBase.DeleteApiClient(headers, baseurl1, pathurl1);
//		System.out.println(res);
	}

}
