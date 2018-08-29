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
	
	public String createAccount(String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);
		map.put(account.getId(), account);
		return "{\"message\": \"account sucessfully added\"}";
	}

	public String deleteAccount(String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);
		map.remove(account.getId());
		return "{\"message\": \"account sucessfully removed\"}";
	}

	public String updateAccount(String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);		
		map.replace(account.getId(), account);
		return "{\"message\": \"account sucessfully updated\"}";
	}

	public Account findAccount(String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);					
		account = map.get(account.getId());
		return account;
	}

	public Collection<Account> findAllAccounts() 
	{
		return map.values();
	}

}
