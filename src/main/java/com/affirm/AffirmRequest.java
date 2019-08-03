package main.java.com.affirm;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AffirmRequest {
	private HttpServletRequest httpServletRequest;
	
	public AffirmRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	
	public boolean affirmParameterCount(int expectedCount) {
		
		Enumeration<?> parameterNames = this.httpServletRequest.getParameterNames();

		if(parameterNames == null && expectedCount == 0) return true;
		if(parameterNames == null) return false;
		int counter = 0;
		
		while(counter < expectedCount)
			parameterNames.nextElement();
		
		return parameterNames.hasMoreElements();
	}
	
	public boolean affirmCookieCount( int expectedCount) {
		Cookie[] cookies = this.httpServletRequest.getCookies();
		if(cookies == null && expectedCount == 0) return true;
		if(cookies == null) return false;
		return cookies.length == expectedCount;
	}
}
