package test.java.com.filters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import main.java.com.action.Action;
import main.java.com.perculator.Perculator;
import test.java.com.helpers.MockDataGenerator;
class FilterTest {
	HttpServletRequest request;
	@Test
	void testCookieCountAllow() {
		request = mock(HttpServletRequest.class);
		when(request.getCookies()).thenReturn(MockDataGenerator.generateCookies(2));
		assertEquals(Action.Accept, new Perculator(request).affirm());	
	}
	
	void testCookieCountBlock() {
		
	}

}
