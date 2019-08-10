package main.java.com.rule;

import javax.servlet.http.HttpServletRequest;

import main.java.com.action.Action;
import main.java.com.exception.UndefinedLocationException;
import main.java.com.exception.UndefinedOperatorException;

public class Rule {
	private Condition[] conditions;
	private Action actionSuccess;
	private Action actionFailure;
	
	public Rule(Condition[] conditions, Action actionSuccess, Action actionFailure) {
		this.conditions = conditions;
		this.actionSuccess = actionSuccess;
		this.actionFailure = actionFailure;
	}
	
	public Rule(Condition condition, Action actionSuccess, Action actionFailure) {
		this.conditions = new Condition[] { condition };
		this.actionSuccess = actionSuccess;
		this.actionFailure = actionFailure;
	}
	
	public Action execute(HttpServletRequest httpServletRequest) throws UndefinedOperatorException, UndefinedLocationException {
		for(Condition condition: conditions) {
			if(!condition.evaluate(httpServletRequest)) 
				return this.actionFailure;
		}
		return this.actionSuccess;
	}

}
