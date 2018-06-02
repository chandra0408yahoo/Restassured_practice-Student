package JiraPackage;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class firstjiraauthetication {

	public static void main(String[] args) {

		
		RestAssured.baseURI="https://chandrapuli.atlassian.net/";
		
	
		
		System.out.println("SECOND TEST");
	
			getsessionid();
		
	
	
	}

	public static String getsessionid() {
		Response res=	given().header("Content-Type","application/json").
				body("{ \"username\": \"chandra.04.08@gmail.com\", \"password\": \"Keyboard1\" }").
				when().post("/rest/auth/1/session").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
				
			String str=res.asString();
System.out.println(str);
			JsonPath js=new JsonPath(str);
			
			
			System.out.println(js.get("session.name").toString());
			System.out.println(js.get("session.value").toString());
	
	return js.get("session.value").toString();
	}
	
}
