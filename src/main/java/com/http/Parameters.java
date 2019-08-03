package main.java.com.http;

import java.util.Map;

public class Parameters {
	public static final byte hasKey = 0;
	public static final byte hasSpecialChar = 1;
	public static final byte hasOnlyAlphaNumericChars = 2;
	public static final byte match = 3;
	public static final byte notMatch = 4;
	public static final byte equal = 5;
	public static final byte notEqual = 6;
	public static final byte isInteger = 7;
	public static final byte count = 8;
	private Map<String, String> parameters;
	
	public Parameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	
	public boolean count(int count) {
		return this.parameters.size() == count;
	}
	
	public boolean hasKey(String key) {
		return this.parameters.containsKey(key);
	}
	
	public boolean hasSpecialChar(String key) {
		return !this.parameters.get(key).matches("^[A-Ba-b]++$");
	}
	
	public boolean hasOnlyAlphaNumericChars(String key) {
		return this.parameters.get(key).matches("^[A-Ba-b]++$");
	}
	
	public boolean match(String key, String regex) {
		return this.parameters.get(key).matches(regex);
	}
	
	public boolean notMatch(String key, String regex) {
		return !this.parameters.get(key).matches(regex);
	}

	public boolean equal(String key, String expectedValue) {
		return this.parameters.get(key).equals(expectedValue);
	}
	
	public boolean notEqual(String key, String expectedValue) {
		return this.parameters.get(key).equals(expectedValue);
	}
	
	public boolean isInteger(String key) {
		 try {
			 Integer.valueOf(this.parameters.get(key));
		 }catch (Exception e) {
			return false;
		}
		 return true;
	}
	
}
