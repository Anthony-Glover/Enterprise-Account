package com.qa.app;

import com.google.gson.Gson;
import com.qa.enterprise_account.business.BusinessLogic;
import com.qa.enterprise_account.interoparability.Interoperability;

public class App {

	public static void main(String[] args) {
		System.out.println("hello somebody");

		Interoperability bl = new Interoperability();
		Account account = new Account();
		
		account.setFirstName("Tony");
		account.setSurname("Handsome");
		account.setAccountNumber(1234);
		
		Gson gson = new Gson();	
		System.out.println(gson.toJson(account));
		System.out.println(bl.createAccount(gson.toJson(account)));
		account.setSurname("Super Handsome");
		System.out.println(gson.toJson(account));
		System.out.println(bl.updateAccount(gson.toJson(account)));
		System.out.println(gson.toJson(account));
		System.out.println(bl.deleteAccount(gson.toJson(account)));
	}

}
