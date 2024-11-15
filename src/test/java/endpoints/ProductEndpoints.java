package endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import pojo.Product;
import utilities.ConfigManager;


public class ProductEndpoints {

     private static String baseUrl = "http://127.0.0.1:8000/v1/products";



        public static Response createProduct(Product product) {
            return given()
                    .header("Content-Type", "application/json")
                    .body(product)
                    .post(baseUrl);
        }

        public static Response getProduct(String productId) {
            return given()
                    .header("Content-Type", "application/json")
                    .get(baseUrl + "/" + productId);
        }

        public static Response updateProduct(Product product, String productId) {
            return given()
                    .header("Content-Type", "application/json")
                    .body(product)
                    .put(baseUrl + "/" + productId);
        }

        public static Response deleteProduct(String productId) {
            return given()
                    .header("Content-Type", "application/json")
                    .delete(baseUrl + "/" + productId);
        }


}
