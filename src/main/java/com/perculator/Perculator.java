package main.java.com.perculator;


import javax.servlet.http.HttpServletRequest;

import main.java.com.action.Action;
import main.java.com.affirm.AffirmationBuilder;


public class Perculator{
	private HttpServletRequest httpServletRequest;
	 
	
	public Perculator(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	
	public boolean isValid() {
		return (httpServletRequest.getParameter("User").equals("Marimuthu"));
	}
	
	public boolean isGetRequest() {
		return httpServletRequest.getMethod().equals("GET");
	}
	
	public Action affirm() {
		AffirmationBuilder affirmationBuilder = new AffirmationBuilder(httpServletRequest);
		return affirmationBuilder.validate();
	}

}
