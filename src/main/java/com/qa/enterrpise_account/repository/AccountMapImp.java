package com.qa.enterrpise_account.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.google.gson.Gson;

import com.qa.app.Account;

@Alternative
public class AccountMapImp implements IService {

	private Map<Integer, Account> map = new HashMap<Integer, Account>();
	
	public String createAccount(Account account) 
	{
		map.put(account.getId(), account);
		return "{\"message\": \"account sucessfully added\"}";
	}

	public String deleteAccount(Account account) 
	{
		map.remove(account.getId());
		return "{\"message\": \"account sucessfully removed\"}";
	}

	public String updateAccount(Account account) 
	{		
		map.replace(account.getId(), account);
		return "{\"message\": \"account sucessfully updated\"}";
	}

	public Account findAccount(Account account) 
	{					
		account = map.get(account.getId());
		return account;
	}

	public Collection<Account> findAllAccounts() 
	{
		return map.values();
	}

}
