package org.statefulj.webapp.controller;

import org.statefulj.framework.core.annotations.StatefulController;
import org.statefulj.framework.core.annotations.Transition;
import org.statefulj.webapp.model.Account;
import org.statefulj.webapp.model.CheckingAccount;

@StatefulController(
	clazz=CheckingAccount.class, 
	startState=Account.NON_EXISTENT
)
public class CheckingAccountController extends AccountController {
	
	@Transition(from=Account.NON_EXISTENT, event="springmvc:post:/accounts/checking", to=Account.ACTIVE)
	public String createCheckingAccount(CheckingAccount checkingAccount, String event) {
		addAccount(checkingAccount);
		return "redirect:/user";
	}
}
