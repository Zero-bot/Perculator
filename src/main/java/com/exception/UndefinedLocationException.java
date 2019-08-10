package main.java.com.exception;

@SuppressWarnings("serial")
public class UndefinedLocationException extends Exception{
	public UndefinedLocationException() {
		super();
	}
	
	public UndefinedLocationException(String exception) {
		super(exception);
	}

}
