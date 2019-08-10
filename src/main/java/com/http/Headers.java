package main.java.com.http;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * Headers models list of operators supported on HTTP headers in {@link HttpServletRequest}
 * @author Marimuthu Mahalingam
 */
public class Headers {
	
	
	public static final byte count = 0;
	public static final byte hasRepeatedHeaders = 1;
	public static final byte equals = 2;
	public static final byte notEquals = 3;
	public static final byte total = 4;
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
	
	public boolean count(String headerName, int count) {
		Enumeration<String> headerValue = this.httpServletRequest.getHeaders(headerName);
		if(headerValue == null && count == 0) return true;
		if(headerValue == null && count != 0) return false;
		int headerCount = 0;
		while(headerValue.hasMoreElements()) {
			headerValue.nextElement();
			headerCount++;
		}
		return headerCount == count;
		
	}
	
	
	/**
	 * Checks if HTTP header named <code>header</code> occurs more than once.
	 * @param header name
	 * @return <code>true</code> if HTTP header named <code>header</code> occurs more than once else <code>false</code>.
	 */
	@SuppressWarnings("unchecked")
	public boolean hasRepeatedHeaders(String header) {
		Enumeration<String> headerValue = this.httpServletRequest.getHeaders(header);
		if(headerValue == null) return false;
		headerValue.nextElement();
		return headerValue.hasMoreElements();
	}
	
	/**
	 * Checks if any HTTP header named <code>headerName</code> has value equal to <code>expectedValue</code>.
	 * If there is more than one header with the given name then it will check if any one of the headers value equals <code>expectedValue</code>
	 * @param headerName 
	 * @param expectedValue
	 * @return <code>true</code> if value of the HTTP header named <code>headerName</code> has value equal to 
	 * <code>expectedValue</code> else <code>false</code>.
	 */
	@SuppressWarnings("unchecked")
	public boolean equals(String headerName, String expectedValue) {
		Enumeration<String> headerValue = this.httpServletRequest.getHeaders(headerName);
		while(headerValue.hasMoreElements()) {
			String value = headerValue.nextElement();
			if(value.equalsIgnoreCase(expectedValue)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if any HTTP header named <code>headerName</code> has value not equal to <code>value</code>.
	 * If there is more than one header with the given name then it will check if any one of the headers value not equals <code>expectedValue</code>
	 * @param headerName 
	 * @param value
	 * @return <code>true</code> if value of the HTTP header named <code>headerName</code> has value not equal to 
	 * <code>value</code> else <code>false</code>.
	 */
	@SuppressWarnings("unchecked")
	public boolean notEquals(String headerName, String value) {
		Enumeration<String> headerValues = this.httpServletRequest.getHeaders(headerName);
		while(headerValues.hasMoreElements()) {
			String headerValue = headerValues.nextElement();
			if(!headerValue.equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if number of HTTP headers in {@link HttpServletRequest} is equal to <code>expectedCount</code>.
	 * @param expectedCount 
	 * @return <code>true</code> if number of HTTP headers in {@link HttpServletRequest} is equal to <code>expectedCount</code> else <code>false</code>.
	 */
	@SuppressWarnings("unchecked")
	public boolean total(int expectedCount) {
		int headerCount = 0;
		Enumeration<String> headerNames = this.httpServletRequest.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			Enumeration<String> headerValue = this.httpServletRequest.getHeaders(headerNames.nextElement());
			while (headerValue.hasMoreElements()) {
				headerValue.nextElement();
				headerCount++;
			}
		}
		return headerCount == expectedCount;
	}
}
