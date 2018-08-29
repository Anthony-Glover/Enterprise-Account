package com.qa.enterrpise_account.repository;

import java.util.Collection;

import com.qa.app.Account;

public interface IService 
{
	public String createAccount(Account account);
	public String deleteAccount(Account account);
	public String updateAccount(Account account);
	public Account findAccount(Account account);
	public Collection<Account> findAllAccounts();
}
