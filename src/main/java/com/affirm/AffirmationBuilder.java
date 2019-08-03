package main.java.com.affirm;

import javax.servlet.http.HttpServletRequest;

import main.java.com.action.Action;
import main.java.com.http.HTTP;

public class AffirmationBuilder {
	private AffirmRequest affirmRequest;
	private HTTP http;
	
	public AffirmationBuilder(HttpServletRequest httpServletRequest) {
		this.affirmRequest = new AffirmRequest(httpServletRequest);
		this.http = new HTTP(httpServletRequest);
	}
	
	public Action validate() {
		if(this.http.parameters.hasKey("test")) return Action.Accept;
		return Action.Reject;
	}
	
}
