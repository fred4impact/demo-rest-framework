package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.Product;
import endpoints.ProductEndpoints;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;

import java.util.List;

public class ProductSteps {
    private Response response;
    private Product product;

    @Given("I set the product payload with the following details")
    public void i_set_the_product_payload_with_the_following_details(DataTable dataTable) {
        // Create a product object from the data table
        List<String> data = dataTable.row(1);  // Get the first (and only) data row

        product = new Product();

        // Set ID and Quantity as String
        product.setId(data.get(0));        // Set ID
        product.setName(data.get(1));      // Set Name
        product.setQuantity(data.get(2));  // Set Quantity
        product.setBrand(data.get(3));     // Set Brand
        product.setCategory(data.get(4));  // Set Category

        assertNotNull(product);  // Ensure the product object is created
    }

    @When("I send a POST request to create the product")
    public void i_send_a_post_request_to_create_the_product() {
        response = ProductEndpoints.createProduct(product);
    }

    @Then("The product is created successfully with id {string}")
    public void the_product_is_created_successfully_with_id(String expectedId) {
        response.then().statusCode(201)
                .body("id", equalTo(expectedId));
    }



}
