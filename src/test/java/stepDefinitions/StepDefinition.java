package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {

	TestDataBuild data = new TestDataBuild();

	public RequestSpecification request;
	public Response response;
	public static String place_id ;
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		request = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI = APIResources.valueOf(resource);
		if (method.equalsIgnoreCase("POST")) {
			response = request.when().post(resourceAPI.getResource()).then().extract().response();
		} else if (method.equalsIgnoreCase("GET")) {
			response = request.when().get(resourceAPI.getResource()).then().extract().response();
		}
	}

	@Then("The API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(response.statusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyName, String expectedValue) {
		// Write code here that turns the phrase above into concrete actions
		// JsonPath js1 = new JsonPath(response.asString());
		assertEquals(getJsonKeyValue(response, keyName), expectedValue);

	}

	@Then("Verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {

		place_id = getJsonKeyValue(response, "place_id");
		// RequestSpecification getPlaceRequest;

		request = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		String actualName = getJsonKeyValue(response, "name");
		assertEquals(actualName, expectedName);
	}
	
	@Given("Delete Place Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
}