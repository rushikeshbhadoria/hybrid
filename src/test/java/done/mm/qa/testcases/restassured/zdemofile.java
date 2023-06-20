package done.mm.qa.testcases.restassured;

import static io.restassured.RestAssured.given;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class zdemofile {
	public static String ApiClient(Map<String, String> headers, String baseurl, String pathurl, String body)
			throws IOException {

		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseurl).build();

		ResponseSpecification resspec = new ResponseSpecBuilder().build();

		RequestSpecification res = given().log().all().spec(req).body(body);

		Response response = res.headers(headers).when().post(pathurl).then().spec(resspec).extract().response();

		String responseString = response.asString();
		System.out.println(responseString);
		return responseString;
//		given()
//		.body(body)
//		.headers(headers)
//		.when()
//		.post(baseurl+pathurl)
//		.then()
//		.log()
//		.all()
//		.statusCode(200);
//		return body;
	}

	

	public static void main(String[] args) throws Exception {
//		String s1=" Minimum limit set by house is  1.5 SHD";  
//		//System.out.println(s1.substring(2,4));//returns va  
//		//System.out.println(s1.substring(32));//returns vatpoint  
//		String s2=s1.substring(30,36);
//		//System.out.println(s2);
//		String s3=s2.trim();
//		System.out.println(s3);
		
		
	     	 
//	     String phone = "9,213.94 SPQ≈ 460.69 USD";
//
//	  // String#split(string regex) accepts regex as the argument
//	  String[] output = phone.split("≈");
//
//	  String part1 = output[0]; // 012
//	  String part2 = output[1]; 
//	int i=  part1.length()-4;
//	  String part3=part1.substring(0,i);
//	  
//	  String part4 = part3.replace(",","");
//     // System.out.println(part4);
//      
//	  float f=Float.parseFloat(part4);  
//	  
//	  
//  
////	     System.out.println(part3);  
////	     System.out.println(part2);  
//	     System.out.println(part4); 
//		
		
		
//		
//		String name="Lokesh Rahul Counters";
//		int k=name.length();
//		String nameOfCounter=name.substring(0,k-9);
//		System.out.println(nameOfCounter); 
	     
		
//		TopUpSPQ tspq = new TopUpSPQ();
//		tspq.PostApiPrIssued();
		
		String body1 = "{\r\n"
				+ "  \"alias\": \"Dum\",\r\n"
				+ "  \"logoUrl\": \"file://44KBnB5z3gN#%iTkU:R_b+-!612rwSsPqoPF94GmC2PexHiiKtj7LjNo&1G+c%mJAdoV&u@va-ztFKc~%-+5@0+#8upgsKMBNT\",\r\n"
				+ "  \"rewardRule\": \"https://qm=L#nW/X.nG@kQHk#|b~y0A0ae_MLx\",\r\n"
				+ "  \"name\": \"Dummy\",\r\n"
				+ "  \"sportCode\": \"Cric\",\r\n"
				+ "  \"rewardDate\": \"2023-02-02\",\r\n"
				+ "  \"tournamentKey\": \"DLF\",\r\n"
				+ "  \"endDate\": \"2023-06-19\",\r\n"
				+ "  \"startDate\": \"2023-06-19\"\r\n"
				+ "}";
		String pathurl1 = "/v1/tournaments";
		String baseurl1 = "https://sportapi-qa.sportiqo.com";
		
		Map<String, String> headers = new HashMap<>();
		// Add headers to the map
		headers.put("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjY3YmFiYWFiYTEwNWFkZDZiM2ZiYjlmZjNmZjVmZTNkY2E0Y2VkYTEiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vc3BvcnRpcW9kZXYiLCJhdWQiOiJzcG9ydGlxb2RldiIsImF1dGhfdGltZSI6MTY4NTU5OTcyMiwidXNlcl9pZCI6ImlWUDVSN092WmVVMmVxbDdFNlVWbkNUN28yaDEiLCJzdWIiOiJpVlA1UjdPdlplVTJlcWw3RTZVVm5DVDdvMmgxIiwiaWF0IjoxNjg3MTc0NTQwLCJleHAiOjE2ODcxNzgxNDAsImVtYWlsIjoicnVzaGlrZXNoYkBudTEwLmNvIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJmaXJlYmFzZSI6eyJpZGVudGl0aWVzIjp7ImVtYWlsIjpbInJ1c2hpa2VzaGJAbnUxMC5jbyJdfSwic2lnbl9pbl9wcm92aWRlciI6InBhc3N3b3JkIn19.dRK1v0kNW-JrYVKcxYLhbwbsfN0_4zdI6nkv8esbb52lVmjoxIdfyM2qyTkx9x0afESaZndITs_LTun7dCDpI3kRSaK0668DCnnyV1sh4ofaGEoBaaTwDwcJf_ZAJkm52EV9u0fMmvtffTsXVPR67rFwLC0kN3gdyZ2Jo500WCry2HbA0mzREDfJiUTwPl0qPFIAHGUwmZbaaT_OvVsIEsoAsXMlf9I0svU17potA11C_ejSmafeY6-sooikslN3bD4RLnMNUgSqH3Y07Fy7WJhZQEq0WkvbV4Q80AMKSSvNi1e-CwBFSwWQIXgL-LKjpI-X2VIcRhBH8_vJYprstA");
		headers.put("Content-Type", "application/json");
		headers.put("accept", "application/json");
		String res = ApiClient(headers, baseurl1, pathurl1, body1);
		System.out.println(res);
		
//		
//			 Map<String, String> headers = new HashMap<>();
//		        
//		        // Add headers to the map
//		        headers.put("Authorization", "Bearer your_token");
//		        headers.put("Content-Type", "application/json");
//			System.out.println(headers); 
		
		}
	}

	

