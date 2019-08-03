package main.java.com.http;

import javax.servlet.http.Cookie;

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
	
	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}
	
	public boolean count(int count) {
		return this.cookies.length == count;
	}
	
	public boolean hasCookie(Object key) {
		
		if (key == null) throw new NullPointerException("Key should not be null for hasCookie operator");
		
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) 
				return true;
		}
		return false;
	}
	
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
	
	public boolean notEquals(Object key, Object value) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(!cookie.getValue().equals(value)) 
					return true;
			}
		}
		return false;
	}
	
	public boolean match(Object key, String regex) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(cookie.getValue().matches(regex))
					return true;
			}
		}
		return false;
	}
	
	public boolean notMatch(Object key, String regex) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(!cookie.getValue().matches(regex))
					return true;
			}
		}
		return false;
	}
	
	public boolean lengthLesserThanEquals(Object key, int length) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(cookie.getValue().length() <= length)
					return true;
			}
		}
		return false;
	}
	
	public boolean lengthGreaterThanEquals(Object key, int length) {
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals(key)) {
				if(cookie.getValue().length() >= length)
					return true;
			}
		}
		return false;
	}
	
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
