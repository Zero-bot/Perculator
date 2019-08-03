package test.java.filters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import main.java.filters.Filter;
class FilterTest {
	HttpServletRequest request;
	@Test
	void testFiltersParam() {
		request = mock(HttpServletRequest.class);
		
		when(request.getParameter("User")).thenReturn("Marimuthu");
		when(request.getMethod()).thenReturn("GET");
		assertTrue(new Filter(request).isValid());
		assertFalse(new Filter(request).isGetRequest());
	}

}
