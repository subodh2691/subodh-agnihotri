package org.n26.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.n26.actions.CoCoinActions;
import org.n26.resources.PrePostSteps;

public class CoCoinMobile {

	private PrePostSteps prePostSteps;
	public Scenario scenario;
//	public CreateTestReport testReport;
	
	public CoCoinMobile (PrePostSteps prePostSteps){
		this.prePostSteps = prePostSteps;
	}
	
	@Given("^Application is launched$")
	public void launch_application()
	{
		CoCoinActions appActions = new CoCoinActions(prePostSteps);
		Assert.assertTrue("Unable to launch application",appActions.launch_app());
	}
	
	
	@When("^Password is entered as \"([^\"]*)\" and confirmed$")
	public void password_entered(String Password)
	{
		CoCoinActions appActions = new CoCoinActions(prePostSteps);
		Assert.assertTrue("Unable to enter given password",appActions.enter_and_confirm_passcode(Password));
	}
	
	@Then("^Validate the main application window is shown to user$")
	public void main_page()
	{
		CoCoinActions appActions = new CoCoinActions(prePostSteps);
		Assert.assertTrue("Main page is not shown",appActions.check_main_page());
	}
	
	@When("^User selects category as \"([^\"]*)\" and Amount as \"([^\"]*)\"$")
	public void add_transactions(String category, String Amount)
	{
		CoCoinActions appActions = new CoCoinActions(prePostSteps);
		Assert.assertTrue("Unable to add transaction",appActions.add_transaction(category, Amount));
	}
	
	@When("^User clicks on menu button and enters password as \"([^\"]*)\"$")
	public void click_menu(String password)
	{
		CoCoinActions appActions = new CoCoinActions(prePostSteps);
		Assert.assertTrue("Unable to click on menu and enter password",appActions.click_menu_with_password(password));
	}
	
	@Then("^Verify that total amount should be \"([^\"]*)\"$")
	public void verify_total_amount(String total)
	{
		CoCoinActions appActions = new CoCoinActions(prePostSteps);
		Assert.assertTrue("Total amount doesn't matched the expected value",appActions.verify_total(total));
	}
	
	@When("^User selects tab or item \"([^\"]*)\"$")
	public void select_menu_tile(String tile)
	{
		CoCoinActions appActions = new CoCoinActions(prePostSteps);
		Assert.assertTrue("User is unable to switch to another tab",appActions.select_tab(tile));
	}
	
	@Then("^Verify that message should be \"([^\"]*)\"$")
	public void verify_msg(String msg)
	{
		CoCoinActions appActions = new CoCoinActions(prePostSteps);
		Assert.assertTrue("Message verification failed",appActions.verify_msg(msg));
	}
	
	@When("^Wait for (\\d+) milli-seconds$")
	public void wait_app(int milliSec)
	{

		try {
			Thread.sleep(milliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
