package main.java.com.http;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import main.java.com.rule.Condition;

/**
 * Parameters models list of operations supported on {@link HttpServletRequest} <code>parameters<code>. 
 * Request parameters are extra information sent with the request. 
 * For HTTP servlets, parameters are contained in the query string or posted form data.
 * 
 * @author Marimuthu Mahalingam
 */
public class Parameters {

	
	
	/**
	 * Used for accessing {@link #hasKey(String)} operator from {@link Condition} object.
	 */
	public static final byte hasKey = 0;
	
	/**
	 * Used for accessing {@link #hasSpecialChar(String)} operator from {@link Condition} object.
	 */
	public static final byte hasSpecialChar = 1;
	
	/**
	 * Used for accessing {@link #hasOnlyAlphaNumericChars(String)} operator from {@link Condition} object.
	 */
	public static final byte hasOnlyAlphaNumericChars = 2;
	
	/**
	 * Used for accessing {@link #match(String, String)} operator from {@link Condition} object.
	 */
	public static final byte match = 3;
	
	/**
	 * Used for accessing {@link #notMatch(String, String)} operator from {@link Condition} object.
	 */
	public static final byte notMatch = 4;
	
	/**
	 * Used for accessing {@link #equal(String, String)} operator from {@link Condition} object.
	 */
	public static final byte equal = 5;
	
	/**
	 * Used for accessing {@link #notEqual(String, String)} operator from {@link Condition} object.
	 */
	public static final byte notEqual = 6;
	
	/**
	 * Used for accessing {@link #isInteger(String)} operator from {@link Condition} object.
	 */
	public static final byte isInteger = 7;
	
	/**
	 * Used for accessing {@link #count(int)} operator from {@link Condition} object.
	 */
	public static final byte count = 8;
	
	/**
	 * {@link HttpServletRequest}
	 */
	private HttpServletRequest httpServletRequest;
	
	/**
	 * <code>java.util.Map<String, String></code> of the parameters returned by {@link HttpServletRequest#getParameterMap()}.
	 */
	private Map<String, String> parameters;
	
	/**
	 * Simple constructor

	 * @param httpServletRequest {@link HttpServletRequest}.
	 */
	public Parameters(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
		this.parameters = this.httpServletRequest.getParameterMap();
	}
	
	/**
	 * Validates {@link #parameters} has <code>expectedCount</code> number of parameters.
	 * @param expectedCount
	 * @return <code>true</code> If {@link #parameters} length is equal to <code>expectedCount</code> else <code>false</code>.
	 */
	public boolean count(int expectedCount) {
		return this.parameters.size() == expectedCount;
	}
	
	/**
	 * Checks {@link #parameters} has a parameter named <code>key</code>.
	 * @param key name of the parameter to check.
	 * @return <code>true</code> if parameter named <code>key</code> is present in {@link #parameters} 
	 * else <code>false</code>.
	 */
	public boolean hasKey(String key) {
		return this.parameters.containsKey(key);
	}
	
	/**
	 * Validates {@link #parameters} named <code>key</code> has special characters.
	 * @param key name of the parameter to check.
	 * @return <code>true</code> if parameter named <code>key</code> has special characters else <code>false</code>.
	 */
	public boolean hasSpecialChar(String key) {
		return !this.parameters.get(key).matches("^[A-Ba-b]++$");
	}
	
	/**
	 * Validates {@link #parameters} named <code>key</code> has only alphanumeric characters.
	 * @param key name of the parameter to check
	 * @return <code>true</code> if parameter named <code>key</code> has only alphanumeric characters else 
	 * <code>false</code>.
	 */
	public boolean hasOnlyAlphaNumericChars(String key) {
		return this.parameters.get(key).matches("^[A-Ba-b]++$");
	}
	
	/**
	 * Check if <code>regex</code> matches the <code>value</code> of {@link #parameters} named <code>key</code>.
	 * @param key name of the parameter to check.
	 * @param regex to match.
	 * @return <code>true</code> if <code>regex</code> matches the <code>value</code> of parameter named <code>key</code>.
	 */
	public boolean match(String key, String regex) {
		return this.parameters.get(key).matches(regex);
	}
	
	/**
	 * Check if <code>regex</code> not matches the <code>value</code> of {@link #parameters} named <code>key</code>.
	 * @param key name of the parameter to check.
	 * @param regex to match.
	 * @return <code>true</code> if <code>regex</code> not matches the <code>value</code> of parameter named 
	 * <code>key</code>.
	 */
	public boolean notMatch(String key, String regex) {
		return !this.parameters.get(key).matches(regex);
	}
	
	/**
	 * Check if <code>value</code> of parameter named <code>key</code> equals <code>expectedValue</code>.
	 * @param key name of the parameter to compare.
	 * @param expectedValue value
	 * @return <code>true</true> if <code>expectedValue</code> is the value of parameter named 
	 * <code>key</code> else <code>false</code>.
	 */
	public boolean equal(String key, String expectedValue) {
		return this.parameters.get(key).equals(expectedValue);
	}
	
	/**
	 * Check if <code>value</code> of parameter named <code>key</code> not equals <code>expectedValue</code>.
	 * @param key name of the parameter to compare.
	 * @param expectedValue value
	 * @return <code>true</true> if <code>expectedValue</code> is not the value of parameter named 
	 * <code>key</code> else <code>false</code>.
	 */
	public boolean notEqual(String key, String expectedValue) {
		return !this.parameters.get(key).equals(expectedValue);
	}
	
	/**
	 * Check if <code>value</code> of parameter named <code>key</code> is an {@link Integer}.
	 * @param key name of the parameter to compare.
	 * @return <code>true</code> if value of <code>key</code> is an {@link Integer} else <code>false</code>.
	 */
	public boolean isInteger(String key) {
		 try {
			 Integer.valueOf(this.parameters.get(key));
		 }catch (Exception e) {
			return false;
		}
		 return true;
	}
	
}
