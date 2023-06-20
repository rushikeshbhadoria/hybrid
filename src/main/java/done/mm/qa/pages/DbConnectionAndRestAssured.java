package done.mm.qa.pages;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import done.mm.qa.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class DbConnectionAndRestAssured extends TestBase {
	static String trx_id, amount, token;

	public DbConnectionAndRestAssured() {
		super();

		PageFactory.initElements(driver, this); //
	}

	@FindBy(xpath = "//android.view.ViewGroup[@index='1']//android.view.View[@index='1']/android.view.View[@index='3']")
	public WebElement portfolio;

	@FindBy(xpath = "//android.widget.TextView[@text='Add Money']")
	public WebElement addmoney;

	@FindBy(xpath = "//android.widget.TextView[@text='Withdraw']")
	public WebElement withdraw;

	@FindBy(xpath = "//android.widget.TextView[@text='Enter INR amount']/following-sibling::android.view.ViewGroup[@index='1']/android.widget.EditText[@index='0']")
	public WebElement enterAmount;

	@FindBy(xpath = "//android.widget.TextView[@text='Enter INR amount to withdraw']/following-sibling::android.view.ViewGroup[@index='3']/android.widget.EditText[@index='0']")
	public WebElement enterWithdrawAmount;

	@FindBy(xpath = "//android.widget.TextView[@text='Proceed to payment']")
	public WebElement proceedToPay;

	@FindBy(xpath = "//android.widget.TextView[@text='Proceed']")
	public WebElement proceedToWithdraw;

	@FindBy(xpath = "//android.widget.TextView[@text='Withdraw in progress']")
	public WebElement withdrawToast;

	@FindBy(xpath = "//android.widget.TextView[@text='Close']")
	public WebElement closeWithdraw;

	@FindBy(xpath = "//android.view.ViewGroup[@index='10']//android.widget.ImageView")
	public WebElement checkBox;

	@FindBy(xpath = "//android.widget.TextView[@text='Proceed']")
	public WebElement proceed;

	@FindBy(xpath = "//android.widget.EditText[@text='Enter Transaction ID']")
	public WebElement enterTrnxId;

	@FindBy(xpath = "//android.view.ViewGroup[@index='3']//android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']")
	public WebElement uploadUrl;

	@FindBy(xpath = "//android.widget.TextView[@text='Submit']")
	public WebElement submit;

	@FindBy(xpath = "//android.widget.TextView[@text='Verification in progress']")
	public WebElement verifyText;

	@FindBy(xpath = "//android.widget.TextView[@text='Okay']")
	public WebElement okay;

	@FindBy(xpath = "//android.widget.TextView[@text='']")
	public WebElement cross;

	/*-------------------------------------------------------------------------------------------------------------*/

	@FindBy(xpath = "//android.widget.TextView[@text='Continue']")
	public WebElement contimue;

	@FindBy(xpath = "//android.widget.TextView[@text='Transactions']")
	public WebElement transactions;

	@FindBy(xpath = "//android.widget.TextView[@text='Player Stock']")
	public WebElement playercounters;

	@FindBy(xpath = "//android.widget.TextView[@text='Funds']")
	public WebElement fundsTransactions;

	@FindBy(xpath = "//android.widget.ScrollView[@index='0']//android.view.ViewGroup[@index='1']//android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']")
	public WebElement firstTrnx;
	// android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]

	@FindBy(xpath = "//android.widget.TextView[@text='Copy']")
	public WebElement copy;

	@FindBy(xpath = "//android.widget.TextView[@text='BUY']/following-sibling::android.widget.TextView[@index='1']")
	public WebElement getPcQty;

	@FindBy(xpath = "//android.widget.TextView[@text='Reference Number']/following-sibling::android.view.ViewGroup[@index='1']//android.widget.TextView[@index='0']")
	public WebElement refNo;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[2]")
	public WebElement pcTransfered;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[4]")
	public WebElement spqTransfered;

	@FindBy(xpath = "//android.widget.TextView[@text='Pay with IMPS/UPI']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.ImageView")
	public WebElement ManualOption;

	@FindBy(xpath = "//android.widget.TextView[@text='Proceed']")
	public WebElement proceedButton;

	@FindBy(xpath = "//android.widget.EditText[@text='Enter Transaction ID']")
	public WebElement EntertrxId;

	@FindBy(xpath = "//android.widget.EditText[@text='Enter Transaction ID']")
	public WebElement imageUrl;

	@FindBy(xpath = "//android.view.ViewGroup[@index='4']/android.widget.ScrollView[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']")
	public WebElement PhonePe;

	@FindBy(xpath = "//android.widget.TextView[@text='Submit']")
	public WebElement submitButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Complete KYC']")
	public WebElement compProfilePopUp;

	@FindBy(xpath = "//android.widget.TextView[@text='KYC must be completed before withdrawing funds']/preceding-sibling::android.widget.TextView[@index='0']")
	public WebElement closePopUp;

	@FindBy(xpath = "//android.widget.TextView[@text='Portfolio Value']/parent::android.view.ViewGroup/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]")
	public WebElement dropdown;

	@FindBy(xpath = "//android.widget.TextView[@text='Funds Available for Trading']/following-sibling::android.widget.TextView")
	public WebElement fundBalance;
	/*-------------------------------------------------------------------------------------------------------------*/

	RequestSpecification res, res1, res2, res3, res4, res5;
	ResponseSpecification resspec;

	public static String PostApiClient(Map<String, String> headers, String baseurl, String pathurl, String body)
			throws IOException {

		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseurl).build();

		ResponseSpecification resspec = new ResponseSpecBuilder().build();

		RequestSpecification res = given().log().all().spec(req).body(body);

		Response response = res.headers(headers).when().post(pathurl).then().spec(resspec).extract().response();

		String responseString = response.asString();
		System.out.println("Response" + '\n' + response.prettyPrint());
		return responseString;

//		given().body(body).headers(headers).when().post(baseurl + pathurl).then().log().all().statusCode(200);
//		return body;
	}

	public static String PutApiClient(Map<String, String> headers, String baseurl, String pathurl, String body)
			throws IOException {

		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseurl).build();

		ResponseSpecification resspec = new ResponseSpecBuilder().build();

		RequestSpecification res = given().log().all().spec(req).body(body);

		Response response = res.headers(headers).when().put(pathurl).then().spec(resspec).extract().response();

		String responseString = response.asString();
		System.out.println("Response" + '\n' + response.prettyPrint());
		return responseString;


	}

	public static String PatchApiClient(Map<String, String> headers, String baseurl, String pathurl, String body)
			throws IOException {

		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseurl).build();

		ResponseSpecification resspec = new ResponseSpecBuilder().build();

		RequestSpecification res = given().log().all().spec(req).body(body);

		Response response = res.headers(headers).when().patch(pathurl).then().spec(resspec).extract().response();

		String responseString = response.asString();
		System.out.println("Response" + '\n' + response.prettyPrint());
		return responseString;


	}

	public static String GetApiClient(Map<String, String> headers, String baseurl, String pathurl)
			throws IOException {

		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseurl).build();

		ResponseSpecification resspec = new ResponseSpecBuilder().build();

		RequestSpecification res = given().log().all().spec(req);

		Response response = res.headers(headers).when().get(pathurl).then().spec(resspec).extract().response();

		String responseString = response.asString();
		System.out.println("Response" + '\n' + response.prettyPrint());
		return responseString;


	}

	public static String DeleteApiClient(Map<String, String> headers, String baseurl, String pathurl)
			throws IOException {

		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseurl).build();

		ResponseSpecification resspec = new ResponseSpecBuilder().build();

		RequestSpecification res = given().log().all().spec(req);

		Response response = res.headers(headers).when().delete(pathurl).then().spec(resspec).extract().response();

		String responseString = response.asString();
		System.out.println("Response" + '\n' + response.prettyPrint());
		return responseString;


	}

	@SuppressWarnings("unchecked")
	public void PostApiPrIssued() throws Exception {
		RestAssured.registerParser("text/plain", Parser.JSON);

		String response0 = DBtoken();
		String respone2 = "Bearer " + response0;

		JSONObject post = new JSONObject();

		post.put("amount", 60.06);
		post.put("gatewayTrxDateTime", "2023-06-07T12:56:07");
		post.put("gatewayUsed", "RestAssured");
		post.put("status", "SUCCESS");
		post.put("trxId", "0x9C75Aac5bbCD271Ac0A");
		post.put("gatewayTrxId", "NA");
		post.put("remarks", "Automation");

		System.out.println(post.toJSONString());
		given().body(post.toJSONString()).header("Authorization", respone2).header("Content-Type", "application/json")
				.when().post("https://walletapi-qa.sportiqo.com/wallets/fiatPaymentStatus").then().log().all()
				.statusCode(200);
	}

	public String DBtoken() throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://spq-qa-db01.cu9isu4v9eh3.ap-southeast-1.rds.amazonaws.com:5432/spq_preprod_db",
				"spqprodadmin", "X#kqe4x0N3%u7J*If1fLGS&Z");

		if (connection.isClosed()) {

		} else {
			System.out.println("We have successfully connected to the database");
		}

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("SELECT token FROM public.db_token dt");

		while (resultSet.next()) {
			token = resultSet.getString("token");

			System.out.println("token= " + token);

		}
		return token;
	}

	public void fiat_payment_status_entry() throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://spq-qa-db01.cu9isu4v9eh3.ap-southeast-1.rds.amazonaws.com:5432/spq_preprod_db",
				"spqprodadmin", "X#kqe4x0N3%u7J*If1fLGS&Z");

		if (connection.isClosed()) {

		} else {
			System.out.println("We have successfully connected to the database");
		}

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(
				"select trx_flow_id ,total_fiat_price from spq_trx_flow  where   created_at in (select max(created_at) from spq_trx_flow where user_id in (select id  from users where mobile ='+917030724471')  )");

		while (resultSet.next()) {
			trx_id = resultSet.getString("trx_flow_id");
			amount = resultSet.getString("total_fiat_price");
			System.out.println("trx_id= " + trx_id);
			System.out.println("amount= " + amount);

		}

		try {
			String Query = "INSERT INTO fiat_payment_status (trx_id,status,amount,remarks) VALUES('" + trx_id
					+ "','SUCCESS','" + amount + "','set by automation');";

			statement.executeQuery(Query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void fiat_payment_status_entry_forWithdrawal() throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://spq-qa-db01.cu9isu4v9eh3.ap-southeast-1.rds.amazonaws.com:5432/spq_preprod_db",
				"spqprodadmin", "X#kqe4x0N3%u7J*If1fLGS&Z");

		if (connection.isClosed()) {

		} else {
			System.out.println("We have successfully connected to the database");
		}

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(
				"select trx_flow_id ,total_fiat_price from spq_trx_flow  where   created_at in (select max(created_at) from spq_trx_flow where user_id in (select id  from users where mobile ='+917030724471')  )");

		while (resultSet.next()) {
			trx_id = resultSet.getString("trx_flow_id");
			amount = resultSet.getString("total_fiat_price");
			System.out.println("trx_id= " + trx_id);
			System.out.println("amount= " + amount);

		}

		try {
			String Query = "INSERT INTO fiat_payment_status (trx_id,status,amount,remarks) VALUES('" + trx_id
					+ "','SUCCESS','" + amount + "','set by automation');";

			String Query1 = "update fiat_imps_trx_withdrawal set status ='CONFIRMED'where trx_id ='" + trx_id + "'";

			statement.executeQuery(Query);
			statement.executeQuery(Query1);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}