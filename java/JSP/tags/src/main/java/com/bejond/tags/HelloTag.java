package com.bejond.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by bejond on 4/25/16.
 */
public class HelloTag extends TagSupport {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter jspWriter = this.pageContext.getOut();
		try {
			jspWriter.println("自定义标签"+ name + "你好");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return TagSupport.SKIP_BODY; // 跳过body, 直接结束标签
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
}
