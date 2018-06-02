import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class restresponse {

	public static void main(String[] args) {
RestAssured.baseURI="https://maps.googleapis.com";
		
	Response res=	given().queryParam("key","AIzaSyBEh5zAdl3cctYOQaT8JKSLc8GUQfYmOeI").
		body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -33.8669710,\r\n" + 
				"    \"lng\": 151.1958750\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Google Shoes!\",\r\n" + 
				"  \"phone_number\": \"(02) 9374 4000\",\r\n" + 
				"  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\r\n" + 
				"  \"types\": [\"shoe_store\"],\r\n" + 
				"  \"website\": \"http://www.google.com.au/\",\r\n" + 
				"  \"language\": \"en-AU\"\r\n" + 
				"}").when().
		        post("/maps/api/place/add/json").then().assertThat().
		        statusCode(200).and().contentType(ContentType.JSON).and().body("status",equalTo("OK")).extract().response() ;

	
	String  str=    res.asString();
	System.out.println(str);
	
	JsonPath js= new JsonPath(str);
	String placeid=js.get("place_id").toString();
	System.out.println(placeid);
	
	given().
	queryParam("key","AIzaSyBEh5zAdl3cctYOQaT8JKSLc8GUQfYmOeI").body("{"+
"\"place_id\": \""+placeid+"\""+
"}").
	when().
	post("/maps/api/place/delete/json").
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	body("status",equalTo("OK"));
	
	
	}

}
