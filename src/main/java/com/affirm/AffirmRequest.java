package main.java.com.affirm;

import javax.servlet.http.HttpServletRequest;

import main.java.com.action.Action;
import main.java.com.http.HTTP;

public class AffirmRequest {
	private HttpServletRequest httpServletRequest;
	private HTTP http;
	
	public AffirmRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
		this.http = new HTTP(httpServletRequest);
	}
	
	public Action validate() {
		if(this.http.parameters.hasKey("test")) return Action.Accept;
		return Action.Reject;
	}
	
}
