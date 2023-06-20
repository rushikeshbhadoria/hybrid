package stepDefinations;

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

public class SampleDbConnectionsAndRestAssured extends TestBase {
	static String trx_id, amount, token;

	public SampleDbConnectionsAndRestAssured() {
		super();

	}

	/*-------------------------------------------------------------------------------------------------------------*/

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