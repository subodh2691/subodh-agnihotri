Feature: Create a Category and verify

  Scenario: Create Category and verify
    Given with resource url as "/categories" ,post request to add item with json as:
      """
      {
		  "name": "TestCategories",
		  "id":  "1"
	  }
      """
    Then verify respone with status code as "201"
    
  Scenario: Get Created Category by ID and verify
    Given with resource url as "/categories" ,get created item by id
    Then verify respone with status code as "200"
    And validate that item with name "TestCategories" is returned in the response
    
 Scenario: Delete Created Category by ID and verify
    Given with resource url as "/categories" ,delete created item by id
    Then verify respone with status code as "200"
