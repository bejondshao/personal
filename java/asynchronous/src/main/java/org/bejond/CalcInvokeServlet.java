package org.bejond;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Future;

@WebServlet(name = "CalcInvokeServlet", urlPatterns = {"/CalcInvokeServlet"})
public class CalcInvokeServlet extends HttpServlet {

	@EJB
	CalculatorBean calcBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();

		sb.append("Begin addition calculation: " + new Date() + "<br/>");
		Future<Integer> addFuture = calcBean.asyncAdd(sb, 1, 1);

		sb.append("Begin subtraction calculation: " + new Date() + "<br/>");
		Future<Integer> subtractFuture = calcBean.asyncSubtract(sb, 2, 1);
		sb.append("Do some other work and wait for results from " + "asynchronous calculations." + "<br/>");

		while (!addFuture.isDone() || !subtractFuture.isDone()) {
			try {
				Thread.sleep(100);

			} catch (InterruptedException e) {
				System.out.println("Error occured while trying to make this thread asleep.");
				e.printStackTrace();
				return;
			}
			request.setAttribute("message", sb.toString());
			request.getRequestDispatcher("response.jsp").forward(request, response);
		}

	}
}
