package main.java.filters;

import javax.servlet.http.HttpServletRequest;

public class Filter {
	private HttpServletRequest httpServletRequest;
	
	public Filter(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	
	public boolean isValid() {
		return (httpServletRequest.getParameter("User").equals("Marimuthu"));
	}
	
	public boolean isGetRequest() {
		return httpServletRequest.getMethod().equals("GET");
	}

}
