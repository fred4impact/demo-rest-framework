#Feature: Get Product API Testing
#
#  Scenario: Retrieve an existing product using a table
#    Given The following product exists
#      | id | name      | quantity | brand  | category            |
#      | 12 | Saxophone | 4        | Yamaha | Musical Instruments |
#    When I send a GET request to retrieve the product with id "12"
#    Then The product is retrieved successfully
#
#
#  Scenario: Attempt to retrieve a non-existing product using a table
#    Given The following product does not exist
#      | id  |
#      | 999 |
#    When I send a GET request to retrieve the product with id "999"
#    Then An error response is returned with status code 404
