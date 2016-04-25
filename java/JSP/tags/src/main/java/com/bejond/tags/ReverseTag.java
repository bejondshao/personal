package com.bejond.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * Created by bejond on 4/25/16.
 */
public class ReverseTag extends BodyTagSupport {
	private String bold;
	private BodyContent bodyContent;

	public String getBold() {
		return bold;
	}

	public void setBold(String bold) {
		this.bold = bold;
	}

	@Override
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}

	@Override
	public int doAfterBody() {

		JspWriter jspWriter = this.pageContext.getOut();
		StringBuffer content = new StringBuffer(bodyContent.getString());

		content = content.reverse();

		StringBuffer out = new StringBuffer(4);

		out.append("<p");

		if (Boolean.getBoolean(bold)) {
			out.append(" class=\"bold\">");
		}
		else {
			out.append(">");
		}

		out.append(content);
		out.append("</p>");

		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
}
