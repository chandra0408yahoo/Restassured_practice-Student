package verstile;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetTwitter {

	
	@Test
	
	public static void testgettweet() {

/*		String ConsumerKey="CJ7Vmd3inq8WHXa4Q7Zg51H9w";
		String ConsumerSecret="tsnxpEsA1h7z5LCWJD7iYdywLE0JhdVOEl1NrlYipflmpyuk2B";
		String Token="854978658905186304-6Iyjh0uNwvFrQDerxItqKRFmvmqwFi4";
		String TokenSecret="hAYIRSFV8NjWK2RYa8qJ5Vij45gPJiLSkeppiJCVLSipa";
		String id;
		
			
			RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		Response res=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
			.queryParam("count", "2")
			.when().get("/home_timeline.json").then().extract().response();
		
		String response =res.asString();
		System.out.println(response);
		JsonPath js= new JsonPath(response);
		
		System.out.println(js.get("text").toString());
		System.out.println(js.get("id").toString());
		*/
		
	}

}
