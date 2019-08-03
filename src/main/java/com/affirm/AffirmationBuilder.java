package main.java.com.affirm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import main.java.com.action.Action;
import main.java.com.exception.UndefinedOperatorException;
import main.java.com.http.HTTP;
import main.java.com.http.Parameters;
import main.java.com.rule.Condition;
import main.java.com.rule.Rule;

public class AffirmationBuilder {
	private HttpServletRequest httpServletRequest;
	private AffirmRequest affirmRequest;
	private List<Rule> ruleSet;
	
	public AffirmationBuilder(HttpServletRequest httpServletRequest, List<Rule> ruleSet) {
		this.httpServletRequest = httpServletRequest;
		this.affirmRequest = new AffirmRequest(this.httpServletRequest);
		this.ruleSet = ruleSet;
	}
	
	public Action validate() throws UndefinedOperatorException {
		Action result = null;
		for(Rule rule: ruleSet) {
			result = rule.execute(this.httpServletRequest);
			
			if(result == Action.Invalidate) {
					this.httpServletRequest.getSession().invalidate();
					return result;
			}
			else if(result == Action.Reject) {
				return result;
			}
		}
		
		return result;
	}
	
}
