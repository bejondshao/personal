package com.bejond.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;
import java.util.Iterator;

/**
 * Created by bejond on 4/26/16.
 */
public class IterateTag extends TagSupport {
	private String value;
	private String items;
	private Iterator iterator;

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

	public Iterator getIterator() {
		return iterator;
	}

	public void setIterator(Iterator iterator) {
		this.iterator = iterator;
	}

	@Override
	public int doStartTag() throws JspException {
		Object object = this.pageContext.getAttribute(items);

		if (object != null && object instanceof List) {
			this.iterator = ((List) object).iterator();

			if (iterator.hasNext()) {
				this.pageContext.setAttribute(value, iterator.next());
				return TagSupport.EVAL_BODY_INCLUDE; // 执行标签体
			}
		}

		return SKIP_BODY;
	}

	@Override
	public int doAfterBody() throws JspException {
		if (iterator.hasNext()) {
			this.pageContext.setAttribute(value, iterator.next());
			return EVAL_BODY_AGAIN; // 再执行一次标签体
		}

		return SKIP_BODY;
	}
}
