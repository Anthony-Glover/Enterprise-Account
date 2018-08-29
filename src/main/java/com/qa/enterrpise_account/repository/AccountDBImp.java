package com.qa.enterrpise_account.repository;

import java.util.List;

import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import javax.transaction.*;
import javax.transaction.Transactional.TxType;

import com.google.gson.Gson;
import com.qa.app.Account;

public class AccountDBImp 
{
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Transactional(TxType.REQUIRES_NEW)
	public String createAccount(String accountInJSON) 
	{
		 
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);		
		manager.persist(account);
		return "{\"message\": \"account sucessfully added\"}";
	}

	@Transactional(TxType.REQUIRES_NEW)
	public String deleteAccount(String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);		
		manager.remove(account);
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	@Transactional(TxType.REQUIRES_NEW)
	public String updateAccount(String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);		
		manager.refresh(account);
		return "{\"message\": \"account sucessfully updated\"}";
	}

	public Account findAccount(String accountInJSON) 
	{
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);					
		account = manager.find(Account.class, account.getId());
		return account;
	}

	public List<Account> findAllAccounts() 
	{
		TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a ORDER BY a.id", Account.class);
        return query.getResultList();
	}
}
