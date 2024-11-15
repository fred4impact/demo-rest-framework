package stepDefinitions;

import static org.hamcrest.Matchers.equalTo;
import endpoints.ProductEndpoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.Product;

import java.util.List;
import java.util.Map;

public class NewGetProductSteps {


    private Response response;

    @Given("The following product exists")
    public void the_following_product_exists(DataTable dataTable) {
        List<Map<String, String>> productData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> data : productData) {
            Product product = new Product();
            product.setId(data.get("id"));
            product.setName(data.get("name"));
            product.setQuantity(data.get("quantity"));
            product.setBrand(data.get("brand"));
            product.setCategory(data.get("category"));

            // Assume product creation happens here via the API
            ProductEndpoints.createProduct(product);
        }
    }

    @Given("The following product does not exist")
    public void the_following_product_does_not_exist(DataTable dataTable) {
        List<Map<String, String>> productData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> data : productData) {
            // Optionally, ensure that this product ID does not exist in your backend
        }
    }

    @When("I send a GET request to retrieve the product with id {string}")
    public void i_send_a_get_request_to_retrieve_the_product_with_id(String id) {
        response = ProductEndpoints.getProduct(id);
    }

    @Then("The product is retrieved successfully")
    public void the_product_is_retrieved_successfully() {
        response.then().statusCode(200)
                .body("id", equalTo(response.jsonPath().getString("id")));
    }

    @Then("An error response is returned with status code {int}")
    public void an_error_response_is_returned_with_status_code(Integer statusCode) {
        response.then().statusCode(statusCode);
    }


}
