package main.java.com.http;

import java.util.Map;

public class Parameters {
	private Map<String, String> parameters;
	
	public Parameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	
	public int count() {
		return this.parameters.size();
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
