package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.form.LoginActionForm;

public class LoginAction {
	private static final String SUCCESS ="success";
	
	public ActionForward execute (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		LoginActionForm laf = (LoginActionForm) form;
		if(laf.checkLogin()){
		return mapping.findForward("success");} else{
			return mapping.findForward("fail");
		}
	}
}
