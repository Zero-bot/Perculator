package main.java.com.affirm;

import javax.servlet.http.HttpServletRequest;

import main.java.com.action.Action;

public class AffirmationBuilder {
	private AffirmRequest affirmRequest;
	
	public AffirmationBuilder(HttpServletRequest httpServletRequest) {
		this.affirmRequest = new AffirmRequest(httpServletRequest);
	}
	
	public Action validate() {
		if(affirmRequest.affirmCookieCount(3)) return Action.Accept;
		return Action.Reject;
	}
	
}
