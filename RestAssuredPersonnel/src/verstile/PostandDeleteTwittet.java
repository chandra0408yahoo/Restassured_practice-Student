package verstile;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostandDeleteTwittet {

	@Test
	
	public static void postdeltwiit() {

		String ConsumerKey="CJ7Vmd3inq8WHXa4Q7Zg51H9w";
		String ConsumerSecret="tsnxpEsA1h7z5LCWJD7iYdywLE0JhdVOEl1NrlYipflmpyuk2B";
		String Token="854978658905186304-6Iyjh0uNwvFrQDerxItqKRFmvmqwFi4";
		String TokenSecret="hAYIRSFV8NjWK2RYa8qJ5Vij45gPJiLSkeppiJCVLSipa";
		String id;
		
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
	Response res=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
		.queryParam("status", "tweet with Automation")
		.when().post("/update.json").then().extract().response();
	
	String response =res.asString();
	System.out.println(response);
	JsonPath js= new JsonPath(response);
	System.out.println("Below is the tweet added");
	//System.out.println(js.get("text"));
	System.out.println(js.get("id").toString());
	id=js.get("id").toString();

	
	testdelete(id,ConsumerKey,ConsumerSecret,Token,TokenSecret);
	
	
	
	}

	
	public static void testdelete(String id,String ConsumerKey,String ConsumerSecret,String Token,String TokenSecret) {
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		Response res=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
			.when().post("/destroy/"+id+".json").then().extract().response();
		
		String response =res.asString();
		System.out.println(response);
		JsonPath js= new JsonPath(response);
		//System.out.println(js.get("text"));
		System.out.println("Tweet which got deleted with automation is below");
		System.out.println(js.get("text").toString());
		System.out.println(js.get("truncated").toString());
		
	}
}
