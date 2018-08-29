package com.qa.enterrpise_account.repository;

import java.util.Collection;

import com.qa.app.Account;

public interface IService 
{
	public String createAccount(String accountInJSON);
	public String deleteAccount(String accountInJSON);
	public String updateAccount(String accountInJSON);
	public Account findAccount(String accountInJSON);
	public Collection<Account> findAllAccounts();
}
