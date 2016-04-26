package com.bejond.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by bejond on 4/26/16.
 */
public class SimpleIterateTag extends SimpleTagSupport {
	private String value;
	private String items;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Object object = this.getJspContext().getAttribute(items);

		if (object != null && object instanceof List) {
			Iterator iterator = ((List) object).iterator();
			while (iterator.hasNext()) {
				this.getJspContext().setAttribute(value, iterator.next());
				this.getJspBody().invoke(null);
			}
		}
	}
}
