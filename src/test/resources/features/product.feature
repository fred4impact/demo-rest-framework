Feature: Product API Testing

  Scenario Outline: Create a new product using dynamic payload
    Given I set the product payload with the following details
      | id       | name    | quantity | brand    | category  |
      | <id>     | <name>  | <quantity> | <brand> | <category> |
    When I send a POST request to create the product
    Then The product is created successfully with id "4"

    Examples:
      | id | name  | quantity | brand | category |
      | 4  | Shoes | 5        | Brand | Shoes    |
