package com.qa.enterprise_account.interoparability;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.qa.app.Account;
import com.qa.enterprise_account.business.BusinessLogic;

@Path("/Interop")
public class Interoperability 
{
	private BusinessLogic businessLogic = new BusinessLogic();
	
	@POST
	@Path("{add_account}")
	@Produces("application/json")
	public String createAccount(@PathParam("account") String accountInJSON)
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);

//		return Response.ok(businessLogic.createAccount(account), MediaType.APPLICATION_JSON).build();
		return businessLogic.createAccount(account);
	}
	
	@POST
	@Path("{delete_account}")
	@Produces("application/json")
	public String deleteAccount(@PathParam("account") String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);		
		return businessLogic.deleteAccount(account);
	}

	@POST
	@Path("{update_account}")
	@Produces("application/json")
	public String updateAccount(@PathParam("account") String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);		
		return businessLogic.updateAccount(account);
	}

	@GET
	@Path("{find_account}")
	@Produces("application/json")
	public String findAccount(@PathParam("account") String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);					
		return gson.toJson(businessLogic.findAccount(account));
	}

	@GET
	@Path("{find_all_accounts}")
	@Produces("application/json")
	public String findAllAccounts() 
	{
		Gson gson = new Gson();
		return gson.toJson(businessLogic.findAllAccounts());
	}

}
