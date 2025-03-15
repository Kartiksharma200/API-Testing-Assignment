package FakeApiAssignment;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProduct {
	
	
	 @Test
	    public void testCreateProduct() {
	        JSONObject request = new JSONObject();
	        request.put("title", "New Product");
	        request.put("price", 49.99);
	        request.put("description", "This is a brand new product.");
	        request.put("image", "https://example.com/product.jpg");
	        request.put("category", "electronics");

	        Response response = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .body(request.toString())
	            .post("https://fakestoreapi.com/products");

	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertNotNull(response.jsonPath().get("id"));
	    }

}
