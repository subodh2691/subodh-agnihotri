Feature: Create a Product and verify

  Scenario: Create Product and verify
    Given with resource url as "/products" ,post request to add item with json as:
      """
      {
  		  "name": "SubodhTest",
		  "type": "TestAPI",
		  "price": 100,
		  "upc": "test",
		  "description": "Test Product",
		  "model": "Test"
	  }
      """
    Then verify respone with status code as "201"
    
  Scenario: Get Created Product by ID and verify
    Given with resource url as "/products" ,get created item by id
    Then verify respone with status code as "200"
    And validate that item with name "SubodhTest" is returned in the response
    
 Scenario: Delete Created Product by ID and verify
    Given with resource url as "/products" ,delete created item by id
    Then verify respone with status code as "200"
