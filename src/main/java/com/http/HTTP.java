package main.java.com.http;


import javax.servlet.http.HttpServletRequest;

public class HTTP {
	public static final byte PARAMETERS = 0;
	public static final byte COOKIES = 1;
	public static final byte HEADERS = 2;
	private HttpServletRequest httpServletRequest;
	public Parameters parameters;
	public Cookies Cookies;
	public Headers headers;
	
	@SuppressWarnings("unchecked")
	public HTTP(HttpServletRequest httpServletRequest){
		this.httpServletRequest = httpServletRequest;
		this.parameters = new Parameters(this.httpServletRequest);
		this.Cookies = new Cookies(this.httpServletRequest);
	}
}

