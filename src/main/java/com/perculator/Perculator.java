package main.java.com.perculator;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import main.java.com.action.Action;
import main.java.com.affirm.AffirmationBuilder;
import main.java.com.exception.UndefinedOperatorException;
import main.java.com.rule.Rule;


public class Perculator{
	private HttpServletRequest httpServletRequest;
	private AffirmationBuilder affirmationBuilder;
	
	public Perculator(HttpServletRequest httpServletRequest, List<Rule> rules) {
		this.httpServletRequest = httpServletRequest;
		this.affirmationBuilder = new AffirmationBuilder(this.httpServletRequest, rules);
	}
	
	public Action affirm() throws UndefinedOperatorException {
		return affirmationBuilder.validate();
	}

}
