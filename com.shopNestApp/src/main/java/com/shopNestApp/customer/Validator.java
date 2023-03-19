package com.shopNestApp.customer;

import com.shopNestApp.dbHandler.DataFetcher;

public class Validator{
	public static boolean isValid(String uname,String pwd)
	{
		System.out.println(uname+"\t"+pwd);
		String dbPass=DataFetcher.fetchPassword(uname);
		System.out.println("\t"+dbPass);
		if (pwd.equals(dbPass)) {
			return true;
		}
		else {
			return false;
		}
	}
}