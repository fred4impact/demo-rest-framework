Feature: Get Product API Testing

  Scenario Outline: Retrieve an existing product using a table
    Given The following product exists
      | id   | name      | quantity | brand  | category            |
      | <id> | <name>    | <quantity> | <brand> | <category>        |

    When I send a GET request to retrieve the product with id "<id>"
    Then The product is retrieved successfully

    Examples:
      | id | name      | quantity | brand  | category            |
      | 12 | Saxophone | 4        | Yamaha | Musical Instruments |
      | 15 | Trumpet   | 2        | Bach   | Musical Instruments |
      | 20 | Guitar    | 10       | Gibson | Musical Instruments |

  Scenario Outline: Attempt to retrieve a non-existing product using a table
    Given The following product does not exist
      | id  |
      | <id> |
    When I send a GET request to retrieve the product with id "<id>"
    Then An error response is returned with status code 404

    Examples:
      | id  |
      | 999 |
      | 888 |
      | 777 |
