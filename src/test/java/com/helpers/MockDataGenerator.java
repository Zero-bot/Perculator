package test.java.com.helpers;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;


public class MockDataGenerator {
	public static Cookie[] generateCookies(int count) {
		Cookie[] cookies = new Cookie[count];
		for(int i=0; i<count; i++)
			cookies[i] = new Cookie(String.valueOf(i), String.valueOf(i));
		return cookies;
	}
	
	public static Cookie[] generateCookies(String[] name, String[] value) throws Exception {
		if(name.length != value.length) throw new Exception("Name and Value array should have same length");
		Cookie[] cookies = new Cookie[name.length];
		for(int i=0; i<name.length; i++)
			cookies[i] = new Cookie(name[i], value[i]);
		return cookies;
	}
	
	public static Map<String, String> generateParametersMap(String[] name, String[] value) throws Exception{
		if(name.length != value.length) throw new Exception("Name and Value array should have same length");
		Map<String, String> parametersMap = new HashMap<String, String>();
		for(int i=0; i<name.length; i++) {
			parametersMap.put(name[i], value[i]);
		}
		return parametersMap;
	}
	
	public static Enumeration<String> generateHeaderNames(Map<String, List<String>> headersMap){
		return Collections.enumeration(headersMap.keySet());
	}
	
	public static Enumeration<String> generateHeadersValue(Map<String, List<String>> headersMap, String key){
		return Collections.enumeration(headersMap.get(key));
	}
	
	
}
