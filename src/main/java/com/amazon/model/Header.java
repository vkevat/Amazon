package com.amazon.model;

import java.util.Date;

public class Header {

	private String msgId;
	private Date timeStamp;
	private int statusCode;
	private String statusDescription;
	
	public Header() {}
	
	public Header(String msgId, Date timeStamp, int statusCode, String statusDescription) {
		super();
		this.msgId = msgId;
		this.timeStamp = timeStamp;
		this.statusCode = statusCode;
		this.statusDescription = statusDescription;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	
	
	
	
}
