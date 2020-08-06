package com.lti.service;

import java.util.HashMap;

public class InMemoryLoginService {

	private HashMap<String,String> users = new HashMap<String, String>();
	public InMemoryLoginService() {
		users.put("sanjana", "123");
		users.put("saumya", "456");
		users.put("samridhi", "789");
	}
	
	public boolean authenticate(String uname, String pwd) {
		if(users.containsKey(uname))
			if(users.get(uname).contentEquals(pwd))
			return true;
		return false;
	}
	
	/*public boolean authenticate(String uname, String pwd) {
		if(uname.equals("sanjana") && pwd.equals("123"))  //hardcore value was given
			return true;
		else
			return false;*/
}
