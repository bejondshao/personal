package com.bejond;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bejond on 15-9-9.
 */
public class SampleAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		// get info from request object
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		MessageResources messageResources = getResources(request);

		String helloWord = messageResources.getMessage("welcome.helloWord");
		String message = messageResources.getMessage("welcome.message");

		// prepare model
		Map model = new HashMap<>();

		if (username.equals("asdf") && password.equals("good")) {
			model.put("name", username);
			model.put("password", password);
			model.put("message", message);

			request.setAttribute("userInfo", model);

			return mapping.findForward("success");
		}
		else {
			return mapping.findForward("error");
		}
	}

}
