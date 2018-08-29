package com.qa.enterprise_account.business;

import java.util.Collection;

import javax.inject.Inject;
import com.google.gson.Gson;
import com.qa.app.Account;
import com.qa.enterrpise_account.repository.IService;

public class BusinessLogic 
{
	@Inject
	IService service;
	
	public String createAccount(String accountInJSON)
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);
		
		if (9999 == account.getAccountNumber())
		{
			return "{'message': 'This account is blocked'}";
		}
		else
			return service.createAccount(account);
	}
	
	public String deleteAccount(String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);		
		return service.deleteAccount(account);
	}

	public String updateAccount(String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);		
		return service.updateAccount(account);
	}

	public Account findAccount(String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);					
		account = service.findAccount(account);
		return account;
	}

	public Collection<Account> findAllAccounts() 
	{
		return service.findAllAccounts();
	}
}
