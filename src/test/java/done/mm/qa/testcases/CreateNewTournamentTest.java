package done.mm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import done.mm.qa.base.TestBase;
import done.mm.qa.pages.CreateNewPCPage;
import done.mm.qa.pages.CreateNewTournament;
import done.mm.qa.pages.LoginPages;

public class CreateNewTournamentTest extends TestBase {
	CreateNewTournament cnt;
	LoginPages loginPages;

	public CreateNewTournamentTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPages = new LoginPages();
		cnt = new CreateNewTournament();
	}

	@Test(invocationCount = 1)
	public void createTournamentTest() throws Exception {
		loginPages.Login(prop.getProperty("username"), prop.getProperty("password"));

		cnt.CreateTournament();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
