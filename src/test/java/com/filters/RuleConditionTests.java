package test.java.com.filters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import main.java.com.action.Action;
import main.java.com.perculator.Perculator;
import main.java.com.rule.Rule;
import test.java.com.helpers.MockDataGenerator;
import test.java.com.helpers.MockRuleGenerator;

class RuleConditionTests {
	HttpServletRequest httpServletrequest;
	
	@Test
	void testSimpleAllow() throws Exception {
		httpServletrequest = mock(HttpServletRequest.class);
		String[] key = {"key", "value"};
		String[] value = {"tests", "'"};
		when(httpServletrequest.getParameterMap()).thenReturn(MockDataGenerator.generateParametersMap(key, value));
		List<Rule> ruleSet = new ArrayList<Rule>();
		ruleSet.add(MockRuleGenerator.generateRule());
		assertEquals(Action.Accept, new Perculator(httpServletrequest, ruleSet).affirm());
	}
	
	@Test
	void testDuplicateParamAllow() throws Exception {
		this.httpServletrequest = mock(HttpServletRequest.class);
		String[] key = {"duplicate", "duplicate"};
		String[] value = {"test", "tests_2"};
		List<Rule> ruleSet = new ArrayList<Rule>();
		ruleSet.add(MockRuleGenerator.generateDuplicateParamCheckerRule());
		when(httpServletrequest.getParameterMap()).thenReturn(MockDataGenerator.generateParametersMap(key, value));
		
		assertEquals(Action.Accept, new Perculator(httpServletrequest, ruleSet).affirm());
	}
	
	@Test
	void testCookieLength() throws Exception {
		this.httpServletrequest = mock(HttpServletRequest.class);
		String[] key = {"key", "duplicate"};
		String[] value = {"test", "tests_2"};
		String[] keyCookie = {"key", "session"};
		String[] valueCookie = {"test", "1234567890"};
		List<Rule> ruleSet = new ArrayList<Rule>();
		ruleSet.add(MockRuleGenerator.generateCookieCheckerRule());
		when(httpServletrequest.getParameterMap()).thenReturn(MockDataGenerator.generateParametersMap(key, value));
		when(httpServletrequest.getCookies()).thenReturn(MockDataGenerator.generateCookies(keyCookie, valueCookie));
		assertEquals(Action.Accept, new Perculator(httpServletrequest, ruleSet).affirm());
	}
	
	@Test
	void testCookieTamper() throws Exception {
		this.httpServletrequest = mock(HttpServletRequest.class);
		String[] key = {"key", "duplicate"};
		String[] value = {"test", "tests_2"};
		String[] keyCookie = {"key", "session"};
		String[] valueCookie = {"test", "123456789"};
		List<Rule> ruleSet = new ArrayList<Rule>();
		ruleSet.add(MockRuleGenerator.generateCookieCheckerRule());
		when(httpServletrequest.getParameterMap()).thenReturn(MockDataGenerator.generateParametersMap(key, value));
		when(httpServletrequest.getCookies()).thenReturn(MockDataGenerator.generateCookies(keyCookie, valueCookie));
		assertEquals(Action.Reject, new Perculator(httpServletrequest, ruleSet).affirm());
	}
	
	

}


