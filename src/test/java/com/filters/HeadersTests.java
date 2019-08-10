package test.java.com.filters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import main.java.com.action.Action;
import main.java.com.perculator.Perculator;
import main.java.com.rule.Rule;
import test.java.com.helpers.MockDataGenerator;
import test.java.com.helpers.MockRuleGenerator;

class HeadersTests {

HttpServletRequest httpServletrequest;
	
	@Test
	void testhasHeaderEqualCondition() throws Exception {
		httpServletrequest = mock(HttpServletRequest.class);
		String[] key = {"key", "value"};
		String[] value = {"tests", "'"};
		
		Map<String, List<String>> headersMap = new HashMap<String, List<String>>();
		ArrayList<String> hostHeader = new ArrayList<String>();
		hostHeader.add("www.google.com");
		headersMap.put("Host", hostHeader);
		when(httpServletrequest.getHeaderNames()).thenReturn(MockDataGenerator.generateHeaderNames(headersMap));
		when(httpServletrequest.getHeaders("Host")).thenReturn(MockDataGenerator.generateHeadersValue(headersMap, "Host"));
		when(httpServletrequest.getParameterMap()).thenReturn(MockDataGenerator.generateParametersMap(key, value));
		List<Rule> ruleSet = new ArrayList<Rule>();
		ruleSet.add(MockRuleGenerator.generateHostHeaderEqualConditionCheckRule("www.google.com", Action.Accept, Action.Reject));
		assertEquals(Action.Accept, new Perculator(httpServletrequest, ruleSet).affirm());
	}
	
	@Test
	void testhasHeaderEqualConditionWithMultipleHeaders() throws Exception {
		httpServletrequest = mock(HttpServletRequest.class);
		String[] key = {"key", "value"};
		String[] value = {"tests", "'"};
		String host = "www.google.com";
		Map<String, List<String>> headersMap = new HashMap<String, List<String>>();
		ArrayList<String> hostHeader = new ArrayList<String>();
		hostHeader.add(host);
		hostHeader.add(host);
		headersMap.put("Host", hostHeader);
		when(httpServletrequest.getHeaderNames()).thenReturn(MockDataGenerator.generateHeaderNames(headersMap));
		when(httpServletrequest.getHeaders("Host")).thenReturn(MockDataGenerator.generateHeadersValue(headersMap, "Host"));
		when(httpServletrequest.getParameterMap()).thenReturn(MockDataGenerator.generateParametersMap(key, value));
		List<Rule> ruleSet = new ArrayList<Rule>();
		ruleSet.add(MockRuleGenerator.generateHostHeaderEqualConditionCheckRule("www.google.com", Action.Accept, Action.Reject));
		assertEquals(Action.Accept, new Perculator(httpServletrequest, ruleSet).affirm());
	}
	
	@Test
	void testhasHeaderCountConditionWithMultipleHeader() throws Exception {
		httpServletrequest = mock(HttpServletRequest.class);
		String[] key = {"key", "value"};
		String[] value = {"tests", "'"};
		String host = "www.google.com";
		Map<String, List<String>> headersMap = new HashMap<String, List<String>>();
		ArrayList<String> hostHeader = new ArrayList<String>();
		hostHeader.add(host);
		hostHeader.add(host);
		headersMap.put("Host", hostHeader);
		when(httpServletrequest.getHeaderNames()).thenReturn(MockDataGenerator.generateHeaderNames(headersMap));
		when(httpServletrequest.getHeaders("Host")).thenReturn(MockDataGenerator.generateHeadersValue(headersMap, "Host"));
		when(httpServletrequest.getHeaders("host")).thenReturn(MockDataGenerator.generateHeadersValue(headersMap, "Host"));
		when(httpServletrequest.getParameterMap()).thenReturn(MockDataGenerator.generateParametersMap(key, value));
		List<Rule> ruleSet = new ArrayList<Rule>();
		ruleSet.add(MockRuleGenerator.generateMultipleHeaderCheckRuleReject("Host", Action.Reject, Action.Accept));
		assertEquals(Action.Reject, new Perculator(httpServletrequest, ruleSet).affirm());
	}
	
	@Test
	void testHasHeaderCountConditionWithMultipleHeaderAccept() throws Exception {
		httpServletrequest = mock(HttpServletRequest.class);
		String[] key = {"key", "value"};
		String[] value = {"tests", "'"};
		String host = "www.google.com";
		Map<String, List<String>> headersMap = new HashMap<String, List<String>>();
		ArrayList<String> hostHeader = new ArrayList<String>();
		hostHeader.add(host);
		hostHeader.add(host);
		headersMap.put("Host", hostHeader);
		when(httpServletrequest.getHeaderNames()).thenReturn(MockDataGenerator.generateHeaderNames(headersMap));
		when(httpServletrequest.getHeaders("Host")).thenReturn(MockDataGenerator.generateHeadersValue(headersMap, "Host"));
		when(httpServletrequest.getParameterMap()).thenReturn(MockDataGenerator.generateParametersMap(key, value));
		List<Rule> ruleSet = new ArrayList<Rule>();
		ruleSet.add(MockRuleGenerator.generateMultipleHeaderCheckRuleReject("Host", Action.Accept, Action.Reject));
		assertEquals(Action.Accept, new Perculator(httpServletrequest, ruleSet).affirm());
	}
	
	@Test
	void testEqualsCountConditionWithMultipleHeaderAccept() throws Exception {
		httpServletrequest = mock(HttpServletRequest.class);
		String[] key = {"key", "value"};
		String[] value = {"tests", "'"};
		String host = "www.google.com";
		Map<String, List<String>> headersMap = new HashMap<String, List<String>>();
		ArrayList<String> hostHeader = new ArrayList<String>();
		hostHeader.add(host);
		headersMap.put("Host", hostHeader);
		when(httpServletrequest.getHeaderNames()).thenReturn(MockDataGenerator.generateHeaderNames(headersMap));
		when(httpServletrequest.getHeaders("Host")).thenReturn(MockDataGenerator.generateHeadersValue(headersMap, "Host"));
		when(httpServletrequest.getParameterMap()).thenReturn(MockDataGenerator.generateParametersMap(key, value));
		List<Rule> ruleSet = new ArrayList<Rule>();
		ruleSet.add(MockRuleGenerator.generateHeaderCheckCountEqualsRuleReject("Host", host, 1, Action.Accept, Action.Reject));
		assertEquals(Action.Accept, new Perculator(httpServletrequest, ruleSet).affirm());
	}

}
