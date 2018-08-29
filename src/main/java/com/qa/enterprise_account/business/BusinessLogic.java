package com.qa.enterprise_account.business;

import java.util.Collection;

import javax.inject.Inject;
import com.google.gson.Gson;
import com.qa.app.Account;
import com.qa.enterrpise_account.repository.IService;

public class BusinessLogic 
{
	@Inject
	private IService service;
	
	public String createAccount(Account account)
	{
		if (9999 == account.getAccountNumber())
		{
			return "{'message': 'This account is blocked'}";
		}
		else
			return service.createAccount(account);
	}
	
	public String deleteAccount(Account account) 
	{
		return service.deleteAccount(account);
	}

	public String updateAccount(Account account) 
	{
		return service.updateAccount(account);
	}

	public Account findAccount(Account account) 
	{
		return service.findAccount(account);
	}

	public Collection<Account> findAllAccounts() 
	{
		return service.findAllAccounts();
	}
}
