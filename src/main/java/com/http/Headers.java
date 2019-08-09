package main.java.com.http;

import javax.servlet.http.HttpServletRequest;

/**
 * Provide way for performing different validations on Http headers in {@link HttpServletRequest}
 * @author Marimuthu Mahalingam - (marimuthu125@gmail.com)
 */
public class Headers {
	
	/**
	 * {@link HttpServletRequest}
	 */
	private HttpServletRequest httpServletRequest;
	
	/**
	 * Simple constructor
	 * @param httpServletRequest {@link HttpServletRequest}
	 */
	public Headers(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	
	
}
