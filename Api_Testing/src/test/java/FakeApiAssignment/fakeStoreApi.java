package FakeApiAssignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class fakeStoreApi {
	
	@Test
	public void gettAllProduct() {
		Response response = RestAssured.get("https://fakestoreapi.com/products");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("$").size() > 0);
		
	}

}
