package done.mm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import done.mm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 10;
	public static String token="Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjY3YmFiYWFiYTEwNWFkZDZiM2ZiYjlmZjNmZjVmZTNkY2E0Y2VkYTEiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vc3BvcnRpcW9kZXYiLCJhdWQiOiJzcG9ydGlxb2RldiIsImF1dGhfdGltZSI6MTY4NTU5OTcyMiwidXNlcl9pZCI6ImlWUDVSN092WmVVMmVxbDdFNlVWbkNUN28yaDEiLCJzdWIiOiJpVlA1UjdPdlplVTJlcWw3RTZVVm5DVDdvMmgxIiwiaWF0IjoxNjg3MjU3NTIwLCJleHAiOjE2ODcyNjExMjAsImVtYWlsIjoicnVzaGlrZXNoYkBudTEwLmNvIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJmaXJlYmFzZSI6eyJpZGVudGl0aWVzIjp7ImVtYWlsIjpbInJ1c2hpa2VzaGJAbnUxMC5jbyJdfSwic2lnbl9pbl9wcm92aWRlciI6InBhc3N3b3JkIn19.Atuq-vOwAUCn1_d1s-03ld8TRkiMIzNwMfNAREOAgGbkBNZ8r_stjhadHw8_XAVoBcD-KqKzGZY1qdbauBES4Mhco1IaCEEWYrhHAIkz2ImF0fCquKAMr5Ag9WEqB_n0Mz72X_Pk7B86i2KCpFjWa92LqXSlCZjzoEL9BCrI9lLogBO52znh14InroFiYfjgmF-K2zHamCiZqR_wkgDdAuBZEVBQqlKeCeTX2D8HuFF1xTrNiXfkt0HFEmsESawoyy6vFZCQbqH84dJTJB9sqxu1g6HLdtIJwB80YajqAppPsJBfhxr7yEFkAK0ppNi0KzGLJUB56K2iIITqDglhqg";

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}



	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}



}