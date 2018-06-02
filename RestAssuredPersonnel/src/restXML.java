import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class restXML {

	public static void main(String[] args) throws IOException {

		RestAssured.baseURI="https://maps.googleapis.com";
		Response str=given().
		queryParam("key","AIzaSyBEh5zAdl3cctYOQaT8JKSLc8GUQfYmOeI").
		body("<PlaceAddRequest>\r\n" + 
		   		"  <location>\r\n" + 
		   		"    <lat>-33.8669710</lat>\r\n" + 
		   		"    <lng>151.1958750</lng>\r\n" + 
		   		"  </location>\r\n" + 
		   		"  <accuracy>50</accuracy>\r\n" + 
		   		"  <name>Google Shoes!</name>\r\n" + 
		   		"  <phone_number>(02) 9374 4000</phone_number>\r\n" + 
		   		"  <address>48 Pirrama Road, Pyrmont, NSW 2009, Australia</address>\r\n" + 
		   		"  <type>shoe_store</type>\r\n" + 
		   		"  <website>http://www.google.com.au/</website>\r\n" + 
		   		"  <language>en-AU</language>\r\n" + 
		   		"</PlaceAddRequest>").when().
			post("/maps/api/place/add/xml").
			then().assertThat().statusCode(200).and().contentType(ContentType.XML).extract().response();
		
		String respo=str.asString();
		
		System.out.println(respo);
		

		XmlPath ret_x=Reuseablemethods.rawToXML(str);

System.out.println(ret_x.get("PlaceAddRespponse.place_id").toString());		
		
		
	}

	/*public static String GenerateStringFromResource(String path) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	*/
	
}
