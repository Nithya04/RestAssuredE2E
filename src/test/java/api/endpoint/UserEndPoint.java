package api.endpoint;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoint {
 
	public static Response createUser(UserPOJO payload){
	
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_user);
		
		return res;
	}
	
	
public static Response getUser(String username){
		
		Response res=given().pathParam("username", username)
		
		.when()
		.get(Routes.get_user);
		
		return res;
	}

public static Response updateUser(UserPOJO payload, String username){
	
	Response res=given().pathParam("username", username)
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
	
	.when()
	.put(Routes.update_user);
	
	return res;
}

public static Response deleteUser(String username){
	
	Response res=given().pathParam("username", username)
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	
	
	.when()
	.delete(Routes.delete_user);
	
	return res;
}

}
