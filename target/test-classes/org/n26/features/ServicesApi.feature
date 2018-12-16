Feature: Create a Service and verify

  Scenario: Create Service and verify
    Given with resource url as "/services" ,post request to add item with json as:
      """
      {
		  "name": "TestService"
	  }
      """
    Then verify respone with status code as "201"
    
  Scenario: Get Created Service by ID and verify
    Given with resource url as "/services" ,get created item by id
    Then verify respone with status code as "200"
    And validate that item with name "TestService" is returned in the response
    
 Scenario: Delete Created Service by ID and verify
    Given with resource url as "/services" ,delete created item by id
    Then verify respone with status code as "200"
