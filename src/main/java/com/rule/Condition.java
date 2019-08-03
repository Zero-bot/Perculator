package main.java.com.rule;


import javax.servlet.http.HttpServletRequest;

import main.java.com.exception.UndefinedOperatorException;
import main.java.com.http.Cookies;
import main.java.com.http.HTTP;
import main.java.com.http.Parameters;


/**
 * @author kalki
 *<h3>Condition models specific condition to be applied on defined location and evaluates based operator.</h3>
 *
 */
public class Condition {
	private byte location;
	private byte operator;
	private Object key;
	private Object value;
	
	/**
	 * 
	 * @param location a location defined in {@link HTTP} as static variable where we want to apply this condition
	 * @param operator a operator that will be evaluated against the location, operator value depends on static variables in {@link Parameters} and {@link Cookies}.
	 * @param key a key to evaluate
	 * @param value a value to evaluate
	 */
	public Condition(byte location, byte operator, Object key, Object value) {
		this.location = location;
		this.operator = operator;
		this.key = key;
		this.value = value;
	}
	
	/**
	 * 
	 * @param location a location defined in {@link HTTP} as static variable where we want to apply this condition
	 * @param operator a operator that will be evaluated against the location, operator value depends on static variables in {@link Parameters} and {@link Cookies}.
	 * @param key a key to evaluate
	 */
	
	public Condition(byte location, byte operator, Object key) {
		this.location = location;
		this.operator = operator;
		this.key = key;
	}
	
	/**
	 * Evaluates the condition and returns the result.
	 * 
	 * @param httpServletRequest a {@link HttpServletRequest} to validate.
	 * @return returns if condition evaluation result.
	 * @throws UndefinedOperatorException
	 */
	public Boolean evaluate(HttpServletRequest httpServletRequest) throws UndefinedOperatorException {
		if(this.location == HTTP.PARAMETERS) {
			Parameters parameters = new Parameters(httpServletRequest.getParameterMap());
			
			if(Parameters.equal == this.operator) {
				if(value == null || key == null) {
					throw new NullPointerException("Key or Value cannot be null for equal operator");
				}
				return parameters.equal((String)key, (String)value);
			}
			
			else if(Parameters.hasKey == this.operator) {
				if( key == null ) {
					throw new NullPointerException("Key cannot be null for hasKey operator");
				}
				return parameters.hasKey((String)key);
			}
			
			else if(Parameters.hasOnlyAlphaNumericChars == this.operator) {
				if( key == null ) {
					throw new NullPointerException("Key cannot be null for hasOnlyAlphaNumericChars operator");
				}
				return parameters.hasOnlyAlphaNumericChars((String)key);
			}
			
			else if(Parameters.hasSpecialChar == this.operator) {
				if(key == null) {
					throw new NullPointerException("Key cannot be null for hasSpecialChar operator");
				}
				return parameters.hasSpecialChar((String) key);
			}
			
			else if(this.operator == Parameters.count) {
				return parameters.count((int) key);
			}
			
			else throw new UndefinedOperatorException();
		}
		
		if(this.location == HTTP.COOKIES) {
			Cookies cookies = new Cookies(httpServletRequest.getCookies());
			
			if(this.operator == Cookies.count) {
				return cookies.count((int) key);
			}
			
			else if(this.operator == Cookies.equals) {
				if(key == null || value == null) {
					throw new NullPointerException("Key or Value cannot be null for equal operator");
				}
				return cookies.equals(key, value);
			}
			
			else if(this.operator == Cookies.hasCookie) {
				if(key == null) {
					throw new NullPointerException("Key cannot be null for equal operator");
				}
				return cookies.hasCookie(key);
			}
			
			else if(this.operator == Cookies.lengthEquals) {
				if(key == null || value == null) {
					throw new NullPointerException("Key or Value cannot be null for lengthEquals operator");
				}
				return cookies.lengthEquals(key, (int) value);
			}
			
			else if(this.operator == Cookies.lengthGreaterThanEquals) {
				if(key == null || value == null) {
					throw new NullPointerException("Key or Value cannot be null for lengthGreaterThanEquals operator");
				}
				return cookies.lengthGreaterThanEquals(key, (int) value);
			}
			
			else if(this.operator == Cookies.lengthLesserThanEquals) {
				if(key == null || value == null) {
					throw new NullPointerException("Key or Value cannot be null for lengthLesserThanEquals operator");
				}
				return cookies.lengthLesserThanEquals(key, (int) value);
			}
			
			else if(this.operator == Cookies.match) {
				if(key == null || value == null) {
					throw new NullPointerException("Key or Value cannot be null for match operator");
				}
				return cookies.match(key, (String) value);
			}
			
			else if(this.operator == Cookies.notEquals) {
				if(key == null || value == null) {
					throw new NullPointerException("Key or Value cannot be null for notEquals operator");
				}
				return cookies.notEquals(key, (String) value);
			}
			
			else if(this.operator == Cookies.notMatch) {
				if(key == null || value == null) {
					throw new NullPointerException("Key or Value cannot be null for notMatch operator");
				}
				return cookies.notMatch(key, (String) value);
			}
			
			else throw new UndefinedOperatorException();
			
		}
		return false;
	}

}
