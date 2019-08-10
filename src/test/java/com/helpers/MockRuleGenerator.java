package test.java.com.helpers;

import main.java.com.action.Action;
import main.java.com.http.Cookies;
import main.java.com.http.HTTP;
import main.java.com.http.Headers;
import main.java.com.http.Parameters;
import main.java.com.rule.Condition;
import main.java.com.rule.Rule;

public class MockRuleGenerator {
	public static Rule generateRule() {
		Condition condition_1 = new Condition(HTTP.PARAMETERS, Parameters.hasKey, "key");
		Condition condition_2 = new Condition(HTTP.PARAMETERS, Parameters.hasKey, "value");
		Condition condition_3 = new Condition(HTTP.PARAMETERS, Parameters.hasSpecialChar, "value");
		Condition[] conditions = new Condition[] {condition_1, condition_2, condition_3};
		Rule rule = new Rule(conditions, Action.Accept, Action.Reject);
		return rule;
	}
	
	public static Rule generateDuplicateParamCheckerRule() {
		Condition condition_1 = new Condition(HTTP.PARAMETERS, Parameters.hasKey, "duplicate");
		Condition condition_2 = new Condition(HTTP.PARAMETERS, Parameters.count, 1);
		Condition condition_3 = new Condition(HTTP.PARAMETERS, Parameters.equal, "duplicate", "tests_2");
		Condition[] conditions = new Condition[] {condition_1, condition_2, condition_3};
		Rule rule = new Rule(conditions, Action.Accept, Action.Reject);
		return rule;
	}
	
	public static Rule generateCookieCheckerRule() {
		Condition condition_1 = new Condition(HTTP.COOKIES, Cookies.hasCookie, "key");
		Condition condition_2 = new Condition(HTTP.COOKIES, Cookies.lengthEquals, "session", 10);
		Condition condition_3 = new Condition(HTTP.PARAMETERS, Parameters.equal, "duplicate", "tests_2");
		Condition[] conditions = new Condition[] {condition_1, condition_2, condition_3};
		Rule rule = new Rule(conditions, Action.Accept, Action.Reject);
		return rule;
	}
	
	public static Rule generateCookieTamperRule() {
		Condition condition_1 = new Condition(HTTP.COOKIES, Cookies.hasCookie, "key");
		Condition condition_2 = new Condition(HTTP.COOKIES, Cookies.lengthEquals, "session", 10);
		Condition condition_3 = new Condition(HTTP.PARAMETERS, Parameters.equal, "duplicate", "tests_2");
		Condition[] conditions = new Condition[] {condition_1, condition_2, condition_3};
		Rule rule = new Rule(conditions, Action.Accept, Action.Reject);
		return rule;
	}
	
	public static Rule generateHostHeaderEqualConditionCheckRule(String host, Action success, Action failure) {
		Condition condition_1 = new Condition(HTTP.HEADERS, Headers.equals, "Host", host);
		Condition[] conditions = new Condition[] {condition_1};
		Rule rule = new Rule(conditions, success, failure);
		return rule;
	}
	
	public static Rule generateMultipleHeaderCheckRuleReject(String headerName, Action success, Action failure) {
		Condition condition_1 = new Condition(HTTP.HEADERS, Headers.hasRepeatedHeaders, headerName);
		Condition[] conditions = new Condition[] {condition_1};
		Rule rule = new Rule(conditions, success, failure);
		return rule;
	}
	
	public static Rule generateHeaderCheckCountEqualsRuleReject(String headerName, String value, int count, Action success, Action failure) {
		Condition condition_1 = new Condition(HTTP.HEADERS, Headers.count, headerName, count);
		Condition condition_2 = new Condition(HTTP.HEADERS, Headers.equals, headerName, value);
//		Condition condition_3 = new Condition(HTTP.HEADERS, Headers., headerName);
		Condition[] conditions = new Condition[] {condition_1};
		Rule rule = new Rule(conditions, success, failure);
		return rule;
	}
	

}
