package test.java.com.helpers;

import javax.servlet.http.Cookie;


public class MockDataGenerator {
	public static Cookie[] generateCookies(int count) {
		Cookie[] cookies = new Cookie[count];
		for(int i=0; i<count; i++)
			cookies[i] = new Cookie(String.valueOf(i), String.valueOf(i));
		return cookies;
	}
	
	public static Cookie[] generateCookies(String[] names, String[] values) {
		assert(names.length == values.length);
		Cookie[] cookies = new Cookie[names.length];
		for(int i=0; i<names.length; i++)
			cookies[i] = new Cookie(names[i], values[i]);
		return cookies;
	}
	
}
