import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class restGETADVANCED {

	public static void main(String[] args) {

		RestAssured.baseURI="https://maps.googleapis.com";
		
		
	Response res=	given().
			param("location","51.503186,-0.126446").
			param("radius","5000").
			param("key","AIzaSyBEh5zAdl3cctYOQaT8JKSLc8GUQfYmOeI").log().all().
			when().
			get("maps/api/place/nearbysearch/json").
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
			body("results[0].name",equalTo("London")).and().body("results[0].place_id",equalTo("ChIJdd4hrwug2EcRmSrV3Vo6llI")).and().
			  header("server", "scaffolding on HTTPServer2").extract().response();
	
	
	JsonPath  readvalue = Reuseablemethods.rawToJson(res);
	
	int count=readvalue.get("results.size()");
	System.out.println(count);
	
	
	for(int i=0;i<count;i++) {
	
		System.out.println(readvalue.get("results["+i+"].name").toString());
	}
		
	}

}
