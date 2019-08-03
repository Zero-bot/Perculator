package main.java.com.perculator;


import javax.servlet.http.HttpServletRequest;

import main.java.com.action.Action;
import main.java.com.affirm.AffirmationBuilder;


public class Perculator{
	private HttpServletRequest httpServletRequest;
	private AffirmationBuilder affirmationBuilder; 
	
	public Perculator(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
		this.affirmationBuilder = new AffirmationBuilder(httpServletRequest);
	}
	
	public Action affirm() {
		return affirmationBuilder.validate();
	}

}
