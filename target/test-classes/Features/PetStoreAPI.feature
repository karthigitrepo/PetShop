Feature: Validation of PetStore Swagger API

	Scenario: Performing delete for Pet 
    Given user should enter the endpoint URI for DELETE
    And user should add the required authentication
    When user should perfom DELETE method
    Then user should verify the response from the server for DELETE

  Scenario: Placing an order for a Pet  
    Given user should enter the endpoint URI for POST
    And user should add headers
    And user should add request body
    When user should perform POST method
    Then user should verify the response from the server for POST

  