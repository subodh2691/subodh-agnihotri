package org.n26.resources;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.response.Response;

public class RestApiMethods 
{
	public String headerAccept="application/JSON";
	public String headerContentType="application/JSON";


	
	public Response getRequest( String baseUrl,String resourceUri)
	{
		return  given().accept(headerAccept).get(baseUrl+resourceUri);
	}
		
	public Response putRequest(String baseUrl,String resourceUri, String body) 
	{
		
		return  given().accept(headerAccept).contentType(headerContentType).body(body).put(baseUrl+resourceUri);
	}
	
	public Response postRequest(String baseUrl,String resourceUri,String body)
	{
		return given().accept(headerAccept).contentType(headerContentType).body(body).when().post(baseUrl+resourceUri);
	}
	
	public Response deleteRequest(String baseUrl,String resourceUri)
	{
		return  given().accept(headerAccept).delete(baseUrl+resourceUri);
	}
	
}
