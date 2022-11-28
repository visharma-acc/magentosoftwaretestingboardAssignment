package com.qa.RequestCall;

import com.fasterxml.jackson.core.JsonParser;

import Pojo.AddressPojo;
import Pojo.UserPoja;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

	public UserPoja getrequest()
	{
		RestAssured.baseURI="https://randomuser.me/api/";
		RequestSpecification httpRequest = RestAssured.given();
		
        // Making GET request directly by RequestSpecification.get() method
         Response response = httpRequest.get();

        //Retrieving Body of response
         String body = response.getBody().asString();
        
         JsonPath json=new JsonPath(body);
         
         System.out.println(json.prettyPrint());
         
     //    System.out.println(json.getString("results[0]"));
        
         
       //  System.out.println(json.getString("results.gender[0]"));
         
         //Retrieving Status Code of response
         int status = response.getStatusCode();
         //Retrieving Status Line
         String statusLine = response.getStatusLine();
         
         //Printing the response
      //   System.out.println("Response Body is "+body);
     //    System.out.println("Status code is "+status);
      //   System.out.println("Status line is "+statusLine);
         
         
         UserPoja user=new UserPoja();
       
         user.setFirstname(json.getString("results.name.first[0]"));
         user.setLastname(json.getString("results.name.last[0]"));
         user.setEmail(json.getString("results.email[0]"));
         user.setPassword(json.getString("results.login.password[0]")+"@"+json.getString("results.location.postcode[0]"));
         
         
         AddressPojo address=new AddressPojo();
         address.setCity(json.getString("results.location.city[0]"));
         address.setState(json.getString("results.location.state[0]"));
         address.setCountry(json.getString("results.location.country[0]"));
         address.setPostcode(json.getString("results.location.postcode[0]"));
         address.setLocation(json.getString("results.location.street.number[0]")+json.getString("results.location.street.name[0]"));
         address.setPhone(json.getString("results.phone[0]"));
         
         user.setAddress(address);
         
         System.out.println(user);
         
         System.out.println(user.getEmail());
         System.out.println(user.getAddress().getCountry());
         return user;
	}
	
	public void Checkpassword(String pwd)
	{
		
		
	}
	


}
