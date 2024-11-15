//package stepDefinitions;
//
//import static org.hamcrest.Matchers.equalTo;
//import java.util.List;
//import java.util.Map;
//import endpoints.ProductEndpoints;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.response.Response;
//import pojo.Product;
//
//public class GetProductSteps {
//    private Response response;
//    private String productId;
//
//    @Given("The following product exists")
//    public void the_following_product_exists(DataTable dataTable) {
//        List<Map<String, String>> productData = dataTable.asMaps(String.class, String.class);
//
//        for (Map<String, String> data : productData) {
//            Product product = new Product();
//            product.setId(data.get("id"));
//            product.setName(data.get("name"));
//            product.setQuantity(data.get("quantity"));
//            product.setBrand(data.get("brand"));
//            product.setCategory(data.get("category"));
//
//            // Assume product creation happens here via the API, storing the ID for retrieval
//            ProductEndpoints.createProduct(product);
//            this.productId = product.getId();  // Store the ID for later retrieval steps
//        }
//    }
//
//    @Given("The following product does not exist")
//    public void the_following_product_does_not_exist(DataTable dataTable) {
//        List<Map<String, String>> productData = dataTable.asMaps(String.class, String.class);
//
//        for (Map<String, String> data : productData) {
//            this.productId = data.get("id");
//            // Optionally, ensure that this product ID does not exist in your backend
//        }
//    }
//
//    @When("I send a GET request to retrieve the product with id {string}")
//    public void i_send_a_get_request_to_retrieve_the_product_with_id(String id) {
//        response = ProductEndpoints.getProduct(id);
//    }
//
//    @Then("The product is retrieved successfully")
//    public void the_product_is_retrieved_successfully() {
//        response.then().statusCode(200)
//                .body("id", equalTo(productId));
//    }
//
//    @Then("An error response is returned with status code {int}")
//    public void an_error_response_is_returned_with_status_code(Integer statusCode) {
//        response.then().statusCode(statusCode);
//    }
//}
