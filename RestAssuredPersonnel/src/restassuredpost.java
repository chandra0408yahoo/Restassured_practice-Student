import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;


public class restassuredpost {

	public static void main(String[] args) throws IOException {

		
		
		RestAssured.baseURI="https://maps.googleapis.com";
	Response res=	given().
		
		queryParam("key","AIzaSyBEh5zAdl3cctYOQaT8JKSLc8GUQfYmOeI").
		body("{"+
  "\"location\": {"+
    "\"lat\": -33.8669710,"+
    "\"lng\": 151.1958750"+
  "},"+
  "\"accuracy\": 50,"+
  "\"name\": \"Google Shoes!\","+
  "\"phone_number\": \"(02) 9374 4000\","+
  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
  "\"types\": [\"shoe_store\"],"+
  "\"website\": \"http://www.google.com.au/\","+
  "\"language\": \"en-AU\""+
"}").when().
		post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
	
	
	String respo=res.asString();
		
	System.out.println(respo);
	
	
	
	
	}

	
	
	
}
