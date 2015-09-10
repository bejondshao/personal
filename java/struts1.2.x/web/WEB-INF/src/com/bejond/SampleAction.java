package com.bejond;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
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
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		// prepare model
		Map model = new HashMap<>();

		if (userName != null && password.equals("good")) {
			model.put("name", userName);
			model.put("password", password);

			request.setAttribute("userInfo", model);

			return mapping.findForward("success");
		}
		else {
			return mapping.findForward("error");
		}
	}

}
