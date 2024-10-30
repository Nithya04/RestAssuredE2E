package api.endpoint;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPointProperyFile {
 
	//Code to load property file and read the data
	
	static ResourceBundle getUrl(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	
	
	public static Response createUser(UserPOJO payload){
	String post_url=getUrl().getString("post_url");
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post_url);
		
		return res;
	}
	
	
public static Response getUser(String username){
	String get_url=getUrl().getString("get_url");
		Response res=given().pathParam("username", username)
		
		.when()
		.get(get_url);
		
		return res;
	}

public static Response updateUser(UserPOJO payload, String username){
	String update_url=getUrl().getString("update_url");
	Response res=given().pathParam("username", username)
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
	
	.when()
	.put(update_url);
	
	return res;
}

public static Response deleteUser(String username){
	String delete_url=getUrl().getString("delete_url");

	Response res=given().pathParam("username", username)
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	
	
	.when()
	.delete(delete_url);
	
	return res;
}

}
