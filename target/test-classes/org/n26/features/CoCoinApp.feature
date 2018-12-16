Feature: Mobile Application Verification

  Scenario: An user tries to launch application with password
  	Given Application is launched
  	When Password is entered as "1234" and confirmed
  	Then Validate the main application window is shown to user
  
  Scenario: An user adds a bill in the application
  	Given User selects category as "Lunch" and Amount as "50"
  	And User selects category as "Dinner" and Amount as "60"
  	And User clicks on menu button and enters password as "1234"
  	Then Verify that total amount should be "$110"
  	And User selects tab or item "THIS WEEK"
  	Then Verify that total amount should be "$110"
  	And User selects tab or item "TODAY"
  	And User selects tab or item "60"
  	Then Verify that message should be "Spend 60in Dinner"