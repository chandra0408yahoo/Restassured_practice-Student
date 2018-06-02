import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
public class PracticeOne {

	public static void main(String[] args) {

 
RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
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

	
	System.out.println(id);
	
	/*Response res1=RestAssured.given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).when().post("/destroy/"+id+".json").
	then().assertThat().extract().response();
	*/
	Response res1=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
		.when().post("/destroy/"+id+".json").then().extract().response();

	
	
	String st= res1.asString();
	
	
	System.out.println(st);
	
	}}
