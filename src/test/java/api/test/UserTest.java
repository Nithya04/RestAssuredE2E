package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoint;
import api.payload.UserPOJO;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	UserPOJO user;
	public Logger logger;
	
	
	//data setup done here using Faker
	@BeforeClass
	public void testdataSetUp() {
		
		faker=new Faker();
		user= new UserPOJO();
		
		user.setId(faker.idNumber().hashCode());
		user.setFirstName(faker.name().firstName());
		user.setUsername(faker.name().username());
		user.setLastName(faker.name().lastName());
		user.setPassword(faker.internet().password());
		user.setPhone(faker.phoneNumber().cellPhone());
		user.setEmail(faker.internet().safeEmailAddress());
		user.setUserStatus(0);
		
		
		logger=LogManager.getLogger(this.getClass());
	}
	@Test(priority = 1)
	public void testCreateUser() {
		logger.info("********Creating User***********");
		//pass the payload
		Response res=UserEndPoint.createUser(user);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("******** User Created**********");
	}
	
	@Test(priority = 2)
	
	public void testGetUser() {
		logger.info("********Reading User Info***********");
		//get username from payload by using this keyword
		Response res=UserEndPoint.getUser(this.user.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("********Retrieved User***********");
	
	}
	
	@Test(priority = 3)

	public void testUpdateUser() {
		logger.info("********Updating User***********");
		//update data that needs to be changed

		user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
		user.setPassword(faker.internet().password());
		
		//get username from payload by using this keyword; send the latest payload
		Response res=UserEndPoint.updateUser(user,this.user.getUsername());
		// we can valdate response by assert or even res.then().log().body().statusCode(200)
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//check data post update
		Response responsePostUpdate=UserEndPoint.getUser(this.user.getUsername());
		Assert.assertEquals(responsePostUpdate.getStatusCode(), 200);

		logger.info("******** User updated***********");
	}
	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("********Deleting User***********");
		Response res=UserEndPoint.deleteUser(this.user.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("********User Deleted***********");
	}
}
