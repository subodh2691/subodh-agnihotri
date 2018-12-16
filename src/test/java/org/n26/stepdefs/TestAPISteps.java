package org.n26.stepdefs;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.n26.resources.RestApiMethods;

import junit.framework.Assert;

import com.jayway.restassured.response.Response;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TestAPISteps 
{
	String baseUrl="http://localhost:3030";
	String resUrl;
	Response actResponse;
	RestApiMethods api;
	static Long productId;
	
	public TestAPISteps (RestApiMethods api)
	{
		//this.actResponse;		
	}	
	
	@Given("^with resource url as \"([^\"]*)\" ,get created item by id$")
	public void get_request_item_by_id(String resoureUrl) 
	{
		System.out.println("Get Product url : "+baseUrl+resoureUrl+"/"+productId);
		api=new RestApiMethods();
		actResponse=null;
		String getProductByID = resoureUrl +"/"+productId;
		
		actResponse=api.getRequest(baseUrl,getProductByID);
		System.out.println("Actual Status Response Code : "+actResponse.getStatusCode());
		System.out.println("Actual Response : "+actResponse.asString());

	}

	
	@Given("^with resource url as \"([^\"]*)\" ,post request to add item with json as:$")
	public void post_request_to_add_item(String resoureUrl,String json) 
	{
		System.out.println("post url : "+baseUrl+resoureUrl);
		api=new RestApiMethods();
		actResponse=null;
		try {
			actResponse=api.postRequest(baseUrl,resoureUrl,json);
			System.out.println("Actual Status Response Code : "+actResponse.getStatusCode());
			System.out.println("Actual Response : "+actResponse.asString());
			JSONObject outerObject = new JSONObject(actResponse.body().asString());
		    Long id = outerObject.getLong("id");
		    System.out.println("ID is :"+ id);
		    productId = id;
		}
		catch(Exception e) {
			System.out.println("Exception caught");
			e.printStackTrace();
		}
		
	}
	
	@Given("^with resource url as \"([^\"]*)\" ,delete created item by id$")
	public void delete_request_item_by_id(String resoureUrl) 
	{
		System.out.println("Get Product url : "+baseUrl+resoureUrl+"/"+productId);
		api=new RestApiMethods();
		actResponse=null;
		String deleteProductByID = resoureUrl +"/"+productId;
		
		actResponse=api.deleteRequest(baseUrl,deleteProductByID);
		System.out.println("Actual Status Response Code : "+actResponse.getStatusCode());
		System.out.println("Actual Response : "+actResponse.asString());

	}
	
	@Then("^verify respone with status code as \"([^\"]*)\"$")
	public void verify_respone_status_code_as(String exptStatusCode)
	{
		Assert.assertTrue("Actual Response : "+actResponse.asString()+"\n"+
				"Expected status : "+exptStatusCode+" , Actual status : "+Integer.toString(actResponse.getStatusCode()),exptStatusCode.trim().equalsIgnoreCase(Integer.toString(actResponse.getStatusCode())));
	}

	@And("^validate that item with name \"([^\"]*)\" is returned in the response$")	
	public void verifyJsonResponse(String dataToVerify)
	{
		Assert.assertTrue("Verification failed for Item name : "+dataToVerify,verifyItemName(actResponse.asString(), dataToVerify));
	}
	
	public boolean verifyItemName(String resonse,String expItemName)
	{
		boolean bFlag=false;
		
		try
		{
			JSONObject outerObject = new JSONObject(actResponse.body().asString());
			String actItemName = outerObject.getString("name");
		    if(actItemName.equalsIgnoreCase(expItemName))
		    {
		    	bFlag=true;
		    }
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}

		return bFlag;
	}
}
