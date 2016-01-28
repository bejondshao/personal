package com.bejond.model;

/**
 * Created by bejond on 16-1-28.
 */
// No @Entity here
public class MessageInfo {
	private int id;
	private String content;
	private String topicTitle;
	private String categoryName;

	public MessageInfo(int id, String content, String topicTitle, String categoryName) {
		this.categoryName = categoryName;
		this.content = content;
		this.id = id;
		this.topicTitle = topicTitle;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	@Override
	public String toString() {
		return "MessageInfo{" +
			"categoryName='" + categoryName + '\'' +
			", id=" + id +
			", content='" + content + '\'' +
			", topicTitle='" + topicTitle + '\'' +
			'}';
	}
}
