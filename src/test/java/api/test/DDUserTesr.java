//package api.test;
//
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.github.javafaker.Faker;
//
//import api.endpoint.UserEndPoint;
//import api.payload.UserPOJO;
//import io.restassured.response.Response;
//public class DDUserTesr {
//
//	
//	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
//	public void testPostUser(String userId, String UserName, String FirstName, String LastName, String Email, String pwd, String ph)
//	{
//		UserPOJO userPayload = new UserPOJO();
//		userPayload.setId(Integer.parseInt(userId));
//		userPayload.setUsername(UserName);
//		userPayload.setFirstname(FirstName);
//		userPayload.setLastname(LastName);
//		userPayload.setEmail(Email);
//		userPayload.setPassword(pwd);
//		userPayload.setPhone(ph);
//
//		Response response = UserEndPoint.CreateUser(userPayload);
//		Assert.assertEquals(response.getStatusCode(),200);
//	}
//
//	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
//	public void testDeleteUserByName(String userName)
//	{
//		Response response = UserEndPoint.DeleteUser(userName);
//		Assert.assertEquals(response.getStatusCode(),200);
//	}
//
//}
