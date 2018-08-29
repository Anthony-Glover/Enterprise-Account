package com.qa.enterrpise_account.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import javax.transaction.*;
import javax.transaction.Transactional.TxType;

import com.qa.app.Account;

@Default
public class AccountDBImp implements IService 
{
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Transactional(TxType.REQUIRES_NEW)
	public String createAccount(Account account) 
	{
		manager.persist(account);
		return "{\"message\": \"account sucessfully added\"}";
	}

	@Transactional(TxType.REQUIRES_NEW)
	public String deleteAccount(Account account) 
	{
		manager.remove(account);
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	@Transactional(TxType.REQUIRES_NEW)
	public String updateAccount(Account accountUpdate) 
	{
		Account account = manager.find(Account.class, accountUpdate.getId());
		account = accountUpdate;
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Transactional(TxType.REQUIRED)
	public Account findAccount(Account account) 
	{
		account = manager.find(Account.class, account.getId());
		return account;
	}

	@Transactional(TxType.REQUIRED)
	public Collection<Account> findAllAccounts() 
	{
		TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a ORDER BY a.id", Account.class);
        return query.getResultList();
	}
}
