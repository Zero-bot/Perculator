package main.java.com.http;

import java.net.HttpCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 * 
 * Models different operators supported on {@link HttpCookie}
 * 
 * @author Marimuthu Mahalingam
 */
public class Cookies {

	public static final byte hasCookie = 0;
	public static final byte equals = 1;
	public static final byte notEquals = 2;
	public static final byte match = 3;
	public static final byte notMatch = 4;
	public static final byte lengthLesserThanEquals = 5;
	public static final byte lengthGreaterThanEquals = 6;
	public static final byte lengthEquals = 7;
	public static final byte count = 8;
	
	private Cookie[] cookies;
	private HttpServletRequest httpServletRequest;
	
	/**
	 * Constructor
	 * @param httpServletRequest {@link HttpServletRequest}
	 */
	public Cookies(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
		this.cookies = this.httpServletRequest.getCookies();
	}
	
	
	/**
	 * Checks if number of cookies is equal to <code>count</code>.
	 * @param count
	 * @return <code>true</code> if <code>count</code> is equal to number of cookies in {@link HttpServletRequest} else <code>false</code>.
	 */
	public boolean count(int count) {
		return this.cookies.length == count;
	}
	
	/**
	 * Checks if {@link HttpServletRequest} has {@link Cookie} named <code>key</code> 
	 * @param key name of the {@link Cookie}.
	 * @return <code>true</code> if cookie named is present in {@link HttpServletRequest} else <code>false</code>.
	 */
	public boolean hasCookie(Object key) {
		
		if (key == null) throw new NullPointerException("Key should not be null for hasCookie operator");
		
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) 
				return true;
		}
		return false;
	}
	
	/**
	 * Checks if {@link HttpServletRequest} has {@link Cookie} named <code>key</code> and its value is <code>value</code>.
	 * @param key name of the {@link Cookie}.
	 * @param value value of the {@link Cookie}.
	 * @return <code>true</code> if value of {@link Cookie} named <code>key</code> is equal to <code>value</code> else <code>false</code>.
	 */
	public boolean equals(Object key, Object value) {
		
		if (key == null || value == null) throw new NullPointerException("Key or Value should not be null for equals operator");
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(cookie.getValue().equals(value)) 
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if {@link HttpServletRequest} has {@link Cookie} named <code>key</code> and its value is not <code>value</code>.
	 * @param key name of the {@link Cookie}.
	 * @param value value of the {@link Cookie}.
	 * @return <code>true</code> if value of {@link Cookie} named <code>key</code> is not equal to <code>value</code> else <code>false</code>.
	 */
	public boolean notEquals(Object key, Object value) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(!cookie.getValue().equals(value)) 
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if {@link HttpServletRequest} has {@link Cookie} named <code>key</code> and its value matches <code>regex</code>.
	 * @param key name of the {@link Cookie}.
	 * @param regex to match.
	 * @return <code>true</code> if value of {@link Cookie} named <code>key</code> matches <code>regex</code> else <code>false</code>.
	 */
	public boolean match(Object key, String regex) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(cookie.getValue().matches(regex))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if {@link HttpServletRequest} has {@link Cookie} named <code>key</code> and its value not matches <code>regex</code>.
	 * @param key name of the {@link Cookie}.
	 * @param regex to match.
	 * @return <code>true</code> if value of {@link Cookie} named <code>key</code> not matches <code>regex</code> else <code>false</code>.
	 */
	public boolean notMatch(Object key, String regex) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(!cookie.getValue().matches(regex))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if {@link HttpServletRequest} has {@link Cookie} named <code>key</code> and length of its value is lesser than or equal to <code>length</code>.
	 * @param key name of the {@link Cookie}.
	 * @param length
	 * @return <code>true</code> if length of value of {@link Cookie} named <code>key</code> is lesser than or equal to <code>length</code>.
	 */
	public boolean lengthLesserThanEquals(Object key, int length) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(cookie.getValue().length() <= length)
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if {@link HttpServletRequest} has {@link Cookie} named <code>key</code> and length of its value is greater than or equal to <code>length</code>.
	 * @param key name of the {@link Cookie}.
	 * @param length
	 * @return <code>true</code> if length of value of {@link Cookie} named <code>key</code> is greater than or equal to <code>length</code>.
	 */
	public boolean lengthGreaterThanEquals(Object key, int length) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(cookie.getValue().length() >= length)
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if {@link HttpServletRequest} has {@link Cookie} named <code>key</code> and length of its value is equal to <code>length</code>.
	 * @param key name of the {@link Cookie}.
	 * @param length
	 * @return <code>true</code> if length of value of {@link Cookie} named <code>key</code> is equal to <code>length</code>.
	 */
	public boolean lengthEquals(Object key, int length) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(cookie.getValue().length() == length)
					return true;
			}
		}
		return false;
	}
	
}
