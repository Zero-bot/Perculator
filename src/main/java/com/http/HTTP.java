package main.java.com.http;

import javax.servlet.http.HttpServletRequest;

public class HTTP {
	private HttpServletRequest httpServletRequest;
	public Parameters parameters;
	
	@SuppressWarnings("unchecked")
	public HTTP(HttpServletRequest httpServletRequest){
		this.httpServletRequest = httpServletRequest;
		this.parameters = new Parameters(this.httpServletRequest.getParameterMap());
	}
}

