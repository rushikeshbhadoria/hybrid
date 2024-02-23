package done.mm.qa.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import done.mm.qa.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class DbConnectionAndRestAssured_TestBase extends TestBase {
	static String trx_id, amount, token;

	public DbConnectionAndRestAssured_TestBase() {
		super();

	}

	/*-------------------------------------------------------------------------------------------------------------*/

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

	public static String GetApiClient(Map<String, String> headers, String baseurl, String pathurl) throws IOException {

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
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream("src\\test\\java\\resource\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	//String signature=getGlobalValue("gobal key name");
		
		
	}
	
	
	public String getJsonPath(String response,String key)
	{
		JsonPath   js = new JsonPath(response);
		return js.get(key).toString();
	}
	
	
}









