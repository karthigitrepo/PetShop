package com.stepdefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojoclass.Request_POJOS;
import com.pojoclass.Response_POJOS;

public class PetStore_Steps extends BaseClass {

	/*
	 * 
	 * DELETE STEPS
	 * 
	 */

	@Given("user should enter the endpoint URI for DELETE")
	public void user_should_enter_the_endpoint_uri_for_delete() {

		baseURI("/pet/88230897");

	}

	@Given("user should add the required authentication")
	public void user_should_add_the_required_authentication() {

		request = RestAssured.given();

	}

	@When("user should perfom DELETE method")
	public void user_should_perfom_delete_method() {

		res = request.contentType(ContentType.JSON).when().delete().then().extract().response();

	}

	@Then("user should verify the response from the server for DELETE")
	public void user_should_verify_the_response_from_the_server_for_delete() {
		Assert.assertEquals(404, res.getStatusCode());
	}

	/*
	 * 
	 * POST STEPS
	 * 
	 */

	@Given("user should enter the endpoint URI for POST")
	public void user_should_enter_the_endpoint_uri_for_post() {
		baseURI("store/order");
	}

	@Given("user should add headers")
	public void user_should_add_headers() {
		request = RestAssured.given();
	}

	@Given("user should add request body")
	public void user_should_add_request_body() throws Throwable {
		Request_POJOS p = new Request_POJOS(0, 0, 0, "2023-08-01T11:25:06.500Z", "placed", true);
		addBody(p);
		ObjectMapper o = new ObjectMapper();
		o.writeValueAsString(p);
	}

	@When("user should perform POST method")
	public void user_should_perform_POST_method() {
		res = requestType("POST");
	}

	@Then("user should verify the response from the server for POST")
	public void user_should_verify_the_response_from_the_server_for_post()
			throws JsonMappingException, JsonProcessingException {
		Assert.assertEquals(200, res.getStatusCode());
		ObjectMapper obj = new ObjectMapper();
		Response_POJOS resp = obj.readValue(res.prettyPrint(), Response_POJOS.class);

		Assert.assertTrue(resp.getId() > 0);
		Assert.assertTrue(resp.getPetId() == 0);
		Assert.assertTrue(resp.getQuantity() == 0);
		Assert.assertTrue(resp.getComplete());
		Assert.assertEquals("placed", resp.getStatus());
	}

}
