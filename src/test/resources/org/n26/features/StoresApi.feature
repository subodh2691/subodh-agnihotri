Feature: Create a Store and verify

  Scenario: Create Store and verify
    Given with resource url as "/stores" ,post request to add item with json as:
      """
      {
		  "name": "TestStore",
		  "type": "Test",
		  "address": "Testing in Pune",
		  "city": "Pune",
		  "state": "MH",
		  "zip": "411007",
		  "lat": 0,
		  "lng": 0
	  }
      """
    Then verify respone with status code as "201"
    
  Scenario: Get Created Store by ID and verify
    Given with resource url as "/stores" ,get created item by id
    Then verify respone with status code as "200"
    And validate that item with name "TestStore" is returned in the response
    
 Scenario: Delete Created Store by ID and verify
    Given with resource url as "/stores" ,delete created item by id
    Then verify respone with status code as "200"
