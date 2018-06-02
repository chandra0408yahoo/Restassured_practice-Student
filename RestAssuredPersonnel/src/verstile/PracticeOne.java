package verstile;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.annotations.Test;
public class PracticeOne {

	
	@Test
	
	public static void prc() {

		String ConsumerKey="CJ7Vmd3inq8WHXa4Q7Zg51H9w";
		String ConsumerSecret="tsnxpEsA1h7z5LCWJD7iYdywLE0JhdVOEl1NrlYipflmpyuk2B";
		String Token="854978658905186304-6Iyjh0uNwvFrQDerxItqKRFmvmqwFi4";
		String TokenSecret="hAYIRSFV8NjWK2RYa8qJ5Vij45gPJiLSkeppiJCVLSipa";
		String id;
		
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		
         Response res=given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
         queryParam("count","1").
         when().
         get("home_timeline.json").then().extract().response();
         String str1=res.asString();
         
         System.out.println(str1);
         
         
        JsonPath js= new JsonPath(str1);
        
        System.out.println(js.get("text").toString());
         
         
         
         
         
         
         
		
		
	}}
